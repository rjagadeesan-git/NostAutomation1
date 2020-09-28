package NostGroup.NostArtifact.Base;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CellDataProvider {
	
	public static SpreadSheetHelper helper=null;
	
	@DataProvider
public static Object[][] getData(Method m){
		
		String sheetName=null;
		
		if(helper == null){
			helper = new SpreadSheetHelper(".\\DataProvider\\Nost_Data_Driven_DP.xlsx");
		}
		
		//helper = new SpreadSheetHelper("D:\\Jagan\\Nost_Data_Driven_DP.xlsx");
		
		for(int a=0;a<helper.workbook.getNumberOfSheets();a++) {
			
		if(m.getName().contains(helper.workbook.getSheetName(a))) {	
			sheetName=helper.workbook.getSheetName(a);
			System.out.println(sheetName);
		} 
	}
		
		//String sheetName="NostLogin";
		int rows = helper.getRowCount(sheetName);
		int cols = helper.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		//DataFormatter formatter=new DataFormatter();
		
		for(int rowNum=2; rowNum<=rows; rowNum++){
			
			table = new Hashtable<String,String>();
			
			for(int colNum=0; colNum<cols; colNum++){
				
		//	data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
			String picker1=helper.getCellData(sheetName,1,colNum);
			String picker2=helper.getCellData(sheetName,rowNum,colNum);
			//table.put(helper.getCellData(sheetName,1,colNum), helper.getCellData(sheetName,rowNum,colNum));
				table.put(picker1, picker2);
			data[rowNum-2][0]=table;	
				
			}
			
		}
		
		return data;
			
	}
	

}