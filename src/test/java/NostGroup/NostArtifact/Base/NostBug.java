package NostGroup.NostArtifact.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NostBug extends CommonMethods{
	
	public void bugCreation(Hashtable<String,String> data) throws InterruptedException, AWTException{
		
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		click("menu-projects","csssele");
		click("menu-nostradamus","linktext");
		click("standard-bugs","csssele");
		click("create-a-bug","csssele");
		
		//((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("manage-menu","xpath"));
		Robot robo1=new Robot();
		robo1.keyPress(KeyEvent.VK_CONTROL);
		robo1.keyPress(KeyEvent.VK_MINUS);
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_MINUS);
		robo1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robo1.keyPress(KeyEvent.VK_MINUS);
		robo1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		
		type("bug-title","csssele",data.get("Title"));
		type("bug-summary","csssele",data.get("Summary"));
		((JavascriptExecutor)Driver).executeScript("arguments[0].scrollIntoView();",find_element("bug-product","csssele"));
		Thread.sleep(2000);
		selectText("bug-product","csssele",data.get("Product"));
		//ex_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(prop.getProperty("bug-product"))));
		//selectValue("bug-product","csssele","45016");
		//selectText("bug-client","csssele","None");
		selectText("bug-module","csssele",data.get("Module"));
		selectText("bug-version","csssele",data.get("Version"));
		selectText("bug-category","csssele",data.get("Category"));
		selectText("bug-issue-type","csssele",data.get("Type"));
		selectText("bug-severity","csssele",data.get("Severity"));
		selectText("bug-priority","csssele",data.get("Priority"));
		selectText("bug-assigned-to","csssele",data.get("Assigned_to"));
		//click("bug-submit","csssele");
		
	}

}
