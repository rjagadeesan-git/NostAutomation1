package NostGroup.NostArtifact.Base;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	
	public static WebDriver Driver;
	public static Actions action;
	public static WebDriverWait ex_wait;
	public static Wait<WebDriver> flu_wait;
//    public Actions action=new Actions(Driver);
//	public WebDriverWait ex_wait= new WebDriverWait(Driver,20);
//	public Wait<WebDriver> flu_wait= new FluentWait<WebDriver>(Driver)
//			.withTimeout(Duration.ofSeconds(30))
//			.pollingEvery(Duration.ofSeconds(4))
//			.withMessage("Testing fluent wait");
//		.ignoring(NoSuchElementException.class);

	public static Properties prop=new Properties();
	
	public CommonMethods() {
		if(Driver==null) {
			WebDriverManager.firefoxdriver().setup();
			Driver=new FirefoxDriver();
			Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
	
//	WebDriverManager.firefoxdriver().setup();
//	Driver=new FirefoxDriver();
		
//	TuleapLogin loginobj= new TuleapLogin();
//		loginobj.login();
//	NostBug bugobj= new NostBug();
//		bugobj.bugCreation();
		
//	NostLogin loginobj=new NostLogin();
//	loginobj.login();
	
//	AddProtocol obj2=new AddProtocol();
//	obj2.addProtocol();
//
//	AddPharmacy obj4=new AddPharmacy();
//	obj4.addPharmacy();
//	
//	AddSupplier obj5=new AddSupplier();
//	obj5.addSupplier();
//
//	AddCatalog obj1=new AddCatalog();
// 	obj1.addDrug();
//	
//	AddPatient obj3=new AddPatient();
//	obj3.addPatient();
		
//	Receive recobj=new Receive();
//	recobj.receiveLot();
	
//	Receive recobj1=new Receive();
//	recobj1.receiveUnit();
//	
//	Receive recobj2=new Receive();
//	recobj2.rec_SubmitQueue();
	
//	TransferToPharmacy transobj1=new TransferToPharmacy();
//	transobj1.transferLot();
	
//	TransferToPharmacy transobj2=new TransferToPharmacy();
//	transobj2.transferUnit();
	
	}

		public static void click(String locator,String locatortype) {
			
			if(locatortype=="xpath") {
				
				Driver.findElement(By.xpath(prop.getProperty(locator))).click();
				
			}else if(locatortype=="id") {
				
				Driver.findElement(By.id(prop.getProperty(locator))).click();
				
			}else if(locatortype=="name") {
				
				Driver.findElement(By.name(prop.getProperty(locator))).click();
				
			}else if(locatortype=="class") {
				
				Driver.findElement(By.className(prop.getProperty(locator))).click();
				
			}else if(locatortype=="csssele") {
				
				Driver.findElement(By.cssSelector(prop.getProperty(locator))).click();
				
			}else if(locatortype=="linktext") {
				
				Driver.findElement(By.linkText(prop.getProperty(locator))).click();
				
			} else if(locatortype=="partialtext") {
				
				Driver.findElement(By.partialLinkText(prop.getProperty(locator))).click();
				
			}
				
		}
		
	public static void type(String locator,String locatortype,String value) {
			
			if(locatortype=="xpath") {
				
				Driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(value);
				
			}else if(locatortype=="id") {
				
				Driver.findElement(By.id(prop.getProperty(locator))).sendKeys(value);
				
			}else if(locatortype=="name") {
				
				Driver.findElement(By.name(prop.getProperty(locator))).sendKeys(value);
				
			}else if(locatortype=="class") {
				
				Driver.findElement(By.className(prop.getProperty(locator))).sendKeys(value);
				
			}else if(locatortype=="csssele") {
				
				Driver.findElement(By.cssSelector(prop.getProperty(locator))).sendKeys(value);
				
			}else if(locatortype=="linktext") {
				
				Driver.findElement(By.linkText(prop.getProperty(locator))).sendKeys(value);
				
			} else if(locatortype=="partialtext") {
				
				Driver.findElement(By.partialLinkText(prop.getProperty(locator))).sendKeys(value);
				
			}
				
		}
	

	public static void check(String locator,String locatortype, String condition) {
		
		if(locatortype=="xpath") {
			
			WebElement c_xpath=Driver.findElement(By.xpath(prop.getProperty(locator)));
			
			System.out.println(c_xpath.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_xpath.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_xpath.click();
				
			}
			else if((condition.equalsIgnoreCase("No")) && (c_xpath.isSelected()==true))
			{
				
			System.out.println(" Condition is NO");
				
			System.out.println(" Checkbox is selected on load");

				c_xpath.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println("\n" + locator + "  is checked by default"); }
			
		}else if(locatortype=="id") {
			
			WebElement c_id=Driver.findElement(By.id(prop.getProperty(locator)));
			
			System.out.println(c_id.isSelected());
			
			System.out.println(" Condition is  "+ condition);
			
			if((condition.equalsIgnoreCase("Yes")) && (c_id.isSelected()==false)){
					
				System.out.println(" Condition is YES");
				
					System.out.println("Checkbox is not selected on Load");
					
				c_id.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else if((condition.equalsIgnoreCase("No")) && (c_id.isSelected()==true))
			{
				System.out.println(" Condition is NO");
				
				System.out.println(" Checkbox is selected on load");
				
				c_id.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "  is checked by default"); }
			
			
		}else if(locatortype=="name") {
			
			WebElement c_name=Driver.findElement(By.name(prop.getProperty(locator)));
			
			System.out.println(c_name.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_name.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_name.click();
				
				System.out.println(locator + "  is clicked");
			
			}
			else if((condition.equalsIgnoreCase("No")) && (c_name.isSelected()==true))
			{
				System.out.println(" Condition is NO");
				
				System.out.println(" Checkbox is selected on load");
				
				c_name.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "is checked by default"); }
			
			
		}else if(locatortype=="class") {
			
			WebElement c_class=Driver.findElement(By.className(prop.getProperty(locator)));
			
			System.out.println(c_class.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_class.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_class.click();
				
				System.out.println(locator + "  is clicked");
				
			}
			else if((condition.equalsIgnoreCase("No")) && (c_class.isSelected()==true))
			{
				System.out.println(" Condition is NO");
				
				System.out.println(" Checkbox is selected on load");
				
				c_class.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "  is checked by default"); }
			
			
		}else if(locatortype=="csssele") {
			
			WebElement c_csssele=Driver.findElement(By.cssSelector(prop.getProperty(locator)));
			
			System.out.println(c_csssele.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_csssele.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_csssele.click();
				
				System.out.println(locator + "  is clicked");
			}
			else if((condition.equalsIgnoreCase("No")) && (c_csssele.isSelected()==true))
			{
				
System.out.println(" Condition is NO");

				System.out.println(" Checkbox is selected on load");
				c_csssele.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "is checked by default"); }
			
			
		}else if(locatortype=="linktext") {
			
			WebElement c_linktext=Driver.findElement(By.linkText(prop.getProperty(locator)));
			
			System.out.println(c_linktext.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_linktext.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_linktext.click();
				
				System.out.println(locator + "   is checked by default");
			}
			else if((condition.equalsIgnoreCase("No")) && (c_linktext.isSelected()==true))
			{
				
				System.out.println(" Condition is NO");
				
				System.out.println(" Checkbox is selected on load");
				
				c_linktext.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "is checked by default"); }
			
			
		} else if(locatortype=="partialtext") {
			
			WebElement c_partialtext=Driver.findElement(By.partialLinkText(prop.getProperty(locator)));
			
			System.out.println(c_partialtext.isSelected());
			
			if((condition.equalsIgnoreCase("Yes")) && (c_partialtext.isSelected()==false)) {
				
				System.out.println(" Condition is YES");
				
				System.out.println("Checkbox is not selected on Load");
				
				c_partialtext.click();
				
				System.out.println(locator + "is checked by default");
			}
			else if((condition.equalsIgnoreCase("No")) && (c_partialtext.isSelected()==true))
			{	
				System.out.println(" Condition is NO");
				
				System.out.println(" Checkbox is selected on load");
				
				c_partialtext.click();
				
				System.out.println(locator + "  is clicked");
			}
			
			else { System.out.println(locator + "is checked by default"); }
			
		}
	}

	public static WebElement find_element(String locator,String locatortype) {
		
		System.out.println(" calling find element method...");
		
		WebElement findelement_out=null;
		
		System.out.println(prop.getProperty(locator));
		
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
		
		System.out.println(findelement_out);
		return findelement_out;
	}	

	//public List find_elements(String locator,String locatortype) {
	//	
