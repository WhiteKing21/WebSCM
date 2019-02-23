
package org.whitesdev.webscm.framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

/**
 *
 * @
 */
public abstract class TestCase{
    public void performTest(Class<WebDriver> driverClass) throws Exception{
	WebDriver driver=initialize(driverClass);
	test(driver);
	driver.quit();
    }

    public WebDriver initialize(Class<WebDriver> driverClass) throws Exception{
	WebDriver driver= driverClass.getDeclaredConstructor().newInstance();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    
	driver.manage().window().maximize();
	return driver;
    }

    public abstract void test(WebDriver driver) throws Exception;
}
