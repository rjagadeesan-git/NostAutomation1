package NostGroup.NostArtifact.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import NostGroup.NostArtifact.Base.BrowserAct;
import NostGroup.NostArtifact.Base.CellDataProvider;
import NostGroup.NostArtifact.Base.NostLogin;
import NostGroup.NostArtifact.Dispense.Dispense;
import NostGroup.NostArtifact.Manage.Protocol;

public class DispenseCase extends BrowserAct{
	
@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	NostLogin login=new NostLogin();
	login.nost_Login(data);
}


//@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2,dependsOnMethods="nostLogin")
//public void addDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
//	Dispense disp=new Dispense();
//	disp.dispPatientSearch(data);
//}


@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=2,dependsOnMethods="nostLogin")
public void saveQueueDispense(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	Dispense disp=new Dispense();
	disp.dispSaveQueue(data);
}

}
