/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.setvar.dofi.model;

import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.com.setvar.dofi.dao.TagDao;
import pl.com.setvar.dofi.util.BaseTestWithHibernate;

/**
 *
 * @author tirpitz
 */
public class TagTest extends BaseTestWithHibernate {

    @Test
    public void getSetByTagnames() {
        String nazwyTagów = " ";
        Set<Tag> setTag;
        setTag = Tag.getSetByTagnames(nazwyTagów);
        assertTrue(setTag.isEmpty(), "Kolekcja tagów nie jest pusta.");
        
        nazwyTagów = "";
        setTag = Tag.getSetByTagnames(nazwyTagów);
        assertTrue(setTag.isEmpty(), "Kolekcja tagów nie jest pusta.");

        String nazwaTaga = "nazwaTaga";
        Tag tag = new Tag(nazwaTaga);
        new TagDao().saveOrUpdate(tag);
        setTag = Tag.getSetByTagnames(nazwaTaga);
        assertTrue(setTag.contains(tag), "Kolekcja nie zawiera zadanego taga.");
        assertEquals(setTag.size(), 1, "Kolekcja ma nieodpowiednią ilość elementów.");
    }
}