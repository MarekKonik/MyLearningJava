package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {


    private final static String EMPLOYEE_MODULE_VIEW = "/fxml/employee.fxml";
    private final static String WAREHOUSE_MODULE_VIEW = "/fxml/warehouse.fxml";
    private final static String LOGIN_VIEW = "/fxml/login.fxml";

    @FXML
    private Pane appPane;


    @FXML
    private BorderPane appBorderPane;


    @FXML
    private MenuItem employeeModuleMenuItem;

    @FXML
    private MenuItem warehouseModuleMenuItem;

    @FXML
    private MenuItem logoutMenueItem;

    @FXML
    private MenuItem exitMenueItem;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadDefaultView();

    }

    private void loadDefaultView() {

        loadModuleView(EMPLOYEE_MODULE_VIEW);
        initializeMenuItems();

    }

    private void initializeMenuItems() {
        warehouseModuleMenuItem.setOnAction(x->loadModuleView(WAREHOUSE_MODULE_VIEW));
        employeeModuleMenuItem.setOnAction(x->loadModuleView(EMPLOYEE_MODULE_VIEW));
        logoutMenueItem.setOnAction(x->logout());
        exitMenueItem.setOnAction(x->getStage().close());



    }

    private void logout() {

        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource(LOGIN_VIEW));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, Main.WIDTH,Main.HEIGHT));
            stage.show();
            getStage().close();

        } catch (IOException e) {
            throw new RuntimeException("Can't load fxml file: " + LOGIN_VIEW);
        }


    }


    private void loadModuleView(String viewPath) {
        appPane.getChildren().clear();

        try {

            BorderPane borderPane = FXMLLoader.load(getClass().getResource(viewPath));
            appPane.getChildren().add(borderPane);

        } catch (IOException e) {
            throw new RuntimeException("Can't load fxml file: " + viewPath);
        }


    }


    private Stage getStage() {
        return (Stage) appBorderPane.getScene().getWindow();
    }

}
