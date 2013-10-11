/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Marta
 */
public class ValueConverterNGTest {

    ValueConverter out = new ValueConverter();

    /**
     * Test of getAsString method, of class ValueConverter.
     */
    @Test
    public void testGetAsString() {
        Integer a = 8500;
        String expected = "85,00";
        String actual = out.getAsString(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsStringMinus() {
        Integer a = -8000;
        String expected = "-80,00";
        String actual = out.getAsString(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsStringZero() {
        Integer a = 0;
        String expected = "0,00";
        String actual = out.getAsString(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsStringNull() {
        Integer a = null;
        String expected = null;
        String actual = out.getAsString(null, null, a);
        assertEquals(actual, expected);
    }
    @Test
    public void testGetAsStringComma() {
        Integer a = 8050;
        String expected = "80,50";
        String actual = out.getAsString(null, null, a);
        assertEquals(actual, expected);
    }
    

    /**
     * Test of getAsObject method, of class ValueConverter.
     */
    @Test
    public void testGetAsObject() {
        String a = "85";
        Integer expected = 8500;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
    @Test
    public void testGetAsObjectMinus() {
        String a = "-80";
        Integer expected = -8000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
    @Test
    public void testGetAsObjectZero() {
        String a = "0";
        Integer expected = 0;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
    @Test
    public void testGetAsObjectNull() {
        String a = null;
        Integer expected = null;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
     @Test
    public void testGetAsObjectComma() {
        String a = "80,50";
        Integer expected = 8050;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
}