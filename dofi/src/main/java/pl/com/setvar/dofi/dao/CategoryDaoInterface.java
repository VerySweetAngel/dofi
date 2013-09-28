package pl.com.setvar.dofi.dao;

import java.util.List;
import pl.com.setvar.dofi.model.Category;

/**
 * * Interfejs operacji DAO dla klasy {@link pl.com.setvar.dofi.model.Category}. Implementuje go
 * {@link pl.com.setvar.dofi.dao.CategoryDao}.
 * 
 * @author tirpitz
 */
public interface CategoryDaoInterface extends GenericDaoInterface {

    /**
     * Metoda wynajduje kategorię po nazwie. Jeżeli nie ma, to zwraca {@code null}.
     * @param name nazwa katoegorii
     * @return kategoria spełniająca kryteria, bądź {@code null}
     */
    public Category findByName(String name);

    /**
     * Metoda zwraca liste wszytkich kategorii.
     * @return lista wszytkich kategorii
     */
    public List<Category> listAll();   
    
        /**
     * Metoda wyszukuje kategorie po nazwie.
     *
     * @param criteria nazwa lub część nazwy katoegorii
     * @return lista kategorii spełaniających zadane kryterium
     */
    List<Category> find(String criteria);
}
