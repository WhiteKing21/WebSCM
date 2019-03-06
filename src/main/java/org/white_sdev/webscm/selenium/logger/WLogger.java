/*
 *  Filename:  WLogger.java
 *  Creation Date:  Mar 6, 2019
 *  Purpose:   [short Description]
 *  Author:    Obed Vazquez
 *  E-mail:    obed.vazquez@gmail.com
 * 
 *  Web Version:https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 *  *** ATTRIBUTION-NONCOMMERCIAL-SHAREALIKE 4.0 INTERNATIONAL (CC BY-NC-SA 4.0) ***
 * 
 * By exercising the Licensed Rights (defined below), You accept and agree to be bound by the terms and conditions of this 
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International Public License ("Public License"). To the extent this Public License may be interpreted as 
 * a contract, You are granted the Licensed Rights in consideration of Your acceptance of these terms and conditions, and the Licensor grants You such rights in 
 * consideration of benefits the Licensor receives from making the Licensed Material available under these terms and conditions.
 * 
 * Section 1 – Definitions.
 * 
 * Adapted Material means material subject to Copyright and Similar Rights that is derived from or based upon the Licensed Material and in which the Licensed Material 
 * is translated, altered, arranged, transformed, or otherwise modified in a manner requiring permission under the Copyright and Similar Rights held by the Licensor. 
 * For purposes of this Public License, where the Licensed Material is a musical work, performance, or sound recording, Adapted Material is always produced where the 
 * Licensed Material is synched in timed relation with a moving image.
 * Adapter's License means the license You apply to Your Copyright and Similar Rights in Your contributions to Adapted Material in accordance with the terms and 
 * conditions of this Public License.
 * BY-NC-SA Compatible License means a license listed at creativecommons.org/compatiblelicenses, approved by Creative Commons as essentially the equivalent of this 
 * Public License.
 * Copyright and Similar Rights means copyright and/or similar rights closely related to copyright including, without limitation, performance, broadcast, sound 
 * recording, and Sui Generis Database Rights, without regard to how the rights are labeled or categorized. For purposes of this Public License, the rights specified 
 * in Section 2(b)(1)-(2) are not Copyright and Similar Rights.
 * Effective Technological Measures means those measures that, in the absence of proper authority, may not be circumvented under laws fulfilling obligations under 
 * Article 11 of the WIPO Copyright Treaty adopted on December 20, 1996, and/or similar international agreements.
 * Exceptions and Limitations means fair use, fair dealing, and/or any other exception or limitation to Copyright and Similar Rights that applies to Your use of the 
 * Licensed Material.
 * License Elements means the license attributes listed in the name of a Creative Commons Public License. The License Elements of this Public License are Attribution, 
 * NonCommercial, and ShareAlike.
 * Licensed Material means the artistic or literary work, database, or other material to which the Licensor applied this Public License.
 * Licensed Rights means the rights granted to You subject to the terms and conditions of this Public License, which are limited to all Copyright and Similar Rights 
 * that apply to Your use of the Licensed Material and that the Licensor has authority to license.
 * Licensor means the individual(s) or entity(ies) granting rights under this Public License.
 * NonCommercial means not primarily intended for or directed towards commercial advantage or monetary compensation. For purposes of this Public License, the exchange 
 * of the Licensed Material for other material subject to Copyright and Similar Rights by digital file-sharing or similar means is NonCommercial provided there is no 
 * payment of monetary compensation in connection with the exchange.
 * Share means to provide material to the public by any means or process that requires permission under the Licensed Rights, such as reproduction, public display, 
 * public performance, distribution, dissemination, communication, or importation, and to make material available to the public including in ways that members of the 
 * public may access the material from a place and at a time individually chosen by them.
 * Sui Generis Database Rights means rights other than copyright resulting from Directive 96/9/EC of the European Parliament and of the Council of 11 March 1996 on 
 * the legal protection of databases, as amended and/or succeeded, as well as other essentially equivalent rights anywhere in the world.
 * You means the individual or entity exercising the Licensed Rights under this Public License. Your has a corresponding meaning.
 * Section 2 – Scope.
 * 
 * License grant.
 * Subject to the terms and conditions of this Public License, the Licensor hereby grants You a worldwide, royalty-free, non-sublicensable, non-exclusive, irrevocable 
 * license to exercise the Licensed Rights in the Licensed Material to:
 * reproduce and Share the Licensed Material, in whole or in part, for NonCommercial purposes only; and
 * produce, reproduce, and Share Adapted Material for NonCommercial purposes only.
 * Exceptions and Limitations. For the avoidance of doubt, where Exceptions and Limitations apply to Your use, this Public License does not apply, and You do not need 
 * to comply with its terms and conditions.
 * Term. The term of this Public License is specified in Section 6(a).
 * Media and formats; technical modifications allowed. The Licensor authorizes You to exercise the Licensed Rights in all media and formats whether now known or 
 * hereafter created, and to make technical modifications necessary to do so. The Licensor waives and/or agrees not to assert any right or authority to forbid You 
 * from making technical modifications necessary to exercise the Licensed Rights, including technical modifications necessary to circumvent Effective Technological 
 * Measures. For purposes of this Public License, simply making modifications authorized by this Section 2(a)(4) never produces Adapted Material.
 * Downstream recipients.
 * Offer from the Licensor – Licensed Material. Every recipient of the Licensed Material automatically receives an offer from the Licensor to exercise the Licensed 
 * Rights under the terms and conditions of this Public License.
 * Additional offer from the Licensor – Adapted Material. Every recipient of Adapted Material from You automatically receives an offer from the Licensor to exercise 
 * the Licensed Rights in the Adapted Material under the conditions of the Adapter’s License You apply.
 * No downstream restrictions. You may not offer or impose any additional or different terms or conditions on, or apply any Effective Technological Measures to, the 
 * Licensed Material if doing so restricts exercise of the Licensed Rights by any recipient of the Licensed Material.
 * No endorsement. Nothing in this Public License constitutes or may be construed as permission to assert or imply that You are, or that Your use of the Licensed 
 * Material is, connected with, or sponsored, endorsed, or granted official status by, the Licensor or others designated to receive attribution as provided in 
 * Section 3(a)(1)(A)(i).
 * 
 * Other rights.
 * 
 * Moral rights, such as the right of integrity, are not licensed under this Public License, nor are publicity, privacy, and/or other similar personality rights; 
 * however, to the extent possible, the Licensor waives and/or agrees not to assert any such rights held by the Licensor to the limited extent necessary to allow You 
 * to exercise the Licensed Rights, but not otherwise.
 * Patent and trademark rights are not licensed under this Public License.
 * To the extent possible, the Licensor waives any right to collect royalties from You for the exercise of the Licensed Rights, whether directly or through a 
 * collecting society under any voluntary or waivable statutory or compulsory licensing scheme. In all other cases the Licensor expressly reserves any right to 
 * collect such royalties, including when the Licensed Material is used other than for NonCommercial purposes.
 * Section 3 – License Conditions.
 * 
 * Your exercise of the Licensed Rights is expressly made subject to the following conditions.
 * 
 * Attribution.
 * 
 * If You Share the Licensed Material (including in modified form), You must:
 * 
 * retain the following if it is supplied by the Licensor with the Licensed Material:
 * identification of the creator(s) of the Licensed Material and any others designated to receive attribution, in any reasonable manner requested by the Licensor 
 * (including by pseudonym if designated);
 * a copyright notice;
 * a notice that refers to this Public License;
 * a notice that refers to the disclaimer of warranties;
 * a URI or hyperlink to the Licensed Material to the extent reasonably practicable;
 * indicate if You modified the Licensed Material and retain an indication of any previous modifications; and
 * indicate the Licensed Material is licensed under this Public License, and include the text of, or the URI or hyperlink to, this Public License.
 * You may satisfy the conditions in Section 3(a)(1) in any reasonable manner based on the medium, means, and context in which You Share the Licensed Material. 
 * For example, it may be reasonable to satisfy the conditions by providing a URI or hyperlink to a resource that includes the required information.
 * If requested by the Licensor, You must remove any of the information required by Section 3(a)(1)(A) to the extent reasonably practicable.
 * ShareAlike.
 * In addition to the conditions in Section 3(a), if You Share Adapted Material You produce, the following conditions also apply.
 * 
 * The Adapter’s License You apply must be a Creative Commons license with the same License Elements, this version or later, or a BY-NC-SA Compatible License.
 * You must include the text of, or the URI or hyperlink to, the Adapter's License You apply. You may satisfy this condition in any reasonable manner based on the 
 * medium, means, and context in which You Share Adapted Material.
 * You may not offer or impose any additional or different terms or conditions on, or apply any Effective Technological Measures to, Adapted Material that restrict 
 * exercise of the rights granted under the Adapter's License You apply.
 * Section 4 – Sui Generis Database Rights.
 * 
 * Where the Licensed Rights include Sui Generis Database Rights that apply to Your use of the Licensed Material:
 * 
 * for the avoidance of doubt, Section 2(a)(1) grants You the right to extract, reuse, reproduce, and Share all or a substantial portion of the contents of the 
 * database for NonCommercial purposes only;
 * if You include all or a substantial portion of the database contents in a database in which You have Sui Generis Database Rights, then the database in which You 
 * have Sui Generis Database Rights (but not its individual contents) is Adapted Material, including for purposes of Section 3(b); and
 * You must comply with the conditions in Section 3(a) if You Share all or a substantial portion of the contents of the database.
 * For the avoidance of doubt, this Section 4 supplements and does not replace Your obligations under this Public License where the Licensed Rights include other 
 * Copyright and Similar Rights.
 * Section 5 – Disclaimer of Warranties and Limitation of Liability.
 * 
 * Unless otherwise separately undertaken by the Licensor, to the extent possible, the Licensor offers the Licensed Material as-is and as-available, and makes no 
 * representations or warranties of any kind concerning the Licensed Material, whether express, implied, statutory, or other. This includes, without limitation, 
 * warranties of title, merchantability, fitness for a particular purpose, non-infringement, absence of latent or other defects, accuracy, or the presence or absence 
 * of errors, whether or not known or discoverable. Where disclaimers of warranties are not allowed in full or in part, this disclaimer may not apply to You.
 * To the extent possible, in no event will the Licensor be liable to You on any legal theory (including, without limitation, negligence) or otherwise for any direct, 
 * special, indirect, incidental, consequential, punitive, exemplary, or other losses, costs, expenses, or damages arising out of this Public License or use of the 
 * Licensed Material, even if the Licensor has been advised of the possibility of such losses, costs, expenses, or damages. Where a limitation of liability is not 
 * allowed in full or in part, this limitation may not apply to You.
 * The disclaimer of warranties and limitation of liability provided above shall be interpreted in a manner that, to the extent possible, most closely approximates an 
 * absolute disclaimer and waiver of all liability.
 * Section 6 – Term and Termination.
 * 
 * This Public License applies for the term of the Copyright and Similar Rights licensed here. However, if You fail to comply with this Public License, then Your 
 * rights under this Public License terminate automatically.
 * Where Your right to use the Licensed Material has terminated under Section 6(a), it reinstates:
 * 
 * automatically as of the date the violation is cured, provided it is cured within 30 days of Your discovery of the violation; or
 * upon express reinstatement by the Licensor.
 * For the avoidance of doubt, this Section 6(b) does not affect any right the Licensor may have to seek remedies for Your violations of this Public License.
 * For the avoidance of doubt, the Licensor may also offer the Licensed Material under separate terms or conditions or stop distributing the Licensed Material at any 
 * time; however, doing so will not terminate this Public License.
 * Sections 1, 5, 6, 7, and 8 survive termination of this Public License.
 * Section 7 – Other Terms and Conditions.
 * 
 * The Licensor shall not be bound by any additional or different terms or conditions communicated by You unless expressly agreed.
 * Any arrangements, understandings, or agreements regarding the Licensed Material not stated herein are separate from and independent of the terms and conditions of 
 * this Public License.
 * Section 8 – Interpretation.
 * 
 * For the avoidance of doubt, this Public License does not, and shall not be interpreted to, reduce, limit, restrict, or impose conditions on any use of the Licensed 
 * Material that could lawfully be made without permission under this Public License.
 * To the extent possible, if any provision of this Public License is deemed unenforceable, it shall be automatically reformed to the minimum extent necessary to make 
 * it enforceable. If the provision cannot be reformed, it shall be severed from this Public License without affecting the enforceability of the remaining terms and 
 * conditions.
 * No term or condition of this Public License will be waived and no failure to comply consented to unless expressly agreed to by the Licensor.
 * Nothing in this Public License constitutes or may be interpreted as a limitation upon, or waiver of, any privileges and immunities that apply to the Licensor or 
 * You, including from the legal processes of any jurisdiction or authority.
 * 
 * Creative Commons may be contacted at creativecommons.org.
 */
