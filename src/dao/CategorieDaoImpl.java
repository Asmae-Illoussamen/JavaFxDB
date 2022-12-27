package dao;

import dao.entities.Categorie;
import dao.entities.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl  implements CategorieDao {

    @Override
    public List<Categorie> findAll() {
        List<Categorie> categories = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Categorie");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Categorie categorie = new Categorie();
                categorie.setId_categorie(rs.getInt("id_categorie"));
                categorie.setName(rs.getString("nom_categorie"));

                categories.add(categorie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Categorie findOne(int id) {

            Categorie categorie = new Categorie();
            try {
                Connection connection = SingletonConnexionDB.getConnection();
                PreparedStatement pstm = connection.prepareStatement("select * from Categorie where id_categorie = ?");
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    categorie.setId_categorie(rs.getInt("id_categorie"));
                    categorie.setName(rs.getString("nom_categorie")); }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return categorie;
    }

    @Override
    public Categorie save(Categorie o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Categorie (nom_categorie) VALUES (?)");
            pstm.setString(1, o.getName());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public boolean delete(Categorie o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Categorie WHERE id_categorie = ?");
            pstm.setInt(1, o.getId_categorie());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Categorie update(Categorie o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Categorie SET nom_categorie = ? WHERE id_categorie = ?");
            pstm.setString(1, o.getName());
            pstm.setInt(2, o.getId_categorie());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }
}

