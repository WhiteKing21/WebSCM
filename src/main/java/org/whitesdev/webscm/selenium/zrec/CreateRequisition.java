/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.whitesdev.webscm.selenium.zrec;

import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.whitesdev.webscm.selenium.framework.TestCase;
import org.whitesdev.webscm.selenium.framework.WebDriverUtils;
import org.whitesdev.webscm.selenium.exception.WebSCMSeleniumException;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.*;

/**
 *
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Feb 23, 2019
 */
public class CreateRequisition extends TestCase {

    LinkedHashSet<String> materialNestedFrames = new LinkedHashSet<>() {
	{
	    add("contentAreaFrame");
	    add("isolatedWorkArea");
	    add("isaTop");
	    add("organizer_content");
	}
    };
    LinkedHashSet<String> productsNestedFrames = new LinkedHashSet<>() {
	{
	    add("contentAreaFrame");
	    add("isolatedWorkArea");
	    add("isaTop");
	    add("work_history");
	    add("form_input");
	    add("productsFrame");
	}
    };
    LinkedHashSet<String> productDetailNestedFrames = new LinkedHashSet<>() {
	{
	    add("contentAreaFrame");
	    add("isolatedWorkArea");
	    add("isaTop");
	    add("work_history");
	    add("form_input");
	    add("positions");
	}
    };
    LinkedHashSet<String> cartNestedFrames = new LinkedHashSet<>() {
	{
	    add("contentAreaFrame");
	    add("isolatedWorkArea");
	    add("isaTop");
	    add("header");
	}
    };
    LinkedHashSet<String> shopCartNestedFrames = new LinkedHashSet<>() {
	{
	    add("contentAreaFrame");
	    add("isolatedWorkArea");
	    add("isaTop");
	    add("work_history");
	    add("form_input");
	}
    };

    /**
     * The default {@link org.slf4j.Logger logger} of the class.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since {date}
     */
    public final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since {date}
     * @return The default {@link org.slf4j.Logger logger} of the class.
     */
    public Logger getLogger() {
	return LOGGER;
    }

    @Override
    public void test(WebDriver driver) {
	try {
	    
	    WebDriverUtils util=initPage(driver);
	    login(util);
	    addToCart(util);
	    finishOrder(util);

	} catch (Exception ex) {
	    getLogger().error("::test(driver): An error has ocurred while testing CreateRequisition. \n Caused by:", ex);
	    JOptionPane.showMessageDialog(null, "An error has ocurred while testing CreateRequisition. \n Caused by: " + ex);
	}

    }
    
    private WebDriverUtils initPage(WebDriver driver) {
	super.quitOnFinish = false;//generating mode
	WebDriverUtils util = new WebDriverUtils(driver);
	driver.get(getProperty("webscm.url"));
	return util;
    }

    private void login(WebDriverUtils util) {
	util.writeId("USERID", getProperty("webscm.createreq.user"));
	util.writeId("PASS", getProperty("webscm.createreq.pass"));

	util.clickId("ibLogin");
    }

    private void addToCart(WebDriverUtils util) throws InterruptedException {
	util.clickId("tabIndex1");
	util.clickId("bc2", 3);//Order Management
	Thread.sleep(2000);
	util.writeName("query", getProperty("webscm.createreq.material"), materialNestedFrames);
	util.clickName("Search"); // Search button
	util.frameReloading();
	util.clickClass("basket-img", productsNestedFrames);

	util.frameReloading();
	//"text-value"
	String loadQuantity = util.textFromXpath("/html/body/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]", productDetailNestedFrames);
	util.writeId("deliveryquantity[0]", loadQuantity);
	util.clickXpath("/html/body/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr[16]/td/a");
    }

    private void finishOrder(WebDriverUtils util) {
	util.clickId("basketlinktext", cartNestedFrames, 10);

	util.frameReloading();
	util.clickXpath("/html/body/div[2]/form/div[4]/div/ul[2]/li[4]/a", shopCartNestedFrames); //order

	util.acceptAlert();
    }

    
}
