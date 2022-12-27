package dao;

import dao.entities.Produit;

import java.util.List;

public interface ProduitDao extends Dao<Produit> {
    List<Produit> findProduitByMc(String mc);
}

