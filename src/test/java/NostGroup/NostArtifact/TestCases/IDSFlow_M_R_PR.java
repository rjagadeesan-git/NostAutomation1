package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Base.SpreadSheetHelper;
import NostGroup.NostArtifact.Dispense.Dispense;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class IDSFlow_M_R_PR extends BrowserAct{
	
	public static SpreadSheetHelper helper=null;
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2,dependsOnMethods="nostLogin")
	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Protocol prot=new Protocol();
		prot.addProtocol(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3,dependsOnMethods= {"addProtocol"})
	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4,dependsOnMethods= {"addProtocol"})
	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5,dependsOnMethods= {"addProtocol"})
	public void addCatalog(Hashtable<String,String> data) throws InterruptedException, IOException {
		Catalog drug=new Catalog();
		drug.addDrug(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=6,dependsOnMethods= {"addProtocol","addCatalog"})
	public void addPatient(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Patient patient=new Patient();
		patient.addPatient(data);
	} 
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=7,dependsOnMethods= {"addProtocol"})
	public void commonReceive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		Receive rec=new Receive();
		rec.receiveCommon(data);
		
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=7,dependsOnMethods= {"commonReceive"})
	public void submitqueueReceive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		Receive rec=new Receive();
		rec.receiveSubmitQueue(data);
	}
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8)
//	public void verifyReceive() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8,dependsOnMethods= {"commonReceive"})
	public void commonTransferToPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon(data);
	}
	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=10)
//	public void verifyTranstoPharm() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=10,dependsOnMethods= {"commonTransferToPharmacy"})
	public void addDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispPatientSearch(data);
	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=12)
//	public void verifyDispense() {}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=13)
//	public void patReturn() {}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=14)
//	public void verifyPatReturn() {}
		
	}
}
