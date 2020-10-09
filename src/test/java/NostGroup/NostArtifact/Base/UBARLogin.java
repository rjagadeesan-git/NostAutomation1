package NostGroup.NostArtifact.Base;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UBARLogin extends CommonMethods{
	
	//public static SpreadSheetHelper helper=null;
	
//	public NostLogin(String filepath) throws IOException {
//		super(filepath);
//	
//	}
	
	String app_url_billing;

	public void ubarLogin(Hashtable<String,String> data) throws IOException, AWTException, InterruptedException {
		
//		WebDriverManager.firefoxdriver().setup();
//		Driver=new FirefoxDriver();
//		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Otherfiles\\locators.properties");
//		prop.load(propin);
		
		System.out.println("AUT_URL_Billing is "+ System.getenv("AUT_URL_Billing"));
		if(System.getenv("AUT_URL_Billing")!=null && !System.getenv("AUT_URL_Billing").isEmpty()) {
			
			app_url_billing=System.getenv("AUT_URL_Billing");
			System.out.println("AUT_URL_Billing is "+app_url_billing);
			
		}else {
			
			app_url_billing=CommonMethods.prop.getProperty("siteurl-billing");
			System.out.println("Default Site-URL is "+app_url_billing);
		}
		
		CommonMethods.prop.setProperty("siteurl-billing",app_url_billing);
		
//		System.out.println(prop.getProperty("url-billing"));
//		log.info(prop.getProperty("url-billing"));
//		Driver.get(prop.getProperty("siteurl-billing"));
		Driver.get("siteurl-billing");
	    System.out.println(Driver.getTitle());
	    
		if(!data.get("rundata").equalsIgnoreCase("Y")) {
			
			extest.log(LogStatus.SKIP, "Skipping this Row Data since 'rundata' marked as 'No'");
			//Reporter.log("Skipping the Data since marked rundata as 'No'");
			throw new SkipException("Skipping this Row Data since 'rundata' marked as 'No'");
		}
		
    System.out.println("Login Billing starts...");
    extest.log(LogStatus.INFO,"Login Billing starts");
    log.info("Login Billing starts...");
    Reporter.log("Login Billing starts....");
    type("username-billing","id",data.get("UserName"));
    System.out.println("Entering Password....");
    type("password-billing","id",data.get("PassWord"));
    click("login-button-billing","csssele");
    log.info("logged in successfully...");
    System.out.println("logged in successfully...");
    
    Robot robo1=new Robot();
	Thread.sleep(2000);
//	robo1.keyPress(KeyEvent.VK_CONTROL);
//	robo1.keyPress(KeyEvent.VK_MINUS);
//	Thread.sleep(2000);
//	robo1.keyPress(KeyEvent.VK_MINUS);
//	robo1.keyRelease(KeyEvent.VK_CONTROL);
//	Thread.sleep(2000);
//    Reporter.log("logged in successfully...");
    //Assert.fail("Failing for Sake");
    
	}
}
