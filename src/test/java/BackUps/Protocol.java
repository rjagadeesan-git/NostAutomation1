

public class Protocol extends CommonMethods{

	public static SpreadSheetHelper helper=null;
	
	@Test(dataProvider="getData")
	public void addProtocol() throws IOException, InterruptedException
	{		
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
	type("protocol-id","id",readExcel("NostData",8,1));
	type("protocol-title","id",readExcel("NostData",8,2));
	selectText("protocol-status","id",readExcel("NostData",8,3));
	selectText("pharmacy-status","id",readExcel("NostData",8,4));
	type("sponsor-protocol-id","id",readExcel("NostData",8,5));
	type("protocol-sponsor","id",readExcel("NostData",8,6));
	type("site-number","id",readExcel("NostData",8,7));
	selectText("protocol-phase","id",readExcel("NostData",8,8));
	selectText("disease-program","id",readExcel("NostData",8,9));
	selectText("service","id",readExcel("NostData",8,10));
	selectText("study-source","id",readExcel("NostData",8,11));
	selectText("protocol-type","id",readExcel("NostData",8,12));
	type("internal-irb","id",readExcel("NostData",8,13));
	type("external-irb","id",readExcel("NostData",8,14));
	selectText("protocol-category","id",readExcel("NostData",8,15));

	//Staffs
	click("staff","csssele");
	type("pi-first-name","id",readExcel("NostData",8,17));
	type("pi-last-name","id",readExcel("NostData",8,18));
	type("investigator-id","id",readExcel("NostData",8,19));
	type("id-expiration","id",readExcel("NostData",8,20));
	type("opt-pi-institution","id",readExcel("NostData",8,21));
	type("opt-pi-first-name","id",readExcel("NostData",8,22));
	type("opt-pi-last-name","id",readExcel("NostData",8,23));
	type("opt-investigator-id","id",readExcel("NostData",8,24));
	type("opt-id-expiration","id",readExcel("NostData",8,25));
	type("study-contact","id",readExcel("NostData",8,26));

	//Key Dates
	click("key-dates","csssele");
	type("protocol-phase-start-date","id",readExcel("NostData",8,27));
	type("closed-to-new-patients","id",readExcel("NostData",8,28));
	type("protocol-closure-date","id",readExcel("NostData",8,29));
	type("reason-for-closure","name",readExcel("NostData",8,30));
	type("protocol-completion-date","id",readExcel("NostData",8,31));

	//Notifications	
	click("notifications","csssele");
	type("not-receive","csssele",readExcel("NostData",8,32));
	type("not-transfer","csssele",readExcel("NostData",8,33));
	type("not-dispense","csssele",readExcel("NostData",8,34));
	type("not-destroy","csssele",readExcel("NostData",8,35));
	type("not-return","csssele",readExcel("NostData",8,36));
//
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
	type("protocol-esign","id",readExcel("NostData",3,3));
	click("protocol-submit","id");
	
	// Protocol deletion
    //	click("protocol-delete","id");	

	// Protocol Cancel
    //	click("protocol-cancel","id");

	Thread.sleep(5000);
	((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
	Thread.sleep(5000);
	}
	
