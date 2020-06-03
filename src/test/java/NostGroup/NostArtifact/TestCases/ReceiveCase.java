package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;

public class ReceiveCase extends BrowserAct{
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void commonReceive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Receive rec=new Receive();
		rec.receiveCommon(data);
		rec.receiveSubmitQueue(data);
//		rec.rec_SubmitQueueAlone();
	}
}
