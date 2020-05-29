package NostGroup.NostArtifact.Manage;

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

public class Supplier extends CommonMethods{
	
	public void addSupplier() throws IOException, InterruptedException {
		
//		Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		Thread.sleep(2000);
		click("organization","csssele");
		System.out.println("Page loaded");
		Thread.sleep(2000);
		selectText("organization-selection","id",readExcel("NostData",19,1));
		Thread.sleep(3000);
		System.out.println("Organization selected");
		Thread.sleep(2000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("supplier-add","csssele"));
		click("supplier-add","csssele");
		type("supplier-name","csssele",readExcel("NostData",21,1));
		click("add-more-supplier1","csssele");
		type("supplier-name-1","csssele",readExcel("NostData",21,2));
		click("add-more-supplier2","csssele");
		type("supplier-name-2","csssele",readExcel("NostData",21,3));
		type("supplier-esign","id",readExcel("NostData",3,3));
		click("supplier-submit","id");
//		click("supplier-cancel","csssele");

//		click("supplier-edit","csssele");
//		type("supplier-delete-esign","id",readExcel("NostData",3,3));
//		click("supplier-delete","id");

		Thread.sleep(4000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
		Thread.sleep(4000);
	}

}
