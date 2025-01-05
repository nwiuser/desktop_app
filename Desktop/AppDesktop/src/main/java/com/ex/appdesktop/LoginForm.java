package com.ex.appdesktop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(grid, 700, 500);
        Text text = new Text("Login : ");

        Label user = new Label("User Name");
        TextField username = new TextField();

        Label pswd = new Label("Password : ");
        PasswordField password = new PasswordField();

        grid.add(user,0,0);
        grid.add(username,1,0);
        grid.add(pswd,0,2);
        grid.add(password,1,2);

        Button btn = new Button("Login");
        HBox hbtn = new HBox(20);
        hbtn.setAlignment(Pos.BOTTOM_CENTER);
        hbtn.getChildren().add(btn);
        grid.add(hbtn,1,4);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}