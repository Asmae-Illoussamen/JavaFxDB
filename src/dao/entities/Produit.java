package dao.entities;

public class Produit {
    private int id_produit;
    private String nom_produit;
    private int prix;
    private Categorie categorie;

    public Produit() {
    }
    public Produit(String name, int prix, Categorie categorie) {
        this.nom_produit = name;
        this.prix = prix;
        this.categorie = categorie;
    }
    public int getId_produit() {
        return id_produit;
    }
    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
    public String getName() {
        return nom_produit;
    }
    public void setName(String name) {
        this.nom_produit = name;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    @Override
    public String toString(){
        return "Produit{" +
                "id_client=" + id_produit +
                ", name='" + nom_produit + '\'' +
                ", prix='" + prix + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
