package presentation;

import dao.ClientDaoImpl;
import dao.entities.Client;
import services.ClientService;
import services.ClientServiceImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ClientService cService = new ClientServiceImpl(new ClientDaoImpl());
        List<Client> clients = cService.getClientsParMc("e");

        for (Client c : clients) {
            System.out.println(c.getId_client() + " " + c.getName() + " " + c.getAdresse());
        }

    }
}
