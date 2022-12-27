package services;

import dao.CommandeDao;
import dao.entities.Commande;

import java.util.List;

public class CommandeServiceImpl implements CommandeService {
    private CommandeDao commandeDao;

    public CommandeServiceImpl(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeDao.findAll();
    }

    @Override
    public void addCommande(Commande commande) {
        commandeDao.save(commande);
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeDao.delete(commande);
    }


    @Override
    public Commande getCommandeById(int id) {
        return commandeDao.findOne(id);
    }
}
