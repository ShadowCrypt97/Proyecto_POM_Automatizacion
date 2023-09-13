package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ModuloRegistroPageObject extends PageObject {
    private final By email = By.id("email");
    private final By nombres = By.id("nombres");
    private final By apellidos = By.id("apellidos");
    private final By tipoDocumento = By.name("tipo_identificacion");
    private final By numeroDocumento = By.id("identificacion");
    private final By celular = By.id("telefono_movil");
    private final By telefono = By.id("telefono");
    private final By contrasena = By.id("contrasena");
    private final By confirmarContrasena = By.id("repeatContrasena");
    private final By checkboxTerminosYCondiciones = By.id("terminosCondiciones");
    private final By btnRegistrarme = By.xpath("//button[text()='Registrarme']");

    public By getBtnRegistrarme() {
        return btnRegistrarme;
    }

    public By getCheckboxTerminosYCondiciones() {
        return checkboxTerminosYCondiciones;
    }

    public By getEmail() {
        return email;
    }

    public By getNombres() {
        return nombres;
    }

    public By getApellidos() {
        return apellidos;
    }

    public By getTipoDocumento() {
        return tipoDocumento;
    }

    public By getNumeroDocumento() {
        return numeroDocumento;
    }

    public By getCelular() {
        return celular;
    }

    public By getTelefono() {
        return telefono;
    }

    public By getContrasena() {
        return contrasena;
    }

    public By getConfirmarContrasena() {
        return confirmarContrasena;
    }
}
