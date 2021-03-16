package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {


    private MainController mainController;


    @FXML
    void exit(ActionEvent event) {
        System.out.println("Nacisnoles exit");
    }

    @FXML
    void openApplication(ActionEvent event) {
        System.out.println("Nacisnoles open aplication");

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
        Pane pane;

        try {

            pane = loader.load();
            mainController.setScreen(pane);

        }catch (IOException e){
            e.printStackTrace();
        }



    }

    @FXML
    void openOption(ActionEvent event) {
        System.out.println("Nacisnoles opcje");


    }

    public void setMainController(MainController mainController) {

        this.mainController = mainController;
    }


}
