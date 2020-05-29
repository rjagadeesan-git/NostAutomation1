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

public class ReceiveCase extends BrowserAct{
	
	@Test(priority=1)
	public void nostlogin() throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login();	
	}
	
	@Test(priority=2)
	public void receiveCommon() throws IOException, InterruptedException, AWTException {
		
		Receive rec=new Receive();
		rec.receiveCommon();
		rec.rec_SubmitQueue();
//		rec.rec_SubmitQueueAlone();
	}
}
