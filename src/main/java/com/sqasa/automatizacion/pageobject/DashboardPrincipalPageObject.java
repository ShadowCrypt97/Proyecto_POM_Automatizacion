package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardPrincipalPageObject extends PageObject {
    private final By strNombreUsuario = By.xpath("//div[contains(text(),'Hola,')]");
    private final By inpSearchBooks = By.xpath("(//input[@formcontrolname='buscar'])[2]");
    private final By productCard = By.xpath("(//a[@href='/producto/313667'])[1]");
    private final By addToCartBtn = By.xpath("//span[text()='Agregar al carrito']");
    private final By verCarritoBtn =By.xpath("//button[text()='Ver Carrito de Compras']");

    public By getVerCarritoBtn() {
        return verCarritoBtn;
    }

    public By getStrNombreUsuario() {
        return strNombreUsuario;
    }
    public By getInpSearchBooks() {
        return inpSearchBooks;
    }
    public By getProductCard() {
        return productCard;
    }
    public By getAddToCartBtn() {
        return addToCartBtn;
    }
}
