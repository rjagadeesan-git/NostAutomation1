package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;

public class IDSUBAR_Flow {
	

	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostlogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);	
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Protocol prot=new Protocol();
		prot.addProtocol(data);
	}
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
	public void verifyAddProtocol() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5)
	public void verifyFacility() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5)
	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=6)
	public void verifyPlan() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=7)
	public void addCatalog(Hashtable<String,String> data) throws InterruptedException, IOException {
		Catalog drug=new Catalog();
		drug.addDrug(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8)
	public void verifyAddCatalog() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=9)
	public void addPatient(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Patient patient=new Patient();
		patient.addPatient(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=10)
	public void receive(Hashtable<String,String> data) {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=11)
	public void verifyReceive() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=12)
	public void addPayer() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=13)
	public void verifyPayer() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=14)
	public void createCDM() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=15)
	public void verifyCDM() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=16)
	public void dispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=17)
	public void verifyDispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=18)
	public void verifyReviewCharges() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=19)
	public void verifyServicedEntity() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=20)
	public void billing() {}
}
