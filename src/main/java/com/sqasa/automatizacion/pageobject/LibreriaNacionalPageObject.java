package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://librerianacional.com/")
public class LibreriaNacionalPageObject extends PageObject {
  private final By accountBtn = By.xpath("(//button[@id='dropdownMenuLogin'])[2]");
  private final By registerBtn = By.cssSelector("div[x-placement]>a:nth-child(2)");
  private final By loginBtn = By.xpath("(//a[@href='/usuario/ingresar'])[2]");
  public By getAccountBtn() {
    return accountBtn;
  }
  public By getRegisterBtn(){
    return registerBtn;
  }

  public By getLoginBtn() {
    return loginBtn;
  }
}
