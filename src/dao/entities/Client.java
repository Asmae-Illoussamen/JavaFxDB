package dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private int id_client;
    private String name;
    private String adresse;
    private List<Commande> commandes = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public int getId_client() {
        return id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
