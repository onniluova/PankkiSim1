package view;

import controller.GUIkontrolleri;
import controller.IKontrolleriForV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SimulaattorinGUI extends Application {

    private IKontrolleriForV kontrolleri;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pankki_simulaatio.fxml"));
        Parent root = loader.load();

        kontrolleri = loader.getController();

        // Add the CSS file to the root object
        root.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Simulaattori");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}