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
     * dla kolumny category - oznacza, że dany tag jest kategorią
     */
    boolean CATEGORY_TAG = true;
    /**
     * dla kolumny category - oznacza, że dany tag nie jest kategorią
     */
    boolean NOT_A_CATEGORY_TAG = false;

    /**
     * Metoda wyszukuje tagi nie będące kategorią.
     *
     * @param criteria kryterium wyboru - może być nazwa taga, lub powiązane z nim słowo
     * @return lista tagów
     */
    List<Tag> findAvaibleTags(String criteria);

    /**
     * Metoda przeszukuje tablice tagów wedle zadanej nazwy. Nie ma rozgraniczenia na kategorie.
     *
     * @param tagname nazwa taga do wyszukania
     * @return żądany tag
     */
    Tag findByTagname(String tagname);

    /**
     * Metoda wyszukuje kategorie, czyli tagi, będące kategoriami.
     *
     * @param criteria nazwa kategorii, lub słową z nią powiązane
     * @return lista kategorii spełniających zadane kryteria
     */
    List<Tag> findCategories(String criteria);

    /**
     * Metoda wyszukuje kategorie jedynie po nazwie.
     *
     * @param tagname nazwa kategorii
     * @return ządana kategoria
     */
    Tag findCategoryByTagname(String tagname);

    /**
     * Metoda wyszukuje tagi niebędące kategoriami po nazwie.
     *
     * @param criteria nazwa lub część nazwy taga
     * @return listan tagów spełaniających zadane kryterium
     */
    List<Tag> findTags(String criteria);

    /**
     * Metdoa zwraca {@link Set} tagów, których nazwy odpowiadają zadanym nazwom.
     *
     * @param tagnames łańcuch z nazwami tagów, oddzielonymi spacjami
     * @return set tagów, spełniających zadane kryteria
     */
    Set<Tag> getSetByTagnames(String tagnames);

    /**
     * MEtoda zwraca wszytstkie tagi, bądź kategorie.
     *
     * @param category czy zwrócone tagi mają być kategoriami?
     * @return lista tagó spłniających zadane kryterium
     */
    List<Tag> listAll(boolean category);
}
