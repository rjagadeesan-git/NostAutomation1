package NostGroup.NostArtifact.Dispense;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Dispense extends CommonMethods {
	
	
	String pat_mrn;
	String disp_prot_id;
	WebElement disp_LOA;
	
	
	public void dispPatientSearch(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		
		ex_wait= new WebDriverWait(Driver,20);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();	
		Thread.sleep(3000);
		click("patient-menu","csssele");
//		WebElement rec_proceed=find_element("receive-proceed","csssele");
//		if(rec_proceed.isDisplayed()) {
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")));
//		find_element("receive-proceed","csssele").click();  }
		Thread.sleep(3000);
		// Start Patient Search
		click("manage-patient-result-search-bar","csssele");
		type("manage-patient-result-search-bar","csssele",data.get("dispense-pat-mrn"));
		Thread.sleep(2000);
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		WebElement patient_tabu=find_element("manage-patient-search-tabu","id");

List<WebElement> patient_tab_row=Driver.findElements(By.xpath(("//table[@id='managePatient']/tbody/tr")));
System.out.println(patient_tab_row.size());

List<WebElement> patient_tab_col=Driver.findElements(By.xpath(("//table[@id='managePatient']/tbody/tr[1]/td")));
System.out.println(patient_tab_col.size());
pat_mrn=data.get("dispense-pat-mrn");
disp_prot_id=data.get("dispense-protocol");
if(patient_tabu.isDisplayed() && patient_tab_col.size()>1) {

if(patient_tab_row.size()>=1)
{
	System.out.println("Inside If");

for(int row=1;row<=patient_tab_row.size();row++) {
	
		System.out.println("Inside row loop");
		String patient_tab_com=Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[4]")).getText();
		String protocol_tab_com=Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[7]")).getText();
		if(patient_tab_com.equalsIgnoreCase(pat_mrn)) {	
			
			if(protocol_tab_com.equalsIgnoreCase(disp_prot_id)) {
			Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[1]")).click();
			System.out.println("Patient for dispense found");
			extest.log(LogStatus.PASS,"Patient '"+pat_mrn+"' present in Patient table" );
			log.info("Patient '"+pat_mrn+"' present in Patient table");
			Reporter.log("Patient '"+pat_mrn+"' present in Patient table");
			click("dispense-to-patient-pat","csssele");
			Thread.sleep(2000);
			selectText("dispense-drug-name","id",data.get("dispense-drug-name"));
			selectText("dispense-lot","id",data.get("dispense-lot"));
			// vali("dispense-expiration-date","id",data.get("dispense-expiration-date");
			// vali("dispense-loa","id",data.get("dispense-loa");
			// vali("dispense-formulation","id",data.get("dispense-formulation");
			// vali("dispense-unit-type","id",data.get("dispense-unit-type");
			// vali("dispense-qty-per-unit","id",data.get("dispense-qty-per-unit");
			selectText("dispense-pharmacy","id",data.get("dispense-pharmacy"));
			// vali("dispense-storage-condition","id",data.get("dispense-storage-condition");
			selectText("dispense-storage-location","id",data.get("dispense-storage-location"));
			type("dispense-dose","id",data.get("dispense-dose"));
			// vali("dispense-route","id",data.get("dispense-route");
			// vali("dispense-frequency","id",data.get("dispense-frequency");
			type("dispense-comments","id",data.get("dispense-comments"));
			type("dispense-visit","id",data.get("dispense-visit"));
			
			// Unit Check Start
			
	      	Thread.sleep(4000);
	      	
	      	WebElement disp_LOA=find_element("dispense-loa","id");
	      	String unit_id=data.get("Unit1");
	     
//	        Select select1=new Select(disp_LOA);
//	        
//	        System.out.println(select1.getFirstSelectedOption().getText());
	        
	        	if(disp_LOA.getText().equalsIgnoreCase("Unit")) {
	      	  
	        	List<WebElement> disp_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
	        	System.out.println(disp_unit_tab_row.size());
	        	
	        	List<WebElement> disp_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
	        	System.out.println(disp_unit_tab_col.size());
	        	
	        	
	        	
	        	for(int row1=1;row1<=disp_unit_tab_row.size();row1++) {
	        		
	        		for(int col1=1;col1<=disp_unit_tab_col.size();col1++)
	        		{
	        			//System.out.println("Row count  " +row);
	        			String disp_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row1+"]/td[1]")).getText();
	        			//System.out.println("Row count  " +row+"  Col count  "+col+ "   Value  "+trans_unit_id);
	        			if(disp_unit_id.equalsIgnoreCase(unit_id)) {
	        				System.out.println("Inside IF "+unit_id);
	        				Thread.sleep(2000);
	        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row1+"]/td[3]/input[1]"));
	        				match_unit.click();
	        				type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
	        				click("dispense-submit","id");
	        			}
	        			break;
	        	}
	        		
	        	}   	
	        }// unit if ends
	        	
	        else if(disp_LOA.getText().equalsIgnoreCase("Unit (by Vial)")) {
	  		

	        	List<WebElement> disp_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
	        	System.out.println(disp_unit_tab_row.size());
	        	
	        	List<WebElement> disp_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
	        	System.out.println(disp_unit_tab_col.size());
	        	
	        	//String unit_id=data.get("Unit#1");
	        	
	        	for(int row2=1;row2<=disp_unit_tab_row.size();row2++) {
	        		
	        		for(int col2=1;col2<=disp_unit_tab_col.size();col2++)
	        		{
	        			System.out.println("Row count  " +row2);
	        			String disp_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row2+"]/td["+col2+"]")).getText();
	        			System.out.println("Row count  " +row2+"  Col count  "+col2+ "   Value  "+disp_unit_id);
	        			if(disp_unit_id.equalsIgnoreCase(unit_id)) {
	        				System.out.println("Inside IF "+unit_id);
	        				Thread.sleep(2000);
	        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row2+"]/td[3]/input[1]"));
	        				match_unit.click();
	        				Thread.sleep(3000);
	        				type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
	        				click("dispense-submit","id");
	        			}
	        			break;
	        	}
	        		
	        	}
	        	
	  	} //unit vial else ends
	       
	    // Unit check end 
	        else {  //Lot
			
			type("total-dispense-qty","id",data.get("total-dispense-qty"));
	
//			click("dispense-reprint-barcode","id");
//			click("dispense-save-queue","id");
//			click("dispense-generate-label","id");
			type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
			click("dispense-submit","id");
	        }
			
