package NostGroup.NostArtifact.Manage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;

public class Catalog extends CommonMethods{
	
	public void addDrug(Hashtable<String,String> data) throws InterruptedException, IOException
	{
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	   Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
		Thread.sleep(3000);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		((JavascriptExecutor)Driver).executeScript("addDrugCodLists();");
				//click("catalog","xpath");
				//click("add-catalog-button","xpath");

		//Add Drug 
		click("add-drug","csssele");
		type("drug-name","xpath",data.get("Drug_Name"));
		selectText("track-by","xpath",data.get("Track_By"));
		type("strength-concentration","xpath",data.get("Strength/Concentration"));
		selectText("unit-of-measure","xpath",data.get("Unit_of_Measure"));
		selectText("formulation","xpath",data.get("Formulation"));
		type("drug-label-name","xpath",data.get("Drug_Label_Name"));
		type("drug-id","xpath",data.get("Drug_ID_#"));
		type("drug-nsc","xpath",data.get("NSC_#"));
		type("alternative-drug-name","xpath",data.get("Alternative_Drug_Name"));
		//selectText("compound-med-label","xpath",data.get("Compounded_Med_Label"));
		
		// Set Defaults
		click("set-defaults","csssele");
		check("patient-specific-drug","xpath",data.get("Patient_Specific_Drug"));
		check("ivrs","xpath",data.get("IVRS"));
		selectText("to-be-linked","xpath",data.get("To_Be_Linked"));
		selectText("level-of-accountability","xpath",data.get("Level_of_Accountability"));
		WebElement cat_loa=find_element("level-of-accountability","xpath");
		Select select0=new Select(cat_loa);
		WebElement loa_selected=select0.getFirstSelectedOption();
		System.out.println(loa_selected.getText());
		if(loa_selected.getText().equalsIgnoreCase("Unit (by Vial)")) {
			System.out.println("Vial get selected by Default");
		}
		else {
			selectText("unit-type","xpath",data.get("Unit_Type"));
			type("qty-per-unit","xpath",data.get("Qty_per_Unit"));
		}
		
		type("catalog-supplier-name","xpath",data.get("Supplier_Name"));
		selectText("storage-condition","xpath",data.get("Storage_Condition"));
		selectText("pharmacy","xpath",data.get("Pharmacy_Drug"));
		selectText("storage-location","xpath",data.get("Storage_Location"));
//		selectText("route","xpath",data.get("Route"));
		selectText("frequency","xpath",data.get("Frequency"));
		type("dose-on-label","xpath",data.get("Dose_on_Label"));
		selectText("label-template","xpath",data.get("Label_Template"));
		type("day-supply","xpath",data.get("Day_Supply"));
//		selectText("aux-label1","xpath",data.get("Aux_Label_1"));
//		selectText("aux-label2","xpath",data.get("Aux_Label_2"));
//		selectText("aux-label3","xpath",data.get("Aux_Label_3"));
//		selectText("aux-label4","xpath",data.get("Aux_Label_4"));
//		selectText("aux-label5","xpath",data.get("Aux_Label_5"));
//		selectText("aux-label6","xpath",data.get("Aux_Label_6"));
		
		//Set Par levels
//		click("set-par-levels","xpath");
//		click("add-new-par-level","xpath");
//		selectText("set-par-protocol-id","xpath",data.get("NostData",13,32));
//		selectText("set-par-pharmacy","xpath",data.get("NostData",13,33));
//		type("set-par-min","xpath",data.get("NostData",13,34));
//		type("set-par-reorder-point","xpath",data.get("NostData",13,35));
//		type("set-par-max","xpath",data.get("NostData",13,36));
//		selectText("set-par-status","xpath",data.get("NostData",13,37));
//		click("set-par-row-delete-button","xpath");

//		// Add Label Criteria 
//		click("add-lab-criteria","csssele");
//		type("anc","xpath",data.get("ANC"));
//		type("plt","xpath",data.get("PLT's"));
//		type("hemoglobin","xpath",data.get("Hemoglobin"));
//		type("dipstick","xpath",data.get("Dipstick"));
//		type("24-hour-collection","xpath",data.get("24-hour_Collection"));
//		type("upc-ratio","xpath",data.get("UPC_Ratio"));
//		type("other1","xpath",data.get("Other1"));
//		type("other2","xpath",data.get("Other2"));
//		type("other3","xpath",data.get("Other3"));
//		type("serum-creatinine","xpath",data.get("Serum_Creatinine"));
//		type("bili-rubin-t-bili","xpath",data.get("Bilirubin:_T-Bili"));
//		type("asg-sgot","xpath",data.get("AST/SGOT"));
//		type("alt-sgpt","xpath",data.get("ALT/SGPT"));

		//Protocol association
		click("add-drug","csssele");
		type("cat-prot-sear","csssele",data.get("Drug_Protocol"));
        Driver.findElement(By.className(data.get("Drug_Proto_SPID"))).click();
        click("cat-prot-sear-ok","csssele");
        
        Thread.sleep(10000);
		
		//Catalog submission
		type("catalog-esign","xpath",data.get("esignature"));
		click("catalog-submit","xpath");
		//click("catalog-cancel","xpath");

			
		Thread.sleep(2000);
//		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));		
//		Thread.sleep(4000);
		
	}
	
