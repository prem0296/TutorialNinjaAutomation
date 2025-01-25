package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static XSSFCellStyle style ;
	public static String path;
	
	public Excel(String path) {
		
		this.path = path ;
	}

	public static int getRowCount(String sheetname) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return lastRowNum;
	}


	public static int getCellCount(String sheetname , int rownum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int lastCellNum = row.getLastCellNum();
		workbook.close();
		fis.close();
		return lastCellNum;
	}

	public static String getCellData(String sheetname , int rownum , int cellnum) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		try {
			//data = cell.toString();
			DataFormatter format = new DataFormatter();
			data = format.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fis.close();
		return data;
	}

	public static void setCellData(String sheetname , int rownum , int cellnum , String data) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		 fos = new FileOutputStream(path);
		 workbook.write(fos);
		 workbook.close();
		 fis.close();
		 fos.close();
		
	}
	
	public static void setGreenColour(String sheetname , int rownum , int cellnum ) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		 style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 
		 fos = new FileOutputStream(path);
		 workbook.write(fos);
		 workbook.close();
		 fis.close();
		 fos.close();
		
	}
	
	public static void setRedColour(String sheetname , int rownum , int cellnum ) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		 style = workbook.createCellStyle();
		 style.setFillForegroundColor(IndexedColors.RED.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 cell.setCellStyle(style);
		 
		 fos = new FileOutputStream(path);
		 workbook.write(fos);
		 workbook.close();
		 fis.close();
		 fos.close();

}
}
