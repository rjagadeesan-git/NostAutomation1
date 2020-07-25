package NostGroup.NostArtifact.Billing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import NostGroup.NostArtifact.Base.CommonMethods;

public class ServiceMaster extends CommonMethods{
	
	String service_name;
	
	public void serviceMasterVerification(Hashtable<String,String> data) throws InterruptedException, AWTException {
	
	Robot robo1=new Robot();
	robo1.keyPress(KeyEvent.VK_CONTROL);
	robo1.keyPress(KeyEvent.VK_MINUS);
	Thread.sleep(2000);
	robo1.keyPress(KeyEvent.VK_MINUS);
	robo1.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(2000);
	click("maintenance-billing-menu","csssele");
	Thread.sleep(2000);
	//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("service-master-menu","csssele"));
	
	click("service-master-menu","csssele");
	type("service-plan-search","id",data.get("service-plan-search"));
	Thread.sleep(2000);
	robo1.keyPress(KeyEvent.VK_DOWN);
	robo1.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	//ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
	type("service-name-search","id",data.get("service-name-search"));
	click("service-search","csssele");
	Thread.sleep(2000);
//	robo1.keyPress(KeyEvent.VK_ENTER);
//	robo1.keyPress(KeyEvent.VK_ENTER);
//	Thread.sleep(2000);

	WebElement servicemaster_tabu=find_element("service-master-result-tabu","id");
	
	List<WebElement> servicemaster_tab_row=Driver.findElements(By.xpath(("//table[@id='svcMasterTable']/tbody/tr")));
	System.out.println(servicemaster_tab_row.size());
	
	List<WebElement> servicemaster_tab_col=Driver.findElements(By.xpath(("//table[@id='svcMasterTable']/tbody/tr[1]/td")));
	System.out.println(servicemaster_tab_col.size());
	service_name=data.get("service-name-search");
	
	if(servicemaster_tabu.isDisplayed() && servicemaster_tab_col.size()>1) {
	
	if(servicemaster_tab_row.size()>=1)
	{
		System.out.println("Inside If");
	
	for(int row=1;row<=servicemaster_tab_row.size();row++) {
		
			System.out.println("Inside row loop");
			String servicemaster_tab_com=Driver.findElement(By.xpath("//table[@id='svcMasterTable']/tbody/tr["+row+"]/td[2]")).getText();
			if(servicemaster_tab_com.equalsIgnoreCase(service_name)) {	
				//Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row+"]/td[1]")).click();
				System.out.println("Service name found");
				extest.log(LogStatus.PASS,"Drug '"+service_name+"' integrated in Service Master successfully" );
				log.info("Drug '"+service_name+"' integrated in Service Master successfully");
				Reporter.log("Drug '"+service_name+"' integrated in Service Master successfully");
				break;
			} else if(servicemaster_tab_com.contains(service_name))	{
				
				System.out.println("Partial match found");
				extest.log(LogStatus.WARNING,"One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
				log.info("One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
				Reporter.log("One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
			}
}

} else {
	System.out.println("Service name not found, Wrong Search");
	extest.log(LogStatus.FAIL,"Drug '"+service_name+"' not integrated in Service Master");
	log.info("Drug '"+service_name+"' not integrated in Service Master");
	Reporter.log("Drug '"+service_name+"' not integrated in Service Master");
	Assert.fail("Drug '"+service_name+"' not integrated in Service Master");
}
	
	}else {
		
		System.out.println("Service name not found, Table not Displayed");
		extest.log(LogStatus.FAIL,"Drug '"+service_name+"' not integrated in Service Master");
		log.info("Drug '"+service_name+"' not integrated in Service Master");
		Reporter.log("Drug '"+service_name+"' not integrated in Service Master");
		Assert.fail("Drug '"+service_name+"' not integrated in Service Master");
	}
	//type("service-plan-search","id",data.get("service-plan-search"));

}
	
	public void serviceMasterRemovalVerification(Hashtable<String,String> data) throws AWTException, InterruptedException {
		
		Robot robo1=new Robot();
		robo1.keyPress(KeyEvent.VK_CONTROL);
		robo1.keyPress(KeyEvent.VK_MINUS);
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_MINUS);
		robo1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		click("maintenance-billing-menu","csssele");
		Thread.sleep(2000);
		//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("service-master-menu","csssele"));
		
		click("service-master-menu","csssele");
		type("service-plan-search","id",data.get("service-plan-search"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_DOWN);
		robo1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
		type("service-name-search","id",data.get("service-name-search"));
		click("service-search","csssele");
		Thread.sleep(2000);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		robo1.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
		WebElement servicemaster_tabu=find_element("service-master-result-tabu","id");
		
		List<WebElement> servicemaster_tab_row=Driver.findElements(By.xpath(("//table[@id='svcMasterTable']/tbody/tr")));
		System.out.println(servicemaster_tab_row.size());
		
		List<WebElement> servicemaster_tab_col=Driver.findElements(By.xpath(("//table[@id='svcMasterTable']/tbody/tr[1]/td")));
		System.out.println(servicemaster_tab_col.size());
		
		service_name=data.get("service-name-search");
		
		if(servicemaster_tabu.isDisplayed() && servicemaster_tab_col.size()>1) {
		
		if(servicemaster_tab_row.size()>=1)
		{
			System.out.println("Inside Service Master tabular search");
		
		for(int row=1;row<=servicemaster_tab_row.size();row++) {
			
				System.out.println("Inside Service Master table row check");
				String servicemaster_tab_com=Driver.findElement(By.xpath("//table[@id='svcMasterTable']/tbody/tr["+row+"]/td[2]")).getText();
				if(servicemaster_tab_com.equalsIgnoreCase(service_name)) {	
					//Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row+"]/td[1]")).click();
					System.out.println("Service name found");
					extest.log(LogStatus.FAIL,"Drug '"+service_name+"' not removed from Service Master" );
					log.info("Drug '"+service_name+"' not removed from Service Master");
					Reporter.log("Drug '"+service_name+"' not removed from Service Master");
					break;
				} else if(servicemaster_tab_com.contains(service_name))	{
					
					System.out.println("Partial match found");
					extest.log(LogStatus.WARNING,"One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
					log.info("One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
					Reporter.log("One of the Drug '"+servicemaster_tab_com+"' contains '"+service_name+"' found,but not the exact match");
				}
	}

	} else {
		System.out.println("Service name not found, Wrong Search");
		extest.log(LogStatus.PASS,"Drug '"+service_name+"' removed from Service Master");
		log.info("Drug '"+service_name+"' removed from Service Master");
		Reporter.log("Drug '"+service_name+"' removed from Service Master");
	}
		
		}else {
			
			System.out.println("Service name not found, Table not Displayed");
			extest.log(LogStatus.PASS,"Drug '"+service_name+"' removed from Service Master");
			log.info("Drug '"+service_name+"' removed from Service Master");
			Reporter.log("Drug '"+service_name+"' removed from Service Master");
		}
	}
	
}
