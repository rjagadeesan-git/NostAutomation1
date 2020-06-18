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
import NostGroup.NostArtifact.Receive.Receive;
import NostGroup.NostArtifact.Transfer.TransferToPharmacy;

public class IDSFlow_M_R_PR extends BrowserAct{
	
	public static SpreadSheetHelper helper=null;
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=1)
	public void nostLogin(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		NostLogin login=new NostLogin();
		login.nost_Login(data);
	}
	
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
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=7)
	public void receive(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		Receive rec=new Receive();
		rec.receiveCommon(data);
		rec.receiveSubmitQueue(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=8)
	public void verifyReceive() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=9)
	public void transfertoPharm(Hashtable<String,String> data) throws IOException, InterruptedException, AWTException {
		
		TransferToPharmacy transGen=new TransferToPharmacy();
		transGen.transferCommon(data);
	}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=10)
	public void verifyTranstoPharm() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=11)
	public void dispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=12)
	public void verifyDispense() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=13)
	public void patReturn() {}
	
	@Test(dataProvider="getData",dataProviderClass = CellDataProvider.class,priority=14)
	public void verifyPatReturn() {}

//
//	@DataProvider
//	public static Object[][] getData(){
//			
//			if(helper == null){
//				helper = new SpreadSheetHelper("D:\\Jagan\\Nost_Data_Driven_DP.xlsx");
//			}
//			
//			String sheetName="NostLogin";
//			int rows = helper.getRowCount(sheetName);
//			int cols = helper.getColumnCount(sheetName);
//			
//			Object[][] data = new Object[rows-1][1];
//			
//			Hashtable<String,String> table = null;
//			
//			for(int rowNum=2; rowNum<=rows; rowNum++){
//				
//				table = new Hashtable<String,String>();
//				
//				for(int colNum=0; colNum<cols; colNum++){
//					
//			//	data[rowNum-2][colNum]=	excel.getCellData(sheetName, colNum, rowNum);
//			
//				table.put(helper.getCellData(sheetName,1,colNum), helper.getCellData(sheetName,rowNum,colNum));	
//				data[rowNum-2][0]=table;	
//					
//				}
//				
//			}
//			
//			return data;
//				
//		}
//
	
}
