package NostGroup.NostArtifact.Base;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentedReports {
	
	private static ExtentReports extent;
	
	public static ExtentReports getObj() {
		
		if(extent==null) {
			
			extent=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			 extent.loadConfig(new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentConfig.xml"));
		}
		return extent;
			
	}

}
