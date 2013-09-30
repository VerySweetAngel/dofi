package pl.com.setvar.dofi.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 * Klasa ta służy do zmieniania tagów na napis. Działa w dwie strony.
 *
 * @author Marta
 */
public class TagConverter implements Converter {
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
        return Tag.findByTagname(value);
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
        if (!(value instanceof Tag)) {
            I18nText global = new I18nText(Bundles.I18N_GLOBAL);
            throw new ConverterException(new FacesMessage(global.get("coverterError")));
        }
        Tag tag = (Tag) value;
        String name = tag.getTagname();
        return name;
    }
}
