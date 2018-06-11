package planarity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 78:20
 * @author cpdeivis
 */
public class Planarity extends Application {
    private Pane aPuzzle;
    private int Level;
    private Grafo gPlanar;
    private GameLogica logica;

    public Planarity() {
        Level = 1;
        aPuzzle = new Pane();
        logica =  new GameLogica();
        gPlanar = logica.geraGrafo(Level);
        refreshPane();
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        root.getChildren().add(aPuzzle);
        
        Scene scene = new Scene(root, 900, 600);
        
        aPuzzle.setOnMouseReleased((MouseEvent e) -> {
            checkConseguiu();
        });
        
        primaryStage.setTitle("Planarity");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void checkConseguiu(){
        if(gPlanar.bContato())
            return;
        
        gPlanar.getVertices().forEach((ver) -> {
            ver.setCor(Color.GREENYELLOW);
        });
        
        Alert popup = new Alert(AlertType.INFORMATION);
        popup.setTitle("Sucesso");
        popup.setContentText("Fase: " + Level + " concluída\n");
        popup.setHeaderText(null);
        popup.showAndWait();
        Level++;
        
        gPlanar = logica.geraGrafo(Level);
        refreshPane();
    }
    
    private void refreshPane(){
        aPuzzle.getChildren().clear();
        
        gPlanar.getArestas().forEach((are) -> {
            aPuzzle.getChildren().add(are.getLinha());
        });
        gPlanar.getVertices().forEach((ver) -> {
            aPuzzle.getChildren().add(ver.getShape());
        });
    }
}
