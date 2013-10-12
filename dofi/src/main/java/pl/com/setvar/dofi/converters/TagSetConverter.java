package pl.com.setvar.dofi.converters;

import com.google.common.base.Joiner;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import pl.com.setvar.dofi.model.Tag;
import pl.com.setvar.dofi.util.Bundles;
import pl.com.setvar.dofi.util.I18nText;

/**
 * Konweter do {@code Set<Tag>}.
 *
 * @author Marta
 */
public class TagSetConverter implements Converter {

    /**
     * Zwraca łańcuch znaków utworzony na podstawie przekazanego objektu. Komponent określa skąd została pobrana
     * wartość.
     *
     * @param value to jest napis.
     * @return na podstawie napisu jest w stanie zwrócić którego taga to dotyczy.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return Tag.getSetByTagnames(value);

    }

    /**
     * Zwraca objekt przekonwertowany z podanej wartości tekstowej. Komponent określa skąd została pobrana wartość.
     *
     * @param value to jest tag (wszystkie jego dane)
     * @return na podstawie danych taga zwraca napis.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (!(Set.class.isAssignableFrom(value.getClass()))) {
            I18nText global = new I18nText(Bundles.I18N_GLOBAL);
            throw new ConverterException(new FacesMessage(global.get("coverterError")));
        }
        Set<Tag> tagSet = (Set<Tag>) value;
        return Joiner.on(" ").join(tagSet);
    }
}
