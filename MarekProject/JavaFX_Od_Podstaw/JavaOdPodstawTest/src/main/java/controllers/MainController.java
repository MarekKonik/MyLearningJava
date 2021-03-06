package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {
    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();


        } catch (IOException e) {
            e.printStackTrace();
        }
        mainStackPane.getChildren().add(pane);
    }
}
