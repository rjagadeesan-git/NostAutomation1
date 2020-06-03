package NostGroup.NostArtifact.Transfer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;

public class TransferToPharmacy extends CommonMethods{
 

	public void transferCommon(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Transfer")));
		action.moveToElement(find_element("transfer-menu","csssele")).perform(); //MouseOver Transfer menu
				//click("transfer-menu","csssele");		
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
		Thread.sleep(2000);
		click("trans-to-pharm","csssele");//Click Transfer to Pharmacy module menu
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchprotvalue")));
		Thread.sleep(4000);
		type("trans-protocol-id","id",data.get("Transfer_Protocol_ID"));
		Thread.sleep(4000);
		//selectText("trans-drug-id","id",data.get("NostData",37,2));
		Robot robo2=new Robot();
		System.out.println(" Robo Start");
		Thread.sleep(3000);
		robo2.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
		System.out.println(" Robo end ");
		Thread.sleep(4000);
        String drug_com=String.join(" ", data.get("Drug_Name"),data.get("Strength/Concentration"),data.get("Unit_of_Measure"));
        System.out.println(" The Drug combination text in 'Transfer to Pharmacy' to be selected is  "+ drug_com);
        //Select the Drug from the list generated
        //String trans_drg_val=data.get("NostData",37,2);
        List<WebElement> trans_drg=Driver.findElements(By.tagName("Option"));
      for(WebElement element:trans_drg)
   	    if(element.getText().contains(drug_com)) {
   	    	element.click();
   	    }
      	Thread.sleep(4000);
      //Select the Lot# from the list generated
        String trans_lot_val=data.get("Transfer_Lot_#");
        List<WebElement> trans_lot=Driver.findElements(By.tagName("Option"));
      for(WebElement element:trans_lot)
   	    if(element.getText().contains(trans_lot_val)) {
   	    	element.click();
   	    }
      
      selectText("trans-fro-pharmacy","id",data.get("Trans_from_Pharmacy"));
  	selectText("trans-from-sto-location","id",data.get("From_Storage_location"));
  	Thread.sleep(3000);
  	selectText("trans-to-pharmacy","id",data.get("Trans_To_Pharmacy"));
  	selectText("trans-to-sto-location","id",data.get("To_Storage_Location"));
  	type("trans-comment","id",data.get("Transfer_comment"));
  	
      	Thread.sleep(4000);
      	
      	WebElement trans_LOA=find_element("trans-loa","id");
     
//        Select select1=new Select(trans_LOA);
//        
//        System.out.println(select1.getFirstSelectedOption().getText());
        
        	if(trans_LOA.getText().equalsIgnoreCase("Unit")) {
      	  
        	List<WebElement> trans_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
        	System.out.println(trans_unit_tab_row.size());
        	
        	List<WebElement> trans_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
        	System.out.println(trans_unit_tab_col.size());
        	
        	String unit_id=data.get("Unit#1");
        	
        	for(int row=1;row<=trans_unit_tab_row.size();row++) {
        		
        		for(int col=1;col<=trans_unit_tab_col.size();col++)
        		{
        			System.out.println("Row count  " +row);
        			String trans_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td["+col+"]")).getText();
        			System.out.println("Row count  " +row+"  Col count  "+col+ "   Value  "+trans_unit_id);
        			if(trans_unit_id.equalsIgnoreCase(unit_id)) {
        				System.out.println("Inside IF "+unit_id);
        				Thread.sleep(2000);
        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td[3]/input[1]"));
        				match_unit.click();
        			}
        	}
        		
        	}   	
        }
        else if(trans_LOA.getText().equalsIgnoreCase("Unit (by Vial)")) {
  		

        	List<WebElement> trans_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
        	System.out.println(trans_unit_tab_row.size());
        	
        	List<WebElement> trans_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
        	System.out.println(trans_unit_tab_col.size());
        	
        	String unit_id=data.get("Unit#1");
        	
        	for(int row=1;row<=trans_unit_tab_row.size();row++) {
        		
        		for(int col=1;col<=trans_unit_tab_col.size();col++)
        		{
        			System.out.println("Row count  " +row);
        			String trans_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td["+col+"]")).getText();
        			System.out.println("Row count  " +row+"  Col count  "+col+ "   Value  "+trans_unit_id);
        			if(trans_unit_id.equalsIgnoreCase(unit_id)) {
        				System.out.println("Inside IF "+unit_id);
        				Thread.sleep(2000);
        				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td[3]/input[1]"));
        				match_unit.click();
        			}
        	}
        		
        	}
        	
  	}else {
  		
  		type("trans-tot-qty-lot","id",data.get("Total_Qty_to_Drug_Transfer-Lot"));
  		
  	}
        type("trans-esign","id",data.get("esignature"));
		click("trans-submit","id");
	
	}


public void transfertoPharmVerifyTable() {}
		
//	public void transferLot(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {}
		
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Transfer")));
//		action.moveToElement(find_element("transfer-menu","csssele")).perform(); //MouseOver Transfer menu
//				//click("transfer-menu","csssele");		
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
//		Thread.sleep(2000);
//		click("trans-to-pharm","csssele");//Click Transfer to Pharmacy module menu
//		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchprotvalue")));
//		Thread.sleep(4000);
//		type("trans-protocol-id","id",data.get("Transfer_Protocol_ID"));
//		Thread.sleep(4000);
//		//selectText("trans-drug-id","id",data.get("NostData",37,2));
//		Robot robo2=new Robot();
//		System.out.println(" Robo Start");
//		Thread.sleep(3000);
//		robo2.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
//		System.out.println(" Robo end ");
//		Thread.sleep(4000);
//        String drug_com=String.join(" ", data.get("Drug_Name"),data.get("Strength/Concentration"),data.get("Unit_of_Measure"));
//        System.out.println(" The Drug combination text in 'Transfer to Pharmacy' to be selected is  "+ drug_com);
//        //Select the Drug from the list generated
//        //String trans_drg_val=data.get("NostData",37,2);
//        List<WebElement> trans_drg=Driver.findElements(By.tagName("Option"));
//      for(WebElement element:trans_drg)
//   	    if(element.getText().contains(drug_com)) {
//   	    	element.click();
//   	    }
//      	Thread.sleep(4000);
//      //Select the Lot# from the list generated
//        String trans_lot_val=data.get("Transfer_Lot_#");
//        List<WebElement> trans_lot=Driver.findElements(By.tagName("Option"));
//      for(WebElement element:trans_lot)
//   	    if(element.getText().contains(trans_lot_val)) {
//   	    	element.click();
//   	    }
//      	Thread.sleep(4000);
//		//selectText("trans-lot","id",data.get("NostData",37,3));
//		selectText("trans-fro-pharmacy","id",data.get("Trans_from_Pharmacy"));
//		selectText("trans-from-sto-location","id",data.get("From_Storage_location"));
//		Thread.sleep(3000);
//		selectText("trans-to-pharmacy","id",data.get("Trans_To_Pharmacy"));
//		selectText("trans-to-sto-location","id",data.get("To_Storage_Location"));
//		type("trans-comment","id",data.get("Transfer_comment"));
//		type("trans-tot-qty-lot","id",data.get("Total_Qty_to_Drug_Transfer-Lot"));
//		type("trans-esign","id",data.get("esignature"));
//		click("trans-submit","id");
//	
//	}

