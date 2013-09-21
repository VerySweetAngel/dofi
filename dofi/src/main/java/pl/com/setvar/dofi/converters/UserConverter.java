/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import pl.com.setvar.dofi.model.User;

// TODO przenieśc implementację do klasy User i nastepnie napisać testy jednostkowe

/**
 * Klasa ta służy do zmieniania danych każdego użytkownika na napis. Działa w
 * dwie strony.
 *
 * @author Marta
 */
public class UserConverter implements Converter {

    /**
     * Zwraca łańcuch znaków utworzony na podstawie przekazanego objektu.
     * Komponent określa skąd została pobrana wartość.
     *
     * @param value to jest napis.
     * @return na podstawie napisu jest w stanie zwrócić którego użytkownika to
     * dotyczy.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        Pattern p = Pattern.compile("\\[(\\w+)\\]");
        Matcher m = p.matcher(value);
        boolean znalazlem = m.find();
        if (znalazlem == false) {
            return null;
        }
        String login = m.group(m.groupCount());
        return User.findByLogin(login);
    }

    /**
     * Zwraca objekt przekonwertowany z podanej wartości tekstowej. Komponent
     * określa skąd została pobrana wartość.
     *
     * @param value to jest użytkownik (wszystkie jego dane)
     * @return na podstawie danych użytkownika zwraca napis.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof User)) {
            throw new ConverterException(new FacesMessage("Nastąpił błąd konwersji!"));
        }
        User user = (User) value;
        String name = user.getRealName() + " [" + user.getLogin() + "]";
        return name;
    }
}
