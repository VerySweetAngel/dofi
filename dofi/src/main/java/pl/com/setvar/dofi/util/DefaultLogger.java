package pl.com.setvar.dofi.util;

import org.apache.log4j.Logger;

/**
 * Klasa, która opakowuje loggery. Zgodnie z log4j.properties, pliki loggerów będą zapisane w glassfish/applications/domain/domain1/logs.
 * @author tirpitz
 */
public class DefaultLogger {
    
    /** właściwa loggera z log4j */
    private Logger loggerImpl;
    /** logger domyślny */
    public static final DefaultLogger DEFAULT = new DefaultLogger("defaultLogger");
    /** logger do hibernate'a i rzeczy związanych z bazami danych */
    public static final DefaultLogger HIBERNATE = new DefaultLogger("hibernate");
    
    private DefaultLogger(String loggerName){
        loggerImpl = Logger.getLogger(loggerName);
    }
    
    public void debug(Object message){
        loggerImpl.debug(message);
    }
    
    public void debug(Object... messages){
        loggerImpl.debug(concatMessages(messages));
    }
    
    public void info(Object message){
        loggerImpl.info(message);
    }
    
    public void info(Object... messages){
        loggerImpl.info(concatMessages(messages));
    }
    
    public void warn(Object message){
        loggerImpl.warn(message);
    }
            
    public void error(Object message){
        loggerImpl.error(message);
    }
    
    public void error(Object message, Throwable throwable){
        loggerImpl.error(message, throwable);
    }
            
    public void fatal(Object message){
        loggerImpl.fatal(message);
    }
    
    public void fatal(Object message, Throwable throwabl){
        loggerImpl.fatal(message, throwabl);
    }
    
    private String concatMessages(Object[] messages){
        StringBuilder msgCombiner = new StringBuilder();
        for(Object singleMsg : messages){
            String singleMsgStr = "null";
            if(singleMsg != null){
                singleMsgStr = singleMsg.toString();;
            }
            msgCombiner.append(singleMsgStr);
            msgCombiner.append(" ");
        }
        return msgCombiner.toString();
    }
}