	//@Test
//	public void transferUnit() throws InterruptedException, IOException, AWTException {
//	
//	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Transfer")));
//	action.moveToElement(find_element("transfer-menu","csssele")).perform(); //MouseOver Transfer menu
//			//click("transfer-menu","csssele");		
//	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MegaMenu > div:nth-child(4) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
//	Thread.sleep(2000);
//	click("trans-to-pharm","csssele");//Click Transfer to Pharmacy module menu
//	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchprotvalue")));
//	Thread.sleep(2000);
//	type("trans-protocol-id","id",data.get("NostData",37,1));
//	Thread.sleep(2000);
//	//selectText("trans-drug-id","id",data.get("NostData",37,2));
//	Robot robo3=new Robot();
//	System.out.println(" Robo Start");
//	//Thread.sleep(3000);
//	robo3.keyPress(KeyEvent.VK_ENTER); //Selecting the Protocol from search list
//	System.out.println(" Robo end ");
//	Thread.sleep(2000);
//    String drug_com=String.join(" ", data.get("NostData",37,2),data.get("NostData",39,2),data.get("NostData",39,3));
//    System.out.println(" The Drug combination text in 'Transfer to Pharmacy' to be selected is  "+ drug_com);
//    //Select the Drug from the list generated
//    //String trans_drg_val=data.get("NostData",37,2);
//    List<WebElement> trans_drg=Driver.findElements(By.tagName("Option"));
//  for(WebElement element:trans_drg)
//	    if(element.getText().contains(drug_com)) {
//	    	element.click();
//	    }
//  	Thread.sleep(3000);
//  //Select the Lot# from the list generated
//    String trans_lot_val=data.get("NostData",37,3);
//    List<WebElement> trans_lot=Driver.findElements(By.tagName("Option"));
//  for(WebElement element:trans_lot)
//	    if(element.getText().contains(trans_lot_val)) {
//	    	element.click();
//	    }
//  	Thread.sleep(3000);
//	//selectText("trans-lot","id",data.get("NostData",37,3));
//	selectText("trans-fro-pharmacy","id",data.get("NostData",37,4));
//	selectText("trans-from-sto-location","id",data.get("NostData",37,5));
//	Thread.sleep(3000);
//	selectText("trans-to-pharmacy","id",data.get("NostData",37,6));
//	selectText("trans-to-sto-location","id",data.get("NostData",37,7));
//	type("trans-comment","id",data.get("NostData",37,8));
//	
//	//Select the Units in the Units selection table
//	
//	//Thread.sleep(3000);
//	
//	List<WebElement> trans_unit_tab_row=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr")));
//	System.out.println(trans_unit_tab_row.size());
//	
//	List<WebElement> trans_unit_tab_col=Driver.findElements(By.xpath(("//table[@id='unittab']/tbody/tr[1]/td")));
//	System.out.println(trans_unit_tab_col.size());
//	
//	String unit_id=data.get("NostData",37,11);
//	
//	for(int row=1;row<=trans_unit_tab_row.size();row++) {
//		
//		for(int col=1;col<=trans_unit_tab_col.size();col++)
//		{
//			System.out.println("Row count  " +row);
//			String trans_unit_id=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td["+col+"]")).getText();
//			System.out.println("Row count  " +row+"  Col count  "+col+ "   Value  "+trans_unit_id);
//			if(trans_unit_id.equalsIgnoreCase(unit_id)) {
//				System.out.println("Inside IF "+unit_id);
//				Thread.sleep(2000);
//				WebElement match_unit=Driver.findElement(By.xpath("//table[@id='unittab']/tbody/tr["+row+"]/td[3]/input[1]"));
//				match_unit.click();
//			}
//	}
//		
//	} 
//	type("trans-esign","id",data.get("NostData",3,3));
//	//click("trans-submit","id");
//	}		

} 
