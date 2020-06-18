package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Dispense.Dispense;
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class AllTest extends BrowserAct{
	
//	################################## Nost Login #########################################
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	
//	################################## Maintenance #########################################
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Protocol prot=new Protocol();
		prot.addProtocol(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier(data);
	}
	
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5)
	public void addCatalog(Hashtable<String,String> data) throws InterruptedException, IOException {
		Catalog drug=new Catalog();
		drug.addDrug(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=6)
	public void addPatient(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Patient patient=new Patient();
		patient.addPatient(data);
	}

//  ################################## Receive #########################################
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void commonReceive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Receive rec=new Receive();
		rec.receiveCommon(data);
		rec.receiveSubmitQueue(data);
//		rec.rec_SubmitQueueAlone();
	}

//	################################## Transfer #########################################
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void commonTransfer(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon(data);
	}
	
	
//	################################## Dispense #########################################
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void patientSearchDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	Dispense disp=new Dispense();
	disp.dispPatientSearch();
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void saveQueueDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	Dispense disp=new Dispense();
	disp.dispSaveQueue();
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void submitDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispSubmit();
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void LabelGeneDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispGenLabel();
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void editSubmitDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispEditSubmit();
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void reprintLabelDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		Dispense disp=new Dispense();
		disp.dispReprintLabel();
	}
	
	
//	################################## Patient returns #########################################
	
	
	
//	################################## Destroy #########################################
	
//	################################## Return to Supplier #########################################
	
//	################################## Monitor #########################################
	
//	################################## Adjust modules #########################################

//	################################## Edit Inventory #########################################
	
//	################################## Drug. Acc Reports #########################################
	
//	################################## Drug Dispensing Report #########################################
	
//	################################## CDM #########################################
	
//	################################## CPP #########################################
	
//	################################## Service Master #########################################
	
//	################################## Review Charges #########################################
	
//	################################## Create Bills #########################################
	
//	################################## User #########################################
	
//	################################## Groups #########################################
	

	
}
