package com.sqasa.automatizacion.steps;

import com.sqasa.automatizacion.pageobject.CarritoDeComprasPageObject;
import com.sqasa.automatizacion.pageobject.SpinnerPageObject;
import com.sqasa.automatizacion.utils.DatosExcelListas;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;

import static com.sqasa.automatizacion.utils.ActionsWebElements.scrollToElement;
import static com.sqasa.automatizacion.utils.Regex.limpiarNumeros;

public class CarritoDeComprasStep {
    private final CarritoDeComprasPageObject carritoDeComprasPageObject = new CarritoDeComprasPageObject();
    private final SpinnerPageObject spinnerPageObject = new SpinnerPageObject();
    private final long SECONDS_OF_WAIT = 10;
    private final WebDriver driver = spinnerPageObject.getDriver();
    @Step
    public void agregarCantidadLibros(int intCantidadLibros){
        //Fluent wait para esperar los botones de sumar o restar cantidad de libros
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(SECONDS_OF_WAIT))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);

        String strCantidadLibrosObtained = carritoDeComprasPageObject
                .waitForElement()
                .forUpTo(SECONDS_OF_WAIT)
                .until(
                ExpectedConditions.visibilityOfElementLocated(carritoDeComprasPageObject.getCantidadLibros()
                )).getTextContent();

        while(!strCantidadLibrosObtained.equals(String.valueOf(intCantidadLibros))){
            if(Integer.parseInt(strCantidadLibrosObtained)<intCantidadLibros){
                spinnerPageObject.waitFor((int) SECONDS_OF_WAIT).second().waitFor(
                        ExpectedConditions.invisibilityOfElementLocated(spinnerPageObject.getSpinner()));
                WebElement btnMas = wait.until(
                        wd -> wd.findElement(carritoDeComprasPageObject.getBtnMas()));
                btnMas.click();
            }
            if(Integer.parseInt(strCantidadLibrosObtained)>intCantidadLibros){
                spinnerPageObject.waitFor((int) SECONDS_OF_WAIT).second().waitFor(
                        ExpectedConditions.invisibilityOfElementLocated(spinnerPageObject.getSpinner()));
                WebElement btnMenos = wait.until(
                        wd -> wd.findElement(carritoDeComprasPageObject.getBtnMenos()));
                btnMenos.click();
            }
            spinnerPageObject.waitFor((int) SECONDS_OF_WAIT).second().waitFor(
                    ExpectedConditions.invisibilityOfElementLocated(spinnerPageObject.getSpinner()));
            strCantidadLibrosObtained = carritoDeComprasPageObject
                    .waitForElement()
                    .forUpTo(SECONDS_OF_WAIT)
                    .until(
                            ExpectedConditions.elementToBeClickable(carritoDeComprasPageObject.getCantidadLibros())
                    )
                    .getTextContent();
        }

    }
    @Step
    public void completarCompra() {
        carritoDeComprasPageObject
                .waitForElement()
                .forUpTo(SECONDS_OF_WAIT)
                .until(
                        ExpectedConditions.elementToBeClickable(carritoDeComprasPageObject.getBtnCompletarCompra())
                ).click();
    }

    @Step
    public void completarFormularioEnvio() throws IOException {
        var datosexcel = DatosExcelListas.readExcel("src/test/resources/Data/DataEntry.xlsx","Hoja2");
        var camposExcel = datosexcel.get(0);
        carritoDeComprasPageObject.waitForElement()
                .forUpTo(SECONDS_OF_WAIT)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(carritoDeComprasPageObject.getAgregarDireccion()));
        agregarDireccion();
        inputNombreDireccion(camposExcel.get("Nombre de la dirección"));
        inputTipoVivienda(camposExcel.get("Tipo de vivienda"));
        inputNombres(camposExcel.get("Nombres"));
        inputApellidos(camposExcel.get("Apellidos"));
        inputTelefonoFijo(camposExcel.get("Teléfono fijo"));
        inputCelular(camposExcel.get("Teléfono celular"));
        inputDireccion(camposExcel.get("Dirección"));
        inputDescripcionDireccion(camposExcel.get("Descripción dirección"));
        selectPais(camposExcel.get("País"));
        selectDepartamento(camposExcel.get("Departamento"));
        selectCiudad(camposExcel.get("Ciudad"));
        scrollToElement(
                carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getBtnGuardarFormularioDireccion());
        carritoDeComprasPageObject.clickOn(
                carritoDeComprasPageObject.find(carritoDeComprasPageObject.getBtnGuardarFormularioDireccion()));
        carritoDeComprasPageObject.waitForElement()
                .forUpTo(SECONDS_OF_WAIT)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(carritoDeComprasPageObject.getBtnConfirmarAlerta()));
        carritoDeComprasPageObject.clickOn(
                carritoDeComprasPageObject.find(carritoDeComprasPageObject.getBtnConfirmarAlerta()));
        carritoDeComprasPageObject.clickOn(
                carritoDeComprasPageObject.find(carritoDeComprasPageObject.getDireccionRegistrada()));
    }

    @Step
    public void verificarCantidadLibros(int intCantidadLibros) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getCantidad());
        var intCantidadLibrosAgregados = Integer.parseInt(
                limpiarNumeros(
                        carritoDeComprasPageObject.find(carritoDeComprasPageObject.getCantidad()).getTextContent()));
        Assert.assertEquals("Compara la cantidad de libros esperada",
                intCantidadLibros, intCantidadLibrosAgregados);
    }
    @Step
    public void verificarTotalCompra(int intCantidadLibros) {
        var intValorUnitario = Integer.parseInt(
                limpiarNumeros(
                        carritoDeComprasPageObject.find(carritoDeComprasPageObject.getValorUnitario()).getTextContent())
        );
        var intValorTotalObtenido = Integer.parseInt(
                limpiarNumeros(
                        carritoDeComprasPageObject.find(carritoDeComprasPageObject.getValorTotal()).getTextContent())
                );
        var intValorTotalEsperado = intValorUnitario*intCantidadLibros;
        Assert.assertEquals("Comparar el valor total contra el esperado",intValorTotalObtenido,intValorTotalEsperado);
    }
    private void selectCiudad(String ciudad) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getSelectCiudad());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getSelectCiudad())
                .waitUntilVisible()
                .selectByVisibleText(ciudad);
    }

    private void selectDepartamento(String departamento) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getSelectDepartamento());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getSelectDepartamento())
                .waitUntilVisible()
                .selectByVisibleText(departamento);
    }

    private void selectPais(String pais) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getSelectPais());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getSelectPais())
                .waitUntilVisible()
                .selectByVisibleText(pais);
    }

    private void inputDescripcionDireccion(String descripcionDireccion) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpDescripcionDireccion());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpDescripcionDireccion())
                .waitUntilVisible()
                .type(descripcionDireccion);
    }

    private void inputDireccion(String direccion) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpDireccion());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpDireccion())
                .waitUntilVisible()
                .type(direccion);
    }

    private void inputCelular(String celular) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpCelular());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpCelular())
                .waitUntilVisible()
                .type(celular);
    }

    private void inputTelefonoFijo(String telefonoFijo) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpTelefono());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpTelefono())
                .waitUntilVisible()
                .type(telefonoFijo);
    }

    private void inputApellidos(String apellidos) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpApellidos());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpApellidos())
                .waitUntilVisible()
                .type(apellidos);
    }

    private void inputNombres(String campoExcel) {
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpNombres());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpNombres())
                .waitUntilVisible()
                .type(campoExcel);
    }

    private void agregarDireccion(){
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getAgregarDireccion());
        carritoDeComprasPageObject.clickOn(
                carritoDeComprasPageObject.find(carritoDeComprasPageObject.getAgregarDireccion()));
    }
    private void inputNombreDireccion(String campoExcel){
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getInpNombreDireccion());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getInpNombreDireccion())
                .type(campoExcel);
    }
    private void inputTipoVivienda(String campoExcel){
        scrollToElement(carritoDeComprasPageObject.getDriver(),carritoDeComprasPageObject.getSelectTipoDireccion());
        carritoDeComprasPageObject.find(
                        carritoDeComprasPageObject.getSelectTipoDireccion())
                .waitUntilVisible()
                .selectByValue(campoExcel);
    }
}