//	if(Driver.findElement(By.id("ui-dialog-title-dialog-confirm2")).isDisplayed()) {
//		
//		Driver.findElement(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")).click();
//	}
//		
//if(Driver.findElement(By.id("ui-dialog-title-dialog-confirm")).isDisplayed()) {
//		
//		Driver.findElement(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")).click();
//	}		
			break;
		}
}  else if(patient_tab_com.contains(pat_mrn))	{
	
	System.out.println("Partial match found");
	extest.log(LogStatus.WARNING,"One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
	log.info("One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
	Reporter.log("One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
}
		
} //Loop ends

} else {
System.out.println("Patient not found, Wrong Search");
extest.log(LogStatus.FAIL,"Patient '"+pat_mrn+"' not present in Patient table");
log.info("Patient '"+pat_mrn+"' not present in Patient table");
Reporter.log("Patient '"+pat_mrn+"' not present in Patient table");
}

}else {
	
	System.out.println("Patient not found, Table not Displayed");
	extest.log(LogStatus.FAIL,"Patient '"+pat_mrn+"' not present in Patient table");
	log.info("Patient '"+pat_mrn+"' not present in Patient table");
	Reporter.log("Patient '"+pat_mrn+"' not present in Patient table");
}

		
		
		// End Patient Search
		
//		pat_lastname=data.get("dispense-protocol");
		//Driver.findElement(By.cssSelector("#\\32 24"));
		//disTable
