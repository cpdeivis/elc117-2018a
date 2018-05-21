import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import javafx.geometry.Pos;

public class HelloImage extends Application {

   public int iterador = 0;

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) {
      ArrayList<Image> vImages = new ArrayList<Image>();
      vImages.add(new Image("madeiras/acacia.png"));
      vImages.add(new Image("madeiras/carvalho.png"));
      vImages.add(new Image("madeiras/carvalhoescuro.png"));
      vImages.add(new Image("madeiras/eucalipto.png"));
      vImages.add(new Image("madeiras/pinheiro.png"));
      vImages.add(new Image("madeiras/selva.png"));
      //Image image = new Image("madeira.png");
      ImageView imageView = new ImageView(vImages.get(0));

      Button btnNX = new Button(">>");
      Button btnPV = new Button("<<");

      btnNX.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            iterador++;
            if(iterador > 5)
              iterador = 0;

            imageView.setImage(vImages.get(iterador));
         }
      });
      btnPV.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
           iterador--;
           if(iterador < 0)
             iterador = 5;

           imageView.setImage(vImages.get(iterador));
         }
      });

      StackPane root = new StackPane();
      root.getChildren().add(imageView);
      root.getChildren().add(btnNX);
      root.getChildren().add(btnPV);
      StackPane.setAlignment(btnNX, Pos.CENTER_RIGHT);
      StackPane.setAlignment(btnPV, Pos.CENTER_LEFT);
      stage.setScene(new Scene(root, 300, 250));
      stage.show();
   }
}
