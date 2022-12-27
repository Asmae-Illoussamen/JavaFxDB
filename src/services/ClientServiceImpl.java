package services;

import dao.ClientDaoImpl;
import dao.entities.Client;
import dao.ClientDao;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    ClientDao cdao;

    public ClientServiceImpl(ClientDao Cdao) {
        this.cdao = Cdao;
    }

    @Override
    public List<Client> getAllClients() {
        return cdao.findAll();
    }

    @Override
    public void addClient(Client c) {
        cdao.save(c);
    }

    @Override
    public void deleteClient(Client c) {
        cdao.delete(c);
    }

    @Override
    public List<Client> getClientsParMc(String mc)  {
        return cdao.findClientByMc(mc);
    }
}

