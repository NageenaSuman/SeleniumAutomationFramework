package org.nageena.Listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListeners implements IAnnotationTransformer{
    // the below codes has been auto generated except if condition , click on generate --> override method
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
       // IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
        // only the above code needs to be replaced with below
        annotation.setRetryAnalyzer(RetryAnalyser.class);
    }
}
