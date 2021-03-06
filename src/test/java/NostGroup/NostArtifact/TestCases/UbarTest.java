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
import NostGroup.NostArtifact.Manage.Catalog;
import NostGroup.NostArtifact.Manage.Patient;
import NostGroup.NostArtifact.Manage.Pharmacy;
import NostGroup.NostArtifact.Manage.Protocol;
import NostGroup.NostArtifact.Manage.Supplier;

public class UbarTest extends BrowserAct{
	
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void ubarLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		UBARLogin login=new UBARLogin();
		login.ubarLogin(data);
	}
	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
//	public void verifyServiceMaster(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		ServiceMaster servicemas=new ServiceMaster();
//		servicemas.serviceMasterVerification(data);
//	}
//	
//// Verify CPP, Add Payer, Add CDM
//	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
//	public void verifyCPP(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		CPP cpp=new CPP();
//		cpp.cppAdd(data);
//	}
	
	//Verify Facility
	
//	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=3)
//	public void verifyFacility(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//		Facility facility=new Facility();
//		facility.facilityVerify(data);
//	}
//	
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2)
	public void verifyReviewCharges(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		ReviewCharges reviewcharges=new ReviewCharges();
		reviewcharges.reviewChargesVerification(data);
	
	}
	
}

