package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Base.UBARLogin;
import NostGroup.NostArtifact.Billing.CPP;
import NostGroup.NostArtifact.Billing.Facility;
import NostGroup.NostArtifact.Billing.ReviewCharges;
import NostGroup.NostArtifact.Billing.ServiceMaster;
import NostGroup.NostArtifact.Billing.ServicedEntity;
import NostGroup.NostArtifact.Dispense.Dispense;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class UbarloginCase extends BrowserAct{
	
// Nost Login
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	
// Add Protocol
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2,dependsOnMethods= {"nostLogin"})
	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Protocol prot=new Protocol();
		prot.addProtocol(data);
	}
	
	// Add Pharmacy
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3,dependsOnMethods= {"nostLogin"})
	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4,dependsOnMethods= {"nostLogin"})
	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier(data);
	}
	
// Add Catalog
	
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
	
// Verify Service in ServiceMaster
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8,dependsOnMethods= {"addCatalog"})
	public void ubarLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		UBARLogin login=new UBARLogin();
		login.ubarLogin(data);
	}

	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=9,dependsOnMethods= {"addCatalog"})
	public void verifyServiceMaster(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		ServiceMaster servicemas=new ServiceMaster();
		servicemas.serviceMasterVerification(data);
	}	
	
// Verify Facility
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=9,dependsOnMethods={"ubarLogin","addPharmacy"})
	public void verifyFacility(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Facility facility=new Facility();
		facility.facilityVerify(data);
	}
	
// Verify CPP, Add Payer, Add CDM
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=10,dependsOnMethods= {"verifyServiceMaster"})
	public void verifyCPP(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		CPP cpp=new CPP();
		cpp.cppAdd(data);
	}
	
// Dispense for Patient in IDS

	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=11,dependsOnMethods= {"verifyCPP"})
	public void nostLogin2(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}

	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=12,dependsOnMethods= {"verifyCPP"})
	public void addDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispPatientSearch(data);
	}
	
	
// Verify Patient in ServicedEntity
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=13,dependsOnMethods= {"addDispense"})
	public void ubarLogin2(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		UBARLogin login=new UBARLogin();
		login.ubarLogin(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=14,dependsOnMethods= {"addPatient","addDispense"})
	public void verifyServicedEntity(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		ServicedEntity servicedent=new ServicedEntity();
		servicedent.servicedEntityVerify(data);
		
	}
	
// Verify review charges, change billing status
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=15,dependsOnMethods= {"addDispense"})
	public void verifyReviewCharges(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		ReviewCharges reviewcharges=new ReviewCharges();
		reviewcharges.reviewChargesVerification(data);
	
	}


//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//public void verifyDisassociateServiceMaster(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//	ServiceMaster servicemas=new ServiceMaster();
//	servicemas.serviceMasterRemovalVerification(data);
//	
//}


	}

