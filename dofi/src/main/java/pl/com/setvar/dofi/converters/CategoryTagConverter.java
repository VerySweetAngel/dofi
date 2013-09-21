package pl.com.setvar.dofi.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.Tag;

// TODO przenieśc implementację do klasy Category (po uwczesnym jej utworzeniu) i nastepnie napisać testy jednostkowe. Dopisać do faces-config.xml

/**
 * Konwerter do Tagów (będących kategoriami).
 * @author Marta
 */
public class CategoryTagConverter extends TagConverter {

    @Override
    public final Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        if (value == null) {
            return null;
        }
        return Tag.findByCategoryTagname(value);
    }
}
