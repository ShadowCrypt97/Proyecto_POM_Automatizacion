package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ModuloLoginPageObject extends PageObject {
    By emailAndPasswordLoginBtn = By.cssSelector("a[href='/usuario/iniciar-sesion']");
    By usuario = By.name("usuario");
    By password = By.name("contrasena");
    By loginBtn = By.tagName("button");
    public By getEmailAndPasswordLoginBtn() {
        return emailAndPasswordLoginBtn;
    }
    public By getUsuario() {
        return usuario;
    }
    public By getPassword() {
        return password;
    }
    public By getLoginBtn() {
        return loginBtn;
    }
}
