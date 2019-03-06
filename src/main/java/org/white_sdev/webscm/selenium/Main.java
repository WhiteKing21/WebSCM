
package org.white_sdev.webscm.selenium;

import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.white_sdev.webscm.selenium.framework.TestSuite;
import org.white_sdev.webscm.selenium.zrec.CreateRequisition;

/**
 *
 * 
 * @since Jan 19, 2019
 */
public class Main {

    
    /**
     * The default {@link org.slf4j.Logger logger} of the class.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-05
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-05
     * @return The default {@link org.slf4j.Logger logger} of the class.
     */
    public static Logger getLogger() {
	return LOGGER;
    }
    
    
    public static void main(String[] args) throws Exception {
	try{
	    
	    TestSuite.registerTest(new CreateRequisition());
	    TestSuite.launchTests();
	    
	    
	}catch(Exception ex){
	    getLogger().error("Exception while excecuting a test",ex);
	    JOptionPane.showMessageDialog(null, ex);
	    System.exit(0);
	}
    }
}
