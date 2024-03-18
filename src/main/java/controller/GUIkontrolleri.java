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

    XYChart.Series series;

    private ChartsIkkunaController chartController;

    private IVisualisointi visualisointi;
    private IKontrolleriForV kontrolleri;

    FXMLLoader fxmlLoader;

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
        chartController = new ChartsIkkunaController();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ChartIkkuna.fxml"));
            fxmlLoader.load();
            chartController = fxmlLoader.getController();
            chartController.initializeChart();
        } catch (IOException e) {
            e.printStackTrace();
        }

        eventLog.setText("Initialization complete");
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