//		List<WebElement> disp_search_div=Driver.findElements(By.tagName("div"));
//		   for(WebElement element:disp_search_div)
//			    if(element.getText().contains(pat_lastname)) {
//			    	element.click();
//			    }
		//	    else if
//		click("dispense-to-pat-result-search-bar","csssele");
//
//		click("dispense-to-current-patient","id");
//		selectText("dispense-drug-name","id",data.get("dispense-drug-name"));
//		selectText("dispense-lot","id",data.get("dispense-lot"));
//		// vali("dispense-expiration-date","id",data.get("dispense-expiration-date");
//		// vali("dispense-loa","id",data.get("dispense-loa");
//		// vali("dispense-formulation","id",data.get("dispense-formulation");
//		// vali("dispense-unit-type","id",data.get("dispense-unit-type");
//		// vali("dispense-qty-per-unit","id",data.get("dispense-qty-per-unit");
//		selectText("dispense-pharmacy","id",data.get("dispense-pharmacy"));
//		// vali("dispense-storage-condition","id",data.get("dispense-storage-condition");
//		selectText("dispense-storage-location","id",data.get("dispense-storage-location"));
//		type("dispense-dose","id",data.get("dispense-dose"));
//		// vali("dispense-route","id",data.get("dispense-route");
//		// vali("dispense-frequency","id",data.get("dispense-frequency");
//		type("dispense-comments","id",data.get("dispense-comments"));
//		type("dispense-visit","id",data.get("dispense-visit"));
//		type("total-dispense-qty","id",data.get("total-dispense-qty"));
//
//		click("dispense-submit","id");
//		click("dispense-reprint-barcode","id");
//		click("dispense-save-queue","id");
//		click("dispense-generate-label","id");
//		type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
//		click("label-template","id");
//		selectText("label-name","id",data.get("label-name"));
//		// vali("label-mrn","id",data.get("label-mrn");
//		// vali("label-pt-Study-id","id",data.get("label-pt-Study-id");
//		// vali("label-dob","id",data.get("label-dob");
//		// vali("label-address","id",data.get("label-address");
//		// vali("label-protocol-id","id",data.get("label-protocol-id");
//		type("label-prescriber","id",data.get("label-prescriber"));
//		// vali("label-institute-name","id",data.get("label-institute-name");
//		// vali("label-pharmacy-location","id",data.get("label-pharmacy-location");
//		// vali("label-pharmacy-address","id",data.get("label-pharmacy-address");
//		// vali("label-pharmacy-phone","id",data.get("label-pharmacy-phone");
//		// vali("label-cohort-level","id",data.get("label-cohort-level");
//		selectText("drugname-on-label","id",data.get("drugname-on-label"));
//		// vali("label-drug-id","id",data.get("label-drug-id");
//		// vali("label-lot","id",data.get("label-lot");
//		// vali("label-rx","id",data.get("label-rx");
//		type("qty-on-label","id",data.get("qty-on-label"));
//		type("dose-on-label","id",data.get("dose-on-label"));
//
//
//
//		type("no-of-labels","id",data.get("no-of-labels"));
//		type("label-use-by-time","id",data.get("label-use-by-time"));
//		// vali("label-compounding-batch","id",data.get("label-compounding-batch");
//		click("comments-for-label","id");
//		click("label-save-to-queue","csssele");
//		click("label-back-to-inventory","csssele");
//		click("label-print-preview","csssele");
//		click("label-cancel","csssele");
//		click("label-submit","id");
//		type("label-esign","id",data.get("label-esign"));
//		click("dispense-submit-tab","id");
		   
}
	
	public void dispSaveQueue(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		
		ex_wait= new WebDriverWait(Driver,20);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();	
		Thread.sleep(3000);
		click("patient-menu","csssele");
//		WebElement rec_proceed=find_element("receive-proceed","csssele");
//		if(rec_proceed.isDisplayed()) {
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")));
//		find_element("receive-proceed","csssele").click();  }
		Thread.sleep(3000);
		// Start Patient Search
		click("manage-patient-result-search-bar","csssele");
		type("manage-patient-result-search-bar","csssele",data.get("dispense-pat-mrn"));
		Thread.sleep(2000);
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		WebElement patient_tabu=find_element("manage-patient-search-tabu","id");

List<WebElement> patient_tab_row=Driver.findElements(By.xpath(("//table[@id='managePatient']/tbody/tr")));
System.out.println(patient_tab_row.size());

List<WebElement> patient_tab_col=Driver.findElements(By.xpath(("//table[@id='managePatient']/tbody/tr[1]/td")));
System.out.println(patient_tab_col.size());
pat_mrn=data.get("dispense-pat-mrn");
disp_prot_id=data.get("dispense-protocol");
if(patient_tabu.isDisplayed() && patient_tab_col.size()>1) {

if(patient_tab_row.size()>=1)
{
	System.out.println("Inside If");

for(int row=1;row<=patient_tab_row.size();row++) {
	
		System.out.println("Inside row loop");
		String patient_tab_com=Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[4]")).getText();
		String protocol_tab_com=Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[7]")).getText();
		if(patient_tab_com.equalsIgnoreCase(pat_mrn)) {	
			
			if(protocol_tab_com.equalsIgnoreCase(disp_prot_id)) {
			Driver.findElement(By.xpath("//table[@id='managePatient']/tbody/tr["+row+"]/td[1]")).click();
			System.out.println("Patient for dispense found");
			extest.log(LogStatus.PASS,"Patient '"+pat_mrn+"' present in Patient table" );
			log.info("Patient '"+pat_mrn+"' present in Patient table");
			Reporter.log("Patient '"+pat_mrn+"' present in Patient table");
			click("dispense-to-patient-pat","csssele");
			Thread.sleep(2000);
			System.out.println("Before-- Checking the Prompt presence");
			Thread.sleep(2000);
			WebElement disp_proceed=find_element("dispense-proceed","csssele");
			if(disp_proceed.isDisplayed()) {
			ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ui-button:nth-child(2) > span:nth-child(1)")));
			find_element("dispense-proceed","csssele").click();
			robo.keyPress(KeyEvent.VK_ENTER);
			}
			Thread.sleep(2000);
			selectText("dispense-drug-name","id",data.get("dispense-drug-name"));
			selectText("dispense-lot","id",data.get("dispense-lot"));
			// vali("dispense-expiration-date","id",data.get("dispense-expiration-date");
			// vali("dispense-loa","id",data.get("dispense-loa");
			// vali("dispense-formulation","id",data.get("dispense-formulation");
			// vali("dispense-unit-type","id",data.get("dispense-unit-type");
			// vali("dispense-qty-per-unit","id",data.get("dispense-qty-per-unit");
			selectText("dispense-pharmacy","id",data.get("dispense-pharmacy"));
			// vali("dispense-storage-condition","id",data.get("dispense-storage-condition");
			selectText("dispense-storage-location","id",data.get("dispense-storage-location"));
			type("dispense-dose","id",data.get("dispense-dose"));
			// vali("dispense-route","id",data.get("dispense-route");
			// vali("dispense-frequency","id",data.get("dispense-frequency");
			type("dispense-comments","id",data.get("dispense-comments"));
			type("dispense-visit","id",data.get("dispense-visit"));
			
			// Unit Check Start
			
	      	Thread.sleep(4000);
	      	
	      	WebElement disp_LOA=find_element("dispense-loa","id");
	      	String unit_id=data.get("Unit1");
	     
//	        Select select1=new Select(disp_LOA);
//	        
//	        System.out.println(select1.getFirstSelectedOption().getText());
	        
	        	if(disp_LOA.getText().equalsIgnoreCase("Unit")) {
	      	  
	        	List<WebElement> disp_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
	        	System.out.println(disp_unit_tab_row.size());
	        	
	        	List<WebElement> disp_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
	        	System.out.println(disp_unit_tab_col.size());
	        	
	        	
	        	
	        	for(int row1=1;row1<=disp_unit_tab_row.size();row1++) {
	        		
	        		for(int col1=1;col1<=disp_unit_tab_col.size();col1++)
	        		{
	        			//System.out.println("Row count  " +row);
	        			String disp_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row1+"]/td[1]")).getText();
	        			//System.out.println("Row count  " +row+"  Col count  "+col+ "   Value  "+trans_unit_id);
	        			if(disp_unit_id.equalsIgnoreCase(unit_id)) {
	        				System.out.println("Inside IF "+unit_id);
	        				Thread.sleep(2000);
	        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row1+"]/td[3]/input[1]"));
	        				match_unit.click();
	        				type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
	        				click("dispense-save-queue","id");
	        			}
	        			break;
	        	}
	        		
	        	}   	
	        }// unit if ends
	        	
	        else if(disp_LOA.getText().equalsIgnoreCase("Unit (by Vial)")) {
	  		

	        	List<WebElement> disp_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
	        	System.out.println(disp_unit_tab_row.size());
	        	
	        	List<WebElement> disp_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
	        	System.out.println(disp_unit_tab_col.size());
	        	
	        	//String unit_id=data.get("Unit#1");
	        	
	        	for(int row2=1;row2<=disp_unit_tab_row.size();row2++) {
	        		
	        		for(int col2=1;col2<=disp_unit_tab_col.size();col2++)
	        		{
	        			System.out.println("Row count  " +row2);
	        			String disp_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row2+"]/td["+col2+"]")).getText();
	        			System.out.println("Row count  " +row2+"  Col count  "+col2+ "   Value  "+disp_unit_id);
	        			if(disp_unit_id.equalsIgnoreCase(unit_id)) {
	        				System.out.println("Inside IF "+unit_id);
	        				Thread.sleep(2000);
	        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row2+"]/td[3]/input[1]"));
	        				match_unit.click();
	        				Thread.sleep(3000);
	        				type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
	        				click("dispense-save-queue","id");
	        			}
	        			break;
	        	}
	        		
	        	}
	        	
	  	} //unit vial else ends
	       
	    // Unit check end 
	        else {  //Lot
			
			type("total-dispense-qty","id",data.get("total-dispense-qty"));
	
//			click("dispense-reprint-barcode","id");
//			click("dispense-save-queue","id");
//			click("dispense-generate-label","id");
			type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
			click("dispense-save-queue","id");
	        }
			
