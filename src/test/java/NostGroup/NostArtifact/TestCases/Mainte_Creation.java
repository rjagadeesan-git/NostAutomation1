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

public class Mainte_Creation extends BrowserAct{
	
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
	public void addPharmacy() throws IOException, InterruptedException, AWTException {
		Pharmacy pharm=new Pharmacy();
		pharm.addPharmacy();
	}
	
	@Test(priority=4)
	public void addSupplier() throws IOException, InterruptedException {
		Supplier supp=new Supplier();
		supp.addSupplier();
	}
	
	@Test(priority=5)
	public void addCatalog() throws InterruptedException, IOException {
		Catalog drug=new Catalog();
		drug.addDrug();
	}
	
	@Test(priority=6)
	public void addPatient() throws IOException, InterruptedException, AWTException {
		Patient patient=new Patient();
		patient.addPatient();
	}

}
