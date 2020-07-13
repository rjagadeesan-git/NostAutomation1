package NostGroup.NostArtifact.Transfer;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class ReturnToSupplier extends CommonMethods{
	
	public void returnSupplierAdd(Hashtable<String,String> data) {
		
		click("transfer-menu","id");
		click("return-to-supplier-menu","csssele");
		selectText("ret-supp-protocol-id","id",data.get("ret-supp-protocol-id"));
		selectText("ret-supp-drug-id","id",data.get("ret-supp-drug-id"));
		// vali("ret-supp-formulation","id",data.get("ret-supp-formulation");
		selectText("ret-supp-lot","id",data.get("ret-supp-lot"));
		// vali("ret-supp-unit-type","csssele",data.get("ret-supp-unit-type");
		selectText("ret-supp-from-pharmacy","id",data.get("ret-supp-from-pharmacy"));
		// vali("ret-supp-storage-condition","id",data.get("ret-supp-storage-condition");
		selectText("ret-supp-storage-location","id",data.get("ret-supp-storage-location"));
		type("ret-supp-comments","id",data.get("ret-supp-comments"));
		// vali("ret-supp-loa","id",data.get("ret-supp-loa");

		type("ret-supp-esign","id",data.get("ret-supp-esign"));
		click("ret-supp-submit","id");
		click("ret-supp-cancel","csssele");

	}
	
}
