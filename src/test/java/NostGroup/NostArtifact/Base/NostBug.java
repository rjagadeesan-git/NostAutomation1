package NostGroup.NostArtifact.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NostBug extends TuleapLogin{
	
	public void bugCreation() throws InterruptedException{
		
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		click("menu-projects","csssele");
		click("menu-nostradamus","linktext");
		click("standard-bugs","csssele");
		click("create-a-bug","csssele");
		
		
		type("bug-title","csssele","Testing  Bug creation");
		type("bug-summary","csssele","This is to test the bug creation failure issue");
		((JavascriptExecutor)Driver).executeScript("window.scrollBy(395,15)");
		selectText("bug-product","csssele","Nostradamus");
		//ex_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(prop.getProperty("bug-product"))));
		//selectValue("bug-product","csssele","45016");
		selectText("bug-client","csssele","None");
		selectText("bug-module","csssele","Adjustment");
		selectText("bug-version","csssele","2.3");
		selectText("bug-category","csssele","Usability");
		selectText("bug-issue-type","csssele","GUI");
		selectText("bug-severity","csssele","Minor");
		selectText("bug-priority","csssele","P1-Low");
		selectText("bug-assigned-to","csssele","R Jagadeesan (rjagadeesan)");
		//click("bug-submit","csssele");
		

	}

}
