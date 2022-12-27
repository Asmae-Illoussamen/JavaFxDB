package services;
import dao.entities.Categorie;
import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategories();
    void addCategorie(Categorie categorie);
    void deleteCategorie(Categorie categorie);
    Categorie getCategorieById(int id) ;

}
