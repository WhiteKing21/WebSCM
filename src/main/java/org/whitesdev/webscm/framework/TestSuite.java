/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.whitesdev.webscm.framework;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.white_sdev.propertiesmanager.model.service.PropertiesManager;

/**
 *
 * 
 * @since Jan 26, 2019
 */
public class TestSuite {

    public void testSuite() throws Exception {
	runSetUp();
	for (Map.Entry<Class<?  extends WebDriver>, Boolean> driverEntry : getDrivers().entrySet()) {
	    if (driverEntry.getValue()) {
		executeTests(driverEntry.getKey());
	    }
	}
    }

    public List<TestCase> tests = new ArrayList<>();

    private TestSuite() {
	super();
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
		put(ChromeDriver.class, Boolean.parseBoolean(PropertiesManager.getProperty("runChromeTests").toString()) );
		put(InternetExplorerDriver.class, Boolean.parseBoolean(PropertiesManager.getProperty("runIETests").toString()));
		put(EdgeDriver.class, Boolean.parseBoolean(PropertiesManager.getProperty("runEdgeTests").toString()));
	}};

	return drivers;
    }

    private void executeTests(Class driver) throws Exception {
	for (TestCase test : tests) {
	    test.performTest(driver);
	}
    }

}
