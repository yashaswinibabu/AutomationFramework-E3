package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	
	public static void main(String[] args) throws Throwable {
		
		//Step 1:open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\practiseexcel.xlsx");
		
		//Step 2:create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3:navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//Step 4: navigate to required row
		Row rw = sh.getRow(0);
		
		//Step 5:naviagte to required cell
		Cell cl = rw.getCell(0);
		
		//Step 6:capture the value and print
		String value = cl.getStringCellValue();
		System.out.println(value);
		
	}


}
