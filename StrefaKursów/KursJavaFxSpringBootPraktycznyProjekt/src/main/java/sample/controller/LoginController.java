package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.dto.UserCredentialsDto;
import sample.factory.PopupFactory;
import sample.rest.Authenticator;
import sample.rest.AuthenticatorImpl;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {


    private PopupFactory popupFactory;
    private Authenticator authenticator;
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


    public LoginController(){
        popupFactory = new PopupFactory();
        authenticator = new AuthenticatorImpl();
    }

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

        Stage waitingPopup = popupFactory.createWaitingPopup("Connecting to the server...");
        waitingPopup.show();

        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setLogin(login);
        dto.setPassword(password);
        authenticator.authenticate(dto);

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
