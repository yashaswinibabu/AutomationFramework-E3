package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelFile {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\WriteData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		
		wb.getSheet("demo").createRow(0).createCell(0).setCellValue("TC_ID");
		
		wb.getSheet("demo").createRow(1).createCell(0).setCellValue("TC_001");
		
		FileOutputStream fo=new FileOutputStream(".\\src\\test\\resources\\WriteData.xlsx");
		
		wb.write(fo);
		
	}

}
