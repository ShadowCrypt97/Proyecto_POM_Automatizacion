package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CarritoDeComprasPageObject extends PageObject {
    private final By cantidadLibros = By.xpath("//span[contains(@class,'amount text--md')]");
    private final By btnMas = By.xpath("//button[@data-dir='up']");
    private final By btnMenos = By.xpath("//button[@data-dir='dwn']");
    private final By btnCompletarCompra = By.xpath("//a[contains(text(),'Continuar con la compra')]");
    private final By inpNombreDireccion = By.id("nombre-direccion");
    private final By selectTipoDireccion = By.xpath("//select[@formcontrolname='tipo_direccion']");
    private final By inpNombres = By.xpath("//input[@placeholder='Nombres']");
    private final By inpApellidos = By.xpath("//input[@placeholder='Apellidos']");
    private final By inpTelefono = By.xpath("//input[@placeholder='Telefono fijo']");
    private final By inpCelular = By.xpath("//input[@placeholder='Telefono celular']");
    private final By inpDireccion = By.id("direccion");
    private final By inpDescripcionDireccion = By.id("direccion_descripcion");
    private final By selectPais = By.name("pais");
    private final By selectDepartamento = By.name("departamento");
    private final By selectCiudad = By.name("ciudad");
    private final By btnGuardarFormularioDireccion = By.xpath("//button[contains(text(),'Guardar')]");
    private final By agregarDireccion = By.xpath("//a[@href='/carrito/datos-envio/direccion/agregar']");
    private final By btnConfirmarAlerta = By.xpath("//button[text()='OK']");
    private final By direccionRegistrada = By.cssSelector("app-listas-direcciones>div>div");
    private final By valorUnitario = By.xpath("//div[text()='Valor unitario: ']/span");
    private final By valorTotal = By.xpath("//span[text()='TOTAL']/following-sibling::span");
    private final By cantidad = By.xpath("//div[text()='Cantidad: ']/span");

    public By getCantidad() {
        return cantidad;
    }

    public By getValorTotal() {
        return valorTotal;
    }

    public By getValorUnitario() {
        return valorUnitario;
    }

    public By getDireccionRegistrada() {
        return direccionRegistrada;
    }

    public By getBtnConfirmarAlerta() {
        return btnConfirmarAlerta;
    }

    public By getAgregarDireccion() {
        return agregarDireccion;
    }

    public By getBtnGuardarFormularioDireccion() {
        return btnGuardarFormularioDireccion;
    }

    public By getInpDireccion() {
        return inpDireccion;
    }

    public By getInpNombreDireccion() {
        return inpNombreDireccion;
    }

    public By getSelectTipoDireccion() {
        return selectTipoDireccion;
    }

    public By getInpNombres() {
        return inpNombres;
    }

    public By getInpApellidos() {
        return inpApellidos;
    }

    public By getInpTelefono() {
        return inpTelefono;
    }

    public By getInpCelular() {
        return inpCelular;
    }

    public By getInpDescripcionDireccion() {
        return inpDescripcionDireccion;
    }

    public By getSelectPais() {
        return selectPais;
    }

    public By getSelectDepartamento() {
        return selectDepartamento;
    }

    public By getSelectCiudad() {
        return selectCiudad;
    }

    public By getBtnMas() {
        return btnMas;
    }

    public By getBtnMenos() {
        return btnMenos;
    }

    public By getCantidadLibros() {
        return cantidadLibros;
    }

    public By getBtnCompletarCompra() {
        return btnCompletarCompra;
    }
}
