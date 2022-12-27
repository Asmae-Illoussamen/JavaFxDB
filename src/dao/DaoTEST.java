package dao;

import dao.entities.Client;

import java.sql.SQLException;
import java.util.List;

public class DaoTEST {
    public static void main(String[] args) throws SQLException {
        ClientDao cDao = new ClientDaoImpl();
       /* Client clt = new Client("Client 1", "Adresse 1");
        cDao.save(clt); // Ajout a la BD*/

        Client client = cDao.findOne(3);
        client.setName("Client 1 modifié");
        client.setAdresse("Adresse 1 modifiée");
        cDao.update(client);



        List<Client> clients = cDao.findAll();
        for (Client c : clients) {
            System.out.println(c.getId_client() +" "+ c.getName() +" "+ c.getAdresse());
        }
    }
}
