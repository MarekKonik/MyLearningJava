package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TILTE = "COST USE CAR";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
       /* Parent root = FXMLLoader.load(getClass().getResource("/fxml/logowanie.fxml"));
        primaryStage.setTitle( TILTE);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();*/

        FXMLLoader loader = FXMLLoader.load(getClass().getResource("/fxml/main_screen.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane,WIDTH,HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TILTE);
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
