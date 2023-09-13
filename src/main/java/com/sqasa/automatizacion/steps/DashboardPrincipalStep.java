package com.sqasa.automatizacion.steps;

import com.sqasa.automatizacion.pageobject.DashboardPrincipalPageObject;
import com.sqasa.automatizacion.utils.DatosExcelListas;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static com.sqasa.automatizacion.utils.ActionsWebElements.moveToElementAndHover;
import static com.sqasa.automatizacion.utils.ActionsWebElements.scrollToElement;

public class DashboardPrincipalStep {
    public static final long SECONDS_OF_WAIT = 10;
    private final DashboardPrincipalPageObject dashboardPrincipalPageObject = new DashboardPrincipalPageObject();
    private final WebDriver driver = dashboardPrincipalPageObject.getDriver();

    @Step
    public void verificarRegistroExitoso() throws IOException {
        var listDatosExcel = DatosExcelListas.readExcel("src/test/resources/Data/DataEntry.xlsx","Hoja1");
        var strTitleObtained = dashboardPrincipalPageObject.waitForElement().forUpTo(SECONDS_OF_WAIT).until(
                ExpectedConditions.visibilityOf(dashboardPrincipalPageObject.find(
                dashboardPrincipalPageObject.getStrNombreUsuario()))).getText();
        var camposExcel = listDatosExcel.get(0);
        var strNombreUsuario = camposExcel.get("Nombre(s)");
        String strTitleExpected = "Hola, "+strNombreUsuario+"!";
        Assert.assertEquals("Verificar titulo con nombre de usuario",strTitleExpected,strTitleObtained);
    }
    @Step
    public void buscarLibro(String nombreLibro){
        dashboardPrincipalPageObject.waitForElement().forUpTo(SECONDS_OF_WAIT).until(
                ExpectedConditions.elementToBeClickable(dashboardPrincipalPageObject.getInpSearchBooks()));
        dashboardPrincipalPageObject.find(dashboardPrincipalPageObject.getInpSearchBooks()).typeAndEnter(nombreLibro);
    }

    @Step
    public void agregarAlCarrito() {
        dashboardPrincipalPageObject.waitForElement().forUpTo(SECONDS_OF_WAIT).until(
                ExpectedConditions.presenceOfElementLocated(dashboardPrincipalPageObject.getProductCard()
        ));
        scrollToElement(driver,dashboardPrincipalPageObject.getProductCard());
        moveToElementAndHover(driver,dashboardPrincipalPageObject.getProductCard());
        dashboardPrincipalPageObject.clickOn(
                dashboardPrincipalPageObject.find(dashboardPrincipalPageObject.getAddToCartBtn()));
    }
    @Step
    public void verCarritoDeCompras() {
        dashboardPrincipalPageObject.waitForElement().forUpTo(SECONDS_OF_WAIT).until(
                ExpectedConditions.presenceOfElementLocated(dashboardPrincipalPageObject.getVerCarritoBtn()
                ));
        dashboardPrincipalPageObject.clickOn(
                dashboardPrincipalPageObject.find(dashboardPrincipalPageObject.getVerCarritoBtn()));
    }
}
