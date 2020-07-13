package NostGroup.NostArtifact.Billing;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class CDM extends CommonMethods{
	
	public void cdmAdd(Hashtable<String,String> data) {
		
		click("cdm-menu","csssele");
		click("add-new-cdm","csssele");
		check("cdm-charge-basis","id",data.get("cdm-charge-basis"));
		type("cdm-plan-search","id",data.get("cdm-plan-search"));
		type("cdm-payer-search","id",data.get("cdm-payer-search"));
		type("cdm-pharmacy","id",data.get("cdm-pharmacy"));
		click("cdm-service-search-icon","csssele");
		type("cdm-service-master-service-name","id",data.get("cdm-service-master-service-name"));

		type("cdm-service-master-result-search-bar","csssele",data.get("cdm-service-master-result-search-bar"));
		type("cdm-service-price","id",data.get("cdm-service-price"));

		check("cdm-service-frequency","id",data.get("cdm-service-frequency"));
		selectText("cdm-service-frequency-interval","id",data.get("cdm-service-frequency-interval"));
		click("cdm-service-save","csssele");
		click("cdm-service-cancel","csssele");

	}
	
	public void cdmVerifySearch(Hashtable<String,String> data) {}

}
