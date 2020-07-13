package NostGroup.NostArtifact.Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends CommonMethods implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testing started for Nostradamus  "+result.getName());
		extest=exreport.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("'On Test Success' invoked for "+result.getName());
		extest.log(LogStatus.PASS, result.getName()+": PASS");
		exreport.endTest(extest);
		exreport.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		log.info("'On Test Failure' invoked for "+result.getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.info("Test failed  "+result.getName());
		try {
			screenshotReg();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			extest.log(LogStatus.FAIL,"Screenshot capture failed");
			e.printStackTrace();
		}
		Reporter.log("<br>"+ result.getName() +": Failed");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\Screenshots\\"+imagename+"\">ScreenShot</a>");
		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\"D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\Screenshots\\"+imagename+"\">ScreenShot</a>");
		extest.log(LogStatus.FAIL,result.getName()+" "+"Failed with exception: "+result.getThrowable());
		extest.log(LogStatus.FAIL, extest.addScreenCapture("D:\\Jagan\\NostAuto\\NostCore\\NostArtifact\\Screenshots\\"+imagename));
		exreport.endTest(extest);
		exreport.flush();
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("'On Test Skipped' invoked for "+result.getName());
		extest.log(LogStatus.SKIP,"'On Test Skipped' invoked for "+result.getName());
		exreport.endTest(extest);
		exreport.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		log.info("'On Test Failed with Timeout' invoked for "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	
}
