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

public class TransferCase extends BrowserAct{
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostlogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);	
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void transferGen(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon(data);
	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
//	public void transferLot(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		
//		TransferToPharmacy translot=new TransferToPharmacy();
//		translot.transferLot(data);
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
//	public void transferUnit(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		
//		TransferToPharmacy transunit=new TransferToPharmacy();
//		transunit.transferUnit(data);
//	}
	
}
