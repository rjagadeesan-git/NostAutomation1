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

public class IDSUBAR_Flow {
	

	@Test(priority=1)
	public void nostlogin() throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login();	
	}
	
	@Test(priority=2)
	public void addProtocol() throws IOException, InterruptedException, AWTException {
		Protocol prot=new Protocol();
		prot.addProtocol();
	}
	@Test(priority=3)
	public void verifyAddProtocol() {}
	
	@Test(priority=4)
	public void addPharmacy() throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy();
	}
	
	@Test(priority=5)
	public void verifyFacility() {}
	
	@Test(priority=5)
	public void addSupplier() throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier();
	}
	
	@Test(priority=6)
	public void verifyPlan() {}
	
	@Test(priority=7)
	public void addCatalog() throws InterruptedException, IOException {
		Catalog drug=new Catalog();
		drug.addDrug();
	}
	@Test(priority=8)
	public void verifyAddCatalog() {}
	
	@Test(priority=9)
	public void addPatient() throws IOException, InterruptedException, AWTException {
		Patient patient=new Patient();
		patient.addPatient();
	}
	
	@Test(priority=10)
	public void receive() {}
	
	@Test(priority=11)
	public void verifyReceive() {}
	
	@Test(priority=12)
	public void addPayer() {}
	
	@Test(priority=13)
	public void verifyPayer() {}
	
	@Test(priority=14)
	public void createCDM() {}
	
	@Test(priority=15)
	public void verifyCDM() {}
	
	@Test(priority=16)
	public void dispense() {}
	
	@Test(priority=17)
	public void verifyDispense() {}
	
	@Test(priority=18)
	public void verifyReviewCharges() {}
	
	@Test(priority=19)
	public void verifyServicedEntity() {}
	
	@Test(priority=20)
	public void billing() {}
}