	public void catalogEdit(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		Robot robo1=new Robot();
		Thread.sleep(3000);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		//((JavascriptExecutor)Driver).executeScript("addDrugCodLists();");
		
		Thread.sleep(3000);
		type("catalog-tab-search","csssele",data.get("Drug_Name"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String drug_id=data.get("Drug_Name");
		String drug_tab_id=prop.getProperty("drug-result-search-tabu");
		tableCommon("drug-result-search-tabu",drug_tab_id,"Catalog",drug_id,2,2,"checkbox_click");
		click("edit-catalog-button","csssele");
		Thread.sleep(2000);
		find_element("drug-name","xpath").clear();
		Thread.sleep(2000);
		type("drug-name","xpath",data.get("Drug_Name_edit"));
		
		//Catalog submission
			type("catalog-esign","xpath",data.get("esignature"));
			click("catalog-submit","xpath");
	
	}
	
	public void catalogVerify(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		Robot robo1=new Robot();
		Thread.sleep(3000);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		//((JavascriptExecutor)Driver).executeScript("addDrugCodLists();");
		
		Thread.sleep(3000);
		type("catalog-tab-search","csssele",data.get("Drug_Name"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String drug_id=data.get("Drug_Name");
		String drug_tab_id=prop.getProperty("drug-result-search-tabu");
		//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
		tableCommon("drug-result-search-tabu",drug_tab_id,"Catalog",drug_id,2,2,"verify");
		
		Thread.sleep(2000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));		
		Thread.sleep(4000);
	}
	
public void catalogEditVerify(Hashtable<String,String> data) throws InterruptedException, AWTException {
		
		Robot robo1=new Robot();
		Thread.sleep(3000);
		ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		//((JavascriptExecutor)Driver).executeScript("addDrugCodLists();");
		
		Thread.sleep(3000);
		type("catalog-tab-search","csssele",data.get("Drug_Name_edit"));
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_ENTER);
		robo1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		String drug_id=data.get("Drug_Name_edit");
		String drug_tab_id=prop.getProperty("drug-result-search-tabu");
		//String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action
		tableCommon("drug-result-search-tabu",drug_tab_id,"Catalog",drug_id,2,2,"verify");
		
		Thread.sleep(2000);
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));		
		Thread.sleep(4000);
	}
	
	
	public void cat_Prot_Asso() {}
	
	public void cat_Prot_Disso() {}
	
	public void cat_Pharm_Def() throws IOException {
	
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		Actions action=new Actions(Driver);
//		action.moveToElement(find_element("manage-menu","xpath")).perform();
//		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
//		type("catalog-supplier-name","xpath",data.get("NostData",13,17));
//		selectText("storage-condition","xpath",data.get("NostData",13,18));
//		selectText("pharmacy","xpath",data.get("NostData",13,19));
//		selectText("storage-location","xpath",data.get("NostData",13,20));
	}
	
	public void cat_Supp_Def() {}
	
	public void cat_Set_Parlevel() {
	
//		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		Actions action=new Actions(Driver);
//		action.moveToElement(find_element("manage-menu","xpath")).perform();
//		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
//		
//		// Add the code to select and edit the Drug
//		click("set-defaults","xpath");
	}

}
