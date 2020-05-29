package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class IDSFlow_R_PR {
	
	@Test(priority=1)
	public void nostlogin() throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login();	
	}
	

	@Test(priority=2)
	public void receive() throws IOException, InterruptedException, AWTException {
		
		Receive rec=new Receive();
		rec.receiveCommon();
		rec.rec_SubmitQueue();
	}
	
	@Test(priority=3)
	public void verifyReceive() {}
	
	@Test(priority=4)
	public void transfertoPharm() throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon();
	}
	
	@Test(priority=4)
	public void verifyTranstoPharm() {}
	
	@Test(priority=5)
	public void dispense() {}
	
	@Test(priority=6)
	public void verifyDispense() {}
	
	@Test(priority=7)
	public void patReturn() {}
	
	@Test(priority=8)
	public void verifyPatReturn() {}

}
