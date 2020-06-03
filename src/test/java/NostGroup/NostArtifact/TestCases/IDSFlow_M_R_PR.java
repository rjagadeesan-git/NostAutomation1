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
//	
//	@Test(priority=3)
//	public void addPharmacy() throws IOException, InterruptedException, AWTException {
//		Pharmacy pharm=new Pharmacy();
//		pharm.addPharmacy();
//	}
//	
//	@Test(priority=4)
//	public void addSupplier() throws IOException, InterruptedException {
//		Supplier supp=new Supplier();
//		supp.addSupplier();
//	}
//	
//	@Test(priority=5)
//	public void addCatalog() throws InterruptedException, IOException {
//		Catalog drug=new Catalog();
//		drug.addDrug();
//	}
//	
//	@Test(priority=6)
//	public void addPatient() throws IOException, InterruptedException, AWTException {
//		Patient patient=new Patient();
//		patient.addPatient();
//	}
//	
//	@Test(priority=7)
//	public void receive() throws IOException, InterruptedException, AWTException {
//		
//		Receive rec=new Receive();
//		rec.receiveCommon();
//		rec.rec_SubmitQueue();
//	}
//	
//	@Test(priority=8)
//	public void verifyReceive() {}
//	
//	@Test(priority=9)
//	public void transfertoPharm() throws IOException, InterruptedException, AWTException {
//		
//		TransferToPharmacy transGen=new TransferToPharmacy();
//		transGen.transferCommon();
//	}
//	
//	@Test(priority=10)
//	public void verifyTranstoPharm() {}
//	
//	@Test(priority=11)
//	public void dispense() {}
//	
//	@Test(priority=12)
//	public void verifyDispense() {}
//	
//	@Test(priority=13)
//	public void patReturn() {}
//	
//	@Test(priority=14)
//	public void verifyPatReturn() {}

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
