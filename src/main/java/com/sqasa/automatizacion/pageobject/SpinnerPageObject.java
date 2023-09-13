package com.sqasa.automatizacion.pageobject;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SpinnerPageObject extends PageObject {
    private final By spinner = By.cssSelector("div#spinner");

    public By getSpinner() {
        return spinner;
    }
}
