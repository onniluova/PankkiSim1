package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import view.IVisualisointi;
import view.Visualisointi2;
import view.ISimulaattorinUI;
import javafx.scene.chart.LineChart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.text.DecimalFormat;

public class GUIkontrolleri implements ISimulaattorinUI, IKontrolleriForV {
    @FXML
    private Button chartsButton;
    @FXML
    private Button kaynnistaButton;
    @FXML
    private Button hidastaButton;
    @FXML
    private Button nopeutaButton;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField aika; // Add this line
    @FXML
    private TextField viive; // Add this line
    @FXML
    private Label tulos; // Add this line

    @FXML
    private TextArea eventLog;

    @FXML
    private LineChart<?, ?> LineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TextField palveluaikaField;

    XYChart.Series series;

    private ChartsIkkunaController chartController;

    private IVisualisointi visualisointi;
    private IKontrolleriForV kontrolleri;

    FXMLLoader fxmlLoader;
    /**
     * Päivittää kankaan.
     */
    public void updateCanvas() {
        canvas.getGraphicsContext2D().drawImage(visualisointi.getCanvas().snapshot(null, null), 0, 0);
    }
    /**
     * Kirjaa tapahtuman.
     *
     * @param eventText Tapahtuman teksti.
     */
    public void logEvent(String eventText) {
        eventLog.appendText(eventText + "\n");
    }
    /**
     * Alustaa komponentit.
     */
    public void initialize() {
        kontrolleri = new Kontrolleri(this);
        visualisointi = new Visualisointi2((int)canvas.getWidth(), (int)canvas.getHeight());
        canvas.getGraphicsContext2D().drawImage(visualisointi.getCanvas().snapshot(null, null), 0, 0);
        chartController = new ChartsIkkunaController();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ChartIkkuna.fxml"));
            fxmlLoader.load();
            chartController = fxmlLoader.getController();
            chartController.initializeChart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Käsittelee "Käynnistä"-painikkeen toiminnon.
     */
    @FXML
    private void handleKaynnistaButtonAction() {
        kontrolleri.kaynnistaSimulointi();
        updateCanvas();
    }
    /**
     * Käsittelee "Hidasta"-painikkeen toiminnon.
     */
    @FXML
    private void handleHidastaButtonAction() {
        kontrolleri.hidasta();
        updateCanvas();
    }
    /**
     * Käsittelee "Nopeuta"-painikkeen toiminnon.
     */
    @FXML
    private void handleNopeutaButtonAction() {
        kontrolleri.nopeuta();
        updateCanvas();
    }
    /**
     * Palauttaa palveluajan.
     *
     * @return Palveluaika.
     */
    @Override
    public double getPalveluaika() {
        try {
            return Double.parseDouble(palveluaikaField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input in palveluaikaField. Please enter a valid number.");
            return 0.0;
        }
    }
    /**
     * Palauttaa ajan.
     *
     * @return Aika.
     */
    @Override
    public double getAika() {
        return Double.parseDouble(aika.getText());
    }
    /**
     * Palauttaa viiveen.
     *
     * @return Viive.
     */
    @Override
    public long getViive() {
        return Long.parseLong(viive.getText());
    }
    /**
     * Asettaa loppuajan.
     *
     * @param aika Loppuaika.
     */
    @Override
    public void setLoppuaika(double aika) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        this.tulos.setText(formatter.format(aika));
    }
    /**
     * Palauttaa visualisoinnin.
     *
     * @return Visualisointi.
     */
    @Override
    public IVisualisointi getVisualisointi() {
        return visualisointi;
    }
    /**
     * Käynnistää simuloinnin.
     */
    @Override
    public void kaynnistaSimulointi() {
        kontrolleri.kaynnistaSimulointi();
    }
    /**
     * Nopeuttaa simulointia.
     */
    @Override
    public void nopeuta() {
        kontrolleri.nopeuta();
    }
    /**
     * Hidastaa simulointia.
     */
    @Override
    public void hidasta() {
        kontrolleri.hidasta();
    }
    /**
     * Käsittelee "Kaaviot"-painikkeen toiminnon.
     *
     * @param actionEvent Tapahtuma.
     */
    @FXML
    private void handleChartsButtonAction(ActionEvent actionEvent) {
        try {
            Scene scene = new Scene(chartController.getLineChart().getParent());
            Stage chartStage = new Stage();
            chartStage.setTitle("Charts");
            chartStage.setScene(scene);
            chartStage.show();
        } catch (Error e) {
            e.printStackTrace();
        }
    }
    /**
     * Palauttaa kaavioikkunan ohjaimen.
     *
     * @return Kaavioikkunan ohjain.
     */
    public ChartsIkkunaController getChartController() {
        if (chartController == null) {
            try {
                fxmlLoader = new FXMLLoader(getClass().getResource("/ChartIkkuna.fxml"));
                fxmlLoader.load();
                chartController = fxmlLoader.getController();
                chartController.initializeChart();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return chartController;
    }
}