package NostGroup.NostArtifact.Manage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Supplier extends CommonMethods{
	
	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
		
//		Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		Thread.sleep(2000);
		click("organization","csssele");
		System.out.println("Page loaded");
		Thread.sleep(2000);
		selectText("organization-selection","id",data.get("Organization"));
		Thread.sleep(3000);
		System.out.println("Organization selected "+data.get("Organization"));
		Thread.sleep(2000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("supplier-add","csssele"));
		click("supplier-add","csssele");
		type("supplier-name","csssele",data.get("Supplier_Name_1"));
		click("add-more-supplier1","csssele");
		type("supplier-name-1","csssele",data.get("Supplier_Name_2"));
		click("add-more-supplier2","csssele");
		type("supplier-name-2","csssele",data.get("Supplier_Name_3"));
		type("supplier-esign","id",data.get("esignature"));
		click("supplier-submit","id");
//		click("supplier-cancel","csssele");

//		click("supplier-edit","csssele");
//		type("supplier-delete-esign","id",readExcel("NostData",3,3));
//		click("supplier-delete","id");

		Thread.sleep(4000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
		Thread.sleep(4000);
	}

	public void supplierEdit() {}
	
	public void supplierDelete() {}
	
	public void supplierVerifyTable(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		Thread.sleep(2000);
		click("organization","csssele");
		System.out.println("Page loaded");
		Thread.sleep(2000);
		selectText("organization-selection","id",data.get("Organization"));
		Thread.sleep(3000);
		System.out.println("Organization selected "+data.get("Organization"));
		
		Robot robo1=new Robot();
		Thread.sleep(2000);
		type("supplier-search-bar","csssele",data.get("Supplier_Name_1"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String supplier_name=data.get("Supplier_Name_1");
		String supplier_tab_id=prop.getProperty("supplier-search-result-tabu");
		//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
		tableCommon("supplier-search-result-tabu",supplier_tab_id,"Supplier",supplier_name,2,2,"verify");
		
	}
	
	public void supplierEditVerify() {}
	
	public void supplierDeleteVerify() {}
	
	
	
}
