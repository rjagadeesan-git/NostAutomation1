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
import NostGroup.NostArtifact.Monitor.Monitor;
import NostGroup.NostArtifact.PatientReturns.PatientReturns;
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.Destroy;
import NostGroup.NostArtifact.Transfer.ReturnToSupplier;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class AllTest extends BrowserAct{
	
//	NostLogin login=new NostLogin();
//	Protocol prot=new Protocol();
//	Pharmacy pharm=new Pharmacy();
//	Supplier supp=new Supplier();
//	Catalog drug=new Catalog();
//	Patient patient=new Patient();
//	Receive rec=new Receive();
//	TransferToPharmacy transGen=new TransferToPharmacy();
//	Dispense disp=new Dispense();
//	PatientReturns patret= new PatientReturns();
//	Destroy destroy=new Destroy();
//	ReturnToSupplier retsupp=new ReturnToSupplier();
//	Monitor monitor=new Monitor();
//	
//	
//	
////	################################## Nost Login #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
//	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		login.nost_Login(data);
//	}
//	
////	################################## Maintenance #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void addProtocol(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		prot.addProtocol(data);
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
//	public void addPharmacy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		pharm.addPharmacy(data);
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=4)
//	public void addSupplier(Hashtable<String,String> data) throws IOException, InterruptedException {
//		supp.addSupplier(data);
//	}
//	
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=5)
//	public void addCatalog(Hashtable<String,String> data) throws InterruptedException, IOException {
//		drug.addDrug(data);
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=6)
//	public void addPatient(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		patient.addPatient(data);
//	}
//
////  ################################## Receive #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void commonReceive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		rec.receiveCommon(data);
//		rec.receiveSubmitQueue(data);
////		rec.rec_SubmitQueueAlone();
//	}
//
////	################################## Transfer #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void commonTransfer(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		transGen.transferCommon(data);
//	}
//	
//	
////	################################## Dispense #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void patientSearchDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//	disp.dispPatientSearch();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void saveQueueDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//	disp.dispSaveQueue();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void submitDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		disp.dispSubmit();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void LabelGeneDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		disp.dispGenLabel();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void editSubmitDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		disp.dispEditSubmit();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void reprintLabelDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		disp.dispReprintLabel();
//	}
//	
//	
////	################################## Patient returns #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void addPatientReturns(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		patret.patReturnsAdd();
//	}
//	
//	
////	################################## Destroy #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void addDestroy(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		destroy.destroyAdd();
//	}
//	
////	################################## Return to Supplier #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void addPatReturn(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		retsupp.returnSupplierAdd();
//	}
//	
////	################################## Monitor #########################################
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void addMonitor(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		monitor.monitorAdd();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void downloadReportsMonitor(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		monitor.monitorDownloadReports();
//	}
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void verifyTransMonitor(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		monitor.monitorVerifyTrans();
//	}
//	
////	################################## Adjust modules #########################################
//
////	################################## Edit Inventory #########################################
//	
////	################################## Drug. Acc Reports #########################################
//	
////	################################## Drug Dispensing Report #########################################
//	
////	################################## CDM #########################################
//	
////	################################## CPP #########################################
//	
////	################################## Service Master #########################################
//	
////	################################## Review Charges #########################################
//	
////	################################## Create Bills #########################################
//	
////	################################## User #########################################
//	
////	################################## Groups #########################################
//	
	
}
