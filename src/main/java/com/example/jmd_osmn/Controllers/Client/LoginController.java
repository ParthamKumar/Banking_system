package com.example.jmd_osmn.Controllers.Client;

import com.example.jmd_osmn.Models.Model;
import com.example.jmd_osmn.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button logn_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT,AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        logn_btn.setOnAction(actionEvent -> on_login());

    }
    private void on_login(){
        Stage stage = (Stage)logn_btn.getScene().getWindow();


        if (Model.getInstance().getViewFactory().getLoginAccountType()==AccountType.CLIENT){
            Model.getInstance().getViewFactory().showClientWindow();
            // Evaluate Client login Credentials
            Model.getInstance().evaluateClientCred(payee_address_fld.getText(),password_fld.getText());
            //if (Model.getInstance().getClientLoginSuccessFlag()){
           //     Model.getInstance().getViewFactory().showClientWindow();
            //    //Close the login window
            //    Model.getInstance().getViewFactory().closeStage(stage);
           // }else {
           //     payee_address_fld.setText("");
           //     password_fld.setText("");
           //     error_lbl.setText("No such Login Credentials");
           // }

        }else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
