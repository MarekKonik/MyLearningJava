package sample.factory;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.handler.InfoPopupOKHandler;

public class PopupFactory {

    public Stage createWaitingPopup(String text) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        VBox pane = new VBox();
        pane.setStyle(waitingPopupPaneStyle());
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);

        Label label = new Label(text);
        label.setStyle(waitnigLabelStyle());

        ProgressBar progressBar = new ProgressBar();
        pane.getChildren().addAll(label,progressBar);



        stage.setScene(new Scene(pane, 200, 100));
        stage.initModality(Modality.APPLICATION_MODAL);

        return stage;
    }

    private String waitnigLabelStyle() {
        return "-fx-text-fill: #003366;";
    }

    private String waitingPopupPaneStyle() {
        return "-fx-background-color: #c7c7c7; -fx-border-color: #003366;";
    }

    private String okButtonStyle(){
        return " -fx-text-fill: -fx-primary-blue;\n" +
                "        -fx-background-color: #c7c7c7;\n" +
                "        -fx-border-color: #003366;\n" +
                "        -fx-background-radius: 0;";
    }

    private String okButtonHoverStyle(){
        return " -fx-text-fill: -fx-primary-blue;\n" +
                "        -fx-background-color: #e1e1e1;\n" +
                "        -fx-border-color: #003366;\n" +
                "        -fx-background-radius: 0;";
    }







    public Stage createInfoPopup(String text, InfoPopupOKHandler hendler) {

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        VBox pane = new VBox();
        pane.setStyle(waitingPopupPaneStyle());
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);

        Label label = new Label(text);
        label.setStyle(waitnigLabelStyle());

        Button okButton = new Button("OK");
        okButton.setStyle(okButtonStyle());
        okButton.setOnMouseEntered(x->{
            okButton.setStyle(okButtonHoverStyle());
        });
        okButton.setOnMouseExited(x->{
            okButton.setStyle(okButtonStyle());
        });
        okButton.setOnAction(x->{
            stage.close();
            hendler.handle();
        });



        pane.getChildren().addAll(label,okButton);



        stage.setScene(new Scene(pane, 200, 100));
        stage.initModality(Modality.APPLICATION_MODAL);

        return stage;



    }
}
