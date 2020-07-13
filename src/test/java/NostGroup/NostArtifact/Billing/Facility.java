package NostGroup.NostArtifact.Billing;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Facility extends CommonMethods{
	
	public void facilityVerify(Hashtable<String,String> data) {
		
		click("facility-menu","csssele");
		type("facility-name","id",data.get("facility-name"));
		click("facility-search","id");
		type("facility-result-search-bar","csssele",data.get("facility-result-search-bar"));

	}
	
}
