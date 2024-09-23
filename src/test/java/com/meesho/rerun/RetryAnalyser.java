package com.meesho.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int i=0,j=2;
	public boolean retry(ITestResult result) {
		if(i<j) {//0<2,1<2,2<2
			i++;//1,2,3
		return true;//if we give false condition wont try again ,only true conditions gets retry 
	}
return false;
}
}