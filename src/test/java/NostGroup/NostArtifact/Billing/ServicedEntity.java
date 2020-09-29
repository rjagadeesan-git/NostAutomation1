package NostGroup.NostArtifact.Billing;

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

public class ServicedEntity extends CommonMethods{
	
	String entity_mrn;
	
	public void servicedEntityVerify(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
		Robot robo1=new Robot();
//		robo1.keyPress(KeyEvent.VK_CONTROL);
//		robo1.keyPress(KeyEvent.VK_MINUS);
//		Thread.sleep(2000);
//		robo1.keyPress(KeyEvent.VK_MINUS);
//		robo1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		click("maintenance-billing-menu","csssele");
		Thread.sleep(2000);
		//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("service-master-menu","csssele"));
		
		click("serviced-entity-menu","csssele");
		type("serviced-first-name","id",data.get("serviced-first-name"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_DOWN);
		robo1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ManageSvcdEntityData")));
		//type("service-name-search","id",data.get("service-name-search"));
		click("serviced-search","id");
		Thread.sleep(2000);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);

		WebElement servicedentity_tabu=find_element("serviced-search-result-tabu","id");
		
		List<WebElement> servicedentity_tab_row=Driver.findElements(By.xpath(("//table[@id='mngSvcdEntityMasterTable']/tbody/tr")));
		System.out.println(servicedentity_tab_row.size());
		
		List<WebElement> servicemaster_tab_col=Driver.findElements(By.xpath(("//table[@id='mngSvcdEntityMasterTable']/tbody/tr[1]/td")));
		System.out.println(servicemaster_tab_col.size());
		
		entity_mrn=data.get("serviced-mrn");
		
		if(servicedentity_tabu.isDisplayed() && servicemaster_tab_col.size()>1) {
		
		if(servicedentity_tab_row.size()>=1)
		{
			System.out.println("Inside If");
		
		for(int row=1;row<=servicedentity_tab_row.size();row++) {
			
				System.out.println("Inside row loop");
				String servicedentity_tab_com=Driver.findElement(By.xpath("//table[@id='mngSvcdEntityMasterTable']/tbody/tr["+row+"]/td[2]")).getText();
				if(servicedentity_tab_com.equalsIgnoreCase(entity_mrn)) {	
					//Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row+"]/td[1]")).click();
					System.out.println("ServicedEntity found");
					extest.log(LogStatus.PASS,"Patient '"+entity_mrn+"' integrated in ServicedEntity successfully");
					log.info("Patient '"+entity_mrn+"' integrated in ServicedEntity successfully");
					Reporter.log("Patient '"+entity_mrn+"' integrated in ServicedEntity successfully");
					break;
				} else if(servicedentity_tab_com.contains(entity_mrn))	{
					
					System.out.println("Partial match found");
					
					extest.log(LogStatus.WARNING,"One of the Patient '"+servicedentity_tab_com+"' contains '"+entity_mrn+"' found,but not the exact match");
					log.info("One of the Patient '"+servicedentity_tab_com+"' contains '"+entity_mrn+"' found,but not the exact match");
					Reporter.log("One of the Patient '"+servicedentity_tab_com+"' contains '"+entity_mrn+"' found,but not the exact match");
					extest.log(LogStatus.FAIL,"Patient '"+entity_mrn+"' not integrated in ServicedEntity");
				}
	}

	} else {
		System.out.println("ServicedEntity not found, Wrong Search");
		extest.log(LogStatus.FAIL,"Patient '"+entity_mrn+"' not integrated in ServicedEntity");
		log.info("Patient '"+entity_mrn+"' not integrated in ServicedEntity");
		Reporter.log("Patient '"+entity_mrn+"' not integrated in ServicedEntity");
	}
		
		}else {
			
			System.out.println("ServicedEntity not found, Table not Displayed");
			extest.log(LogStatus.FAIL,"Patient '"+entity_mrn+"' not integrated in ServicedEntity");
			log.info("Patient '"+entity_mrn+"' not integrated in ServicedEntity");
			Reporter.log("Patient '"+entity_mrn+"' not integrated in ServicedEntity");
		}
		
	}

}
