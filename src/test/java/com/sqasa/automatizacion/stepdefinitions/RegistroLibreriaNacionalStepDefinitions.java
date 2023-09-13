package com.sqasa.automatizacion.stepdefinitions;


import com.sqasa.automatizacion.steps.DashboardPrincipalStep;
import com.sqasa.automatizacion.steps.LibreriaNacionalStep;
import com.sqasa.automatizacion.steps.ModuloRegistroStep;
import io.cucumber.java.es.*;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class RegistroLibreriaNacionalStepDefinitions {
    @Steps
    LibreriaNacionalStep libreriaNacionalStep;
    @Steps
    ModuloRegistroStep moduloRegistroStep;
    @Steps
    DashboardPrincipalStep dashboardPrincipalStep;
    @Dado("que me encuentro en la página web de la Librería Nacional")
    public void queMeEncuentroEnLaPaginaWebDeLaLibreriaNacional() {
        libreriaNacionalStep.abrirNavegador();
    }

    @Y("me encuentro en la opción de registrarme")
    public void meEncuentroEnLaOpcionDeRegistrarme() {
        libreriaNacionalStep.abrirRegistroNuevaCuenta();
    }

    @Cuando("realice el registro de mi cuenta en la página")
    public void realiceElRegistroDeMiCuentaEnLaPagina() throws IOException {
        moduloRegistroStep.completarFormularioRegistro();
    }

    @Entonces("verifico que la cuenta haya sido creada exitosamente")
    public void verificoQueLaCuentaHayaSidoCreadaExitosamente() throws IOException {
        dashboardPrincipalStep.verificarRegistroExitoso();
    }
}
