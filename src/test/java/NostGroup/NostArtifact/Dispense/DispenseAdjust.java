package NostGroup.NostArtifact.Dispense;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NostGroup.NostArtifact.Base.CommonMethods;

public class DispenseAdjust extends CommonMethods {
	
	public void dispAdjustVerify(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		ex_wait= new WebDriverWait(Driver,20);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Dispense")));
		action.moveToElement(find_element("dispense-menu","csssele")).perform();
		Thread.sleep(3000);
		ex_wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
		Thread.sleep(3000);
		click("dispense-adjust","csssele");
		
		type("dispense-adjust-protid","id",data.get("dispense-pat-mrn"));
		//Thread.sleep(2000);
		type("dispense-adjust-drugid","id",data.get("dispense-pat-mrn"));
		//Thread.sleep(2000);
		
		
	}
	
	public void dispReversal() {}

}
