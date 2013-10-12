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

    /**
     * Testy do działań matematycznych - dodawanie.
     */
    @Test
    public void testGetAsObjectPlus1() {
        String a = "20+10";
        Integer expected = 3000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectPlus2() {
        String a = "0+10";
        Integer expected = 1000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectPlus3() {
        String a = "2,5+3";
        Integer expected = 550;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectPlus4() {
        String a = "2,5+3";
        Integer expected = 550;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectPlus5() {
        String a = "2,22+4";
        Integer expected = 622;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    /**
     * Testy do działań matematycznych - odejmowanie.
     */
    @Test
    public void testGetAsObjectMinus1() {
        String a = "20-10";
        Integer expected = 1000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus2() {
        String a = "10-20";
        Integer expected = -1000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus3() {
        String a = "0-10";
        Integer expected = -1000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus4() {
        String a = "10-0";
        Integer expected = 1000;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus5() {
        String a = "2,5-3";
        Integer expected = -50;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus6() {
        String a = "2,22-4";
        Integer expected = -178;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMinus7() {
        String a = "4-2,22";
        Integer expected = 178;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    /**
     * Testy do działań matematycznych - mnożenie.
     */
    @Test
    public void testGetAsObjectMultiplication1() {
        String a = "2*4";
        Integer expected = 800;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMultiplication2() {
        String a = "2,5*2";
        Integer expected = 500;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMultiplication3() {
        String a = "2,55*2";
        Integer expected = 510;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMultiplication4() {
        String a = "2,33*2";
        Integer expected = 466;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectMultiplication5() {
        String a = "2*0";
        Integer expected = 0;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    /**
     * Testy do działań matematycznych - dzielenie.
     */
    @Test
    public void testGetAsObjectDivision1() {
        String a = "2/4";
        Integer expected = 50;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision2() {
        String a = "4/2";
        Integer expected = 200;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision3() {
        String a = "5/2";
        Integer expected = 250;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision4() {
        String a = "9,96/3";
        Integer expected = 332;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision5() {
        String a = "10/3";
        Integer expected = 333;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision6() {
        String a = "7,08/3";
        Integer expected = 236;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetAsObjectDivision7() {
        String a = "7,07/3";
        Integer expected = 236;
        Integer actual = (Integer) out.getAsObject(null, null, a);
        assertEquals(actual, expected);
    }
}