package org.white_sdev.webscm.selenium.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;

/**
 *
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Mar 6, 2019
 */
public class WLogger {

    public static Map<Class<?>, Logger> loggers = new HashMap<>();
    public static Boolean levelInBrackets=null;
    
    /**
     * A simple implementation to visualize more organized method signatures 
     * in the {@link org.slf4j.Logger logs}.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @param callerClassNameLenght Size of the caller class name.
     * @param methodSignatureLenght Size of the method signature. for example: here is this method signature
     *		    <code> getNormalizerTabs(callerClassNameLenght, methodSignatureLenght) </code> and it has length of 63
     * @since	    2019-03-06
     * @return	    The signature normalized with the same 
     *		    number of characters (filled with tabs) than the rest 
     *		    of the normalized methods.
     */
    public static String getNormalizerTabs(Integer callerClassNameLenght, Integer methodSignatureLenght){
	try{
	    String numberOfTabsConfigured=getProperty("normalized-logger-tabs","simplelogger.properties");
	    Integer spaces= 8*(numberOfTabsConfigured!=null? Integer.parseInt(numberOfTabsConfigured) : 7);
	    Integer numOftabs=(spaces-(callerClassNameLenght+(" - ".length()) +methodSignatureLenght))/8;
	    Integer leftOver=(spaces-(callerClassNameLenght+(" - ".length()) +methodSignatureLenght))%8;
	    if(leftOver>0) numOftabs++;
	    
	    StringBuilder tabs=new StringBuilder();
	    for(int i=0;i<numOftabs;i++){
		tabs.append("\t");
	    }
	    return tabs.toString(); 
	}catch(Exception ex){
	    throw new RuntimeException("An error has occurred while configuring the class logger. Impossible to configure the number of tabs required to log.",ex);
	}
    }
    
