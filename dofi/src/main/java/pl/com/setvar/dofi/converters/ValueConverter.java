/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import java.text.DecimalFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Marta
 */
public class ValueConverter implements Converter {

    /**
     * Ten konwerter zamienia wartość na napis (liczba to wartość pomnożona
     * przez 100),
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        Integer liczba = (Integer) value;
        Double liczbaPrzec = liczba.doubleValue();
        liczbaPrzec = liczbaPrzec / 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String wynik = df.format(liczbaPrzec);
        wynik = wynik.replace('.', ',');
        return wynik;
    }

    /**
     * Ten konwerter zamienia liczbę na watość (wartość to liczba podzielona
     * przez 100),
     *
     * @param fc
     * @param uic
     * @param string
     * @return
     */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        string = string.replace(',', '.');
        Double liczba = Double.parseDouble(string);
        liczba = liczba * 100;
        Integer actual = liczba.intValue();
        return actual;
    }
}
