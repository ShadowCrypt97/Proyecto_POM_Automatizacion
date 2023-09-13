package com.sqasa.automatizacion.stepdefinitions;

import com.sqasa.automatizacion.steps.CarritoDeComprasStep;
import com.sqasa.automatizacion.steps.DashboardPrincipalStep;
import com.sqasa.automatizacion.steps.LibreriaNacionalStep;
import com.sqasa.automatizacion.steps.ModuloLoginStep;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ComprarLibrosStepDefinitions {
    @Steps
    LibreriaNacionalStep libreriaNacionalStep;
    @Steps
    ModuloLoginStep moduloLoginStep;
    @Steps
    DashboardPrincipalStep dashboardPrincipalStep;
    @Steps
    CarritoDeComprasStep carritoDeComprasStep;
    @E("ingreso con una cuenta registrada")
    public void ingresoConUnaCuentaRegistrada() throws IOException {
        libreriaNacionalStep.abrirLogin();
        moduloLoginStep.completarLogin();
    }

    @Cuando("busco el Libro {string}")
    public void buscoElLibroNombreLibro(String strNombreLibro) {
        dashboardPrincipalStep.buscarLibro(strNombreLibro);
    }

    @Y("lo agrego al carrito de compras")
    public void loAgregoAlCarritoDeCompras() {
        dashboardPrincipalStep.agregarAlCarrito();
    }

    @Y("vea el carrito de compras")
    public void veaElCarritoDeCompras() {
        dashboardPrincipalStep.verCarritoDeCompras();
    }

    @Y("agregue la cantidad de {int} libros")
    public void agregueLaCantidadDeCantidadLibros(Integer intCantidadLibros) {
        carritoDeComprasStep.agregarCantidadLibros(intCantidadLibros);
    }

    @Y("continue con la compra")
    public void continueConLaCompra() {
        carritoDeComprasStep.completarCompra();
    }

    @Y("adicione la información para el envío")
    public void adicioneLaInformacionParaElEnvio() throws IOException {
        carritoDeComprasStep.completarFormularioEnvio();
        carritoDeComprasStep.completarCompra();
    }

    @Entonces("verifico que la cantidad de libros es {int}")
    public void verificoQueLaCantidadDeLibrosEsCantidad(Integer intCantidadLibros) {
        carritoDeComprasStep.verificarCantidadLibros(intCantidadLibros);
    }

    @Y("verifico el total de la compra realizada para {int} libros")
    public void verificoElTotalDeLaCompraRealizada(Integer intCantidadLibros) {
        carritoDeComprasStep.verificarTotalCompra(intCantidadLibros);
    }
}
