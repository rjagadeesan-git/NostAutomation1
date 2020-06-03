package NostGroup.NostArtifact.Receive;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Receive extends CommonMethods{
	
	public void receiveCommon(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
		action.moveToElement(find_element("receive","csssele")).perform(); //MouseOver Receive menu
				//click("receive","csssele");		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
		//Thread.sleep(2000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("receive-menu","csssele"));
		click("receive-menu","csssele");								//Click Receive module menu
				//((JavascriptExecutor)Driver).executeScript("menuMethod('Receive','pages/jsp/Receive_Drug.jsp');");
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plusDrugRc")));
		Thread.sleep(2000);
		click("receive-add","id");		//Click Add
		Thread.sleep(3000);
		type("receive-protocol-id","id",data.get("Receive_Protocol_ID")); 	//Enter the Protocol ID
		Robot robo=new Robot();
		Thread.sleep(3000);
		robo.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
		Thread.sleep(4000);
        String drug_com=String.join(" ", data.get("Drug_Name"),data.get("Strength/Concentration"),data.get("Unit_of_Measure"));
        System.out.println(" The Drug combination text in Receive to be selected is  "+ drug_com);
        
      //Select the Drug from the list generated
        String rec_drg_val=data.get("Drug_Name");
        List<WebElement> rec_drg=Driver.findElements(By.tagName("Option"));
      for(WebElement element:rec_drg)
   	    if(element.getText().contains(rec_drg_val)) {
   	    	element.click();
   	    }
      
      WebElement rec_LOA=find_element("receive-level-of-accountability","id");
      Select select1=new Select(rec_LOA);
      
      System.out.println(select1.getFirstSelectedOption().getText());
      
      if(select1.getFirstSelectedOption().getText().equalsIgnoreCase("Lot")) {
    	  
    	  //Thread.sleep(2000);
    	  type("receive-lot","id",data.get("Lot_#"));			 //Enter Lot#
          type("receive-expiration-date","id",data.get("Expiration_Date"));  //Enter Lot Expiration date
          type("receive-total-qty","id",data.get("Total_Qty"));		 //Enter Total Quantity
      }
      else if(select1.getFirstSelectedOption().getText().equalsIgnoreCase("Unit")) {
    	  
    	  Thread.sleep(2000);
          type("receive-lot","id",data.get("Lot_#"));	//Enter Lot#
          type("receive-static","id",data.get("Static_ID")); //Enter the Static Unit ID
          type("unit-range-start","id",data.get("Range_Start"));  //Enter Range Start
          type("unit-range-end","id",data.get("Range_End")); //Enter Range End
          click("unit-gen","csssele"); // Units generator
          type("receive-expiration-date","id",data.get("Expiration_Date"));  //Enter Lot Expiration date
    	  
      }else if(select1.getFirstSelectedOption().getText().equalsIgnoreCase("Unit (by Vial)")) {
		
    	  Thread.sleep(2000);
    	  
    	  type("receive-lot","id",data.get("Lot_#"));	//Enter Lot#
          type("receive-static","id",data.get("Static_ID")); //Enter the Static Unit ID
          type("unit-range-start","id",data.get("Range_Start"));  //Enter Range Start
          type("unit-range-end","id",data.get("Range_End")); //Enter Range End
          click("unit-gen","csssele"); // Units generator
          type("receive-expiration-date","id",data.get("Expiration_Date"));  //Enter Lot Expiration date
          
	}else { 
		
		System.out.println("Unknown LOA entered");
	}
      
      type("receive-comment","id",data.get("Comment"));			 //Enter Comments
      click("receive-save","id"); 		//Save
	}

	//@Test(priority=2)
	public void receiveSubmitQueue(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
		
		Robot robo1=new Robot();
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
		action.moveToElement(find_element("receive","csssele")).perform(); //MouseOver Receive menu
				//click("receive","csssele");		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
		Thread.sleep(2000);
		click("receive-menu","csssele");
		Thread.sleep(3000);
		Driver.getTitle();
//		Alert alert=ex_wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();
		WebElement rec_proceed=find_element("receive-proceed","csssele");
		if(rec_proceed.isDisplayed()) {
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")));
		find_element("receive-proceed","csssele").click(); 
		//robo1.keyPress(KeyEvent.VK_ENTER);
		}
		Thread.sleep(3000);
		type("rec-tab-search","csssele", data.get("Receive_Protocol_ID"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		List<WebElement> rec_tab_row=Driver.findElements(By.xpath(("//table[@id='receiveDrug']/tbody/tr")));
		System.out.println(rec_tab_row.size());
		
		List<WebElement> rec_tab_col=Driver.findElements(By.xpath(("//table[@id='receiveDrug']/tbody/tr[1]/td")));
		System.out.println(rec_tab_col.size());
		
		for(int row=1;row<=rec_tab_row.size();row++) {
			
			for(int col=1;col<=rec_tab_col.size();col++)
			{
			
				String prot_id=data.get("Receive_Protocol_ID");
				String rec_tab_com=Driver.findElement(By.xpath("//table[@id='receiveDrug']/tbody/tr["+row+"]/td["+col+"]")).getText();
				if(rec_tab_com.equalsIgnoreCase(prot_id)) {
					
					Driver.findElement(By.xpath("//table[@id='receiveDrug']/tbody/tr["+row+"]/td[1]")).click();
					break;
				}	
		}
	}
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("receive-submit","id"));
		
		//String rec_esign=data.get("esignature").replace(".0","");
		type("receive-edit","id",data.get("esignature"));
		click("receive-submit","id");
		
	}
	
public void receiveSubmitQueueAlone(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
		
		Robot robo1=new Robot();
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
		action.moveToElement(find_element("receive","csssele")).perform(); //MouseOver Receive menu
				//click("receive","csssele");		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
		Thread.sleep(2000);
		click("receive-menu","csssele");
		Thread.sleep(3000);
		Driver.getTitle();
//		WebElement rec_proceed=find_element("receive-proceed","csssele");
//		if(rec_proceed.isDisplayed()) {
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.ui-button:nth-child(1) > span:nth-child(1)")));
//		find_element("receive-proceed","csssele").click(); 
//		//robo1.keyPress(KeyEvent.VK_ENTER);
//		}
		Thread.sleep(3000);
		type("rec-tab-search","csssele", data.get("Receive_Protocol_ID"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		List<WebElement> rec_tab_row=Driver.findElements(By.xpath(("//table[@id='receiveDrug']/tbody/tr")));
		System.out.println(rec_tab_row.size());
		
		List<WebElement> rec_tab_col=Driver.findElements(By.xpath(("//table[@id='receiveDrug']/tbody/tr[1]/td")));
		System.out.println(rec_tab_col.size());
		
		for(int row=1;row<=rec_tab_row.size();row++) {
			
			for(int col=1;col<=rec_tab_col.size();col++)
			{
			
				String prot_id=data.get("Receive_Protocol_ID");
				String rec_tab_com=Driver.findElement(By.xpath("//table[@id='receiveDrug']/tbody/tr["+row+"]/td["+col+"]")).getText();
				if(rec_tab_com.equalsIgnoreCase(prot_id)) {
					
					Driver.findElement(By.xpath("//table[@id='receiveDrug']/tbody/tr["+row+"]/td[1]")).click();
					break;
				}	
		}
	}
		
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("receive-submit","id"));
		type("receive-edit","id",data.get("esignature"));
		click("receive-submit","id");
		
	}
	
	public void receiveEdit() {}
	
	public void receiveDelete() {}
	
	public void receiveDeleteVerify() {}
	
	public void receiveEditVerify() {}
	
	public void receiveVerifyTable() {
		
//Assert.assertEquals(actual, expected);
//Assert.fail(message);
//SoftAssert softassert=new SoftAssert();
//Assert.assertEquals(true, false, "Testing string");
//softassert.assertEquals(
		
	}
	
	public void receivePrint() {}
	
	public void receivePrintBarcodes() {}
	
//	//@Test(priority=1)
//	public void receiveLot() throws IOException, InterruptedException, AWTException {
//	
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
//		action.moveToElement(find_element("receive","csssele")).perform(); //MouseOver Receive menu
//				//click("receive","csssele");		
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
//		//Thread.sleep(2000);
//		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", find_element("receive-menu","csssele"));
//		click("receive-menu","csssele");								//Click Receive module menu
//				//((JavascriptExecutor)Driver).executeScript("menuMethod('Receive','pages/jsp/Receive_Drug.jsp');");
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plusDrugRc")));
//		Thread.sleep(2000);
//		click("receive-add","id");		//Click Add
//		Thread.sleep(3000);
//		type("receive-protocol-id","id",data.get("NostData",33,3)); 	//Enter the Protocol ID
//		Robot robo=new Robot();
//		Thread.sleep(3000);
//		robo.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
//		Thread.sleep(4000);
//        String drug_com=String.join(" ", data.get("NostData",13,1),data.get("NostData",13,3),data.get("NostData",13,4));
//        System.out.println(" The Drug combination text in Receive to be selected is  "+ drug_com);
//        
//      //Select the Drug from the list generated
//        String rec_drg_val=data.get("NostData",13,1);
//        List<WebElement> rec_drg=Driver.findElements(By.tagName("Option"));
//      for(WebElement element:rec_drg)
//   	    if(element.getText().contains(rec_drg_val)) {
//   	    	element.click();
//   	    }
//        type("receive-lot","id",data.get("NostData",33,7));			 //Enter Lot#
//        type("receive-expiration-date","id",data.get("NostData",33,12));  //Enter Lot Expiration date
//        type("receive-total-qty","id",data.get("NostData",33,15));		 //Enter Total Quantity
//        type("receive-comment","id",data.get("NostData",33,16));			 //Enter Comments
//        click("receive-save","id"); 		//Save
//
//        //Validate all other default fields are auto populated based on the catalog default tab
//        
////        check("rec-patient-specific-drug","id",data.get("NostData",33,1));
////        check("rec-ivrs","id",data.get("NostData",33,2));
////        type("receive-formulation","id",data.get("NostData",33,5));
////        selectText("receive-level-of-accountability","id",data.get("NostData",3,2));
////        selectText("receive-unit-type","id",data.get("NostData",3,2));
////        selectText("receive-pharmacy","id",data.get("NostData",3,2));
////        selectText("receive-storage-condition","id",data.get("NostData",3,2));
////        selectText("receive-storage-locaction","id",data.get("NostData",3,2));
////        type("receive-supplier-name","id",data.get("NostData",3,2));
////        type("receive-qty-per-unit","id",data.get("NostData",3,2));
//    
//	}
//	
//	//@Test
//	public void receiveUnit() throws IOException, InterruptedException, AWTException {
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Receive")));
//		action.moveToElement(find_element("receive","csssele")).perform(); //MouseOver Receive menu
//				//click("receive","csssele");		
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
//		Thread.sleep(2000);
//		click("receive-menu","csssele");								//Click Receive module menu
//				//((JavascriptExecutor)Driver).executeScript("menuMethod('Receive','pages/jsp/Receive_Drug.jsp');");
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("plusDrugRc")));
//		Thread.sleep(2000);
//		click("receive-add","id");		//Click Add
//		Thread.sleep(2000);
//		type("receive-protocol-id","id",data.get("NostData",33,3)); 	//Enter the Protocol ID
//		Robot robo=new Robot();
//		Thread.sleep(3000);
//		robo.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
//		Thread.sleep(4000);
//        String drug_com=String.join(" ", data.get("NostData",13,1),data.get("NostData",13,3),data.get("NostData",13,4));
//        System.out.println(" The Drug combination text in Receive to be selected is  "+ drug_com);
//        
//      //Select the Drug from the list generated
//        String rec_drg_val=data.get("NostData",13,1);
//        List<WebElement> rec_drg=Driver.findElements(By.tagName("Option"));
//      for(WebElement element:rec_drg)
//   	    if(element.getText().contains(rec_drg_val)) {
//   	    	element.click();
//   	    }
//        
//        type("receive-lot","id",data.get("NostData",33,7));	//Enter Lot#
//        type("receive-static","id",data.get("NostData",33,18)); //Enter the Static Unit ID
//        type("unit-range-start","id",data.get("NostData",33,19));  //Enter Range Start
//        type("unit-range-end","id",data.get("NostData",33,20)); //Enter Range End
//        click("unit-gen","csssele"); // Units generator
//        type("receive-expiration-date","id",data.get("NostData",33,12));  //Enter Lot Expiration date
//        //type("receive-total-qty","id",data.get("NostData",33,15));		 //Enter Total Quantity
//        type("receive-comment","id",data.get("NostData",33,16));			 //Enter Comments
//        click("receive-save","id"); 		//Save
//		//Reset
//		//Cancel
//		
//	}

}

