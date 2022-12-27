package services;

import dao.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {
    //les fonctionnalités d'un client (CRUD)

    List<Client> getAllClients() ;
    void addClient(Client client);
    void deleteClient(Client client);
    List<Client> getClientsParMc(String mc) ;

}
