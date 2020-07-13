package NostGroup.NostArtifact.Billing;

import java.sql.Driver;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import NostGroup.NostArtifact.Base.CommonMethods;

public class errortest extends CommonMethods{
	
	String plan_id;
	String payer_id;
public void testMethod(Hashtable<String,String> data) {

	WebElement cpp_plan_tabu=find_element("cpp-result-tabu","id");

	List<WebElement> cpp_plan_tab_row=Driver.findElements(By.xpath(("//table[@id='cppTable']/tbody/tr")));
	System.out.println(cpp_plan_tab_row.size());

	List<WebElement> cpp_plan_tab_col=Driver.findElements(By.xpath(("//table[@id='cppTable']/tbody/tr[1]/td")));
	System.out.println(cpp_plan_tab_col.size());

	plan_id=data.get("cpp-plan-search");
	
	if(cpp_plan_tabu.isDisplayed() && cpp_plan_tab_col.size()>1) { //Plan table displayed, Col size- If start
		
		if(cpp_plan_tab_row.size()>=1) // Plan table row size- If start
		{
			
			System.out.println("Inside If");
			
			for(int row=1;row<=cpp_plan_tab_row.size();row++) { //Plan table row iteration- loop start
				
				System.out.println("Inside row loop");
				String cpp_plan_tab_com=Driver.findElement(By.xpath("//table[@id='cppTable']/tbody/tr["+row+"]/td[2]")).getText();
				if(cpp_plan_tab_com.contains(plan_id)) { //Plan present in table- If start
					System.out.println("Plan ID found");
					extest.log(LogStatus.PASS,"Plan '"+plan_id+"' integrated to CPP successfully");
					log.info("Plan '"+plan_id+"' integrated to CPP successfully");
					Reporter.log("Plan '"+plan_id+"' integrated to CPP successfully");
	
					//Clicking on Payer tab
					
					WebElement cpp_plan_tab_payer=Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row+"]/td[7]"));
					cpp_plan_tab_payer.findElement(By.cssSelector("button.btn:nth-child(3)")).click();
					click("cpp-payer-search-icon","csssele");
					type("cpp-attach-payer-search","id",data.get("cpp-attach-payer-search"));
					type("cpp-add-new-payer-search","csssele",data.get("cpp-add-new-payer-search"));
					WebElement cpp_add_new_payer_tabu=find_element("cpp-payer-search-result-tabu","id");
					
					List<WebElement> cpp_add_new_payer_tab_row=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr")));
					System.out.println(cpp_add_new_payer_tab_row.size());

					List<WebElement> cpp_add_new_payer_tab_col=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr[1]/td")));
					System.out.println(cpp_add_new_payer_tab_col.size());

					if(cpp_add_new_payer_tabu.isDisplayed() && cpp_add_new_payer_tab_col.size()>1) { //CPP existing Payer displayed, Col size, If- Start
						
						if(cpp_add_new_payer_tab_row.size()>=1) { //CPP existing payer table row size, If- Start
							
							System.out.println("Inside CPP Payer table row if");
							
							for(int row1=1;row1<=cpp_add_new_payer_tab_row.size();row1++) { //CPP Existing Payer table loop- Start
								
								System.out.println("Inside CPP Payer table loop");
								String cpp_add_new_payer_tab_com=Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row+"]/td[2]")).getText();
								if(cpp_add_new_payer_tab_com.equalsIgnoreCase(payer_id)) { // CPP Existing Payer present in table search, If start 
									
									Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[2]")).click();
									 System.out.println("Payer selected from Existing Payer list");
									 extest.log(LogStatus.PASS,"Payer '"+payer_id+"' selected from existing Payer's list successfully");
										log.info("Payer '"+payer_id+"' selected from existing Payer's list successfully");
										Reporter.log("Payer '"+payer_id+"' selected from existing Payer's list successfully");
									break;
								} // CPP Existing Payer present in table search, If close
								else if(cpp_add_new_payer_tab_com.contains(payer_id)) {  // CPP Payer table search contains, else if- Start
									System.out.println("Payer partial match found");
									extest.log(LogStatus.WARNING,"One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
									log.info("One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
									Reporter.log("One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
									
								} // CPP Payer table search contains, else if- end
								else { //CPP Payer not found, adding new one, else- start
									
									System.out.println("Payer not found in the existing list,Adding as New Payer");
									extest.log(LogStatus.WARNING,"Payer '"+payer_id+"' not found in the Payer List");
									log.info("Payer '"+payer_id+"' not found in the Payer List");
									Reporter.log("Payer '"+payer_id+"' not found in the Payer List");
									click("cpp-add-new-payer","id");
									type("cpp-payer-id","id",data.get("cpp-payer-id"));
									type("cpp-account-no","id",data.get("cpp-account-no"));
									//type("cpp-same-payerid","id",data.get("cpp-same-payerid"));
									type("cpp-account-name","id",data.get("cpp-account-name"));
									type("cpp-type-code","id",data.get("cpp-type-code"));
									type("cpp-payer-email","id",data.get("cpp-payer-email"));
									click("cpp-save-payer","csssele");
									String alerttext=Driver.switchTo().alert().getText();
									if(alerttext.contains("Information has been updated successfully")) { //Payer addition confirm alert text, If- start
										
										Driver.switchTo().alert().accept();
										System.out.println("New Payer added successfully");
										extest.log(LogStatus.PASS,"Payer '"+payer_id+"' added successfully");
										log.info("Payer '"+payer_id+"' added successfully");
										Reporter.log("Payer '"+payer_id+"' added successfully");
										
										WebElement cpp_add_new_payer_tabu1=find_element("cpp-payer-search-result-tabu","id");

										List<WebElement> cpp_add_new_payer_tab_row1=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr")));
										System.out.println(cpp_add_new_payer_tab_row1.size());

										List<WebElement> cpp_add_new_payer_tab_col1=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr[1]/td")));
										System.out.println(cpp_add_new_payer_tab_col1.size());
										
										if(cpp_add_new_payer_tabu1.isDisplayed() && cpp_add_new_payer_tab_col1.size()>1) { // New Payer add table search Displayed, Col size, If- start
											
											if(cpp_add_new_payer_tab_row1.size()>=1) { // new Payer search table row size, If- Start
												
												System.out.println("new Payer search table row size, If");

												for(int row2=1;row2<=cpp_add_new_payer_tab_row.size();row2++) { //New Payer add check row loop- Start
													
													System.out.println("Inside row2 loop");
													String cpp_add_new_payer_tab_com1=Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row+"]/td[2]")).getText();
													
													if(cpp_add_new_payer_tab_com1.equalsIgnoreCase(payer_id)) { //New Payer click present check, If- Start
														
														Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[2]")).click();
														 System.out.println("New Payer added and selected from the List");
														 extest.log(LogStatus.PASS,"New Payer '"+payer_id+"' added and selected from Payer's list successfully");
															log.info("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
															Reporter.log("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
													break;
													} //New Payer click present check, If- end
													
													else { // New Payer click selec failed, else- start 
														String alerttext1=Driver.switchTo().alert().getText();
														System.out.println(alerttext1);
														System.out.println("New Payer selection failed with warning- "+alerttext1);
														
													} // New Payer click selec failed, else- end
													
												} //New Payer add check row loop- end

												
											} // new Payer search table row size, If- end
											
											
										} // New Payer table search Displayed, Col size, If- end
										
										else {  //  New Payer table search Displayed, Col size, else - start
											
											System.out.println("New Payer not found in the table");
										} // New Payer table search Displayed, Col size, else - start

									}  //Payer addition confirm alert text, If- end
									
									else { //Payer addition failed else- Start
										
										System.out.println(alerttext);
										System.out.println("Adding new Payer faile with warning- "+alerttext);
										
									} //Payer addition failed else- end
									
								} //CPP Payer not found, adding new one, else- end
								
							} //CPP Payer table loop- end
							
						} //CPP payer table row size, If- end
						
					} //CPP Payer displayed, Col size, If- end
					
					break;
				} // Plan present in table- If close
				
			} //Plan table row iteration- loop close
			
		}    // Plan table row size- If close
		else {   // Plan table row size- else start
			System.out.println("Plan ID not found, Search Failed");
			extest.log(LogStatus.FAIL,"Plan '"+plan_id+"' not integrated to CPP");
			log.info("Plan '"+plan_id+"' not integrated to CPP");
			Reporter.log("Plan '"+plan_id+"' not integrated to CPP");
			Assert.fail("Plan ID failed to Integrate");
			}   // Plan table row size- else end
		
	}  // Plan table displayed, Col size- If close
		else {    //Plan table displayed,Col size- else start
		
		System.out.println("Plan ID not found, Table not Displayed");
		extest.log(LogStatus.FAIL,"Plan '"+plan_id+"' not integrated to CPP");
		log.info("Plan '"+plan_id+"' not integrated to CPP");
		Reporter.log("Plan '"+plan_id+"' not integrated to CPP");
		Assert.fail("Plan ID failed to Integrate");
	}   //Plan table displayed,Col size- else end

	}// Method closing 


}
