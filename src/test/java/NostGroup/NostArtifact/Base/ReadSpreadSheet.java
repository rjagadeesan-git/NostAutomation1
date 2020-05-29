package NostGroup.NostArtifact.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSpreadSheet {
	
	XSSFWorkbook book;
	
	//XSSFSheet login;
	//XSSFSheet Bugcreation;

	public ReadSpreadSheet(String spreadsheet) throws IOException {
		
		try
		{
		File src=new File(spreadsheet);
		
		FileInputStream excel_in= new FileInputStream(src);
		
		book= new XSSFWorkbook(excel_in);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getData(String sheetName,int row,int col) {
		
		//System.out.println(sheetName);
		
		XSSFSheet login=book.getSheet(sheetName);
		
		//System.out.println(row);
		//System.out.println(col);
		
		String data=login.getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
		
	}
}
