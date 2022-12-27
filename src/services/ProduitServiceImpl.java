package services;

import dao.entities.Produit;
import dao.ProduitDao;

import java.util.List;

public class ProduitServiceImpl implements ProduitService {
    ProduitDao pdao;

    public ProduitServiceImpl(ProduitDao Pdao) {
        this.pdao = Pdao;
    }

    @Override
    public List<Produit> getAllProduits() {
        return pdao.findAll();
    }

    @Override
    public void addProduit(Produit p) {
        pdao.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        pdao.delete(p);
    }

    @Override
    public List<Produit> getProduitParMc(String mc) {
        return pdao.findProduitByMc(mc);
    }
}

