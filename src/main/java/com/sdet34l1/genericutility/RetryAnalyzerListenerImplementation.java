package com.sdet34l1.genericutility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzerListenerImplementation implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.sdet34l1.genericutility.ReferenceAnalyserImplementation.class);
		
	}
	
	

}
