package com.example.jmd_osmn.Controllers.Admin;

import com.example.jmd_osmn.Models.Model;
import com.example.jmd_osmn.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposite_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    addListeners();
    }
    private void addListeners(){
        create_client_btn.setOnAction(event->onCreateClient());
        clients_btn.setOnAction(event-> onClients());
        deposite_btn.setOnAction(event->onDeposite());
    }
    private void onCreateClient(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENTS);
    }
    private void onClients(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }
    private void onDeposite(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSITE);
    }
}
