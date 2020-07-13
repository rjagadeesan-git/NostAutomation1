package NostGroup.NostArtifact.PatientReturns;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class PatientReturns extends CommonMethods{
	
	public void patReturnsAdd(Hashtable<String,String> data) {
		
		click("patient-returns-menu","id");
		click("patient-returns","csssele");
		type("pat-ret-protocol-search","id",data.get("pat-ret-protocol-search"));
		click("pat-ret-search","csssele");

		// vali("pat-ret-qty-disp","csssele",data.get("pat-ret-qty-disp");
		type("qty-pat-returned","id",data.get("qty-pat-returned"));

		type("pat-ret-comment","id",data.get("pat-ret-comment"));
		check("pat-ret-destroyed","id",data.get("pat-ret-destroyed"));

		type("pat-ret-esign","id",data.get("pat-ret-esign"));
		click("pat-ret-submit","id");
		click("pat-ret-delete","id");
		click("pat-ret-cancel","csssele");

	}
	
	public void patReturnsVerify() {}

}
