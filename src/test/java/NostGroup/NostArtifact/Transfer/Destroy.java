package NostGroup.NostArtifact.Transfer;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Destroy extends CommonMethods{
	
	public void destroyAdd(Hashtable<String,String> data) {
		
		click("transfer-menu","id");
		click("destroy-menu","csssele");
		selectText("destroy-protocol-id","id",data.get("destroy-protocol-id"));
		selectText("destroy-drug-name","id",data.get("destroy-drug-name"));
		// vali("destroy-formulation","id",data.get("destroy-formulation");
		selectText("destroy-lot","id",data.get("destroy-lot"));
		// vali("destroy-exp-date","id",data.get("destroy-exp-date");
		// vali("destroy-unit-type","csssele",data.get("destroy-unit-type");
		selectText("destroy-from-pharmacy","id",data.get("destroy-from-pharmacy"));
		// vali("destroy-storage-condition","id",data.get("destroy-storage-condition");
		selectText("destroy-storage-location","id",data.get("destroy-storage-location"));
		type("destroy-comments","id",data.get("destroy-comments"));

		// vali("destroy-loa","id",data.get("destroy-loa");
		type("destroy-qty-per-unit","id",data.get("destroy-qty-per-unit"));
		type("tot-qty-drug-destroy","id",data.get("tot-qty-drug-destroy"));
		// vali("total-drg-qty","id",data.get("total-drg-qty");

		click("destroy-submit","id");
		click("destroy-cancel","csssele");
		
	}
	

}
