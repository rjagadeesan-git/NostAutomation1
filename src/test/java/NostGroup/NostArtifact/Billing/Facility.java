package NostGroup.NostArtifact.Billing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Facility extends CommonMethods{
	
	public void facilityVerify(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		Robot robo1=new Robot();
		
		click("maintenance-billing-menu","csssele");
		Thread.sleep(2000);
		click("facility-menu","csssele");
		type("facility-name","id",data.get("facility-name"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_DOWN);
		robo1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		click("facility-search","id");
		
		type("facility-result-search-bar","csssele",data.get("facility-name"));
		Thread.sleep(2000);
		
		String facility_name=data.get("facility-name");
		String facility_tab_id=prop.getProperty("facility-result-search-tabu");
		//(String element_ref,String entity_type,String entity_value,String col_text,String col_click,String action)
		tableCommon("facility-result-search-tabu",facility_tab_id, "Facility", facility_name, 2, 2,"verify");
	}
	
	
}
