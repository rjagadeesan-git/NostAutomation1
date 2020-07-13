package NostGroup.NostArtifact.Manage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;

public class Patient extends CommonMethods{
	
	public void addPatient(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
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
	type("patient-mrn","id",data.get("Patient_MRN"));
	Thread.sleep(2000);
	type("patient-first-name","id",data.get("Patient_First_Name"));
	type("patient-last-name","id",data.get("Patient_Last_Name"));
	selectText("patient-gender","id",data.get("Gender"));
	type("patient-dob","id",data.get("Patient_DOB"));
	selectText("patient-status","id",data.get("Patient_Status"));
	
	//Selecting Protocol
	type("patient-protocol-id","id",data.get("Protocol_ID"));
	Thread.sleep(2000);
	Robot robo=new Robot();
	robo.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	 type("patient-study-id","id",data.get("Patient_Study_ID"));
	 String drug_com=String.join(" ",data.get("Drug_Name"),data.get("Strength/Concentration"),data.get("Unit_of_Measure"));
     System.out.println(" The Drug combination text in Receive to be selected is  "+ drug_com);
     String pat_drg_val=data.get("Drug_Name");
     List<WebElement> pat_drg_opt=Driver.findElements(By.tagName("Option"));
   for(WebElement element1:pat_drg_opt)
	    if(element1.getText().contains(pat_drg_val)) {
	    	element1.click();
	    //}
	
	//Selecting Drug
//	click("assigned-drug-plus","csssele");
//	type("patient-start-date","id",data.get("NostData",28,10));
//	type("patient-stop-date","id",data.get("NostData",28,11));
	type("cohort-dose-level","id",data.get("Cohort/Dose_Level"));
	
	//Add Contact info
	click("add-contact-info","csssele");
	type("address-1","id",data.get("Address_1"));
	type("address-2","id",data.get("Address_2"));
	type("city","id",data.get("City"));
	type("state","id",data.get("State"));
	type("zip-postal-code","id",data.get("Zip/Postal_Code"));
	type("country","id",data.get("Country"));
	type("home-phone","id",data.get("Home_Phone(s)"));
	type("work-phone","id",data.get("Work_Phone(s)"));
	type("email","id",data.get("Email"));
	type("pid","id",data.get("PID"));
	type("patient-esgin","id",data.get("esignature"));
	click("patient-submit","id");
	break;
	//Thread.sleep(15000);
//	     else {
//			
//			Assert.fail("No Drug named '"+pat_drg_val+"'  populated in the list to be selected");
//		}
   }
	Thread.sleep(4000);
//	((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
//	Thread.sleep(4000);
   
	}
	
	public void patientEdit() {}
	
	public void patientDispense() {}
	
	public void patientProtocolDisassociation() {}
	
	public void patientVerifyTable() {}
	
	public void patientVerifyEdit()  {}
	
	public void patientVerifyProtocolDisassociation() {}
	
}
