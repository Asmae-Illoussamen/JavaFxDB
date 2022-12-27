package services;

import dao.entities.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> getAllCommandes() ;
    void addCommande(Commande commande);
    void deleteCommande(Commande commande);
    Commande getCommandeById(int id) ;



}