    public static Logger getLogger(Class<?> callerClass) {
	try{
	    if(callerClass==null) callerClass=Class.forName(getCallerClassName());
	    Logger logger=loggers.get(callerClass);
	    if(logger==null){
		logger=LoggerFactory.getLogger(callerClass);
		loggers.put(callerClass, logger);
	    }
	    return logger;
	}catch(Exception ex){
	    throw new RuntimeException("Impossible to obtain the logger",ex);
	}
    }

    public static String getCallerClassName() {
	StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
	for (int i = 1; i < stElements.length; i++) {
	    StackTraceElement ste = stElements[i];
	    if (!ste.getClassName().equals(WLogger.class.getName()) && ste.getClassName().indexOf("java.lang.Thread") != 0) {
		return ste.getClassName();
	    }
	}
	return null;
    }

    
    //<editor-fold defaultstate="collapsed" desc="Default">
    public static String getName() {
	return getName(null);
    }

    public static boolean isTraceEnabled() {
	return isTraceEnabled((Class<?>)null);
    }

    public static void trace(String msg) {
	trace((Class<?>)null,msg);
    }

    public static void trace(String format, Object arg) {
	trace((Class<?>)null,format,arg);
    }

    public static void trace(String format, Object arg1, Object arg2) {
	trace((Class<?>)null,format,arg1,arg2);
    }

