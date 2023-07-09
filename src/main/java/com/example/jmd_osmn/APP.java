package com.example.jmd_osmn;

import com.example.jmd_osmn.Models.Model;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class APP extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();

    }
}
