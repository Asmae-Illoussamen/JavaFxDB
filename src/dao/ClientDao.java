package dao;

import dao.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao extends Dao<Client> {
    List<Client> findClientByMc(String mc);
}