    public static void trace(String format, Object... arguments) {
	trace((Class<?>)null,format,arguments);
    }

    public static void trace(String msg, Throwable t) {
	trace((Class<?>)null,msg,t);
    }

    public static boolean isTraceEnabled(Marker marker) {
	return isTraceEnabled((Class<?>)null,marker);
    }

    public static void trace(Marker marker, String msg) {
	trace((Class<?>)null,marker,msg);
    }

    public static void trace(Marker marker, String format, Object arg) {
	trace((Class<?>)null,marker,format,arg);
    }

    public static void trace(Marker marker, String format, Object arg1, Object arg2) {
	trace((Class<?>)null,marker,format,arg1,arg2);
    }

    public static void trace(Marker marker, String format, Object... argArray) {
	trace((Class<?>)null,marker,format,argArray);
    }

    public static void trace(Marker marker, String msg, Throwable t) {
	trace((Class<?>)null,marker,msg,t);
    }


    public static boolean isDebugEnabled() {
	return isDebugEnabled((Class<?>)null);
    }

    public static void debug(String msg) {
	debug((Class<?>)null,msg);
    }

    public static void debug(String format, Object arg) {
	debug((Class<?>)null,format,arg);
    }

    public static void debug(String format, Object arg1, Object arg2) {
	debug((Class<?>)null,format,arg1,arg2);
    }

