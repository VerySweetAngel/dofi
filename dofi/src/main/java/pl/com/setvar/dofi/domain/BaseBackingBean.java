package pl.com.setvar.dofi.domain;

import pl.com.setvar.dofi.util.MessageAdder;
import pl.com.setvar.dofi.util.MessageAdderImpl;

/**
 * Klasa bazowa dla obiektów wspierających widoki.
 * @author tirpitz
 */
public class BaseBackingBean {
    
    protected MessageAdder messageAdder = new MessageAdderImpl();
    
}
