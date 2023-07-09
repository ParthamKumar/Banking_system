module com.example.jmd_osmn {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.jmd_osmn to javafx.fxml;
    exports com.example.jmd_osmn;
    exports com.example.jmd_osmn.Controllers;
    exports com.example.jmd_osmn.Controllers.Admin;
    exports com.example.jmd_osmn.Controllers.Client;
    exports com.example.jmd_osmn.Models;
    exports com.example.jmd_osmn.Views;

}