package com.sqasa.automatizacion.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/libreria_nacional.feature",
        glue = "com.sqasa.automatizacion.stepdefinitions",
        tags = "@HistoriaDeUsuario",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome=true
)
public class LibreriaNacionalRunner {
}
