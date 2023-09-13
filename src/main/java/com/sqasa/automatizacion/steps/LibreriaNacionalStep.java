package com.sqasa.automatizacion.steps;

import com.sqasa.automatizacion.pageobject.LibreriaNacionalPageObject;
import net.thucydides.core.annotations.Step;

public class LibreriaNacionalStep {
  private final LibreriaNacionalPageObject libreriaNacionalPageObject = new LibreriaNacionalPageObject();
  @Step
  public void abrirNavegador(){
    libreriaNacionalPageObject.open();
  }

  @Step
  public void abrirRegistroNuevaCuenta(){
    libreriaNacionalPageObject.clickOn(libreriaNacionalPageObject.find(libreriaNacionalPageObject.getAccountBtn()));
    libreriaNacionalPageObject.clickOn(libreriaNacionalPageObject.find(libreriaNacionalPageObject.getRegisterBtn()));
  }
  @Step
  public void abrirLogin(){
    libreriaNacionalPageObject.clickOn(libreriaNacionalPageObject.find(libreriaNacionalPageObject.getAccountBtn()));
    libreriaNacionalPageObject.clickOn(libreriaNacionalPageObject.find(libreriaNacionalPageObject.getLoginBtn()));
  }
}