    public static void debug(String format, Object... arguments) {
	debug((Class<?>)null,format,arguments);
    }

    public static void debug(String msg, Throwable t) {
	debug((Class<?>)null,msg,t);
    }

    public static boolean isDebugEnabled(Marker marker) {
	return isDebugEnabled((Class<?>)null,marker);
    }

    public static void debug(Marker marker, String msg) {
	debug((Class<?>)null,marker,msg);
    }

    public static void debug(Marker marker, String format, Object arg) {
	debug((Class<?>)null,marker,format,arg);
    }

    public static void debug(Marker marker, String format, Object arg1, Object arg2) {
	debug((Class<?>)null,marker,format,arg1,arg2);
    }

    public static void debug(Marker marker, String format, Object... arguments) {
	debug((Class<?>)null,marker,format,arguments);
    }

    public static void debug(Marker marker, String msg, Throwable t) {
	debug((Class<?>)null,marker,msg,t);
    }

    public static boolean isInfoEnabled() {
	return isInfoEnabled((Class<?>)null);
    }

    public static void info(String msg) {
	info((Class<?>)null,msg);
    }

    public static void info(String format, Object arg) {
	info((Class<?>)null,format,arg);
    }

    public static void info(String format, Object arg1, Object arg2) {
	info((Class<?>)null,format,arg1,arg2);
    }

    public static void info(String format, Object... arguments) {
	info((Class<?>)null,format,arguments);
    }

    public static void info(String msg, Throwable t) {
	info((Class<?>)null,msg,t);
    }

    public static boolean isInfoEnabled(Marker marker) {
	return isInfoEnabled((Class<?>)null,marker);
    }

    public static void info(Marker marker, String msg) {
	info((Class<?>)null,marker,msg);
    }

    public static void info(Marker marker, String format, Object arg) {
	info((Class<?>)null,marker,format,arg);
    }

    public static void info(Marker marker, String format, Object arg1, Object arg2) {
	info((Class<?>)null,marker,format,arg1,arg2);
    }

    public static void info(Marker marker, String format, Object... arguments) {
	info((Class<?>)null,marker,format,arguments);
    }

    public static void info(Marker marker, String msg, Throwable t) {
	info((Class<?>)null,marker,msg,t);
    }

    public static boolean isWarnEnabled() {
	return isWarnEnabled((Class<?>)null);
    }

    public static void warn(String msg) {
	warn((Class<?>)null,msg);
    }

    public static void warn(String format, Object arg) {
	warn((Class<?>)null,format,arg);
    }

    public static void warn(String format, Object... arguments) {
	warn((Class<?>)null,format,arguments);
    }

    public static void warn(String format, Object arg1, Object arg2) {
	warn((Class<?>)null,format,arg1,arg2);
    }

    public static void warn(String msg, Throwable t) {
	warn((Class<?>)null,msg,t);
    }

    public static boolean isWarnEnabled(Marker marker) {
	return isWarnEnabled((Class<?>)null,marker);
    }

    public static void warn(Marker marker, String msg) {
	warn((Class<?>)null,marker,msg);
    }

    public static void warn(Marker marker, String format, Object arg) {
	warn((Class<?>)null,marker,format,arg);
    }

    public static void warn(Marker marker, String format, Object arg1, Object arg2) {
	warn((Class<?>)null,marker,format,arg1,arg2);
    }

    public static void warn(Marker marker, String format, Object... arguments) {
	warn((Class<?>)null,marker,format,arguments);
    }

    public static void warn(Marker marker, String msg, Throwable t) {
	warn((Class<?>)null,marker,msg,t);
    }

    public static boolean isErrorEnabled() {
	return isErrorEnabled((Class<?>)null);
    }

    public static void error(String msg) {
	error((Class<?>)null,msg);
    }

    public static void error(String format, Object arg) {
	error((Class<?>)null,format,arg);
    }

    public static void error(String format, Object arg1, Object arg2) {
	error((Class<?>)null,format,arg1,arg2);
    }

    public static void error(String format, Object... arguments) {
	error((Class<?>)null,format,arguments);
    }