//	if(Driver.findElement(By.id("ui-dialog-title-dialog-confirm2")).isDisplayed()) {
//		
//		Driver.findElement(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")).click();
//	}
//		
//if(Driver.findElement(By.id("ui-dialog-title-dialog-confirm")).isDisplayed()) {
//		
//		Driver.findElement(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")).click();
//	}		
			break;
		}
}  else if(patient_tab_com.contains(pat_mrn))	{
	
	System.out.println("Partial match found");
	extest.log(LogStatus.WARNING,"One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
	log.info("One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
	Reporter.log("One of the Patient '"+patient_tab_com+"' contains '"+pat_mrn+"' found,but not the exact match");
}
		
} //Loop ends

} else {
System.out.println("Patient not found, Wrong Search");
extest.log(LogStatus.FAIL,"Patient '"+pat_mrn+"' not present in Patient table");
log.info("Patient '"+pat_mrn+"' not present in Patient table");
Reporter.log("Patient '"+pat_mrn+"' not present in Patient table");
}

}else {
	
	System.out.println("Patient not found, Table not Displayed");
	extest.log(LogStatus.FAIL,"Patient '"+pat_mrn+"' not present in Patient table");
	log.info("Patient '"+pat_mrn+"' not present in Patient table");
	Reporter.log("Patient '"+pat_mrn+"' not present in Patient table");
}

		
		
		// End Patient Search
		
