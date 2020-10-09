package NostGroup.NostArtifact.Base;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonMethods {
	
	public static WebDriver Driver;
	public static Actions action;
	public static WebDriverWait ex_wait;
	public static Wait<WebDriver> flu_wait;
	public static Logger log;
	public static Reporter RepLog;
//    public Actions action=new Actions(Driver);
//	public WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//	public Wait<WebDriver> flu_wait= new FluentWait<WebDriver>(Driver)
//			.withTimeout(Duration.ofSeconds(30))
//			.pollingEvery(Duration.ofSeconds(4))
//			.withMessage("Testing fluent wait");
//		.ignoring(NoSuchElementException.class);

	public static Properties prop=new Properties();
	public static String imagename;
	public static String imagename_a;
	public static String imagename_ele;
	public static String exreportname;
	private static ExtentReports extent;
	//public ExtentReports exreport=ExtentedReports.getObj();
	public ExtentReports exreport=getExtentReportsObj();
	public static ExtentTest extest;
	
//	public CommonMethods() {
//		if(Driver==null) {
//			WebDriverManager.firefoxdriver().setup();
//			Driver=new FirefoxDriver();
//			Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		}
//		
//	}	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {	}
	
	public static void click(String locator,String locatortype) {
		
		WebElement clickelement=find_element(locator, locatortype);
		clickelement.click();
		extest.log(LogStatus.INFO,"Clicked the item: "+locator);
		log.info("Clicked the item: "+locator);
		
		Reporter.log("Clicked the item: "+locator);
	
	}
		
		public static void type(String locator,String locatortype,String value) {
			
			WebElement typeelement=find_element(locator, locatortype);
			typeelement.sendKeys(value);
			extest.log(LogStatus.INFO,"Entered the value '"+value+"' in field '"+locator+"'");
			log.info("Entered the value '"+value+"' in field '"+locator+"'");
			Reporter.log("Entered the value '"+value+"' in field '"+locator+"'");		
		}
	
	public static void check(String locator,String locatortype, String condition) {
		
		WebElement checkelement=find_element(locator, locatortype);
		log.info(locator+" selection is "+checkelement.isSelected());
		if((condition.equalsIgnoreCase("Yes")) && (checkelement.isSelected()==false)) {
			
			checkelement.click();
			log.info(" Input is Yes for the field '"+locator+"' and Checkbox is unchecked by default, now checked/ticked successfully");
			extest.log(LogStatus.INFO,"Input is Yes for the field '"+locator+"' and unchecked by default, now checked/ticked successfully");
			Reporter.log(" Input is Yes for the field '"+locator+"' and Checkbox is unchecked by default, now checked/ticked successfully");
			
		}
		else if((condition.equalsIgnoreCase("No")) && (checkelement.isSelected()==true))
		{
			checkelement.click();
		log.info("Input is No for the field '"+locator+"' and checked by default, now unchecked/unticked successfully");
		extest.log(LogStatus.INFO,"Input is No for the field '"+locator+"' and checked by default, now unchecked/unticked successfully");
		Reporter.log("Input is No for the field '"+locator+"' and checked by default, now unchecked/unticked successfully");	
		
		}
		
		else { 
			log.info("'"+locator+"' is checked/ticked by default");
			Reporter.log("'"+locator+"' is checked/ticked by default");
			extest.log(LogStatus.INFO,"'"+locator+"' is checked/ticked by default");
			
		}
		
	}

	public static void selectText(String locator,String locatortype,String text) {
		
		WebElement selecttext=find_element(locator, locatortype);
		
		Select select =new Select(selecttext);
		select.selectByVisibleText(text);
		extest.log(LogStatus.INFO,"Selected the value '"+text+"' in field '"+locator+"'");
		log.info("Selected the value '"+text+"' in field '"+locator+"'");
		Reporter.log("Selected the value '"+text+" in field '"+locator+"'");		
	}
	
	public static void selectValue(String locator,String locatortype,String value) {
		
		WebElement selectvalue=find_element(locator, locatortype);		 
		
		Select select =new Select(selectvalue);
		select.selectByValue(value);
		extest.log(LogStatus.INFO,"Selected the value(key) "+value+" in "+locator);
		log.info("Selected the value(key) "+value+" in "+locator);
		Reporter.log("Selected the value(key) "+value+" in "+locator);
		
	}
	
	public static void screenshotReg() throws IOException  {
		
		String DateString=new Date().toString().replace(":","_").replace(" ", "_");
		imagename=("Screenshot_"+DateString+".jpg");
		File screenshot=((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"//Screenshots//"+imagename));
	}

	public static void snapShot() throws IOException {
		
		String DateString=new Date().toString().replace(":","_").replace(" ", "_");
		imagename_a=("Screenshot_A_"+DateString+".jpg");
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Driver);
		ImageIO.write(screenshot.getImage(),"jpg",new File(".//Screenshots-A//"+imagename_a));
		
	}

	public static void snapShotElement(WebElement element) throws IOException {
		
		String DateString=new Date().toString().replace(":","_").replace(" ", "_");
		imagename_ele=("Screenshot_Ele_"+DateString+".jpg");
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Driver,element);
		ImageIO.write(screenshot.getImage(),"jpg", new File(".//Screenshot-Element//"+imagename_ele));
		
	}

	public static ExtentReports getExtentReportsObj() {
		
		if(extent==null) {
			
			String DateString=new Date().toString().replace(":","_").replace(" ", "_");
//			exreportname=("Extent_"+DateString+".html");
			exreportname=("Extent.html");
			System.out.println(exreportname);
			extent=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\"+exreportname,true,DisplayOrder.OLDEST_FIRST);
			 extent.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentConfig.xml"));
		}
		return extent;
	}

	public static WebElement find_element(String locator,String locatortype) {
		
		WebElement findelement_out=null;
		
		System.out.println("Finding element: "+locator);
		
		log.info("Finding Element: "+prop.getProperty(locator));
			
		if(locatortype=="xpath") {
			
			WebElement xpath_in=Driver.findElement(By.xpath(prop.getProperty(locator)));
			findelement_out=xpath_in;
			
		} else if(locatortype=="id") {
			
			WebElement id_in=Driver.findElement(By.id(prop.getProperty(locator)));
			findelement_out=id_in;
			
		}else if(locatortype=="name") {
			
			WebElement name_in=Driver.findElement(By.name(prop.getProperty(locator)));
			findelement_out=name_in;
			
		}else if(locatortype=="class") {
			
			WebElement class_in=Driver.findElement(By.className(prop.getProperty(locator)));
			findelement_out=class_in;
			
		} else if(locatortype=="csssele") {
			
			WebElement csssele_in=Driver.findElement(By.cssSelector(prop.getProperty(locator)));
			findelement_out=csssele_in;
			
		} else if(locatortype=="linktext") {
			
			WebElement link_in=Driver.findElement(By.linkText(prop.getProperty(locator)));
			findelement_out=link_in;
			
		} else if(locatortype=="partiallink") {
			
			WebElement partialtext_in=Driver.findElement(By.partialLinkText(prop.getProperty(locator)));
			findelement_out=partialtext_in;
			
		} 
		
		log.info("Found Element: "+prop.getProperty(locator));
		return findelement_out;
	}
	
	public List<WebElement> find_elements(String locator,String locatortype) {
		
		System.out.println(" calling find element method...");
		
		List<WebElement> findelement_out=null;
		
		System.out.println(locator);
		
		if(locatortype=="xpath") {
			
			List<WebElement> xpath_in=Driver.findElements(By.xpath(locator));
			findelement_out=xpath_in;
			
		} else if(locatortype=="id") {
			
			List<WebElement> id_in=Driver.findElements(By.id(locator));
			findelement_out=id_in;
			
		}else if(locatortype=="name") {
			
			List<WebElement> name_in=Driver.findElements(By.name(locator));
			findelement_out=name_in;
			
		}else if(locatortype=="class") {
			
			List<WebElement> class_in=Driver.findElements(By.className(locator));
			findelement_out=class_in;
			
		} else if(locatortype=="csssele") {
			
			List<WebElement> csssele_in=Driver.findElements(By.cssSelector(locator));
			findelement_out=csssele_in;
			
		} else if(locatortype=="linktext") {
			
			List<WebElement> link_in=Driver.findElements(By.linkText(locator));
			findelement_out=link_in;
			
		} else if(locatortype=="partiallink") {
			
			List<WebElement> partialtext_in=Driver.findElements(By.partialLinkText(locator));
			findelement_out=partialtext_in;
			
		}
		
		System.out.println(findelement_out);
		return findelement_out;
	}
	
	public static void tableCommon(String tab_loc_ref,String table_id,String entity_type,String entity_value,int col_text,int col_click,String action) {
		
		WebElement table_ref=find_element(tab_loc_ref,"id");
		
		List<WebElement> tab_row=Driver.findElements(By.xpath(("//table[@id='"+table_id+"']/tbody/tr")));
		System.out.println(tab_row.size());
		
		List<WebElement> tab_col=Driver.findElements(By.xpath(("//table[@id='"+table_id+"']/tbody/tr[1]/td")));
		System.out.println(tab_col.size());
		//String entity_item=data.get(entity_value);
		
		if(table_ref.isDisplayed() && tab_col.size()>1) {
		
		if(tab_row.size()>=1)
		{
			System.out.println("Inside Tabular row If");
		
		for(int row=1;row<=tab_row.size();row++) {
			
				System.out.println("Inside Tabular row For loop");
				String tab_comp_value=Driver.findElement(By.xpath("//table[@id='"+table_id+"']/tbody/tr["+row+"]/td["+col_text+"]")).getText();
				if(tab_comp_value.equalsIgnoreCase(entity_value)) {	
						if(action.equalsIgnoreCase("verify")) {
					//Driver.findElement(By.xpath("//table[@id='"+element_ref+"']/tbody/tr["+row+"]/td["+col_click+"]")).click();
					System.out.println(entity_type+" "+entity_value+" found");
					extest.log(LogStatus.PASS,entity_type+" '"+entity_value+"' found in the "+entity_type+" table");
					log.info(entity_type+" '"+entity_value+"' found in the "+entity_type+" table");
					Reporter.log(entity_type+" '"+entity_value+"' found in the "+entity_type+" table");
						} else if(action.equalsIgnoreCase("click")) {
							Driver.findElement(By.xpath("//table[@id='"+table_id+"']/tbody/tr["+row+"]/td["+col_click+"]")).click();
							System.out.println(entity_type+" "+entity_value+" found in the table to click");
							extest.log(LogStatus.PASS,entity_type+" '"+entity_value+"' found in the "+entity_type+" table to click");
							log.info(entity_type+" '"+entity_value+"' found in the "+entity_type+" table to click");
							Reporter.log(entity_type+" '"+entity_value+"' found in the "+entity_type+" table to click");
						} else if(action.equalsIgnoreCase("checkbox_click")) {
							
							Driver.findElement(By.xpath("//table[@id='"+table_id+"']/tbody/tr["+row+"]/td[1]")).click();
							System.out.println(entity_type+" "+entity_value+" found in the table to be checked");
							extest.log(LogStatus.PASS,entity_type+" '"+entity_value+"' found in the "+entity_type+" table to be checked");
							log.info(entity_type+" '"+entity_value+"' found in the "+entity_type+" table to be checked");
							Reporter.log(entity_type+" '"+entity_value+"' found in the "+entity_type+" table to be checked");
							
						}
					break;
				} else if(tab_comp_value.contains(entity_value))	{
					
					System.out.println("Partial match found");
					extest.log(LogStatus.WARNING,"One of the "+entity_type+" '"+tab_comp_value+"' contains '"+entity_value+"' found,but not the exact match");
					log.info("One of the "+entity_type+" '"+tab_comp_value+"' contains '"+entity_value+"' found,but not the exact match");
					Reporter.log("One of the "+entity_type+" '"+tab_comp_value+"' contains '"+entity_value+"' found,but not the exact match");
				}
	}

	} else {
		System.out.println("Tabular entity not found, Wrong Search");
		extest.log(LogStatus.FAIL,entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
		log.info(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
		Reporter.log(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
		Assert.fail(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
	}
		
		}else {
			
			System.out.println(entity_type+" '"+entity_value+"' not found, Table not Displayed");
			extest.log(LogStatus.FAIL,entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
			log.info(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
			Reporter.log(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
			Assert.fail(entity_type+" '"+entity_value+"' not found in "+entity_type+" table");
		}

	}
	
	
	public String getSign(Hashtable<String,String> data) {

		return null;
		
	}

	public static boolean isExecuteTest(String testname,SpreadSheetHelper spreadsheet) {
		
		String sheetname="TestExecutor";
		int rows=spreadsheet.getRowCount(sheetname);
		
		for(int rNum=2;rNum<=rows;rNum++) {
			
			String testCase=spreadsheet.getCellData(sheetname, rNum, "TestCaseID");
			
			if(testCase.equalsIgnoreCase(testname)) {
				
				String runmode=spreadsheet.getCellData(sheetname, rNum, "runtest");
			if(runmode.equalsIgnoreCase("Y"))
				return true;
			else
				return false;
			}
		}
			
		return false;
		
	}


public static String readExcel(String sheetName,int rownum,int colnum) throws IOException {
	
	// File file1=new File("D:\\Jagan\\Drug_Accountability_Report(5).xlsx");
	
	FileInputStream excelin= new FileInputStream("D:\\Jagan\\Nost_Data_Driven.xlsx");
	
	XSSFWorkbook excel=new XSSFWorkbook(excelin);

	XSSFSheet sheet1=excel.getSheet(sheetName);
	
//	Row row=sheet1.getRow(rownum);
//	Cell cell1=row.getCell(0);
//	Cell cell2=row.getCell(1);

	DataFormatter formatter=new DataFormatter();
	
	//CellType cell_type=sheet1.getRow(rownum).getCell(colnum).getCellType();
	
	Cell cell=sheet1.getRow(rownum).getCell(colnum);

//    System.out.println((sheet1.getRow(rownum).getCell(colnum).getCellType()) +" "+);
	String excelout=formatter.formatCellValue(cell);
	
	System.out.println((sheet1.getRow(rownum).getCell(colnum).getCellType()) +" "+excelout);
	
//	System.out.println("Cell 1" +cell1+" Cell 2" +cell2);
//excel.close();
return excelout;

}

}
