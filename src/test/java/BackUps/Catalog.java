package BackUps;

import java.io.IOException;
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
	
	public void addDrug() throws InterruptedException, IOException
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
		type("drug-name","xpath",readExcel("NostData",13,1));
		selectText("track-by","xpath",readExcel("NostData",13,2));
		type("strength-concentration","xpath",readExcel("NostData",13,3));
		selectText("unit-of-measure","xpath",readExcel("NostData",13,4));
		selectText("formulation","xpath",readExcel("NostData",13,5));
		type("drug-label-name","xpath",readExcel("NostData",13,6));
		type("drug-id","xpath",readExcel("NostData",13,7));
		type("drug-nsc","xpath",readExcel("NostData",13,8));
		type("alternative-drug-name","xpath",readExcel("NostData",13,9));
		selectText("compound-med-label","xpath",readExcel("NostData",13,10));
		
		// Set Defaults
		click("set-defaults","csssele");
		check("patient-specific-drug","xpath",readExcel("NostData",13,11));
		check("ivrs","xpath",readExcel("NostData",13,12));
		selectText("to-be-linked","xpath",readExcel("NostData",13,13));
		selectText("level-of-accountability","xpath",readExcel("NostData",13,14));
		WebElement cat_loa=find_element("level-of-accountability","xpath");
		Select select0=new Select(cat_loa);
		WebElement loa_selected=select0.getFirstSelectedOption();
		System.out.println(loa_selected.getText());
		if(loa_selected.getText().equalsIgnoreCase("Unit (by Vial)")) {
			System.out.println("Vial get selected by Default");
		}
		else {
			selectText("unit-type","xpath",readExcel("NostData",13,15));
			type("qty-per-unit","xpath",readExcel("NostData",13,16));
		}
		
		type("catalog-supplier-name","xpath",readExcel("NostData",13,17));
		selectText("storage-condition","xpath",readExcel("NostData",13,18));
		selectText("pharmacy","xpath",readExcel("NostData",13,19));
		selectText("storage-location","xpath",readExcel("NostData",13,20));
//		selectText("route","xpath",readExcel("NostData",3,21));
		selectText("frequency","xpath",readExcel("NostData",13,22));
		type("dose-on-label","xpath",readExcel("NostData",13,23));
		selectText("label-template","xpath",readExcel("NostData",13,24));
		type("day-supply","xpath",readExcel("NostData",13,25));
		selectText("aux-label1","xpath",readExcel("NostData",13,26));
		selectText("aux-label2","xpath",readExcel("NostData",13,27));
		selectText("aux-label3","xpath",readExcel("NostData",13,28));
		selectText("aux-label4","xpath",readExcel("NostData",13,29));
//		selectText("aux-label5","xpath",readExcel("NostData",13,30));
//		selectText("aux-label6","xpath",readExcel("NostData",13,31));
		
		//Set Par levels
//		click("set-par-levels","xpath");
//		click("add-new-par-level","xpath");
//		selectText("set-par-protocol-id","xpath",readExcel("NostData",13,32));
//		selectText("set-par-pharmacy","xpath",readExcel("NostData",13,33));
//		type("set-par-min","xpath",readExcel("NostData",13,34));
//		type("set-par-reorder-point","xpath",readExcel("NostData",13,35));
//		type("set-par-max","xpath",readExcel("NostData",13,36));
//		selectText("set-par-status","xpath",readExcel("NostData",13,37));
//		click("set-par-row-delete-button","xpath");

		// Add Label Criteria 
		click("add-lab-criteria","csssele");
		type("anc","xpath",readExcel("NostData",13,38));
		type("plt","xpath",readExcel("NostData",13,39));
		type("hemoglobin","xpath",readExcel("NostData",13,40));
		type("dipstick","xpath",readExcel("NostData",13,41));
		type("24-hour-collection","xpath",readExcel("NostData",13,42));
		type("upc-ratio","xpath",readExcel("NostData",13,43));
		type("other1","xpath",readExcel("NostData",13,44));
		type("other2","xpath",readExcel("NostData",13,45));
		type("other3","xpath",readExcel("NostData",13,46));
		type("serum-creatinine","xpath",readExcel("NostData",13,47));
		type("bili-rubin-t-bili","xpath",readExcel("NostData",13,48));
		type("asg-sgot","xpath",readExcel("NostData",13,49));
		type("alt-sgpt","xpath",readExcel("NostData",13,50));

		//Protocol association
		click("add-drug","csssele");
		type("cat-prot-sear","csssele",readExcel("NostData",13,32));
        Driver.findElement(By.className(readExcel("NostData",13,33))).click();
        click("cat-prot-sear-ok","csssele");
		
		//Catalog submission
		type("catalog-esign","xpath",readExcel("NostData",3,3));
		click("catalog-submit","xpath");
		//click("catalog-cancel","xpath");

		Thread.sleep(20000);
		
	}
	
	public void editCatalog() {}
	
	public void cat_Prot_Asso() {}
	
	public void cat_Prot_Disso() {}
	
	public void cat_Pharm_Def() throws IOException {
	
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions action=new Actions(Driver);
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		type("catalog-supplier-name","xpath",readExcel("NostData",13,17));
		selectText("storage-condition","xpath",readExcel("NostData",13,18));
		selectText("pharmacy","xpath",readExcel("NostData",13,19));
		selectText("storage-location","xpath",readExcel("NostData",13,20));
	}
	
	public void cat_Supp_Def() {}
	
	public void cat_Set_Parlevel() {
	
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions action=new Actions(Driver);
		action.moveToElement(find_element("manage-menu","xpath")).perform();
		((JavascriptExecutor)Driver).executeScript("menuActionMethod('Manage','catalogDrug.action');");
		
		// Add the code to select and edit the Drug
		click("set-defaults","xpath");
	}

}
