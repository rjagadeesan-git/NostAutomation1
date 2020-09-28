package NostGroup.NostArtifact.Manage;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;

public class Pharmacy extends CommonMethods{
	
	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException {
		
//		Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//        Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		Thread.sleep(3000);
		click("organization","csssele");
		selectText("organization-selection","id",data.get("Organization"));
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("add-new-pharmacy","csssele"));
		Thread.sleep(2000);
		
		// Add Pharmacy
		click("add-new-pharmacy","csssele");
		type("pharmacy-name","csssele",data.get("Pharmacy_Name"));
		check("grant-control-rights","id",data.get("Grant_Control_Rights?"));
		selectText("nci-record","id",data.get("NCI_Record"));
		selectText("storage-condition1","id",data.get("Storage_Condition_1"));
		find_element("storage-location1","id").clear();
		type("storage-location1","id",data.get("Storage_Location_1"));
		check("disable-dispense-par-level1","id",data.get("Disable_Dispensing/Par_Level_1"));
	//	click("storage-cancel1","csssele");
		
		selectText("storage-condition2","id",data.get("Storage_Condition_2"));
		find_element("storage-location2","id").clear();
		type("storage-location2","id",data.get("Storage_Location_2"));
		check("disable-dispense-par-level2","id",data.get("Disable_Dispensing/Par_Level_2"));
//		click("storage-cancel2","csssele");
		
		selectText("storage-condition3","id",data.get("Storage_Condition_3"));
		find_element("storage-location3","id").clear();
		type("storage-location3","id",data.get("Storage_Location_3"));
		check("disable-dispense-par-level3","id",data.get("Disable_Dispensing/Par_Level_3"));
//		click("storage-cancel3","csssele");
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("add-more1","csssele"));
		
		selectText("storage-condition4","id",data.get("Storage_Condition_4"));
		find_element("storage-location4","id").clear();
		type("storage-location4","id",data.get("Storage_Location_4"));
		check("disable-dispense-par-level4","id",data.get("Disable_Dispensing/Par_Level_4"));	
//		click("storage-cancel4","csssele");

		//click("add-more1","csssele");
//		click("add-more2","csssele");
//		click("add-more3","csssele");
		
		//Pharmacy Address
		
		click("pharmacy-address","csssele");
		type("pharmacy-address-1","id",data.get("Address_1"));
		type("pharmacy-address-2","id",data.get("Address_2"));
		type("pharmacy-city","id",data.get("City"));
		type("pharmacy-state","id",data.get("State"	));
		type("pharmacy-zip-postalcode","id",data.get("Zip/PostalCode"));
		type("pharmacy-phone","id",data.get("Phone"));
		type("pharmacy-name-label-name","id",data.get("Pharmacy's_Name_for_Patient_Label"));
		type("pharmacy-dea","id",data.get("DEA"));
		
		//Pharmacy submission
		
		//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("pharmacy-esign","id"));
		type("pharmacy-esign","id",data.get("esignature"));
		click("pharmacy-submit","csssele");
		//click("pharmacy-cancel","csssele");

//		Thread.sleep(4000);
//		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));		
//		Thread.sleep(4000);
	}

	public void pharmacyEdit(Hashtable<String,String> data) throws InterruptedException {
		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		click("organization","csssele");
		selectText("organization-selection","id",data.get("Organization"));
		
//	Robot robo1=new Robot();
	Thread.sleep(2000);
	type("pharmacy-search-bar","id",data.get("Pharmacy_Name"));
//	Thread.sleep(2000);
//	robo1.keyPress(KeyEvent.VK_ENTER);
//	robo1.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	
	String pharmacy_name=data.get("Pharmacy_Name");
	String pharmacy_tab_id=prop.getProperty("pharmacy-search-result-tabu");
	//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
	tableCommon("pharmacy-search-result-tabu",pharmacy_tab_id,"Pharmacy",pharmacy_name,3,3,"checkbox_click");	
	Thread.sleep(2000);
	click("edit-pharmacy","csssele");
	Thread.sleep(2000);
	find_element("pharmacy-name","csssele").clear();
	type("pharmacy-name","csssele",data.get("Pharmacy_Name_Edit"));
	type("pharmacy-esign","id",data.get("esignature"));
	click("pharmacy-submit","csssele");
		
	}
	
	public void pharmacyDelete() {}
	
	public void pharmacyVerifyTable(Hashtable<String,String> data) throws InterruptedException {
		
//		 ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
//			action.moveToElement(find_element("manage-menu","xpath")).perform();
//			Thread.sleep(3000);
//			click("organization","csssele");
		Thread.sleep(2000);
			selectText("organization-selection","id",data.get("Organization"));
			Thread.sleep(2000);
		
//		Robot robo1=new Robot();
		Thread.sleep(2000);
		type("pharmacy-search-bar","id",data.get("Pharmacy_Name"));
//		Thread.sleep(2000);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String pharmacy_name=data.get("Pharmacy_Name");
		String pharmacy_tab_id=prop.getProperty("pharmacy-search-result-tabu");
		//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
		tableCommon("pharmacy-search-result-tabu",pharmacy_tab_id,"Pharmacy",pharmacy_name,3,3,"verify");
		
		
	}
	
	public void pharmacyEditVerify(Hashtable<String,String> data) throws InterruptedException {
		
//		 ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
//			action.moveToElement(find_element("manage-menu","xpath")).perform();
//			Thread.sleep(3000);
//			click("organization","csssele");
		Thread.sleep(2000);
			selectText("organization-selection","id",data.get("Organization"));
			Thread.sleep(2000);
		
//		Robot robo1=new Robot();
		Thread.sleep(2000);
		type("pharmacy-search-bar","id",data.get("Pharmacy_Name_Edit"));
//		Thread.sleep(2000);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String pharmacy_name=data.get("Pharmacy_Name_Edit");
		String pharmacy_tab_id=prop.getProperty("pharmacy-search-result-tabu");
		//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
		tableCommon("pharmacy-search-result-tabu",pharmacy_tab_id,"Pharmacy",pharmacy_name,3,3,"verify");
	
	}
	
	public void pharmacyDeleteVerify() {}
	
}
