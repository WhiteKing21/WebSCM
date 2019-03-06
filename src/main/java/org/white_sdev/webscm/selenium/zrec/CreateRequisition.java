/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.white_sdev.webscm.selenium.zrec;

import java.util.LinkedHashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.white_sdev.webscm.selenium.framework.TestCase;
import org.white_sdev.webscm.selenium.framework.WebDriverUtils;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.*;
import org.white_sdev.webscm.selenium.exception.WebSCMSeleniumException;
import static org.white_sdev.webscm.selenium.logger.WLogger.debug;
import static org.white_sdev.webscm.selenium.logger.WLogger.info;
import static org.white_sdev.webscm.selenium.logger.WLogger.trace;

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
     * @since 2019-03-06
     */
    public final Logger LOGGER = LoggerFactory.getLogger(getClass());

    
    /**
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-06
     * @return The default {@link org.slf4j.Logger logger} of the class.
     */
    public Logger getLogger() {
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
    public String normalize(String methodSignature){
	try{
	    if(tabber==null){
		String numberOfTabsConfigured=getProperty("normalized-logger-tabs");
		Integer spaces=8*(numberOfTabsConfigured!=null?Integer.parseInt(numberOfTabsConfigured):7);
		Integer tabs=(spaces-(getClass().getSimpleName().length()+" - ".length()+methodSignature.length()))/8;
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
    
    @Override
    public String getTestFullName() {
	return "REQ Create Requisition Order";
    }

    @Override
    public void test(WebDriver driver) {
	info("test(driver) - Start","Launching Create Requisition Tests");
	WebDriverUtils util=initPage(driver);
	try {
	    
	    
	    login(util);
	    addToCart(util);
	    finishOrder(util);
	    String path=util.takeScreenShot(this);
	    
	    info("test(driver) - Finish","Create Requisition Test Finished successfully. Evidences saved in: "+path);

	} catch (Exception ex) {
	    throw new WebSCMSeleniumException("An error has ocurred while testing CreateRequisition",ex);
	}

    }
    
    private WebDriverUtils initPage(WebDriver driver) {
	//super.quitOnFinish = false;//generating mode
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
	trace("addToCart(util) - Start","Adding material to the cart.");
	
	trace("addToCart(util)","Next Action: Clicking Operations Tab");
	util.clickId("tabIndex1");
	
	trace("addToCart(util)","Completed: Operations Tab Clicked - Next Action: Clicking Order Management menu");
	util.clickId("bc2", 5);
	
	trace("addToCart(util)","Completed: Order Management menu Clicked - Next Action: Writting Material ");
	Thread.sleep(2000);
	util.writeName("query", getProperty("webscm.createreq.material"), materialNestedFrames); //Input del material
	
	trace("addToCart(util)","Completed: Material Writed - Next Action: Clicking Search Button");
	Thread.sleep(2000);
	util.clickName("Search"); // Search button
	
	trace("addToCart(util)","Completed: Search Button Clicked - Next Action: Clicking Basket Image");
	util.frameReloading();
	util.clickClass("basket-img", productsNestedFrames);
	
	trace("addToCart(util)","Completed: Basket Image Clicked - Next Action: Reading material Quantity ");
	util.frameReloading();
	//"text-value"
	Integer loadQuantity = (Double.valueOf(util.textFromXpath("/html/body/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr[4]/td/span[2]", productDetailNestedFrames))).intValue();
	
	trace("addToCart(util)","Completed: material Quantity read - Next Action: Writing material Quantity in table ");
	util.writeId("deliveryquantity[0]", loadQuantity.toString());
	
	trace("addToCart(util)","Completed: Writing material Quantity in table - Next Action: Clicking Add to cart");
	util.frameReloading();
	util.clickXpath("/html/body/div[2]/table[2]/tbody/tr/td[2]/table/tbody/tr[16]/td/a",productDetailNestedFrames);
	
	trace("addToCart(util) - Finish","Add to cart Clicked");
    }

    private void finishOrder(WebDriverUtils util) throws InterruptedException {
	trace("finishOrder(util) - Start","finishing Order.");
	
	trace("finishOrder(util)","Next Action: Clicking Basket Image.");
	if(util.isEdgeBeingTested()){
	    debug("finishOrder(util)","Taking Deviation due to Edge");
	    focusEdgeFrame(util);
	    util.clickId("basketlinktext", 10);
	}else{
	    LinkedHashSet<String> cartNestedFrames = new LinkedHashSet<>() {
		{
		    add("contentAreaFrame");
		    add("isolatedWorkArea");
		    add("isaTop");
		    add("header");
		}
	    };
	    util.clickId("basketlinktext", cartNestedFrames, 10);
	}
	
	trace("finishOrder(util)","Completed: Basket Image Clicked - Next Action: Selecting (Dropdown): Deliver To ");
	util.frameReloading();
	util.focus(shopCartNestedFrames); // Failed to switch to: form_input in Edge [1] & Chrome [2]
	Select deliverTo=new Select(util.driver.findElement(By.id("headerShipTo"))); //Select (Dropdown): Deliver To 
	deliverTo.selectByIndex(2);
	
	trace("finishOrder(util)","Completed: Selected (Dropdown): Deliver To - Next Action: Click Checkbox");
	util.clickId("shipToSelect1");//checkbox
	
	trace("finishOrder(util)","Completed: Click Checkbox - Next Action: Click Update");
	util.clickId("myRefresh");//Update
	
	trace("finishOrder(util)","Completed: Click Update - Next Action: Click Order Button");
	util.frameReloading();
	util.clickXpath("/html/body/div[2]/form/div[4]/div/ul[2]/li[4]/a",shopCartNestedFrames); //order
	
	trace("finishOrder(util)","Completed: Click Order Button - Next Action: Closing Accepting Alert");
	util.acceptAlert();
	
	trace("::finishOrder(util) - Finish","Completed: Closing Accepting Alert - Order Finished");
    }

    private void focusEdgeFrame(WebDriverUtils util) throws InterruptedException {
	util.frameReloading();
	Thread.sleep(1000);
	util.driver.switchTo().frame("contentAreaFrame");
	Thread.sleep(1000);
	util.driver.switchTo().frame("isolatedWorkArea");
	Thread.sleep(1000);
	
	util.driver.switchTo().frame(util.driver.findElement(By.xpath("/html/frameset/frame"))); //this frame does not work in Edge o.O
	Thread.sleep(1000);
	
	util.driver.switchTo().frame("header");
	Thread.sleep(1000);
    }

    
}
