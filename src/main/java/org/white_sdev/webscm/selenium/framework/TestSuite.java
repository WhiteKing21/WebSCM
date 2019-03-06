/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.white_sdev.webscm.selenium.framework;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;
import org.white_sdev.webscm.selenium.exception.WebSCMSeleniumException;
import static org.white_sdev.webscm.selenium.logger.WLogger.info;

/**
 *
 * 
 * @since Jan 26, 2019
 */
public class TestSuite {
    
    
    /**
     * The default {@link org.slf4j.Logger logger} of the class.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-05
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(TestSuite.class);

    /**
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-05
     * @return The default {@link org.slf4j.Logger logger} of the class.
     */
    public static Logger getLogger() {
	return LOGGER;
    }
    
    /**
     * This is used by the method {@link #normalize(java.lang.String) } to improve the performance of the normalization process.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-06
     */
    public static String tabber=null;
    
    /**
     * A simple implementation to visualize more organized method signatures in the {@link org.slf4j.Logger logs}.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-06
     * @param methodSignature	This is the method signature to normalize with the number of tabs configured in the properties
     * @return			The signature normalized with the same number of characters (filled with tabs) than the rest of the normalized methods.
     */
    public static String normalize(String methodSignature){
	try{
	    if(tabber==null){
		String numberOfTabsConfigured=getProperty("normalized-logger-tabs");
		Integer spaces=8*(numberOfTabsConfigured!=null?Integer.parseInt(numberOfTabsConfigured):7);
		Integer tabs=(spaces-(TestSuite.class.getSimpleName().length()+" - ".length()+methodSignature.length()))/8;
		tabber=methodSignature;
		for(int i=0;i<tabs;i++){
		    tabber+="\t";
		}
	    }
	    return tabber; 
	}catch(Exception ex){
	    throw new WebSCMSeleniumException("An error has ocurred while configuring the class logger. Impossible to configure the number of tabs required to log.",ex);
	}
    }
    
    //TODO OV: Generate documentation
    public static List<TestCase> tests = new ArrayList<>();

    public static void registerTest(TestCase testCase) {
	tests.add(testCase);
    }
    
    public static void registerTests(Set<TestCase> testCases) {
	testCases.forEach((testCase)->{
	    tests.add(testCase);
	});
	
    }
    
    
    public void testSuite() throws Exception {
	runSetUp();
	for (Map.Entry<Class<?  extends WebDriver>, Boolean> driverEntry : getDrivers().entrySet()) {
	    if (driverEntry.getValue()) {
		executeTests(driverEntry.getKey());
	    }
	}
    }

    public static void launchTests() throws Exception {
	info("launchTests() - Start","Launching Tests.");
	new TestSuite().testSuite();
	info("launchTests() - Finish","All tests were excecuted successfully.");
    }

    private void runSetUp() {
	WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
	WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
	WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
    }

    private HashMap<Class<?  extends WebDriver>, Boolean> getDrivers() throws IOException {
	HashMap<Class<?  extends WebDriver>, Boolean> drivers;
	drivers = new LinkedHashMap<Class<?  extends WebDriver>, Boolean>() {{
		put(ChromeDriver.class, Boolean.parseBoolean(getProperty("run.tests.chrome")) );
		put(InternetExplorerDriver.class, Boolean.parseBoolean(getProperty("run.tests.ie")));
		put(EdgeDriver.class, Boolean.parseBoolean(getProperty("run.tests.edge")));
		put(FirefoxDriver.class, Boolean.parseBoolean(getProperty("run.tests.firefox")));
		put(OperaDriver.class, Boolean.parseBoolean(getProperty("run.tests.opera")));
	}};

	return drivers;
    }

    private void executeTests(Class driver) throws Exception {
	for (TestCase test : tests) {
	    info("executeTests(driver)", "Excecuting ["+test.getTestFullName()+"] test case over ["+driver.getSimpleName()+"]");
	    test.performTest(driver);
	    info("executeTests(driver)", "Test case ["+test.getTestFullName()+"] Excecuted successfully over ["+driver.getSimpleName()+"]");
	}
    }

}
