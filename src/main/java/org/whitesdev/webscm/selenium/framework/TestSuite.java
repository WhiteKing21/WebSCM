/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.whitesdev.webscm.selenium.framework;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;

/**
 *
 * 
 * @since Jan 26, 2019
 */
public class TestSuite {
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
	new TestSuite().testSuite();
    }

    private void runSetUp() {
	WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
	WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
	WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
    }

    private HashMap<Class<?  extends WebDriver>, Boolean> getDrivers() throws IOException {
	HashMap<Class<?  extends WebDriver>, Boolean> drivers;
	drivers = new HashMap<Class<?  extends WebDriver>, Boolean>() {{
		put(ChromeDriver.class, Boolean.parseBoolean(getProperty("run.tests.chrome")) );
		put(InternetExplorerDriver.class, Boolean.parseBoolean(getProperty("run.tests.ie")));
		put(EdgeDriver.class, Boolean.parseBoolean(getProperty("run.tests.edge")));
	}};

	return drivers;
    }

    private void executeTests(Class driver) throws Exception {
	for (TestCase test : tests) {
	    test.performTest(driver);
	}
    }

}
