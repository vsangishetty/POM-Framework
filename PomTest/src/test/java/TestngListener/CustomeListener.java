package TestngListener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;


import com.crm.qa.utils.TestUtil;


public class CustomeListener extends TestUtil implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
