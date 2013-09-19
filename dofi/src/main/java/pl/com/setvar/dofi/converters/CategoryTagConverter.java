/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import pl.com.setvar.dofi.model.Tag;

/**
 *
 * @author Marta
 */
public class CategoryTagConverter extends TagConverter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return Tag.findByCategoryTagname(value);
    }
}