    public static void error(String msg, Throwable t) {
	error((Class<?>)null,msg,t);
    }

    public static boolean isErrorEnabled(Marker marker) {
	return isErrorEnabled((Class<?>)null);
    }

    public static void error(Marker marker, String msg) {
	error((Class<?>)null,marker,msg);
    }

    public static void error(Marker marker, String format, Object arg) {
	error((Class<?>)null,format,arg);
    }

    public static void error(Marker marker, String format, Object arg1, Object arg2) {
	error((Class<?>)null,format,arg1,2);
    }

    public static void error(Marker marker, String format, Object... arguments) {
	error((Class<?>)null,format,arguments);
    }

    public static void error(Marker marker, String msg, Throwable t) {
	error((Class<?>)null,marker,msg,t);
    }
    
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Clazz added">
    
    
    public static String getName(Class<?> clazz) {
	return getLogger(clazz).getName();
    }

    public static boolean isTraceEnabled(Class<?> clazz) {
	return getLogger(clazz).isTraceEnabled();
    }

    public static void trace(Class<?> clazz,String msg) {
	getLogger(clazz).trace(msg);
    }

    public static void trace(Class<?> clazz,String format, Object arg) {
	getLogger(clazz).trace(format, arg);
    }

    public static void trace(Class<?> clazz,String format, Object arg1, Object arg2) {
	getLogger(clazz).trace(format, arg1, arg2);
    }

    public static void trace(Class<?> clazz,String format, Object... arguments) {
	getLogger(clazz).trace(format, arguments);
    }

    public static void trace(Class<?> clazz,String msg, Throwable t) {
	getLogger(clazz).trace(msg, t);
    }

    public static boolean isTraceEnabled(Class<?> clazz,Marker marker) {
	return getLogger(clazz).isTraceEnabled(marker);
    }

    public static void trace(Class<?> clazz,Marker marker, String msg) {
	getLogger(clazz).trace(marker, msg);
    }

    public static void trace(Class<?> clazz,Marker marker, String format, Object arg) {
	getLogger(clazz).trace(marker, format, arg);
    }

    public static void trace(Class<?> clazz,Marker marker, String format, Object arg1, Object arg2) {
	getLogger(clazz).trace(marker, format, arg1, arg2);
    }

    public static void trace(Class<?> clazz,Marker marker, String format, Object... argArray) {
	getLogger(clazz).trace(marker, format, argArray);
    }

    public static void trace(Class<?> clazz,Marker marker, String msg, Throwable t) {
	getLogger(clazz).trace(marker, msg, t);
    }


    public static boolean isDebugEnabled(Class<?> clazz) {
	return getLogger(clazz).isDebugEnabled();
    }

    public static void debug(Class<?> clazz,String msg) {
	getLogger(clazz).debug(msg);
    }

    public static void debug(Class<?> clazz,String format, Object arg) {
	getLogger(clazz).debug(format, arg);
    }

    public static void debug(Class<?> clazz,String format, Object arg1, Object arg2) {
	getLogger(clazz).debug(format, arg1, arg2);
    }

    public static void debug(Class<?> clazz,String format, Object... arguments) {
	getLogger(clazz).debug(format, arguments);
    }

    public static void debug(Class<?> clazz,String msg, Throwable t) {
	getLogger(clazz).debug(msg, t);
    }

    public static boolean isDebugEnabled(Class<?> clazz,Marker marker) {
	return getLogger(clazz).isDebugEnabled(marker);
    }

    public static void debug(Class<?> clazz,Marker marker, String msg) {
	getLogger(clazz).debug(marker, msg);
    }

    public static void debug(Class<?> clazz,Marker marker, String format, Object arg) {
	getLogger(clazz).debug(marker, format, arg);
    }

    public static void debug(Class<?> clazz,Marker marker, String format, Object arg1, Object arg2) {
	getLogger(clazz).warn(marker, format, arg1, arg2);
    }

    public static void debug(Class<?> clazz,Marker marker, String format, Object... arguments) {
	getLogger(clazz).debug(marker, format, arguments);
    }

    public static void debug(Class<?> clazz,Marker marker, String msg, Throwable t) {
	getLogger(clazz).debug(marker, msg, t);
    }

    public static boolean isInfoEnabled(Class<?> clazz) {
	return getLogger(clazz).isInfoEnabled();
    }

