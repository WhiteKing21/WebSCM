
package org.whitesdev.webscm.selenium;

import org.whitesdev.webscm.selenium.framework.TestSuite;
import org.whitesdev.webscm.selenium.zrec.CreateRequisition;

/**
 *
 * 
 * @since Jan 19, 2019
 */
public class Main {

    public static void main(String[] args) throws Exception {
	//System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
	
	TestSuite.registerTest(new CreateRequisition());
	TestSuite.launchTests();
	
    }
}
