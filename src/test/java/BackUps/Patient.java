package BackUps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;

public class Patient extends CommonMethods{
	
	public void addPatient() throws IOException, InterruptedException, AWTException {
		
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		Actions action=new Actions(Driver);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();	
		Thread.sleep(3000);
		click("patient-menu","csssele");
				//((JavascriptExecutor)Driver).executeScript("loadPatientCodelst();");
		Thread.sleep(2000);	
		click("add-patient-to-protocol","csssele");
//	click("patient-edit","csssele");
//	click("dispense-to-patient","csssele");
	
	// Add Patient
	//click("add-patient","csssele");
	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mrn")));
	Thread.sleep(2000);
	type("patient-mrn","id",readExcel("NostData",28,1));
	Thread.sleep(2000);
	type("patient-first-name","id",readExcel("NostData",28,2));
	type("patient-last-name","id",readExcel("NostData",28,3));
	selectText("patient-gender","id",readExcel("NostData",28,4));
	type("patient-dob","id",readExcel("NostData",28,5));
	selectText("patient-status","id",readExcel("NostData",28,6));
	
	//Selecting Protocol
	type("patient-protocol-id","id",readExcel("NostData",28,7));
	Thread.sleep(2000);
	Robot robo=new Robot();
	robo.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	 type("patient-study-id","id",readExcel("NostData",28,8));
	 String drug_com=String.join(" ",readExcel("NostData",13,1),readExcel("NostData",13,3),readExcel("NostData",13,4));
     System.out.println(" The Drug combination text in Receive to be selected is  "+ drug_com);
     String pat_drg_val=readExcel("NostData",13,1);
     List<WebElement> pat_drg_opt=Driver.findElements(By.tagName("Option"));
   for(WebElement element:pat_drg_opt)
	    if(element.getText().contains(pat_drg_val)) {
	    	element.click();
	    }
	
	//Selecting Drug
//	click("assigned-drug-plus","csssele");
//	type("patient-start-date","id",readExcel("NostData",28,10));
//	type("patient-stop-date","id",readExcel("NostData",28,11));
	type("cohort-dose-level","id",readExcel("NostData",28,12));
	
	//Add Contact info
	click("add-contact-info","csssele");
	type("address-1","id",readExcel("NostData",28,13));
	type("address-2","id",readExcel("NostData",28,14));
	type("city","id",readExcel("NostData",28,15));
	type("state","id",readExcel("NostData",28,16));
	type("zip-postal-code","id",readExcel("NostData",28,17));
	type("country","id",readExcel("NostData",28,18));
	type("home-phone","id",readExcel("NostData",28,19));
	type("work-phone","id",readExcel("NostData",28,20));
	type("email","id",readExcel("NostData",28,21));
	type("pid","id",readExcel("NostData",28,22));
	type("patient-esgin","id",readExcel("NostData",3,3));
	click("patient-submit","id");
	
	Thread.sleep(4000);
	((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
	Thread.sleep(4000);
	}
	
	public void editPatient() {}
	
	public void dispenseToPatient() {}
	
	public void pat_Prot_Disso() {}
	
}
