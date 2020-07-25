package NostGroup.NostArtifact.Billing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import NostGroup.NostArtifact.Base.CommonMethods;

public class CPP extends CommonMethods{
	
	String plan_id;
	String payer_id;
	String cpp_service_name;
	
public void cppAdd(Hashtable<String,String> data) throws AWTException, InterruptedException {

	Robot robo1=new Robot();
//	robo1.keyPress(KeyEvent.VK_CONTROL);
//	robo1.keyPress(KeyEvent.VK_MINUS);
//	Thread.sleep(2000);
//	robo1.keyPress(KeyEvent.VK_MINUS);
//	robo1.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(2000);
click("maintenance-billing-menu","csssele");
Thread.sleep(2000);
click("cpp-menu","csssele");
type("cpp-plan-search","id",data.get("cpp-plan-search"));
//Thread.sleep(2000);
//robo1.keyPress(KeyEvent.VK_DOWN);
//robo1.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(2000);
click("cpp-search","id");
Thread.sleep(3000);
WebElement cpp_plan_tabu=find_element("cpp-result-tabu","id");

List<WebElement> cpp_plan_tab_row=Driver.findElements(By.xpath(("//table[@id='cppTable']/tbody/tr")));
System.out.println(cpp_plan_tab_row.size());

List<WebElement> cpp_plan_tab_col=Driver.findElements(By.xpath(("//table[@id='cppTable']/tbody/tr[1]/td")));
System.out.println(cpp_plan_tab_col.size());

plan_id=data.get("cpp-plan-search");
payer_id=data.get("cpp-attach-payer-search");

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
				
				WebElement cpp_plan_tab_payer=Driver.findElement(By.xpath("//table[@id='cppTable']/tbody/tr["+row+"]/td[7]"));
				cpp_plan_tab_payer.findElement(By.cssSelector("button.btn:nth-child(3)")).click();
				click("cpp-payer-search-icon","csssele");
				Thread.sleep(2000);
				type("cpp-attach-payer-search","id",data.get("cpp-attach-payer-search"));
				//type("cpp-attach-payer-search","id",data.get("cpp-attach-payer-search"));
				click("cpp-add-new-payer-search","csssele");
				
				Thread.sleep(3000);
				
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
							String cpp_add_new_payer_tab_com=Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[1]")).getText();
							System.out.println("Got the payer text from table "+cpp_add_new_payer_tab_com);
							if(cpp_add_new_payer_tab_com.equalsIgnoreCase(payer_id)) { // CPP Existing Payer present in table search, If start 
								System.out.println("Inside Payer equals If");	
								Thread.sleep(2000);
								System.out.println(Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[3]")).getTagName());
								System.out.println(Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[3]")).getText());
								Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row1+"]/td[3]")).click();
								Thread.sleep(15000);
								 System.out.println("Payer selected from Existing Payer list");
								 extest.log(LogStatus.PASS,"Payer '"+payer_id+"' selected from existing Payer's list successfully");
									log.info("Payer '"+payer_id+"' selected from existing Payer's list successfully");
									Reporter.log("Payer '"+payer_id+"' selected from existing Payer's list successfully");
									//selectText("cpp-payer-level","id",data.get("cpp-payer-level"));
									click("cpp-attach-payer","csssele");
									Thread.sleep(2000);
									robo1.keyPress(KeyEvent.VK_ENTER);
									
									Thread.sleep(3000);
									
									// Adding CDM 
									
									
//									Set<String> windis=Driver.getWindowHandles();
//									Iterator<String> iterate=windis.iterator();
//									String first_window=iterate.next();
//									//String second_window=iterate.next();
//									Driver.switchTo().window(first_window);
//									WebElement cpp_payer_save_info=find_element("cpp-payer-save-info","id");
//									if(cpp_payer_save_info.getText().contains("Information has been saved successfully")) { 
//										
//										click("cpp_payer_save_ok","id");
//										Thread.sleep(2000);
//										System.out.println("New Payer added successfully");
//										extest.log(LogStatus.PASS,"Payer '"+payer_id+"' added successfully");
//										log.info("Payer '"+payer_id+"' added successfully");
//										Reporter.log("Payer '"+payer_id+"' added successfully");
//									}
//									String alerttext11=Driver.switchTo().alert().getText();
//									if(alerttext11.contains("Information has been saved successfully")) {
//										Driver.switchTo().alert().accept();
//										Thread.sleep(2000);
//										System.out.println("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//										extest.log(LogStatus.PASS,"Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//										log.info("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//										Reporter.log("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//									} else {
//										System.out.println("Error in Attaching Payer");
//										System.out.println(alerttext11);
//										
//									}
								break;
							} // CPP Existing Payer present in table search, If close
							else if(cpp_add_new_payer_tab_com.contains(payer_id)) {  // CPP Payer table search contains, else if- Start
								System.out.println("Inside Payer contains else If");
								System.out.println("Payer partial match found");
								extest.log(LogStatus.WARNING,"One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
								log.info("One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
								Reporter.log("One of the Payer '"+cpp_add_new_payer_tab_com+"' contains '"+payer_id+"' found,but not the exact match");
								
							} // CPP Payer table search contains, else if- end
							else { //CPP Payer not found, adding new one, else- start
								System.out.println("Inside Payer not contains else ");
								System.out.println("Payer not found in the existing list,Adding as New Payer");
								extest.log(LogStatus.WARNING,"Payer '"+payer_id+"' not found in the Payer List, Adding as New Payer");
								log.info("Payer '"+payer_id+"' not found in the Payer List, Adding as New Payer");
								Reporter.log("Payer '"+payer_id+"' not found in the Payer List, Adding as New Payer");
								click("cpp-add-new-payer","id");
								Thread.sleep(2000);
								type("cpp-payer-id","id",data.get("cpp-attach-payer-search"));
								type("cpp-account-no","id",data.get("cpp-account-no"));
								//type("cpp-same-payerid","id",data.get("cpp-same-payerid"));
								type("cpp-account-name","id",data.get("cpp-account-name"));
								selectText("cpp-type-code","id",data.get("cpp-type-code"));
								type("cpp-payer-email","id",data.get("cpp-payer-email"));
								click("cpp-save-payer","csssele");
								Thread.sleep(3000);
								String alerttext=Driver.switchTo().alert().getText();
								if(alerttext.contains("Information has been updated successfully")) { //Payer addition confirm alert text, If- start
									
									Driver.switchTo().alert().accept();
									Thread.sleep(2000);
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
													Thread.sleep(2000);
													 System.out.println("New Payer added and selected from the List");
													 extest.log(LogStatus.PASS,"New Payer '"+payer_id+"' added and selected from Payer's list successfully");
														log.info("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
														Reporter.log("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
														
														// attaching in Plan screen
														
														//selectText("cpp-payer-level","id",data.get("cpp-payer-level"));
														click("cpp-attach-payer","csssele");
														Thread.sleep(2000);
														
														String alerttext2=Driver.switchTo().alert().getText();
														if(alerttext2.contains("Information has been updated successfully")) {
															Driver.switchTo().alert().accept();
															Thread.sleep(2000);
															System.out.println("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
															extest.log(LogStatus.PASS,"Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
															log.info("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
															Reporter.log("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
														} else {
															System.out.println("Error in Attaching Payer");
															System.out.println(alerttext2);
															
														}
														
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
										
										System.out.println("New Payer not found in the table, Table not displayed");
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
				
				else { //CPP Payer not found, adding new one, else- start
					
					System.out.println("Payer not found in the existing list,Adding as New Payer");
					extest.log(LogStatus.WARNING,"Payer '"+payer_id+"' not found in the Payer List");
					log.info("Payer '"+payer_id+"' not found in the Payer List");
					Reporter.log("Payer '"+payer_id+"' not found in the Payer List");
					click("cpp-add-new-payer","id");
					Thread.sleep(2000);
					type("cpp-payer-id","id",data.get("cpp-attach-payer-search"));
					type("cpp-account-no","id",data.get("cpp-account-no"));
					//type("cpp-same-payerid","id",data.get("cpp-same-payerid"));
					type("cpp-account-name","id",data.get("cpp-account-name"));
					selectText("cpp-type-code","id",data.get("cpp-type-code"));
					type("cpp-payer-email","id",data.get("cpp-payer-email"));
					click("cpp-save-payer","csssele");
					Thread.sleep(3000);
//					WebElement cpp_payer_save_info=find_element("cpp-payer-save-info","id");
//					if(cpp_payer_save_info.getText().contains("Information has been saved successfully")) { //Payer addition confirm alert text, If- start
						
//						click("cpp_payer_save_ok","id");
//						Thread.sleep(2000);
					robo1.keyPress(KeyEvent.VK_ENTER);
						System.out.println("New Payer added successfully");
						extest.log(LogStatus.PASS,"Payer '"+payer_id+"' added successfully");
						log.info("Payer '"+payer_id+"' added successfully");
						Reporter.log("Payer '"+payer_id+"' added successfully");
						
						WebElement cpp_add_new_payer_tabu5=find_element("cpp-payer-search-result-tabu","id");

						List<WebElement> cpp_add_new_payer_tab_row5=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr")));
						System.out.println(cpp_add_new_payer_tab_row5.size());

						List<WebElement> cpp_add_new_payer_tab_col5=Driver.findElements(By.xpath(("//table[@id='attachCppPayerTableData']/tbody/tr[1]/td")));
						System.out.println(cpp_add_new_payer_tab_col5.size());
						
						if(cpp_add_new_payer_tabu5.isDisplayed() && cpp_add_new_payer_tab_col5.size()>1) { // New Payer add table search Displayed, Col size, If- start
							
							if(cpp_add_new_payer_tab_row5.size()>=1) { // new Payer search table row size, If- Start
								
								System.out.println("new Payer search table row size, If");

								for(int row5=1;row5<=cpp_add_new_payer_tab_row.size();row5++) { //New Payer add check row loop- Start
									
									System.out.println("Inside row5 loop");
									String cpp_add_new_payer_tab_com5=Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row5+"]/td[1]")).getText();
									
									if(cpp_add_new_payer_tab_com5.equalsIgnoreCase(payer_id)) { //New Payer click present check, If- Start
										
										Thread.sleep(2000);
										Driver.findElement(By.xpath("//table[@id='attachCppPayerTableData']/tbody/tr["+row5+"]/td[2]")).click();
										Thread.sleep(2000);
										 System.out.println("New Payer added and selected from the List");
										 extest.log(LogStatus.PASS,"New Payer '"+payer_id+"' added and selected from Payer's list successfully");
											log.info("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
											Reporter.log("New Payer '"+payer_id+"' added and selected from Payer's list successfully");
											
											// attaching in Plan screen
											Thread.sleep(2000);
											selectText("cpp-payer-level","id",data.get("cpp-payer-level"));
											click("cpp-attach-payer","csssele");
											Thread.sleep(2000);
											robo1.keyPress(KeyEvent.VK_ENTER);
//											String alerttext6=Driver.switchTo().alert().getText();
//											if(alerttext6.contains("Information has been updated successfully")) {
//												Driver.switchTo().alert().accept();
//												Thread.sleep(2000);
//												System.out.println("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//												extest.log(LogStatus.PASS,"Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//												log.info("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//												Reporter.log("Payer '"+payer_id+"' attached to the Plan '"+plan_id+"' successfully");
//											} else {
//												System.out.println("Error in Attaching Payer");
//												System.out.println(alerttext6);
//												
//											}
											
						// Adding CDM
											
													
									break;
									} //New Payer click present check, If- end
									
									else { // New Payer click selec failed, else- start 
//										String alerttext7=Driver.switchTo().alert().getText();
//										System.out.println(alerttext7);
//										System.out.println("New Payer selection failed with warning- "+alerttext7);
										System.out.println("New Payer click selection failed");
									} // New Payer click selec failed, else- end
									
								} //New Payer add check row loop- end

								
							} // new Payer search table row size, If- end
							
							
						} // New Payer table search Displayed, Col size, If- end
						
						else {  //  New Payer table search Displayed, Col size, else - start
							
							System.out.println("New Payer not found in the table, Table not displayed");
						} // New Payer table search Displayed, Col size, else - end

//					
//					else { //Payer addition failed else- Start
//						String alerttext8=Driver.switchTo().alert().getText();
//						System.out.println(alerttext8);
//						System.out.println("Adding new Payer faile with warning- ");
//						
//					} //Payer addition failed else- end
					
				} //CPP Payer not found, adding new one, else- end
				
  // Clicking on Services tab
				
				WebElement cpp_plan_tab_service=Driver.findElement(By.xpath("//table[@id='cppTable']/tbody/tr["+row+"]/td[7]"));
				cpp_plan_tab_service.findElement(By.cssSelector("button.btn:nth-child(4)")).click();
				
 // CDM verification
				
				WebElement cpp_cdm_tabu=find_element("cpp-cdm-search-tabu","id");
				
				List<WebElement> cpp_cdm_tab_row=Driver.findElements(By.xpath(("//table[@id='cppServicesTable']/tbody/tr")));
				System.out.println(cpp_cdm_tab_row.size());
				
				List<WebElement> cpp_cdm_tab_col=Driver.findElements(By.xpath(("//table[@id='cppServicesTable']/tbody/tr[1]/td")));
				System.out.println(cpp_cdm_tab_col.size());
				
				cpp_service_name=data.get("cpp-cdm-service-name");
				
				if(cpp_cdm_tabu.isDisplayed() && cpp_cdm_tab_col.size()>1) { // CPP CDM table displayed, Col size, If- Start
				
				if(cpp_cdm_tab_row.size()>=1) { //CPP CDM table row size, If Start
					
					System.out.println("InsideCPP CDM table row size, If");
				
				for(int row13=1;row<=cpp_cdm_tab_row.size();row13++) { //CPP CDM data loop- Start
					
						System.out.println("Inside CPP CDM data loop");
						String cpp_cdm_tab_com=Driver.findElement(By.xpath("//table[@id='cppServicesTable']/tbody/tr["+row13+"]/td[2]")).getText();
						if(cpp_cdm_tab_com.equalsIgnoreCase(cpp_service_name)) {	
//							Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row13+"]/td[2]")).click();
							System.out.println("CDM entry for Service name found");
							extest.log(LogStatus.PASS,"CDM entry for Service '"+cpp_service_name+"' present already in CPP CDM");
							log.info("CDM entry for Service '"+cpp_service_name+"' present already in CPP CDM");
							Reporter.log("CDM entry for Service '"+cpp_service_name+"' present already in CPP CDM");
							break;
						} else if(cpp_cdm_tab_com.contains(cpp_service_name))	{ // CPP CDM table data contains, else if Start
							
							System.out.println("Partial match found");
							extest.log(LogStatus.WARNING,"One of the CDM entry Service '"+cpp_cdm_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
							log.info("One of the CDM entry Service '"+cpp_cdm_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
							Reporter.log("One of the CDM entry Service '"+cpp_cdm_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
						} // CPP CDM table data contains, else if end
						
			} //CPP CDM table for loop- end

			} //CPP CDM table row size, If end
				else {  // CPP CDM table row size, else Start
					System.out.println("CPP CDM not found in CDM table, wrong search");
					extest.log(LogStatus.FAIL,"Service '"+cpp_service_name+"' not listed in CPP CDM");
					log.info("Service '"+cpp_service_name+"' not listed in CPP CDM");
					Reporter.log("Service '"+cpp_service_name+"' not listed in CPP CDM");
			}  // CPP CDM table row size, else end
				
				} // CPP CDM table displayed, Col size, If- Start
				
				else { // CPP CDM table displayed, Col size, Else- Start
					
					System.out.println("Service name in CDM table not found, Table not Displayed");
					extest.log(LogStatus.FAIL,"Service '"+cpp_service_name+"' not listed in CPP CDM");
					log.info("Service '"+cpp_service_name+"' not listed in CPP CDM");
					Reporter.log("Service '"+cpp_service_name+"' not listed in CPP CDM");
					
					// Service verification
					
					WebElement cpp_servicemaster_tabu=find_element("cpp-service-master-result-tabu","id");
					
					List<WebElement> cpp_servicemaster_tab_row=Driver.findElements(By.xpath(("//table[@id='cppServicesTable1']/tbody/tr")));
					System.out.println(cpp_servicemaster_tab_row.size());
					
					List<WebElement> cpp_servicemaster_tab_col=Driver.findElements(By.xpath(("//table[@id='cppServicesTable1']/tbody/tr[1]/td")));
					System.out.println(cpp_servicemaster_tab_col.size());
					
					cpp_service_name=data.get("cpp-cdm-service-name");
					
					if(cpp_servicemaster_tabu.isDisplayed() && cpp_servicemaster_tab_col.size()>1) { // CPP Service table displayed, Col size, If- Start
					
					if(cpp_servicemaster_tab_row.size()>=1) { //CPP Service table row size, If Start
						
						System.out.println("Inside CPP service table row");
					
					for(int row14=1;row<=cpp_servicemaster_tab_row.size();row14++) { //CPP Service data loop- Start
						
							System.out.println("Inside CPP Service data loop");
							String cpp_servicemaster_tab_com=Driver.findElement(By.xpath("//table[@id='cppServicesTable1']/tbody/tr["+row14+"]/td[2]")).getText();
							if(cpp_servicemaster_tab_com.equalsIgnoreCase(cpp_service_name)) {	
								Driver.findElement(By.xpath("//table[@id='cppServicesTable1']/tbody/tr["+row14+"]/td[2]")).click();
								System.out.println("Service name found in CPP");
								extest.log(LogStatus.PASS,"Service '"+cpp_service_name+"' found in CPP Services table" );
								log.info("Service '"+cpp_service_name+"' found in CPP Services table");
								Reporter.log("Service '"+cpp_service_name+"' found in CPP Services table");
								
								Thread.sleep(3000);
								
		// Write the CPP CDM addition steps
								click("cpp-cdm-quantity-based","id");
								type("cpp-cdm-service-price","id",data.get("cpp-cdm-service-price"));
								//Pending
								Thread.sleep(15000);
//								 WebElement cpp_cdm_price_eff_from=find_element("cpp-cdm-price-eff-from","id");
//								 WebElement cpp_cdm_price_eff_to=find_element("cpp-cdm-price-eff-to","id");
//								 cpp_cdm_price_eff_from.sendKeys(data.get("cpp-cdm-price-eff-from"));
//								 cpp_cdm_price_eff_to.sendKeys(data.get("cpp-cdm-price-eff-to"));
								click("cpp-cdm-save","csssele");
								Thread.sleep(2000);
								robo1.keyPress(KeyEvent.VK_ENTER);
								
								Thread.sleep(3000);
								
								// Add info click
								
		// CDM verification, after CDM addition
								
								WebElement cpp_cdm_tabu1=find_element("cpp-cdm-search-tabu","id");
								
								List<WebElement> cpp_cdm_tab_row1=Driver.findElements(By.xpath(("//table[@id='cppServicesTable']/tbody/tr")));
								System.out.println(cpp_cdm_tab_row1.size());
								
								List<WebElement> cpp_cdm_tab_col1=Driver.findElements(By.xpath(("//table[@id='cppServicesTable']/tbody/tr[1]/td")));
								System.out.println(cpp_cdm_tab_col.size());
								
								//cpp_service_name=data.get("cpp-cdm-service-name");
								
								if(cpp_cdm_tabu1.isDisplayed() && cpp_cdm_tab_col1.size()>1) { // After CDM add, CPP CDM table displayed, Col size, If- Start
								
								if(cpp_cdm_tab_row1.size()>=1) { //After CDM add, CPP CDM table row size, If Start
									
									System.out.println("Inside After CDM add, CPP CDM table row size, If Start");
								
								for(int row16=1;row<=cpp_cdm_tab_row1.size();row16++) { //After CDM add, CPP CDM data loop- Start
									
										System.out.println("Inside After CDM add, CPP CDM data loop- Start");
										String cpp_cdm_tab_com1=Driver.findElement(By.xpath("//table[@id='cppServicesTable']/tbody/tr["+row16+"]/td[2]")).getText();
										if(cpp_cdm_tab_com1.equalsIgnoreCase(cpp_service_name)) {	
//											Driver.findElement(By.xpath("//table[@id='service-name-search']/tbody/tr["+row13+"]/td[2]")).click();
											System.out.println("After CDM addition, CDM entry added successfully in CPP CDM");
											extest.log(LogStatus.PASS,"After CDM addition, CDM entry added successfully in CPP CDM");
											log.info("After CDM addition, CDM entry added successfully in CPP CDM");
											Reporter.log("After CDM addition, CDM entry added successfully in CPP CDM");
											break;
										} else if(cpp_cdm_tab_com1.contains(cpp_service_name))	{ //After CDM add,  CPP CDM table data contains, else if Start
											
											System.out.println("Partial match found");
											extest.log(LogStatus.WARNING,"After CDM addition, One of the Service '"+cpp_cdm_tab_com1+"' contains '"+cpp_service_name+"' found,but not the exact match");
											log.info("After CDM addition, One of the Service '"+cpp_cdm_tab_com1+"' contains '"+cpp_service_name+"' found,but not the exact match");
											Reporter.log("After CDM addition, One of the Service '"+cpp_cdm_tab_com1+"' contains '"+cpp_service_name+"' found,but not the exact match");
										} // After CDM add, CPP CDM table data contains, else if end
										
							} //After CDM add, CPP CDM table for loop- end

							} //After CDM add, CPP CDM table row size, If end
								else {  // After CDM add, CPP CDM table row size, else Start
									System.out.println("After CDM addition, Service not listed in CPP CDM, Wrong search");
									extest.log(LogStatus.FAIL,"After CDM addition, Service '"+cpp_service_name+"' not listed in CPP CDM");
									log.info("After CDM addition, Service '"+cpp_service_name+"' not listed in CPP CDM");
									Reporter.log("After CDM addition, Service '"+cpp_service_name+"' not listed in CPP CDM");
									Assert.fail("CDM addition failed in CPP CDM");
							}  // After CDM add, CPP CDM table row size, else end
								
								} // After CDM add, CPP CDM table displayed, Col size, If- Start
								
								else { // After CDM add, CPP CDM table displayed, Col size, Else- Start
									
									System.out.println("After CDM addition, Service name not found in CDM table, Table not Displayed");
									extest.log(LogStatus.FAIL,"After CDM addition, CDM entry '"+cpp_service_name+"' not listed in CPP CDM");
									log.info("After CDM addition, CDM entry '"+cpp_service_name+"' not listed in CPP CDM");
									Reporter.log("After CDM addition, CDM entry '"+cpp_service_name+"' not listed in CPP CDM");
									Assert.fail("CDM addition failed in CPP CDM");
									
								}  // After CDM add, CPP CDM table displayed, Col size, Else- End
								
			// End of CDM verification, after CDM addition					
								
								break;
							} else if(cpp_servicemaster_tab_com.contains(cpp_service_name))	{ // CPP Service table data contains, else if Start
								
								System.out.println("Partial match found");
								extest.log(LogStatus.WARNING,"One of the Service '"+cpp_servicemaster_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
								log.info("One of the Service '"+cpp_servicemaster_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
								Reporter.log("One of the Service '"+cpp_servicemaster_tab_com+"' contains '"+cpp_service_name+"' found,but not the exact match");
							} // CPP Service table data contains, else if Start
							
				} //CPP Service table for loop- end

				} //CPP Service table row size, If end
					else {  // CPP Service table row size, else Start
					System.out.println("Service name not found in CPP, Wrong Search");
					extest.log(LogStatus.FAIL,"Service '"+cpp_service_name+"' not found in CPP Service table");
					log.info("Service '"+cpp_service_name+"' not found in CPP Service table");
					Reporter.log("Service '"+cpp_service_name+"' not found in CPP Service table");
					Assert.fail("Service '"+cpp_service_name+"' not found in CPP Service table");
					
				}  // CPP Service table row size, else end
					
					} // CPP Service table displayed, Col size, If- Start
					
					else { // // CPP Service table displayed, Col size, Else- Start
						
						System.out.println("Service name not found, Table not Displayed");
						extest.log(LogStatus.FAIL,"Service '"+cpp_service_name+"' not found in CPP Service table");
						log.info("Service '"+cpp_service_name+"' not found in CPP Service table");
						Reporter.log("Service '"+cpp_service_name+"' not found in CPP Service table");
						Assert.fail("Service '"+cpp_service_name+"' not found in CPP Service table");
						
					}  // CPP Service table displayed, Col size, Else- End

	// End of Service verification				
						
				}  // CPP CDM table displayed, Col size, Else- End
				
												
				break;  //Plan Break
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
	
	public void cppVerifySearch() {}
	
	public void cppPayerAdd() {}
	

}
