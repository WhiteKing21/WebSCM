
package org.white_sdev.webscm.selenium.framework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;

/**
 *
 * @
 */
public abstract class TestCase{
    
    public Boolean quitOnFinish=true;
    public final PrintStream SYSTEM_OUT=System.out;
    public final PrintStream SYSTEM_ERR=System.err;
    
    public void performTest(Class<WebDriver> driverClass) throws Exception{
	WebDriver driver=initialize(driverClass);
	test(driver);
	if(quitOnFinish)driver.quit();
	quitOnFinish=true;
    }

    public WebDriver initialize(Class<WebDriver> driverClass) throws Exception{
	disableLogs();
	WebDriver driver= driverClass.getDeclaredConstructor().newInstance();	
	String wait=getProperty("implicit-wait");
	if(wait!=null) driver.manage().timeouts().implicitlyWait(Long.parseLong(wait), TimeUnit.SECONDS);
	if(Boolean.valueOf(getProperty("maximize-on-open"))) driver.manage().window().maximize();
	enableLogs();
	return driver;
    }

    public abstract void test(WebDriver driver) throws Exception;
    
    public abstract String getTestFullName();

    public void disableLogs() {
	System.setOut(
	    new PrintStream(new OutputStream() { 
		@Override
		public  void    close() {}
		@Override
		public  void    flush() {}
		@Override
		public  void    write(byte[] b) {}
		@Override
		public  void    write(byte[] b, int off, int len) {}
		@Override
		public  void    write(int b) {}

	    }));
	System.setErr(
	    new PrintStream(new OutputStream() { 
		@Override
		public  void    close() {}
		@Override
		public  void    flush() {}
		@Override
		public  void    write(byte[] b) {}
		@Override
		public  void    write(byte[] b, int off, int len) {}
		@Override
		public  void    write(int b) {}

	    }));
    }

    public void enableLogs() {
	System.setOut(SYSTEM_OUT);
	System.setErr(SYSTEM_ERR);
    }
}
