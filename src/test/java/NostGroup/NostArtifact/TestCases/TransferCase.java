package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class TransferCase extends BrowserAct{
	
	@Test(priority=1)
	public void nostlogin() throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login();	
	}
	
	@Test(priority=2)
	public void transferGen() throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon();
	}
	
//	@Test(priority=3)
//	public void transferLot() throws IOException, InterruptedException, AWTException {
//		
//		TransferToPharmacy translot=new TransferToPharmacy();
//		translot.transferLot();
//	}
	
//	@Test(priority=4)
//	public void transferUnit() throws IOException, InterruptedException, AWTException {
//		
//		TransferToPharmacy transunit=new TransferToPharmacy();
//		transunit.transferUnit();
//	}
	
}
