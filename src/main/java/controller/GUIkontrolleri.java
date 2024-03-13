package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.IVisualisointi;
import view.Visualisointi2;
import view.ISimulaattorinUI;

import java.text.DecimalFormat;

public class GUIkontrolleri implements ISimulaattorinUI, IKontrolleriForV {
    @FXML
    private Button kaynnistaButton;
    @FXML
    private Button hidastaButton;
    @FXML
    private Button nopeutaButton;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField aika;
    @FXML
    private TextField viive;
    @FXML
    private Label tulos;
    @FXML
    private Button openChartsButton;
    private ChartWindowController chartController;
    @FXML
    private TextArea eventLog;
    private IVisualisointi visualisointi;
    private IKontrolleriForV kontrolleri;

    private Parent root;

    public GUIkontrolleri() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChartWindow.fxml"));
        Parent root = loader.load();

        chartController = loader.getController();
    }

    public void updateCanvas() {
        canvas.getGraphicsContext2D().drawImage(visualisointi.getCanvas().snapshot(null, null), 0, 0);
    }

    public void logEvent(String eventText) {
        eventLog.appendText(eventText + "\n");
    }

    public void initialize() {
        kontrolleri = new Kontrolleri(this);
        visualisointi = new Visualisointi2((int)canvas.getWidth(), (int)canvas.getHeight());
        canvas.getGraphicsContext2D().drawImage(visualisointi.getCanvas().snapshot(null, null), 0, 0);
    }

    @FXML
    private void handleKaynnistaButtonAction() {
        kontrolleri.kaynnistaSimulointi();
        updateCanvas();
    }

    @FXML
    private void handleHidastaButtonAction() {
        kontrolleri.hidasta();
        updateCanvas();
    }

    @FXML
    private void handleNopeutaButtonAction() {
        kontrolleri.nopeuta();
        updateCanvas();
    }

    @FXML
    private void handleOpenChartsButtonAction() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChartWindow.fxml"));
        Parent root = loader.load();

        chartController = loader.getController();

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Charts");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public ChartWindowController getChartController() {
        return chartController;
    }

    public void enableOpenChartsButton() {
        openChartsButton.setDisable(false);
    }

    @Override
    public double getAika() {
        return Double.parseDouble(aika.getText());
    }
    @Override
    public long getViive() {
        return Long.parseLong(viive.getText());
    }

    @Override
    public void setLoppuaika(double aika) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        this.tulos.setText(formatter.format(aika));
    }

    @Override
    public IVisualisointi getVisualisointi() {
        return visualisointi;
    }


    @Override
    public void kaynnistaSimulointi() {
        kontrolleri.kaynnistaSimulointi();
    }

    @Override
    public void nopeuta() {
        kontrolleri.nopeuta();
    }

    @Override
    public void hidasta() {
        kontrolleri.hidasta();
    }
}