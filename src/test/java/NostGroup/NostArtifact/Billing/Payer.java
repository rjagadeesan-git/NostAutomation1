package NostGroup.NostArtifact.Billing;

import java.util.Hashtable;

import NostGroup.NostArtifact.Base.CommonMethods;

public class Payer extends CommonMethods{
	
	public void payerAdd(Hashtable<String,String> data) {
		
		click("payer-menu","csssele");
		click("add-new-payer","id");
		type("payer-id","id",data.get("payer-id"));
		type("account-no","id",data.get("account-no"));
		type("same-payer-id","id",data.get("same-payer-id"));
		type("account-name","id",data.get("account-name"));
		type("type-code","id",data.get("type-code"));
		type("payer-address1","id",data.get("payer-address1"));
		type("payer-email","id",data.get("payer-email"));
		click("payer-save","id");
		click("payer-reset","csssele");
		click("payer-cancel","csssele");

	}

}
