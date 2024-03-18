package view;

import controller.GUIkontrolleri;
import controller.IKontrolleriForV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * SimulaattorinGUI-luokka, joka käynnistää simulaattorin käyttöliittymän.
 */
public class SimulaattorinGUI extends Application {

    private IKontrolleriForV kontrolleri;

    /**
     * Käynnistää simulaattorin käyttöliittymän.
     *
     * @param primaryStage ensisijainen näyttämö sovellukselle
     * @throws Exception jos käyttöliittymän käynnistämisessä tapahtuu virhe
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pankki_simulaatio.fxml"));
        Parent root = loader.load();

        kontrolleri = loader.getController();

        root.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Simulaattori");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Käynnistää simulaattorin.
     *
     * @param args komentoriviparametrit
     */
    public static void main(String[] args) {
        launch(args);
    }
}