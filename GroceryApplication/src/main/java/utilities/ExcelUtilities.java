package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public static FileInputStream f;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;

	public static String readExcelData(int row, int col, String filePath, String sheetName) throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		String value = formatter.formatCellValue(c);
		return value;	
	}
	
	public static String readStringData(int row, int col, String filePath, String sheetName) throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();		
	}
	
	public static String readIntegerData(int row, int col, String filePath, String sheetName) throws IOException{
		f = new FileInputStream(filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue();
		return String.valueOf(val);
	}
	
	/*public static String readDataFromGroceryApplicationRowColumn(int row, int column, String filePath,String sheetName) throws IOException{
		f = new FileInputStream(System.getProperty("user.dir") + filePath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		String value = formatter.formatCellValue(c);
		//return c.getStringCellValue();
		return value;
	}
	
	public static String readDataFromExcelGroceryApplicationData(int cellNumber, String sheetName)
			throws IOException, InvalidFormatException {
		String path = System.getProperty("usr.dir") + "‪F:\\GroceryApplicationData.xlsx";
		ArrayList<String> excelRows = new ArrayList<String>();
		f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		for (Row r : sh) {
			for (Cell c : r) {
				if (c !=null && !c.toString().isEmpty()) {
					excelRows.add(formatter.formatCellValue(c));
				}
			}
		}
		return excelRows.get(cellNumber);
	}*/

}
