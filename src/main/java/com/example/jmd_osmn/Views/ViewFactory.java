package com.example.jmd_osmn.Views;

import com.example.jmd_osmn.Controllers.Admin.AdminController;
import com.example.jmd_osmn.Controllers.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    //Client View

    private final ObjectProperty<ClientMenuOpion> clientSelectedMenuItem;
    private AnchorPane accountsView;
    private AnchorPane dashboardView;
    private AnchorPane transactionview;
    // Admin View

    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositeView;
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;

    public ViewFactory(){
        this.loginAccountType =AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<ClientMenuOpion> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView(){
        System.out.println("hello1");
        if (dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionviewiew() {
        System.out.println("hello");
        if (transactionview==null){

            try {
                transactionview = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionview;
    }

    public AnchorPane getAccountsView() {
        try {
            if (accountsView==null){
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return accountsView;
    }


    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
//        Scene scene=null;
//        try {
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("Solace Bank");
//        stage.show();
    }

    // Admin Viewers section

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getCreateClientView() {
        try {
            if (createClientView==null){
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return createClientView;
    }

    public AnchorPane getClientsView(){
        if (clientsView==null){
            try {
                clientsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Clients.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }

    public AnchorPane getDepositeView() {
        if (depositeView==null){
            try {
                depositeView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Deposite.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return depositeView;
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller =new AdminController();
        loader.setController(controller);
        createStage(loader);
//        ///
//        Scene scene=null;
//        try {
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("Solace Bank");
//        stage.show();
    }
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Login.fxml"));
        createStage(loader);
//        Scene scene=null;
//        try {
//            scene = new Scene(loader.load());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("Solace Bank");
//        stage.show();
    }
    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icons8-bank-60.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Solace Bank");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}
