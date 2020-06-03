package NostGroup.NostArtifact.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NostLogin extends CommonMethods{
	
	//public static SpreadSheetHelper helper=null;
	
//	public NostLogin(String filepath) throws IOException {
//		super(filepath);
//	
//	}

	public void nost_Login(Hashtable<String,String> data) throws IOException {
		
//		WebDriverManager.firefoxdriver().setup();
//		Driver=new FirefoxDriver();
//		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Otherfiles\\locators.properties");
//		prop.load(propin);
		
	System.out.println(prop.getProperty("url"));
	Driver.get(prop.getProperty("url"));
    System.out.println(Driver.getTitle());
    System.out.println("Starting to Login...");

    type("username","xpath",data.get("UserName"));
    type("password","xpath",data.get("PassWord"));
    click("login-button","xpath");
	
	}

//	public static Object[][] getData(){
//			
//			if(helper == null){
//				helper = new SpreadSheetHelper("D:\\Jagan\\Nost_Data_Driven_DP.xlsx");
//			}
//			
//			String sheetName="NostLogin";
//			int rows = helper.getRowCount(sheetName);
//			int cols = helper.getColumnCount(sheetName);
//			
//			Object[][] data = new Object[rows-1][1];
//			
//			Hashtable<String,String> table = null;
//			
//			for(int rowNum=2; rowNum<=rows; rowNum++){
//				
//				table = new Hashtable<String,String>();
//				
//				for(int colNum=0; colNum<cols; colNum++){
//					
//			//	data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
//			
//				table.put(helper.getCellData(sheetName,1,colNum), helper.getCellData(sheetName,rowNum,colNum));	
//				data[rowNum-2][0]=table;	
//					
//				}
//				
//			}
//			
//			return data;
//				
//		}
}
