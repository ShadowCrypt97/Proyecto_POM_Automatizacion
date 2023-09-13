package com.sqasa.automatizacion.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public final class ActionsWebElements {
    private ActionsWebElements() {
        throw new IllegalStateException("Utility class");
    }
    public static void moveToElementAndHover(WebDriver driver, By hoverElement){
        var builder = new Actions(driver);
        builder.moveToElement(driver.findElement(hoverElement)).perform();
    }
    public static void scrollToElement(WebDriver driver, By webElement){
        var builder = new Actions(driver);
        builder.scrollToElement(driver.findElement(webElement)).perform();
    }
}
