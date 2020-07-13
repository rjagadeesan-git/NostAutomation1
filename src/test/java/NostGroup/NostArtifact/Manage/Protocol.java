package NostGroup.NostArtifact.Manage;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Base.CommonMethods;
import NostGroup.NostArtifact.Base.SpreadSheetHelper;

public class Protocol extends CommonMethods{

	//@Test(dataProvider="getData")
	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException
	{	
		System.out.println("Starting Adding protocol.....");
//		Actions action=new Actions(Driver);
//		WebDriverWait ex_wait= new WebDriverWait(Driver,20);
	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Manage']")));
	action.moveToElement(Driver.findElement(By.xpath("//*[@id='Manage']"))).perform();
	
	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section[1]/div/div/table/tbody/tr/td/div[2]/div[3]/table/tbody/tr/th/table/tbody/tr[2]/td/ul/li/a")));
	click("protocol","csssele");
	Thread.sleep(2000);
	ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cataloghead_bg > form:nth-child(1) > input:nth-child(1)")));
	click("add-protocol","csssele");
	
	//Add Protocol Tab
	type("protocol-id","id",data.get("Protocol_ID"));
	type("protocol-title","id",data.get("Protocol_Title"));
	selectText("protocol-status","id",data.get("Protocol_Status"));
	selectText("pharmacy-status","id",data.get("Pharmacy_Status"));
	type("sponsor-protocol-id","id",data.get("Sponsor_Protocol_ID"));
	type("protocol-sponsor","id",data.get("Protocol_Sponsor"));
	type("site-number","id",data.get("Site_Number"));
	selectText("protocol-phase","id",data.get("Protocol_Phase"));
	selectText("disease-program","id",data.get("Disease_Program"));
	selectText("service","id",data.get("Service"));
	selectText("study-source","id",data.get("Study_Source"));
	selectText("protocol-type","id",data.get("Protocol_Type"));
	type("internal-irb","id",data.get("Internal_IRB#"));
	type("external-irb","id",data.get("External_IRB#"));
	selectText("protocol-category","id",data.get("Protocol_Category"));

	//Staffs
	click("staff","csssele");
	type("pi-first-name","id",data.get("PI_First_Name"));
	type("pi-last-name","id",data.get("PI_Last_Name"));
	type("investigator-id","id",data.get("Investigator_ID"));
	type("id-expiration","id",data.get("ID_Expiration"));
	type("opt-pi-institution","id",data.get("Optional_PI_Institution"));
	type("opt-pi-first-name","id",data.get("OP_PI_First_Name"));
	type("opt-pi-last-name","id",data.get("OP_PI_Last_Name"));
	type("opt-investigator-id","id",data.get("OP_Investigator_ID"));
	type("opt-id-expiration","id",data.get("ID_Expiration"));
	type("study-contact","id",data.get("Study_Contact"));

	//Key Dates
	click("key-dates","csssele");
	type("protocol-phase-start-date","id",data.get("Protocol_Phase_Start_Date"));
	type("closed-to-new-patients","id",data.get("Closed_to_New_Patients"));
	type("protocol-closure-date","id",data.get("Protocol_Closure_Date"));
	type("reason-for-closure","name",data.get("Reason_for_Closure"));
	type("protocol-completion-date","id",data.get("Protocol_Completion_Date"));

	//Notifications	
	click("notifications","csssele");
	type("not-receive","csssele",data.get("Noti_Receive"));
	type("not-transfer","csssele",data.get("Noti_Transfer"));
	type("not-dispense","csssele",data.get("Noti_Dispense"));
	type("not-destroy","csssele",data.get("Noti_Destroy"));
	type("not-return","csssele",data.get("Noti_Return"));
//	type("not-pat-ret","csssele",data.get("Noti_Pat_Return"));
//	//Documents
//	click("documents","csssele");
//	//ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#addDoc")));
//	ex_wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addDoc")));
//	//ex_wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#addDoc")));
//	click("add-new-document","csssele");
//	//((JavascriptExecutor)Driver).executeScript("addNewDocument(this);");
//	selectText("category","id",readExcel("NostData",8,37));
//	type("version","id",readExcel("NostData",8,38));
//	selectText("type","id",readExcel("NostData",8,39));
//	//click("browse","id");
//	type("description","id",readExcel("NostData",8,40));
////driver.get(baseUrl);
//    WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
//    // enter the file path onto the file-selection input field
//    uploadElement.sendKeys("C:\\newhtml.html");
//	((JavascriptExecutor)Driver).executeScript("addNewDocument(this);");
//	//click("add-another-document","id");
//	selectText("category1","id",readExcel("NostData",8,41));
//	type("version1","id",readExcel("NostData",8,42));
//	selectText("type1","id",readExcel("NostData",8,43));
//	//click("browse1","id");
//	type("description1","id",readExcel("NostData",8,44));

	//Protocol submission
	type("protocol-esign","id",data.get("esignature"));
	click("protocol-submit","id");
	
	// Protocol deletion
    //	click("protocol-delete","id");	

	// Protocol Cancel
    //	click("protocol-cancel","id");

	Thread.sleep(5000);
	((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
	Thread.sleep(5000);
	}
	
	public void protocolEdit() {}
	
	public void protocolVerify() {}
	
	public void protocolVerifyTable() {}

}