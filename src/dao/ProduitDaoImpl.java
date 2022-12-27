package dao;

import dao.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProduitDaoImpl implements ProduitDao{
    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Produit");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId_produit(rs.getInt("id_produit"));
                produit.setName(rs.getString("nom_produit"));
                produit.setPrix(rs.getInt("prix"));
                //produit.setCategorie(rs.getString("categorie"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    @Override
    public Produit findOne(int id) {
        Produit produit = new Produit();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Produit where id_produit = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                produit.setId_produit(rs.getInt("id_produit"));
                produit.setName(rs.getString("nom_produit"));
                produit.setPrix(rs.getInt("prix"));
                //produit.setCategorie(rs.getString("categorie"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produit;
    }

    @Override
    public Produit save(Produit o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Produit (nom_produit, prix) VALUES (?, ?)");
            pstm.setString(1, o.getName());
            pstm.setInt(2, o.getPrix());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public boolean delete(Produit o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Produit WHERE id_produit = ?");
            pstm.setInt(1, o.getId_produit());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Produit update(Produit o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Produit SET nom_produit = ?, prix = ? WHERE id_produit = ?");
            pstm.setString(1, o.getName());
            pstm.setInt(2, o.getPrix());
            pstm.setInt(3, o.getId_produit());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public List<Produit> findProduitByMc(String mc) {
        List<Produit> produits = null;
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Produit where nom_produit like ?");
            pstm.setString(1, "%" + mc + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId_produit(rs.getInt("id_produit"));
                produit.setName(rs.getString("nom_produit"));
                produit.setPrix(rs.getInt("prix"));
                //produit.setCategorie(rs.getString("categorie"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }
}
