package NostGroup.NostArtifact.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserAct{

	public String browsertype;
   
	@BeforeSuite
	public void browserLaunch() throws IOException {
		
//		WebDriverManager.firefoxdriver().setup();
//		CommonMethods.Driver=new FirefoxDriver();
		System.out.println(" Loading the BeforeSuite method ");
		browserSetup();
		CommonMethods.Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Supplies\\locators.properties");
//		CommonMethods.prop.load(propin);
		CommonMethods.log=Logger.getLogger(BrowserAct.class.getName());
		PropertyConfigurator.configure("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Supplies\\log4j.properties");
		CommonMethods.action=new Actions(CommonMethods.Driver);
		CommonMethods.ex_wait= new WebDriverWait(CommonMethods.Driver,20);
		CommonMethods.flu_wait= new FluentWait<WebDriver>(CommonMethods.Driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(4))
				.withMessage("Testing fluent wait");
		//	.ignoring(NoSuchElementException.class);
		
	}
	
	public void browserSetup() throws IOException {
		
		System.out.println("Starting Browser setup ");
		
		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Supplies\\locators.properties");
		CommonMethods.prop.load(propin);
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			
			browsertype=System.getenv("browser");
		} else {
			
			browsertype=CommonMethods.prop.getProperty("browser");
		}
		
		CommonMethods.prop.setProperty("browser", browsertype);
		
		if(CommonMethods.prop.getProperty("browser").contentEquals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			CommonMethods.Driver=new FirefoxDriver();
			System.out.println("Firefox browser is set");
			
		}else if(CommonMethods.prop.getProperty("browser").contentEquals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			CommonMethods.Driver=new ChromeDriver();
			System.out.println("Chrome browser is set");
		}else if(CommonMethods.prop.getProperty("browser").contentEquals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			CommonMethods.Driver=new EdgeDriver();
			System.out.println("Edge browser is set");
		}
		
		System.out.println("Ending Browser setup ");
	}

		
	
	public void browserQuit() {
		
		CommonMethods.Driver.quit();
	}
	

}