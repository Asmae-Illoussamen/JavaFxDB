package presentation.controllers;

import dao.entities.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ClientService;

import java.io.Serializable;

public class ProduitController implements Serializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextArea textAdresse;
    @FXML
    private ListView<Client> listView;
    private ObservableList<Client> observableList= FXCollections.observableArrayList();
    private ClientService clientService;
}