//		pat_lastname=data.get("dispense-protocol");
		//Driver.findElement(By.cssSelector("#\\32 24"));
		//disTable
//		List<WebElement> disp_search_div=Driver.findElements(By.tagName("div"));
//		   for(WebElement element:disp_search_div)
//			    if(element.getText().contains(pat_lastname)) {
//			    	element.click();
//			    }
		//	    else if
//		click("dispense-to-pat-result-search-bar","csssele");
//
//		click("dispense-to-current-patient","id");
//		selectText("dispense-drug-name","id",data.get("dispense-drug-name"));
//		selectText("dispense-lot","id",data.get("dispense-lot"));
//		// vali("dispense-expiration-date","id",data.get("dispense-expiration-date");
//		// vali("dispense-loa","id",data.get("dispense-loa");
//		// vali("dispense-formulation","id",data.get("dispense-formulation");
//		// vali("dispense-unit-type","id",data.get("dispense-unit-type");
//		// vali("dispense-qty-per-unit","id",data.get("dispense-qty-per-unit");
//		selectText("dispense-pharmacy","id",data.get("dispense-pharmacy"));
//		// vali("dispense-storage-condition","id",data.get("dispense-storage-condition");
//		selectText("dispense-storage-location","id",data.get("dispense-storage-location"));
//		type("dispense-dose","id",data.get("dispense-dose"));
//		// vali("dispense-route","id",data.get("dispense-route");
//		// vali("dispense-frequency","id",data.get("dispense-frequency");
//		type("dispense-comments","id",data.get("dispense-comments"));
//		type("dispense-visit","id",data.get("dispense-visit"));
//		type("total-dispense-qty","id",data.get("total-dispense-qty"));
//
//		click("dispense-submit","id");
//		click("dispense-reprint-barcode","id");
//		click("dispense-save-queue","id");
//		click("dispense-generate-label","id");
//		type("dispense-dispense-esign","id",data.get("dispense-dispense-esign"));
//		click("label-template","id");
//		selectText("label-name","id",data.get("label-name"));
//		// vali("label-mrn","id",data.get("label-mrn");
//		// vali("label-pt-Study-id","id",data.get("label-pt-Study-id");
//		// vali("label-dob","id",data.get("label-dob");
//		// vali("label-address","id",data.get("label-address");
//		// vali("label-protocol-id","id",data.get("label-protocol-id");
//		type("label-prescriber","id",data.get("label-prescriber"));
//		// vali("label-institute-name","id",data.get("label-institute-name");
//		// vali("label-pharmacy-location","id",data.get("label-pharmacy-location");
//		// vali("label-pharmacy-address","id",data.get("label-pharmacy-address");
//		// vali("label-pharmacy-phone","id",data.get("label-pharmacy-phone");
//		// vali("label-cohort-level","id",data.get("label-cohort-level");
//		selectText("drugname-on-label","id",data.get("drugname-on-label"));
//		// vali("label-drug-id","id",data.get("label-drug-id");
//		// vali("label-lot","id",data.get("label-lot");
//		// vali("label-rx","id",data.get("label-rx");
//		type("qty-on-label","id",data.get("qty-on-label"));
//		type("dose-on-label","id",data.get("dose-on-label"));
//
//
//
//		type("no-of-labels","id",data.get("no-of-labels"));
//		type("label-use-by-time","id",data.get("label-use-by-time"));
//		// vali("label-compounding-batch","id",data.get("label-compounding-batch");
//		click("comments-for-label","id");
//		click("label-save-to-queue","csssele");
//		click("label-back-to-inventory","csssele");
//		click("label-print-preview","csssele");
//		click("label-cancel","csssele");
//		click("label-submit","id");
//		type("label-esign","id",data.get("label-esign"));
//		click("dispense-submit-tab","id");

	}
	
	public void dispSubmit() {}
	
	public void dispGenLabel() {}
	
	public void dispEditSubmit() {}
	
	public void dispReprintLabel() {}
	

}
