package NostGroup.NostArtifact.Billing;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import NostGroup.NostArtifact.Base.CommonMethods;

public class ReviewCharges extends CommonMethods{
	
	String reviewcharges_plan;
	String reviewcharges_drug;
	String reviewcharges_price;

	public void reviewChargesVerification(Hashtable<String,String> data) throws AWTException, InterruptedException {
		

Robot robo1=new Robot();
//robo1.keyPress(KeyEvent.VK_CONTROL);
//robo1.keyPress(KeyEvent.VK_MINUS);
//Thread.sleep(2000);
//robo1.keyPress(KeyEvent.VK_MINUS);
//robo1.keyRelease(KeyEvent.VK_CONTROL);

//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("service-master-menu","csssele"));
Thread.sleep(2000);
click("billing-review-charges-menu","csssele");
Thread.sleep(2000);
click("charges-menu","csssele");
Thread.sleep(2000);
click("review-charges-menu","csssele");
Thread.sleep(2000);
type("review-charges-plan","id",data.get("review-charges-plan"));
Thread.sleep(2000);
robo1.keyPress(KeyEvent.VK_DOWN);
robo1.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(2000);
//ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));

selectText("review-charges-status","id",data.get("review-charges-status"));
Thread.sleep(2000);
click("review-charges-search","id");

//robo1.keyPress(KeyEvent.VK_ENTER);
//robo1.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(4000);

WebElement reviewcharges_pass_tabu=find_element("review-charges-tabu","id");

List<WebElement> reviewcharges_tab_row=Driver.findElements(By.xpath(("//table[@id='rsliTable']/tbody/tr")));
System.out.println(reviewcharges_tab_row.size());

List<WebElement> reviewcharges_tab_col=Driver.findElements(By.xpath(("//table[@id='rsliTable']/tbody/tr[1]/td")));
System.out.println(reviewcharges_tab_col.size());
reviewcharges_plan=data.get("review-charges-plan");
reviewcharges_drug=data.get("review-charges-drug");
reviewcharges_price=data.get("review-charges-price");

if(reviewcharges_pass_tabu.isDisplayed() && reviewcharges_tab_col.size()>1) {

if(reviewcharges_tab_row.size()>=1)
{
	System.out.println("Inside If");

for(int row=1;row<=reviewcharges_tab_row.size();row++) {
	
		System.out.println("Inside row loop");
		String reviewcharges_tab_com=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row+"]/td[6]")).getText();
		System.out.println("RowNum "+row+" reviewcharges_tab_com "+reviewcharges_tab_com);
		String reviewcharges_tab_drg=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row+"]/td[7]")).getText();
		System.out.println("RowNum "+row+" reviewcharges_tab_com "+reviewcharges_tab_drg);
		String reviewcharges_tab_price=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row+"]/td[10]")).getText();
		System.out.println("RowNum "+row+" reviewcharges_tab_com "+reviewcharges_tab_price);
		
		if(reviewcharges_tab_com.contains(reviewcharges_plan)) {
			
			System.out.println("Inside equalscase 1");
			if(reviewcharges_tab_drg.equalsIgnoreCase(reviewcharges_drug)) {
				System.out.println("Inside equalscase 2");
			if(reviewcharges_tab_price.contains(reviewcharges_price)) {	
			
			System.out.println("Inside equalscase 3");
			
			List<WebElement> statusedit_col=Driver.findElements(By.xpath("//table[@id='rsliTable']/tbody/tr["+row+"]/td[15]"));
			for(WebElement element:statusedit_col) {
				element.findElement(By.cssSelector(".odd > td:nth-child(15) > button:nth-child(1)")).click();
			}
			Thread.sleep(3000);
			((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("review-charges-comments","id"));
			type("review-charges-comments","id",data.get("review-charges-comments"));
			selectText("review-charges-billing-status","id",data.get("review-charges-billing-status"));
			click("review-charges-update","id");
			String alerttext=Driver.switchTo().alert().getText();
			if(alerttext.contains("Information has been updated successfully")) {
				Driver.switchTo().alert().accept();
				System.out.println("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+"' for Plan '"+reviewcharges_plan+"' created in Review Charges");
				extest.log(LogStatus.PASS,"Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' created in Review Charges");
				log.info("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' created in Review Charges");
				Reporter.log("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' created in Review Charges");
			} else {
				System.out.println(Driver.switchTo().alert().getText());
				extest.log(LogStatus.WARNING,Driver.switchTo().alert().getText());
				log.info(Driver.switchTo().alert().getText());
				Reporter.log(Driver.switchTo().alert().getText());
				Assert.fail();
			}
			break;
		} 
			}
			   }
		  else {
			
			//if(reviewcharges_tab_com.contains(reviewcharges_plan) && reviewcharges_tab_drg.contains(reviewcharges_drug) && reviewcharges_tab_price.equalsIgnoreCase(reviewcharges_price))	
			System.out.println(" match not found");
			extest.log(LogStatus.FAIL,"Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
			log.info("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
			Reporter.log("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
			click("records-data-error-yes","id");
			Thread.sleep(3000);
			if(reviewcharges_pass_tabu.isDisplayed() && reviewcharges_tab_col.size()>1) {

				if(reviewcharges_tab_row.size()>=1)
				{
					System.out.println("Inside If");

				for(int row1=1;row1<=reviewcharges_tab_row.size();row1++) {
					
						System.out.println("Inside row1 loop");
						String reviewcharges_tab_com1=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row1+"]/td[6]")).getText();
						System.out.println("RowNum "+row1+" reviewcharges_tab_com "+reviewcharges_tab_com1);
						String reviewcharges_tab_drg1=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row1+"]/td[7]")).getText();
						System.out.println("RowNum "+row1+" reviewcharges_tab_com "+reviewcharges_tab_drg1);
//						String reviewcharges_tab_price1=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row1+"]/td[10]")).getText();
//						System.out.println("RowNum "+row1+" reviewcharges_tab_com "+reviewcharges_tab_price1);
						
						if(reviewcharges_tab_com1.contains(reviewcharges_plan)) {
							
							System.out.println("Inside equalscase 1");
							if(reviewcharges_drug.contains(reviewcharges_tab_drg1)) {
								System.out.println("Inside equalscase 2");
							action.moveToElement(Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row1+"]/td[6]"))).perform();
							Assert.fail("Records not found in error Page too, Verify the related Dispense transaction in IDS");

		}  } } } } }	//else closing
}

}   else {
System.out.println("Charges not found, Wrong Search");
extest.log(LogStatus.FAIL,"Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges");
log.info("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges");
Reporter.log("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges");
}

}else {
	System.out.println("Charges not found, Table not displayed");
	extest.log(LogStatus.FAIL,"Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
	log.info("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
	Reporter.log("Charges for Drug '"+reviewcharges_drug+ "' with price '"+reviewcharges_price+ "' for Plan '"+reviewcharges_plan+"' not created in Review Charges, Checking in errors page");
	click("records-data-error-yes","id");
	Thread.sleep(3000);
	List<WebElement> reviewcharges_tab_row1=Driver.findElements(By.xpath(("//table[@id='rsliTable']/tbody/tr")));
	System.out.println(reviewcharges_tab_row1.size());

	List<WebElement> reviewcharges_tab_col1=Driver.findElements(By.xpath(("//table[@id='rsliTable']/tbody/tr[1]/td")));
	System.out.println(reviewcharges_tab_col1.size());
	
	if(reviewcharges_pass_tabu.isDisplayed() && reviewcharges_tab_col1.size()>1) {

		if(reviewcharges_tab_row1.size()>=1)
		{
			System.out.println("Inside If");

		for(int row2=1;row2<=reviewcharges_tab_row1.size();row2++) {
			
				System.out.println("Inside row2 loop");
				String reviewcharges_tab_com2=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row2+"]/td[6]")).getText();
				System.out.println("RowNum "+row2+" reviewcharges_tab_com "+reviewcharges_tab_com2);
				String reviewcharges_tab_drg2=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row2+"]/td[7]")).getText();
				System.out.println("RowNum "+row2+" reviewcharges_tab_com "+reviewcharges_tab_drg2);
//				String reviewcharges_tab_price1=Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row1+"]/td[10]")).getText();
//				System.out.println("RowNum "+row1+" reviewcharges_tab_com "+reviewcharges_tab_price1);
				
				if(reviewcharges_tab_com2.contains(reviewcharges_plan)) {
					
					System.out.println("Inside equalscase 1");
					if(reviewcharges_drug.contains(reviewcharges_tab_drg2)) {
						System.out.println("Inside equalscase 2");
					action.moveToElement(Driver.findElement(By.xpath("//table[@id='rsliTable']/tbody/tr["+row2+"]/td[6]"))).build().perform();
					Thread.sleep(3000);
					Assert.fail("Transaction failed to process with error");
}  } } } }
	else {
		Assert.fail("Transaction not found in error page too, Verify the related Dispense transaction in IDS");
	}

}//else closing

	}

}
