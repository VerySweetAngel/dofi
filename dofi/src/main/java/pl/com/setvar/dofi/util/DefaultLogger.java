/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.util;

import org.apache.log4j.Logger;

/**
 *
 * @author tirpitz
 */
public final class DefaultLogger {
    
    private static final DefaultLogger SINGLETON = new DefaultLogger();
    
    private Logger loggerImpl = Logger.getLogger("defaultLogger");
    
    public static void debug(Object message){
        SINGLETON.loggerImpl.debug(message);
    }
    
    public static void debug(Object... messages){
        StringBuilder msgCombiner = new StringBuilder();
        for(Object singleMsg : messages){
            String singleMsgStr = "null";
            if(singleMsg != null){
                singleMsgStr = singleMsg.toString();;
            }
            msgCombiner.append(singleMsgStr);
            msgCombiner.append(" ");
        }
        SINGLETON.loggerImpl.debug(msgCombiner.toString());
    }
    
    public static void info(Object message){
        SINGLETON.loggerImpl.info(message);
    }
    
    public static void warn(Object message){
        SINGLETON.loggerImpl.warn(message);
    }
            
    public static void error(Object message){
        SINGLETON.loggerImpl.error(message);
    }
    
    public static void error(Object message, Throwable throwable){
        SINGLETON.loggerImpl.error(message, throwable);
    }
            
    public static void fatal(Object message){
        SINGLETON.loggerImpl.fatal(message);
    }
    
    public static void fatal(Object message, Throwable throwabl){
        SINGLETON.loggerImpl.fatal(message, throwabl);
    }
}
