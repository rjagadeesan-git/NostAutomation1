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

public class NostloginCase extends BrowserAct{
	
public static SpreadSheetHelper helper=null;
	
@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
	NostLogin login=new NostLogin();
	login.nost_Login(data);
}
	}

