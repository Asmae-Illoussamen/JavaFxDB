package presentation.controllers;
import dao.ClientDaoImpl;
import dao.entities.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ClientService;
import services.ClientServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    @FXML
    private TextField textNom;
    @FXML
    private TextArea textAdresse;
    @FXML
    private ListView<Client> listView;
    private ObservableList<Client> observableList= FXCollections.observableArrayList();
    private ClientService clientService;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientService=new ClientServiceImpl(new ClientDaoImpl());
        listView.setItems(observableList);
        loadClients();
    }
    @FXML
    private void addClient(){
        String nom=textNom.getText();
        String adresse=textAdresse.getText();

        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Client c=new Client(nom,adresse);
            clientService.addClient(c);
            loadClients();
        }
    }
    @FXML
    private void deleteClient(){
        Client c=listView.getSelectionModel().getSelectedItem();
        if(c!=null){
            clientService.deleteClient(c);
               loadClients();
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément !!");
            alert.show();
        }
    }

    private void loadClients(){
        observableList.clear();
        observableList.addAll(clientService.getAllClients());
    }


}
