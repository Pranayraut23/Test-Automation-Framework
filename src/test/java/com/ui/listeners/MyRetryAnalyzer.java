package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;


public class MyRetryAnalyzer implements IRetryAnalyzer{// IRetryAnalyzer inter gives you information for failed test case
	
	private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTTEMPTS")) ;
	
	//private static final int MAX_NUMBER_OF_ATTEMPTS= JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currrentAttempt = 1;
	
	@Override
	public boolean retry(ITestResult result) {// ITestresult will give information about test . 
		
		if(currrentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currrentAttempt++;
			return true;
			
		}
		return false;
	}

}
