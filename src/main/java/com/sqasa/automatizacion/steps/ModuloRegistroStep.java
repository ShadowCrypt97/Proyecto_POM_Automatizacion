package com.sqasa.automatizacion.steps;

import com.sqasa.automatizacion.pageobject.ModuloRegistroPageObject;
import com.sqasa.automatizacion.utils.DatosExcelListas;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ModuloRegistroStep {
    private final ModuloRegistroPageObject moduloRegistroPageObject = new ModuloRegistroPageObject();

    @Step
    public void completarFormularioRegistro() throws IOException {
        List<Map<String,String>> datosExcelList =
                DatosExcelListas.readExcel("src/test/resources/Data/DataEntry.xlsx","Hoja1");
        var camposExcel = datosExcelList.get(0);
        moduloRegistroPageObject.enter(camposExcel.get("Correo electrónico"))
                .into(moduloRegistroPageObject.getEmail());
        moduloRegistroPageObject.enter(camposExcel.get("Nombre(s)"))
                .into(moduloRegistroPageObject.getNombres());
        moduloRegistroPageObject.enter(camposExcel.get("Apellido(s)"))
                .into(moduloRegistroPageObject.getApellidos());
        moduloRegistroPageObject.find(moduloRegistroPageObject.getTipoDocumento())
                .selectByValue(camposExcel.get("Tipo Documento"));
        moduloRegistroPageObject.enter(camposExcel.get("Número de documento"))
                .into(moduloRegistroPageObject.getNumeroDocumento());
        moduloRegistroPageObject.enter(camposExcel.get("Teléfono Celular"))
                .into(moduloRegistroPageObject.getCelular());
        moduloRegistroPageObject.enter(camposExcel.get("Teléfono Fijo"))
                .into(moduloRegistroPageObject.getTelefono());
        moduloRegistroPageObject.enter(camposExcel.get("Contraseña"))
                .into(moduloRegistroPageObject.getContrasena());
        moduloRegistroPageObject.enter(camposExcel.get("Contraseña"))
                .into(moduloRegistroPageObject.getConfirmarContrasena());
        moduloRegistroPageObject.clickOn(
                moduloRegistroPageObject.find(moduloRegistroPageObject.getCheckboxTerminosYCondiciones()));
        moduloRegistroPageObject.clickOn(
                moduloRegistroPageObject.find(moduloRegistroPageObject.getBtnRegistrarme()));
    }
}
