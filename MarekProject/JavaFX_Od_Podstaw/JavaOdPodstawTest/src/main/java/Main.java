import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final static int WIDTH = 700;
    private final static int HEIGHT = 400;
    private final static String Title = "Marek Konik - JavaFX";

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainScreen.fxml"));
        primaryStage.setTitle("Marek - JavaFX");
        primaryStage.setScene(new Scene(root, WIDTH,HEIGHT));
        primaryStage.show();*/

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane,WIDTH,HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Title);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
