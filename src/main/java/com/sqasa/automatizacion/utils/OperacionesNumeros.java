package com.sqasa.automatizacion.utils;

public final class OperacionesNumeros {
  private OperacionesNumeros() {
    throw new IllegalStateException("Utility class");
  }
  public static <T extends Number> Boolean validator(T value) {
    return value instanceof Double || value instanceof Integer;
  }
}
