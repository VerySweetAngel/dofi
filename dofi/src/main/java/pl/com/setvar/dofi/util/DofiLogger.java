package pl.com.setvar.dofi.util;

import org.apache.log4j.Logger;

/**
 * Klasa, która opakowuje loggery. Zgodnie z log4j.properties, pliki loggerów
 * będą zapisane w glassfish/applications/domain/domain1/logs.
 *
 * @author tirpitz
 */
public final class DofiLogger {

    /**
     * właściwy logger z log4j
     */
    private Logger loggerImpl;
    /**
     * logger domyślny
     */
    public static final DofiLogger DEFAULT = new DofiLogger("defaultLogger");
    /**
     * logger do hibernate'a i rzeczy związanych z bazami danych
     */
    public static final DofiLogger HIBERNATE = new DofiLogger("hibernate");

    /**
     * Konstruktor prywatny.
     * @param loggerName nazwa loggera
     */
    private DofiLogger(String loggerName) {
        loggerImpl = Logger.getLogger(loggerName);
    }

    /**
     * Metoda zapisze informację typu DEBUG do loga.
     * @param message obiekt wiadomości do zapisania
     */
    public void debug(Object message) {
        loggerImpl.debug(message);
    }

    /**
     * Metoda zapisze informację typu DEBUG do loga.
     * @param messages obiekty wiadomości do zapisania
     */
    public void debug(Object... messages) {
        loggerImpl.debug(concatMessages(messages));
    }

    /**
     * Metoda zapisze informację typu INFO do loga.
     * @param message obiekt wiadomości do zapisania
     */
    public void info(Object message) {
        loggerImpl.info(message);
    }

    /**
     * Metoda zapisze informację typu INFO do loga.
     * @param messages obiekty wiadomości do zapisania
     */
    public void info(Object... messages) {
        loggerImpl.info(concatMessages(messages));
    }

    /**
     * Metoda zapisze informację typu WARN do loga.
     * @param message obiekt wiadomości do zapisania
     */
    public void warn(Object message) {
        loggerImpl.warn(message);
    }

    /**
     * Metoda zapisze informację typu ERROR do loga.
     * @param message obiekt wiadomości do zapisania
     */
    public void error(Object message) {
        loggerImpl.error(message);
    }

    /**
     * Metoda zapisze informację typu ERROR do loga.
     * @param message obiekt wiadomości do zapisania
     * @param throwable wyjątek do zapisania
     */
    public void error(Object message, Throwable throwable) {
        loggerImpl.error(message, throwable);
    }
    
    /**
     * Metoda zapisze informację typu FATAL do loga.
     * @param message obiekt wiadomości do zapisania
     */
    public void fatal(Object message) {
        loggerImpl.fatal(message);
    }

    /**
     * Metoda zapisze informację typu FATAL do loga.
     * @param message obiekt wiadomości do zapisania
     * @param throwabl wyjątek do zapisania
     */
    public void fatal(Object message, Throwable throwabl) {
        loggerImpl.fatal(message, throwabl);
    }

    /**
     * Metoda dokona konkatenacji tablicy obiektów do jednego łańcucha
     * @param messages tablica wiadomości
     * @return pojedynczy łańcuch wiadomości
     */
    private String concatMessages(Object[] messages) {
        StringBuilder msgCombiner = new StringBuilder();
        for (Object singleMsg : messages) {
            String singleMsgStr = "null";
            if (singleMsg != null) {
                singleMsgStr = singleMsg.toString();
            }
            msgCombiner.append(singleMsgStr);
            msgCombiner.append(" ");
        }
        return msgCombiner.toString();
    }
}
