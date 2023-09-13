package com.sqasa.automatizacion.steps;

import com.sqasa.automatizacion.pageobject.ModuloLoginPageObject;
import com.sqasa.automatizacion.utils.DatosExcelListas;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class ModuloLoginStep {
    private final ModuloLoginPageObject moduloLoginPageObject = new ModuloLoginPageObject();

    @Step
    public void completarLogin() throws IOException {
        var excelList = DatosExcelListas.readExcel("src/test/resources/Data/DataEntry.xlsx","Hoja1");
        var camposExcel = excelList.get(0);
        moduloLoginPageObject.clickOn(moduloLoginPageObject.find(moduloLoginPageObject.getEmailAndPasswordLoginBtn()));
        moduloLoginPageObject.waitFor(ExpectedConditions.visibilityOf(moduloLoginPageObject.find(
                moduloLoginPageObject.getUsuario()))).sendKeys(camposExcel.get("Correo electrónico"));
        moduloLoginPageObject.waitFor(ExpectedConditions.visibilityOf(moduloLoginPageObject.find(
                moduloLoginPageObject.getPassword()))).sendKeys(camposExcel.get("Contraseña"));
        moduloLoginPageObject.clickOn(moduloLoginPageObject.find(moduloLoginPageObject.getLoginBtn()));
    }
}
