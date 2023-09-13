package com.sqasa.automatizacion.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DatosExcelListas {
  private DatosExcelListas() {
    throw new IllegalStateException("Utility class");
  }
  public static List<Map<String, String>> readExcel(String rutaDeExcel, String hojaDeExcel) throws IOException {
    ArrayList<Map<String, String>> arrayListDatoPlanTrabajo = new ArrayList<>();
    Map<String, String> informacionProyecto = new HashMap<>();
    var file = new File(rutaDeExcel);
    var inputStream = new FileInputStream(file);
    var newWorkbook = new XSSFWorkbook(inputStream);
    XSSFSheet newSheet = newWorkbook.getSheet(hojaDeExcel);
    Iterator<Row> rowIterator = newSheet.iterator();
    var titulos = rowIterator.next();
    while (rowIterator.hasNext()) {
      var row = rowIterator.next();
      Iterator<Cell> cellIterator = row.cellIterator();
      while (cellIterator.hasNext()) {
        var cell = cellIterator.next();
        cell.getColumnIndex();
        switch (cell.getCellType()) {
          case STRING ->
            informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),cell.getStringCellValue());
          case NUMERIC ->
            informacionProyecto.put(
              titulos.getCell(cell.getColumnIndex()).toString(),String.valueOf((long)cell.getNumericCellValue()));
          case BLANK ->
            informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),"");
          default ->
            informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),"");
        }
      }
      arrayListDatoPlanTrabajo.add(informacionProyecto);
      informacionProyecto = new HashMap<>();
    }
    newWorkbook.close();
    return arrayListDatoPlanTrabajo;
  }
}
