/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 *
 * @author Marta
 */
public class ValueConverter implements Converter {
    private int l;

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
     * @param wyrazenie
     * @return
     */
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String wyrazenie) {
        if (wyrazenie == null) {
            return null;
        }
        wyrazenie = wyrazenie.replace(',', '.');
        Calculable calc;
        try {
            calc = new ExpressionBuilder (wyrazenie).build();
        } catch (UnknownFunctionException | UnparsableExpressionException ex) {
            I18nText operations = new I18nText(Bundles.I18N_OPERATIONS);
            String text = operations.get("coverterError");
            FacesMessage message = new FacesMessage(text);
            fc.addMessage(uic.getClientId(fc), message);
            throw new ConverterException(message);
        }
        BigDecimal liczba = new BigDecimal(calc.calculate());
        liczba = liczba.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        liczba = liczba.multiply(new BigDecimal(100));
        Integer actual = liczba.intValue();
        return actual;
        
    }
}
