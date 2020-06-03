package BackUps;

import java.io.IOException;
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
	
	public void addPharmacy() throws IOException, InterruptedException {
		
//		Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//        Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		
		Thread.sleep(3000);
		
		click("organization","csssele");
		
		selectText("organization-selection","id",readExcel("NostData",16,1));
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("add-new-pharmacy","csssele"));
		
		Thread.sleep(2000);
		
		// Add Pharmacy
		click("add-new-pharmacy","csssele");
		
		type("pharmacy-name","csssele",readExcel("NostData",18,1));
		check("grant-control-rights","id",readExcel("NostData",18,2));
		selectText("nci-record","id",readExcel("NostData",18,3));
		
		selectText("storage-condition1","id",readExcel("NostData",18,4));
		find_element("storage-location1","id").clear();
		type("storage-location1","id",readExcel("NostData",18,5));
		check("disable-dispense-par-level1","id",readExcel("NostData",18,6));
	//	click("storage-cancel1","csssele");
		
		selectText("storage-condition2","id",readExcel("NostData",18,7));
		find_element("storage-location2","id").clear();
		type("storage-location2","id",readExcel("NostData",18,8));
		check("disable-dispense-par-level2","id",readExcel("NostData",18,9));
//		click("storage-cancel2","csssele");
		
		selectText("storage-condition3","id",readExcel("NostData",18,10));
		find_element("storage-location3","id").clear();
		type("storage-location3","id",readExcel("NostData",18,11));
		check("disable-dispense-par-level3","id",readExcel("NostData",18,12));
//		click("storage-cancel3","csssele");
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("add-more1","csssele"));
		
		selectText("storage-condition4","id",readExcel("NostData",18,13));
		find_element("storage-location4","id").clear();
		type("storage-location4","id",readExcel("NostData",18,14));
		check("disable-dispense-par-level4","id",readExcel("NostData",18,15));
//		click("storage-cancel4","csssele");

		//click("add-more1","csssele");
//		click("add-more2","csssele");
//		click("add-more3","csssele");
		
		//Pharmacy Address
		
		click("pharmacy-address","csssele");
		
		type("pharmacy-address-1","id",readExcel("NostData",18,16));
		type("pharmacy-address-2","id",readExcel("NostData",18,17));
		type("pharmacy-city","id",readExcel("NostData",18,18));
		type("pharmacy-state","id",readExcel("NostData",18,19));
		type("pharmacy-zip-postalcode","id",readExcel("NostData",18,20));
		type("pharmacy-phone","id",readExcel("NostData",18,21));
		type("pharmacy-name-label-name","id",readExcel("NostData",18,22));
		type("pharmacy-dea","id",readExcel("NostData",18,23));
		
		//Pharmacy submission
		
		//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("pharmacy-esign","id"));
		type("pharmacy-esign","id",readExcel("NostData",3,3));
		click("pharmacy-submit","csssele");
		//click("pharmacy-cancel","csssele");

//		Thread.sleep(4000);
//		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));		
//		Thread.sleep(4000);
	}

}
