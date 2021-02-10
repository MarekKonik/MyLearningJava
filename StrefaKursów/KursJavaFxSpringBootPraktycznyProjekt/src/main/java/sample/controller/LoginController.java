package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeExitButton();
        initializeLoginButton();

    }

    private void initializeLoginButton() {
        loginButton.setOnAction((x) -> {
            performAutentication();
        });
    }

    private void performAutentication() {

        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        System.out.println("Login: "+login);
        System.out.println("Password "+password);
    }

    private void initializeExitButton() {
        System.out.println("LoginController initialize");
        exitButton.setOnAction((x) -> {
            System.out.println("exitButton action");
            getStage().close();
        });
    }

    private Stage getStage() {
        return (Stage) loginAnchorPane.getScene().getWindow();
    }


}
