package dao.entities;

import java.io.Serializable;

public class Commande implements Serializable {
    private int id_commande;
    private int num_commande;
    private Client client;
    private Float total;

    public Commande() {
    }
    public Commande(int num_commande,Client client, Float total) {
        this.num_commande = num_commande;
        this.client = client;
        total = total;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        total = total;
    }
}
