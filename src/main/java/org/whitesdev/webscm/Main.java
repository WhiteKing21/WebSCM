
package org.whitesdev.webscm;

import org.whitesdev.webscm.framework.TestSuite;

/**
 *
 * 
 * @since Jan 19, 2019
 */
public class Main {

    public static void main(String[] args) throws Exception {
	System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "info");
	TestSuite.launchTests();
	
    }
}
