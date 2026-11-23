package config;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelReader 
{
	@Test
	public void excelreader() throws EncryptedDocumentException, IOException
	{
	//Step1- Let project know where is your excel sheet?
		//FileInputStrem is a class
	FileInputStream file = new FileInputStream("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmazonE2EProject\\test-output\\ExcelSheet\\AmazonE2ETestData.xlsx");
	//Step2= Opening ExcelSheet
	Workbook workbook= WorkbookFactory.create(file);
	//Workbook is an interface, with its help we can open sheet
	//Step3= Open your required sheet
	Sheet sheet= workbook.getSheet("product");
	//Step4= Open Row
	Row row = sheet.getRow(0);
	//Step5= Open cell/column
	Cell cell= row.getCell(0);
	//Step6=Get column value
	String productname =cell.getStringCellValue();
	System.out.println(productname);
	//Above can be done in one line as well
	//String productname1 = workbook.getSheet("product").getRow(1).getCell(0).getStringCellValue();
	//System.out.println(productname1);
	workbook.close();
	file.close();
	}
}
