package dao.entities;

public class Categorie {
    int id_categorie;
    String nom_categorie;

    public Categorie() {
    }
    public Categorie(String name) {
        this.nom_categorie = name;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public String getName() {
        return nom_categorie;
    }
    public void setName(String name) {
        this.nom_categorie = name;
    }
    @Override
    public String toString(){
        return "Categorie{" +
                "id_categorie=" + id_categorie +
                ", name='" + nom_categorie + '\'' +
                '}';
    }

}
