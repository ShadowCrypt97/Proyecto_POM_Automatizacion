package com.sqasa.automatizacion.utils;

public class Regex {
    public static String limpiarNumeros(String numeroSinFormato){
        return numeroSinFormato.replaceAll("[^0-9]","");
    }

}
