package NostGroup.NostArtifact.Base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

public class TuleapLogin extends BrowserInit1{
	
	public void login() throws IOException {
		
		ReadSpreadSheet excelobj= new ReadSpreadSheet("D:\\Jagan\\Drug_Accountability_Report(5).xlsx");
		
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		FileInputStream propin= new FileInputStream("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\src\\test\\java\\Otherfiles\\locators.properties");
		prop.load(propin);
				
			System.out.println(prop.getProperty("tuleap_url"));

			Driver.get(prop.getProperty("tuleap_url"));		
		    Driver.manage().window().maximize();
		    System.out.println(Driver.getTitle());
			
		   // Dimension dim=new Dimension(1000,600);
		    
		    //Driver.manage().window().setSize(dim);
			
		    System.out.println("Starting Login...");
			
		    type("tuleap-username","csssele",excelobj.getData("login_info",1,0));
			type("tuleap-password","csssele",excelobj.getData("login_info",1,1));
			click("tuleap-login-button","csssele");
			
			Driver.get(prop.getProperty("tuleap_url1"));
			
			System.out.println("Login successful....");
			
			}


}
