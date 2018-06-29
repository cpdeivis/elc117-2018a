//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author cpdeivis
 */
public class GraficosController{
    @FXML
    private PieChart graInercia;
    @FXML
    private BarChart graIneLinha;
    @FXML
    private Label lblServidor;
    @FXML
    private Label lblQtd;
    @FXML
    private Label lblRecente;
    @FXML
    private Label lblAntiga;

    public void initialize(int inercia[], Map<String, Long> linhas, String[] info) {
        setPieChart(inercia);
        setBarChart(linhas);
        setLabels(info);
    }

    public void updateData(int inercia[], Map<String, Long> linhas, String[] info) {
        graInercia.getData().clear();
        graInercia.layout();
        setPieChart(inercia);
        graIneLinha.getData().clear();
        graIneLinha.layout();
        setBarChart(linhas);
        setLabels(info);
    }

    private void setLabels(String infos[]){
        lblQtd.setText(infos[0]);
        lblServidor.setText(infos[1]);
        lblRecente.setText(infos[2]);
        lblAntiga.setText(infos[3]);
    }

    private void setPieChart(int inercia[]){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Em Movimento - " + inercia[0],inercia[0]),
                new PieChart.Data("Parado - " + inercia[1], inercia[1])
        );
        graInercia.setData(pieChartData);
    }

    private void setBarChart(Map<String, Long> linhas){
        XYChart.Series<String, Long> dataSeries = new XYChart.Series<>();
        linhas.forEach((key, val) ->{
            dataSeries.getData().add(new XYChart.Data<>(key, val));
        });

        graIneLinha.getData().add(dataSeries);
    }
}
