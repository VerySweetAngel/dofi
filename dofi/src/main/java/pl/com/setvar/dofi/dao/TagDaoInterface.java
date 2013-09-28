package pl.com.setvar.dofi.dao;

import java.util.List;
import java.util.Set;
import pl.com.setvar.dofi.model.Tag;

/**
 * Interfejs operacji DAO dla klasy {@link pl.com.setvar.dofi.model.Tag}. Implementuje go
 * {@link pl.com.setvar.dofi.dao.TagDao}.
 *
 * @author tirpitz
 */
public interface TagDaoInterface extends GenericDaoInterface {

    /**
     * Metoda przeszukuje tablice tagów wedle zadanej nazwy. Nie ma rozgraniczenia na kategorie.
     *
     * @param tagname nazwa taga do wyszukania
     * @return żądany tag
     */
    Tag findByTagname(String tagname);

    /**
     * Metoda wyszukuje tagi niebędące kategoriami po nazwie.
     *
     * @param criteria nazwa lub część nazwy taga
     * @return listan tagów spełaniających zadane kryterium
     */
    List<Tag> find(String criteria);

    /**
     * Metdoa zwraca {@link Set} tagów, których nazwy odpowiadają zadanym nazwom.
     *
     * @param tagnames łańcuch z nazwami tagów, oddzielonymi spacjami
     * @return set tagów, spełniających zadane kryteria
     */
    Set<Tag> getSetByTagnames(String tagnames);

    /**
     * Metoda zwraca wszytstkie tagi.
     *
     * @return lista tagó spłniających zadane kryterium
     */
    List<Tag> listAll();
}
