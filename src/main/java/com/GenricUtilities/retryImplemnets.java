package com.GenricUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryImplemnets implements IRetryAnalyzer {

	int count  = 0;
	int retryLimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if (count<retryLimit) {
			count++;
			return true;
		}

		
		return false;
	}

}