//		System.out.println(" calling find element method...");
	//	
//		List findelement_out=null;
	//	
//		System.out.println(locator);
	//	
//		if(locatortype=="xpath") {
//			
//			List<WebElement> xpath_in=Driver.findElements(By.xpath(locator));
//			findelement_out=xpath_in;
//			
//		} else if(locatortype=="id") {
//			
//			List<WebElement> id_in=Driver.findElements(By.id(locator));
//			findelement_out=id_in;
//			
//		}else if(locatortype=="name") {
//			
//			List<WebElement> name_in=Driver.findElements(By.name(locator));
//			findelement_out=name_in;
//			
//		}else if(locatortype=="class") {
//			
//			List<WebElement> class_in=Driver.findElements(By.className(locator));
//			findelement_out=class_in;
//			
//		} else if(locatortype=="csssele") {
//			
//			List<WebElement> csssele_in=Driver.findElements(By.cssSelector(locator));
//			findelement_out=csssele_in;
//			
//		} else if(locatortype=="linktext") {
//			
//			List<WebElement> link_in=Driver.findElements(By.linkText(locator));
//			findelement_out=link_in;
//			
//		} else if(locatortype=="partiallink") {
//			
//			List<WebElement> partialtext_in=Driver.findElements(By.partialLinkText(locator));
//			findelement_out=partialtext_in;
//			
//		}
	//	
//		System.out.println(findelement_out);
//		return findelement_out;
	//}	

public static void selectText(String locator,String locatorType,String text) {
	
	WebElement selecttext=find_element(locator, locatorType);
	
	Select select =new Select(selecttext);
	select.selectByVisibleText(text);
	
}

public static void selectValue(String locator,String locatorType,String value) {
	
	WebElement selectvalue=find_element(locator, locatorType);	
	
	//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();", selectvalue);	 
	
	Select select =new Select(selectvalue);
	select.selectByValue(value);
	
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