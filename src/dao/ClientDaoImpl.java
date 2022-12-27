package dao;

import dao.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public List<Client> findAll() {
        List <Client> clients = new ArrayList<>();

        try {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Client");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Client client = new Client();
            client.setId_client(rs.getInt("id_client"));
            client.setName(rs.getString("name"));
            client.setAdresse(rs.getString("adresse"));
            clients.add(client);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    @Override
    public Client findOne(int id) {
        Client client = new Client();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Client where id_client = ?");
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            client.setId_client(rs.getInt("id_client"));
            client.setName(rs.getString("name"));
            client.setAdresse(rs.getString("adresse"));
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return client;
    }
    @Override
    public Client save(Client o)  {
        try {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Client (name, adresse) VALUES (?, ?)");
        pstm.setString(1, o.getName());
        pstm.setString(2, o.getAdresse());
        pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public boolean delete(Client o)  {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM Client WHERE id_client = ?");
            pstm.setInt(1, o.getId_client());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Client update(Client o)  {
       try {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Client SET name = ?, adresse = ? WHERE id_client = ?");
        pstm.setString(1, o.getName());
        pstm.setString(2, o.getAdresse());
        pstm.setInt(3, o.getId_client());
        pstm.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
        return o;
    }

    @Override
    public List<Client> findClientByMc(String mc)  {
        List <Client> clients = new ArrayList<>();
        try {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Client where name like ?");
        pstm.setString(1, "%"+mc+"%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Client client = new Client();
            client.setId_client(rs.getInt("id_client"));
            client.setName(rs.getString("name"));
            client.setAdresse(rs.getString("adresse"));
            clients.add(client);
        }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
        return clients;
    }
}

