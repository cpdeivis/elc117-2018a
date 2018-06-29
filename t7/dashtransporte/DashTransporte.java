//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author cpdeivis
 */
public class DashTransporte extends Application {
    private GraficosController graControl = null;
    private TabelaController tabControl = null;
    private FeederModel tratador = null;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefWidth(1366);

        FXMLLoader graficosLoader = new FXMLLoader(getClass().getResource("graficos.fxml"));
        root.setCenter(graficosLoader.load());
        graControl = graficosLoader.getController();

        FXMLLoader tabelaLoader = new FXMLLoader(getClass().getResource("tabela.fxml"));
        root.setLeft(tabelaLoader.load());
        tabControl = tabelaLoader.getController();

        Scene scene = new Scene(root);

        tratador = new FeederModel();
        tratador.getDados("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes");

        tabControl.initialize(tratador.getLista());
        graControl.initialize(tratador.getInercia(), tratador.getLinhas(), tratador.getInfo());

        stage.setScene(scene);
        stage.setTitle("Dashboard Transportes");
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();

        //Implementação "cachorra" de Threads
        startTask();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /* A implementação de código abaixo é totalmente baseada neste link:
    <https://examples.javacodegeeks.com/desktop-java/javafx/javafx-concurrency-example/> */
    public void startTask() {
	Runnable task = () -> {
            runTask();
        };
	// Executa a thread no background da aplicação
	Thread backgroundThread = new Thread(task);
	// Termina de executar caso saia da aplicação
	backgroundThread.setDaemon(true);
	// Inicia a thread
	backgroundThread.start();
    }
    public void runTask() {
	while(true) {
            try {
		Platform.runLater(() -> {
                    tratador.getDados("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes");
                    tabControl.updateData(tratador.getLista());
                    graControl.updateData(tratador.getInercia(), tratador.getLinhas(), tratador.getInfo());
                });

		Thread.sleep(120000);//2 min
            }
            catch (InterruptedException e) {
		e.printStackTrace();
            }
	}
    }
}
