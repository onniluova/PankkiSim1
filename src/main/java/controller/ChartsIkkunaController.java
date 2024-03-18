package controller; // Match the package of your FXML file

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class ChartsIkkunaController {
    @FXML
    private LineChart<?, ?> LineChart;
    @FXML
    private CategoryAxis x; // Make sure this matches the fx:id in the FXML
    @FXML
    private NumberAxis y;

    private XYChart.Series pankkiaikaData;
    private XYChart.Series arvioData;

    /**
     * Alustaa kaavion X- ja Y-akselin otsikoilla ja kahdella datasarjalla.
     */

    public void initializeChart() {
        x.setLabel("X-Axis");  // Example label
        y.setLabel("Y-Axis");  // Example label

        pankkiaikaData = new XYChart.Series();
        pankkiaikaData.setName("Pankkiaika");
        LineChart.getData().add(pankkiaikaData);

        arvioData = new XYChart.Series();
        arvioData.setName("Arviot");
        LineChart.getData().add(arvioData);
    }
    /**
     * Lisää kaaviotietoja 'Pankkiaika' sarjaan.
     *
     * @param poistumisajat Lista poistumisaikoja, jotka lisätään kaavioon.
     */

    public void addChartData(List<Double> poistumisajat) {
        int index = 0;
        for (double aika : poistumisajat) {
            pankkiaikaData.getData().add(new XYChart.Data<>(String.valueOf(index++), aika));
        }
    }
    /**
     * Lisää tietoa 'Arviot' sarjaan.
     *
     * @param x Datapisteen x-koordinaatti.
     * @param y Datapisteen y-koordinaatti.
     */

    public void addArvioData(double x, double y) {
        arvioData.getData().add(new XYChart.Data<>(String.valueOf(x), y));
    }
    /**
     * Palauttaa LineChart-objektin.
     *
     * @return LineChart-objekti.
     */

    public LineChart<?, ?> getLineChart() {
        return LineChart;
    }
}
