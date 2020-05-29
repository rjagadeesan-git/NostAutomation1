package NostGroup.NostArtifact.Base;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriverMethods extends BrowserInit1{
		
	public void click(String locator,String locatortype) {
		
		if(locator=="xpath") {
			
			Driver.findElement(By.xpath(locator)).click();
			
		}else if(locator=="id") {
			
			Driver.findElement(By.id(locator)).click();
			
		}else if(locator=="name") {
			
			Driver.findElement(By.name(locator)).click();
			
		}else if(locator=="class") {
			
			Driver.findElement(By.className(locator)).click();
			
		}else if(locator=="csssele") {
			
			Driver.findElement(By.cssSelector(locator)).click();
			
		}else if(locator=="linktext") {
			
			Driver.findElement(By.linkText(locator)).click();
			
		} else if(locator=="partialtext") {
			
			Driver.findElement(By.partialLinkText(locator)).click();
			
		}
			
	}
	

public void type(String locator,String locatortype,String value) {
		
		if(locator=="xpath") {
			
			Driver.findElement(By.xpath(locator)).sendKeys(value);
			
		}else if(locator=="id") {
			
			Driver.findElement(By.id(locator)).sendKeys(value);
			
		}else if(locator=="name") {
			
			Driver.findElement(By.name(locator)).sendKeys(value);
			
		}else if(locator=="class") {
			
			Driver.findElement(By.className(locator)).sendKeys(value);
			
		}else if(locator=="csssele") {
			
			Driver.findElement(By.cssSelector(locator)).sendKeys(value);
			
		}else if(locator=="linktext") {
			
			Driver.findElement(By.linkText(locator)).sendKeys(value);
			
		} else if(locator=="partialtext") {
			
			Driver.findElement(By.partialLinkText(locator)).sendKeys(value);
			
		}
			
	}

public WebElement find_element(String locator,String locatortype) {
	
	System.out.println(" calling find element method...");
	
	WebElement findelement_out=null;
	
	System.out.println(locator);
	
	if(locatortype=="xpath") {
		
		WebElement xpath_in=Driver.findElement(By.xpath(locator));
		findelement_out=xpath_in;
		
	} else if(locatortype=="id") {
		
		WebElement id_in=Driver.findElement(By.id(locator));
		findelement_out=id_in;
		
	}else if(locatortype=="name") {
		
		WebElement name_in=Driver.findElement(By.name(locator));
		findelement_out=name_in;
		
	}else if(locatortype=="class") {
		
		WebElement class_in=Driver.findElement(By.className(locator));
		findelement_out=class_in;
		
	} else if(locatortype=="csssele") {
		
		WebElement csssele_in=Driver.findElement(By.cssSelector(locator));
		findelement_out=csssele_in;
		
	} else if(locatortype=="linktext") {
		
		WebElement link_in=Driver.findElement(By.linkText(locator));
		findelement_out=link_in;
		
	} else if(locatortype=="partiallink") {
		
		WebElement partialtext_in=Driver.findElement(By.partialLinkText(locator));
		findelement_out=partialtext_in;
		
	}
	
	System.out.println(findelement_out);
	return findelement_out;
}	

//public List find_elements(String locator,String locatortype) {
//	
//	System.out.println(" calling find element method...");
//	
//	List findelement_out=null;
//	
//	System.out.println(locator);
//	
//	if(locatortype=="xpath") {
//		
//		List<WebElement> xpath_in=Driver.findElements(By.xpath(locator));
//		findelement_out=xpath_in;
//		
//	} else if(locatortype=="id") {
//		
//		List<WebElement> id_in=Driver.findElements(By.id(locator));
//		findelement_out=id_in;
//		
//	}else if(locatortype=="name") {
//		
//		List<WebElement> name_in=Driver.findElements(By.name(locator));
//		findelement_out=name_in;
//		
//	}else if(locatortype=="class") {
//		
//		List<WebElement> class_in=Driver.findElements(By.className(locator));
//		findelement_out=class_in;
//		
//	} else if(locatortype=="csssele") {
//		
//		List<WebElement> csssele_in=Driver.findElements(By.cssSelector(locator));
//		findelement_out=csssele_in;
//		
//	} else if(locatortype=="linktext") {
//		
//		List<WebElement> link_in=Driver.findElements(By.linkText(locator));
//		findelement_out=link_in;
//		
//	} else if(locatortype=="partiallink") {
//		
//		List<WebElement> partialtext_in=Driver.findElements(By.partialLinkText(locator));
//		findelement_out=partialtext_in;
//		
//	}
//	
//	System.out.println(findelement_out);
//	return findelement_out;
//}	

	
}
