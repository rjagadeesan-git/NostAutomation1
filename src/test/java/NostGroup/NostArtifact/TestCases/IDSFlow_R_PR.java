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
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class IDSFlow_R_PR extends BrowserAct{
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	

	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void receive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {	
		Receive rec=new Receive();
		rec.receiveCommon(data);
		rec.receiveSubmitQueue(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
	public void verifyReceive() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
	public void transfertoPharm(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
	public void verifyTranstoPharm() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5)
	public void dispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=6)
	public void verifyDispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=7)
	public void patReturn() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8)
	public void verifyPatReturn() {}

}
