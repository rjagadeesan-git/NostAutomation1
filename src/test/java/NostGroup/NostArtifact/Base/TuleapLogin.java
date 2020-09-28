package NostGroup.NostArtifact.Base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

public class TuleapLogin extends CommonMethods{
	
	public void login(Hashtable<String,String> data) throws IOException, InterruptedException {
		
						
			System.out.println(prop.getProperty("tuleap_url"));

			Driver.get(prop.getProperty("tuleap_url"));		
		    Driver.manage().window().maximize();
		    System.out.println(Driver.getTitle());
			
		   // Dimension dim=new Dimension(1000,600);
		    
		    //Driver.manage().window().setSize(dim);
			
		    System.out.println("Starting Login...");
			
		    type("tuleap-username","csssele",data.get("UserName"));
			type("tuleap-password","csssele",data.get("PassWord"));
			click("tuleap-login-button","csssele");
			
			Driver.get(prop.getProperty("tuleap_url1"));
			
			System.out.println("Login successful....");
			Thread.sleep(3000);
			
			}


}
