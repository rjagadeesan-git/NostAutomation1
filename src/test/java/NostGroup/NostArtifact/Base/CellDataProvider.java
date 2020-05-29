package NostGroup.NostArtifact.Base;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class CellDataProvider {
	
	public static SpreadSheetHelper helper=null; 
	
	@DataProvider
public static Object[][] getData(){
		
		if(helper == null){
			helper = new SpreadSheetHelper("c:\\selenium\\testngdata.xlsx");
		}
		
		String sheetName="loginTest";
		int rows = helper.getRowCount(sheetName);
		int cols = helper.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++){
			
			table = new Hashtable<String,String>();
			
			for(int colNum=0; colNum<cols; colNum++){
				
		//	data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
		
			table.put(helper.getCellData(sheetName, colNum, 1), helper.getCellData(sheetName, colNum, rowNum));	
			data[rowNum-2][0]=table;	
				
			}
			
		}
		
		return data;
			
	}

}