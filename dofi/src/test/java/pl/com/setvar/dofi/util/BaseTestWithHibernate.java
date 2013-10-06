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

    private HibernateUtil hibernateUtil;

    @BeforeClass(groups = "integration")
    public static void setUpClass() throws Exception {
        HibernateUtil.createFactory();
    }

    @AfterClass(groups = "integration")
    public static void tearDownClass() throws Exception {
        HibernateUtil.closeFactory();
    }

    @BeforeMethod(groups = "integration")
    public void setUpHibernateUtil() {
         hibernateUtil = new HibernateUtil();
    }
    
    @BeforeMethod(groups = "integration")
    public void setUpMethod() throws Exception {
        hibernateUtil.beginTransaction();
    }

    @AfterMethod(groups = "integration")
    public void tearDownMethod() throws Exception {
        hibernateUtil.rollbackTransaction();
    }
}
