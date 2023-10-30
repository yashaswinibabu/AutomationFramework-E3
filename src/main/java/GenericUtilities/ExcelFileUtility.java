package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic methods related to excel file
 * @author Admin
 *
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	
	public String ReadDataFromExcelFile(String sheetname,int rowno,int cellno) throws Throwable  {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\practiseexcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
		
		
	}
	
	/**
	 * This method will read multiple data from excel sheet at time used for data provider
	 * @param Sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDate(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practiseexcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			
			for (int j = 0; j < lastCell; j++) 
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;
	}

}
