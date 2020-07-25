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
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;

public class NostloginCase extends BrowserAct{
	
@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	NostLogin login=new NostLogin();
	login.nost_Login(data);
}

//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//public void verifyCatalog(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
//	Catalog drug=new Catalog();
//	drug.catalogVerify(data);
//
//	}

//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//public void verifyProtocol(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
//	Protocol prot=new Protocol();
//	prot.protocolVerify(data);
//
//	}


//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//public void verifyPharmacy(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
//	Pharmacy pharm=new Pharmacy();
//	pharm.pharmacyVerifyTable(data);
//
//	}

//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//public void verifyPatient(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
//	Patient pat=new Patient();
//	pat.patientVerifyTable(data);
//
//	}

@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
public void verifySupplier(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException {
	Supplier supp=new Supplier();
	supp.supplierVerifyTable(data);

	}

}