    public static void info(Class<?> clazz,String msg) {
	getLogger(clazz).info(msg);
    }

    public static void info(Class<?> clazz,String format, Object arg) {
	getLogger(clazz).info(format, arg);
    }

    public static void info(Class<?> clazz,String format, Object arg1, Object arg2) {
	getLogger(clazz).info(format, arg1, arg2);
    }

    public static void info(Class<?> clazz,String format, Object... arguments) {
	getLogger(clazz).info(format, arguments);
    }

    public static void info(Class<?> clazz,String msg, Throwable t) {
	getLogger(clazz).info(msg, t);
    }

    public static boolean isInfoEnabled(Class<?> clazz,Marker marker) {
	return getLogger(clazz).isInfoEnabled(marker);
    }

    public static void info(Class<?> clazz,Marker marker, String msg) {
	getLogger(clazz).info(marker, msg);
    }

    public static void info(Class<?> clazz,Marker marker, String format, Object arg) {
	getLogger(clazz).info(marker, format, arg);
    }

    public static void info(Class<?> clazz,Marker marker, String format, Object arg1, Object arg2) {
	getLogger(clazz).info(marker, format, arg1, arg2);
    }

    public static void info(Class<?> clazz,Marker marker, String format, Object... arguments) {
	getLogger(clazz).info(marker, format, arguments);
    }

    public static void info(Class<?> clazz,Marker marker, String msg, Throwable t) {
	getLogger(clazz).info(marker, msg, t);
    }

    public static boolean isWarnEnabled(Class<?> clazz) {
	return getLogger(clazz).isWarnEnabled();
    }

    public static void warn(Class<?> clazz,String msg) {
	getLogger(clazz).warn(msg);
    }

    public static void warn(Class<?> clazz,String format, Object arg) {
	getLogger(clazz).warn(format, arg);
    }

    public static void warn(Class<?> clazz,String format, Object... arguments) {
	getLogger(clazz).warn(format, arguments);
    }

    public static void warn(Class<?> clazz,String format, Object arg1, Object arg2) {
	getLogger(clazz).warn(format, arg1, arg2);
    }

    public static void warn(Class<?> clazz,String msg, Throwable t) {
	getLogger(clazz).warn(msg, t);
    }

    public static boolean isWarnEnabled(Class<?> clazz,Marker marker) {
	return getLogger(clazz).isWarnEnabled(marker);
    }

    public static void warn(Class<?> clazz,Marker marker, String msg) {
	getLogger(clazz).warn(marker, msg);
    }

    public static void warn(Class<?> clazz,Marker marker, String format, Object arg) {
	getLogger(clazz).warn(marker, format, arg);
    }

    public static void warn(Class<?> clazz,Marker marker, String format, Object arg1, Object arg2) {
	getLogger(clazz).warn(marker, format, arg1, arg2);
    }

    public static void warn(Class<?> clazz,Marker marker, String format, Object... arguments) {
	getLogger(clazz).warn(marker, format, arguments);
    }

    public static void warn(Class<?> clazz,Marker marker, String msg, Throwable t) {
	getLogger(clazz).warn(marker, msg, t);
    }

    public static boolean isErrorEnabled(Class<?> clazz) {
	return getLogger(clazz).isErrorEnabled();
    }

    public static void error(Class<?> clazz,String msg) {
	getLogger(clazz).error(msg);
    }

    public static void error(Class<?> clazz,String format, Object arg) {
	getLogger(clazz).error(format, arg);
    }

    public static void error(Class<?> clazz,String format, Object arg1, Object arg2) {
	getLogger(clazz).error(format, arg1, arg2);
    }

    public static void error(Class<?> clazz,String format, Object... arguments) {
	getLogger(clazz).error(format, arguments);
    }

    public static void error(Class<?> clazz,String msg, Throwable t) {
	getLogger(clazz).error(msg, t);
    }

    public static boolean isErrorEnabled(Class<?> clazz,Marker marker) {
	return getLogger(clazz).isErrorEnabled(marker);
    }

    public static void error(Class<?> clazz,Marker marker, String msg) {
	getLogger(clazz).error(marker, msg);
    }

    public static void error(Class<?> clazz,Marker marker, String format, Object arg) {
	getLogger(clazz).error(marker, format, arg);
    }

