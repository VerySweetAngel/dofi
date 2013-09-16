/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import java.util.Iterator;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import pl.com.setvar.dofi.model.Tag;

/**
 *
 * @author Marta
 */
public class TagSetConverter implements Converter {

    /**
     * Zwraca łańcuch znaków utworzony na podstawie przekazanego objektu.
     * Komponent określa skąd została pobrana wartość.
     *
     * @param value to jest napis.
     * @return na podstawie napisu jest w stanie zwrócić którego taga to
     * dotyczy.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return Tag.getSetByTagnames(value);
        
   }

    /**
     * Zwraca objekt przekonwertowany z podanej wartości tekstowej. Komponent
     * określa skąd została pobrana wartość.
     *
     * @param value to jest tag (wszystkie jego dane)
     * @return na podstawie danych taga zwraca napis.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof Set<?>)) {
            throw new ConverterException(new FacesMessage("Nastąpił błąd konwersji!"));
        }
        StringBuilder result = new StringBuilder();
        Set<Tag> tagList = (Set<Tag>) value;
        for (Iterator<Tag> it = tagList.iterator(); it.hasNext();) {
            Tag tag = it.next();
            result.append(tag.getTagname());
            result.append(" ");
        }
        return result.toString();
    }
}
