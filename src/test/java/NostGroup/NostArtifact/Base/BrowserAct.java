package NostGroup.NostArtifact.Base;

import java.io.FileInputStream;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserAct{

   
	@BeforeSuite
	public void browserLaunch() throws IOException {
		
		WebDriverManager.firefoxdriver().setup();
		CommonMethods.Driver=new FirefoxDriver();
		CommonMethods.Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Supplies\\locators.properties");
		CommonMethods.prop.load(propin);
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
	
	public void browserQuit() {
		
		CommonMethods.Driver.quit();
	}
	

}