    public static void error(Class<?> clazz,Marker marker, String format, Object arg1, Object arg2) {
	getLogger(clazz).error(marker, format, arg1, arg2);
    }

    public static void error(Class<?> clazz,Marker marker, String format, Object... arguments) {
	getLogger(clazz).error(marker, format, arguments);
    }

    public static void error(Class<?> clazz,Marker marker, String msg, Throwable t) {
	getLogger(clazz).error(marker, msg, t);
    }
    
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Custom">

    public static Boolean isLevelInBrackets(){
	if(levelInBrackets==null){
	    String levelInBracketsProp=getProperty("org.slf4j.simpleLogger.levelInBrackets","simplelogger.properties");
	    levelInBrackets=levelInBracketsProp!=null? Boolean.parseBoolean(levelInBracketsProp):false;
	}
	return levelInBrackets;
    }
    
    private static String getFinalMessage(Integer callerSimpleClassNameLength,String methodSignature,String msg) {
	
	    String normalizerTabs=getNormalizerTabs(callerSimpleClassNameLength,methodSignature.length());

	    StringBuilder builder= new StringBuilder();

	    //builder.append("#");
	    builder.append(methodSignature);
	    builder.append(normalizerTabs);
	    builder.append(": ");
	    builder.append(msg);
	    return builder.toString();
    }
    
    public static void trace(String methodSignature,String msg) {
	try{
	    
	    String levelMark=isLevelInBrackets()?"[TRACE] ":"TRACE ";
	    
	    Class<?> callerClass=Class.forName(getCallerClassName());
	    getLogger(callerClass).trace(getFinalMessage(callerClass.getSimpleName().length()+levelMark.length(),methodSignature,msg));
	    
	}catch(ClassNotFoundException ex){
	    throw new RuntimeException("Impossible to obtain the caller class to log",ex);
	} catch (Exception ex) {
	    throw new RuntimeException("Impossible to log.",ex);
	}
    }
    
    public static void debug(String methodSignature,String msg) {
	try{
	    String levelMark=isLevelInBrackets()?"":"DEBUG ";
	    
	    Class<?> callerClass=Class.forName(getCallerClassName());
	    getLogger(callerClass).debug(getFinalMessage(callerClass.getSimpleName().length()+levelMark.length(),methodSignature,msg));
	    
	}catch(ClassNotFoundException ex){
	    throw new RuntimeException("Impossible to obtain the caller class to log",ex);
	} catch (Exception ex) {
	    throw new RuntimeException("Impossible to log.",ex);
	}
    }
    
    public static void info(String methodSignature,String msg) {
	try{
	    
	    String levelMark=isLevelInBrackets()?"":"INFO ";
	    Class<?> callerClass=Class.forName(getCallerClassName());
	    Logger logger=getLogger(callerClass);
	    String finalMessage=getFinalMessage(callerClass.getSimpleName().length()+levelMark.length(),methodSignature,msg);
	    logger.info(finalMessage);
	    
	}catch(ClassNotFoundException ex){
	    throw new RuntimeException("Impossible to obtain the caller class to log",ex);
	} catch (Exception ex) {
	    throw new RuntimeException("Impossible to log.",ex);
	}
    }
    
    public static void warn(String methodSignature,String msg) {
	try{
	    
	    String levelMark=isLevelInBrackets()?"[WARN] ":"WARN ";
	    Class<?> callerClass=Class.forName(getCallerClassName());
	    getLogger(callerClass).warn(getFinalMessage(callerClass.getSimpleName().length()+levelMark.length(),methodSignature,msg));
	    
	}catch(ClassNotFoundException ex){
	    throw new RuntimeException("Impossible to obtain the caller class to log",ex);
	} catch (Exception ex) {
	    throw new RuntimeException("Impossible to log.",ex);
	}
    }
    
    public static void error(String methodSignature,String msg) {
	try{
	    String levelMark=isLevelInBrackets()?"":"ERROR ";
	    Class<?> callerClass=Class.forName(getCallerClassName());
	    getLogger(callerClass).error(getFinalMessage(callerClass.getSimpleName().length()+levelMark.length(),methodSignature,msg));
	    
	}catch(ClassNotFoundException ex){
	    throw new RuntimeException("Impossible to obtain the caller class to log",ex);
	} catch (Exception ex) {
	    throw new RuntimeException("Impossible to log.",ex);
	}
    }

    
//</editor-fold>
    
}
