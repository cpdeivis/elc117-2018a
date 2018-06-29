//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author cpdeivis
 */
public class TabelaController{
    @FXML
    private TableView<DataTable> tabAllData;
    @FXML
    private TableColumn<DataTable,String> dataCol;
    @FXML
    private TableColumn<DataTable,String> ordemCol;
    @FXML
    private TableColumn<DataTable,String> linhaCol;
    @FXML
    private TableColumn<DataTable,Float> latCol;
    @FXML
    private TableColumn<DataTable,Float> lonCol;
    @FXML
    private TableColumn<DataTable,Float> velCol;
    @FXML
    private TableColumn<DataTable,DataTable> gMaps;

    @FXML
    private CheckBox cbVelocidade;
    @FXML
    private CheckBox cbFiltragem;
    @FXML
    private TextField txtLinha;
    @FXML
    private Button btnShow;

    private ObservableList<DataTable> masterData = FXCollections.observableArrayList();

    public void initialize(ArrayList<DataModel> dados) {
        // TODO
        dataCol.setCellValueFactory(new PropertyValueFactory<>("DataHora"));
        ordemCol.setCellValueFactory(new PropertyValueFactory<>("Ordem"));
        linhaCol.setCellValueFactory(new PropertyValueFactory<>("Linha"));
        latCol.setCellValueFactory(new PropertyValueFactory<>("Lat"));
        lonCol.setCellValueFactory(new PropertyValueFactory<>("Lon"));
        velCol.setCellValueFactory(new PropertyValueFactory<>("Vel"));
        gMaps.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

        gMaps.setCellFactory(param -> new TableCell<DataTable, DataTable>() {
            private final Button btngMaps = new Button("gMaps");
            @Override
            protected void updateItem(DataTable person, boolean empty) {
                super.updateItem(person, empty);
                if (person == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(btngMaps);
                //deleteButton.setOnAction(event -> data.remove(person));
                btngMaps.setOnAction((ActionEvent event) -> {
                    Parent root;
                    try {
                        FXMLLoader fxmlgMaps = new FXMLLoader(getClass().getResource("gMaps.fxml"));
                        root = fxmlgMaps.load();
                        GMapsController controller = fxmlgMaps.getController();
                        controller.initialize(person.LatProperty().get(), person.LonProperty().get(), person.OrdemProperty().get());

                        Stage stage = new Stage();
                        stage.setTitle("Localização");
                        stage.setScene(new Scene(root, 500, 500));
                        stage.setResizable(false);
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        btnShow.setOnAction((ActionEvent event) -> {
            if(cbFiltragem.isSelected()){
                FilteredList<DataTable> filteredData = new FilteredList<>(masterData);
                filteredData.setPredicate(elem -> {
                    String val = txtLinha.getText().toLowerCase();
                    if(((DataTable)elem).LinhaProperty().get().toLowerCase().contains(val)){
                        return !(cbVelocidade.isSelected() && ((DataTable)elem).VelProperty().get() > 0);
                    } else
                        return false;
                });
                tabAllData.setItems(filteredData);
            } else{
                tabAllData.setItems(masterData);
            }
        });

        setItens(dados);
        tabAllData.setItems(masterData);
    }

    public void updateData(ArrayList<DataModel> dados){
        setItens(dados);
        if(!cbFiltragem.isSelected()){
            tabAllData.setItems(masterData);
        }
    }

    private void setItens(ArrayList<DataModel> dados){
        masterData.clear();
        dados.forEach((dado) -> {
            masterData.add(new DataTable(dado));
        });
    }

    //Representação da DataModel para ser usada na tabela
    public static class DataTable{
        private final SimpleStringProperty DataHora;
        private final SimpleStringProperty Ordem;
        private final SimpleStringProperty Linha;
        private final SimpleFloatProperty Lat;
        private final SimpleFloatProperty Lon;
        private final SimpleFloatProperty Vel;

        public DataTable(DataModel elemento) {
            this.DataHora = new SimpleStringProperty(elemento.getDataHora());
            this.Ordem = new SimpleStringProperty(elemento.getOrdem());
            this.Linha = new SimpleStringProperty(elemento.getLinha());
            this.Lat = new SimpleFloatProperty(elemento.getLatitude());
            this.Lon = new SimpleFloatProperty(elemento.getLongitude());
            this.Vel = new SimpleFloatProperty(elemento.getVelocidade());
        }

        public SimpleStringProperty DataHoraProperty() {
            return DataHora;
        }
        public SimpleFloatProperty LatProperty() {
            return Lat;
        }
        public SimpleStringProperty LinhaProperty() {
            return Linha;
        }
        public SimpleFloatProperty LonProperty() {
            return Lon;
        }
        public SimpleStringProperty OrdemProperty() {
            return Ordem;
        }
        public SimpleFloatProperty VelProperty() {
            return Vel;
        }
    }
}
