package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ChartWindowController {
    @FXML
    private LineChart<String, Number> reviewChart;

    @FXML
    private LineChart<String, Number> avgTimeChart;


    public void updateReviewChart(XYChart.Series<String, Number> data) {
        reviewChart.getData().clear();
        reviewChart.getData().add(data);
    }

    public void updateAvgTimeChart(XYChart.Series<String, Number> data) {
        avgTimeChart.getData().clear();
        avgTimeChart.getData().add(data);
    }
}