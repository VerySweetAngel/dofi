package pl.com.setvar.dofi.util;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pl.com.setvar.dofi.dao.HibernateUtil;

/**
 * Bazowa klasa testów z obsługą hibernate. Całe klasy są otoczone sesją a metoday rollbackowanymi tranzakcjami.
 *
 * @author tirpitz
 */
public class BaseTestWithHibernate {

    private HibernateUtil hibernateUtil = new HibernateUtil();

    @BeforeClass
    public static void setUpClass() throws Exception {
        HibernateUtil.createFactory();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        HibernateUtil.closeFactory();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        hibernateUtil.beginTransaction();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        hibernateUtil.rollbackTransaction();
    }
}
