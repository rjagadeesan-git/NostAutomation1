package NostGroup.NostArtifact.Base;

import static org.testng.Assert.fail;

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

public class NostLogin extends CommonMethods{
	
	//public static SpreadSheetHelper helper=null;
	
//	public NostLogin(String filepath) throws IOException {
//		super(filepath);
//	
//	}
	
	String app_url;

	public void nost_Login(Hashtable<String,String> data) throws IOException {
		
//		WebDriverManager.firefoxdriver().setup();
//		Driver=new FirefoxDriver();
//		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Otherfiles\\locators.properties");
//		prop.load(propin);
		System.out.println("AUT_URL is "+ System.getenv("AUT_URL"));
			if(System.getenv("AUT_URL")!=null && !System.getenv("AUT_URL").isEmpty()) {
				
				app_url=System.getenv("AUT_URL");
				System.out.println("AUT_URL is "+app_url);
				
			}else {
				
				app_url=CommonMethods.prop.getProperty("siteurl");
				System.out.println("Default Site-URL is "+app_url);
			}
			
			CommonMethods.prop.setProperty("siteurl",app_url);
			
	    System.out.println(Driver.getTitle());
	    
		if(!data.get("rundata").equalsIgnoreCase("Y")) {
			
			extest.log(LogStatus.SKIP, "Skipping this Row Data since 'rundata' marked as 'No'");
			//Reporter.log("Skipping the Data since marked rundata as 'No'");
			throw new SkipException("Skipping this Row Data since 'rundata' marked as 'No'");
		
		}
		
    System.out.println("Starting to Login...");
    log.info("Starting to Login...");
    Reporter.log("Starting to Login....");
    type("username","xpath",data.get("UserName"));
    System.out.println("Entering Password....");
    type("password","xpath",data.get("PassWord"));
    click("login-button","xpath");
log.info("logged in successfully...");
System.out.println("logged in successfully...");

//    Reporter.log("logged in successfully...");
    //Assert.fail("Failing for Sake");
    
	}
}
