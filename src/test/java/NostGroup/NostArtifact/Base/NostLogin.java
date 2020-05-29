package NostGroup.NostArtifact.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NostLogin extends CommonMethods{
	
//	public NostLogin(String filepath) throws IOException {
//		super(filepath);
//	
//	}
	public void nost_Login() throws IOException {
		
//		WebDriverManager.firefoxdriver().setup();
//		Driver=new FirefoxDriver();
//		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Otherfiles\\locators.properties");
//		prop.load(propin);
		
	System.out.println(prop.getProperty("url"));
	Driver.get(prop.getProperty("url"));
    System.out.println(Driver.getTitle());
    System.out.println("Starting to Login...");

    type("username","xpath",readExcel("NostData",3,1));
    type("password","xpath",readExcel("NostData",3,2));
    click("login-button","xpath");
	
	}

}
