package pl.com.setvar.dofi.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.Category;

/**
 * Konwerter do Kategorii.
 * @author Marta
 */
public class CategoryConverter extends TagConverter {

    @Override
    public final Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        if (value == null) {
            return null;
        }
        return Category.findByName(value);
    }
}
