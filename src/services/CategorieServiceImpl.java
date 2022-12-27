package services;
import dao.entities.Categorie;
import java.util.List;
import dao.CategorieDao;
public class CategorieServiceImpl implements CategorieService {
    private CategorieDao categorieDao;

    public CategorieServiceImpl(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    @Override
    public void addCategorie(Categorie categorie) {
        categorieDao.save(categorie);
    }

    @Override
    public void deleteCategorie(Categorie categorie) {
        categorieDao.delete(categorie);
    }

    @Override
    public Categorie getCategorieById(int id) {
        return categorieDao.findOne(id);
    }
}
