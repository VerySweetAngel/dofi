package pl.com.setvar.dofi.dao;

import java.util.List;
import java.util.Set;
import pl.com.setvar.dofi.model.Tag;

/**
 * Interfejs operacji DAO dla klasy {@link pl.com.setvar.dofi.model.Tag}. Implementuje go
 * {@link pl.com.setvar.dofi.dao.TagDao} i {@link pl.com.setvar.dofi.dao.CategoryDao}.
 *
 * @author tirpitz
 */
public interface TagDaoInterface extends GenericDaoInterface {

    /**
     * Metoda przeszukuje tabelę tag'ów, wedle zadanej nazwy.
     *
     * @param tagname nazwa tag'a do wyszukania
     * @return żądany tag
     */
    <T extends Tag> T findByTagname(String tagname);

    /**
     * Metoda wyszukuje tag'i, po nazwie.
     *
     * @param criteria nazwa lub część nazwy tag'a
     * @return listan tag'ów spełaniających zadane kryterium
     */
    List<Tag> find(String criteria);

    /**
     * Metoda zwraca {@link Set} tag'ów, których nazwy odpowiadają zadanym nazwom.
     *
     * @param tagnames łańcuch z nazwami tagów, oddzielonymi znakami SPACE
     * @return set tag'ów, spełniających zadane kryteria
     */
    Set<Tag> getSetByTagnames(String tagnames);
    
    /**
     * Metoda usówa encję razem z powiązaniami.
     * @param <T> klasa {@link pl.com.setvar.dofi.model.Tag} lub z niej dziedzicząca
     * @param model obiekt do usunięcia
     */
    <T extends Tag> void deleteWithTaglinks(T model);
}
