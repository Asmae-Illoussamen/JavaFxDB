package services;


import dao.entities.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits() ;
    void addProduit(Produit produit);
    void deleteProduit(Produit produit);
    List<Produit> getProduitParMc(String mc) ;
}
