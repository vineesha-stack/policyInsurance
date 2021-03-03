package com.policybazaar.input;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Input {
   public static DataFormatter formatter = new DataFormatter();
	public static String[] readExcelDataForTravel() throws IOException {
		FileInputStream fin = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\policybazaar\\input\\input data.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String[] value = new String[6];
		for (int i = 0; i < value.length; i++) {
			value[i] = formatter.formatCellValue(sheet.getRow(0).getCell(i));
		}
		workbook.close();
		fin.close();
		return value;
	}

	public static String[] readExcelDataForCar() throws IOException {
		FileInputStream fin = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\policybazaar\\input\\input data.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(1);
		String[] value = new String[3];
		for (int i = 0; i < value.length; i++) {
			value[i] = formatter.formatCellValue(sheet.getRow(0).getCell(i));
		}
		workbook.close();
		fin.close();
		return value;
	}

	public static String[] readExcelDataForHealth() throws IOException {
		FileInputStream fin = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\policybazaar\\input\\input data.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(2);
		DataFormatter formatter = new DataFormatter();
		String[] value = new String[3];
		for (int i = 0; i < value.length; i++) {
			value[i] = formatter.formatCellValue(sheet.getRow(0).getCell(i));
		}
		workbook.close();
		fin.close();
		return value;
	}


}
