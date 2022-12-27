package dao;

import dao.entities.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDaoImpl implements CommandeDao {

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from Commande");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Commande commande = new Commande();
                commande.setId_commande(rs.getInt("id_commande"));
                //commande.setClient(rs.getObject(1, "client"));
                commande.setTotal(rs.getFloat("total"));

                commandes.add(commande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commandes;
    }

        @Override
    public Commande findOne(int id) {

            Commande commande = new Commande();
            try {
                Connection connection = SingletonConnexionDB.getConnection();
                PreparedStatement pstm = connection.prepareStatement("select * from Commande where id_commande = ?");
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    commande.setId_commande(rs.getInt("id_commande"));
                    //commande.setClient(rs.getObject(1, "client"));
                    commande.setTotal(rs.getFloat("total")); }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return commande;
    }

    @Override
    public Commande save(Commande o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Commande (total , id_client) VALUES (?, ?)");
            pstm.setFloat(1, o.getTotal() );
            pstm.setFloat(2, o.getClient().getId_client());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public boolean delete(Commande o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Commande WHERE id_commande = ?");
            pstm.setInt(1, o.getId_commande());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Commande update(Commande o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("UPDATE Commande SET total = ?, id_client = ? WHERE id_commande = ?");
            pstm.setFloat(1, o.getTotal());
            pstm.setInt(2, o.getClient().getId_client());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }
}
