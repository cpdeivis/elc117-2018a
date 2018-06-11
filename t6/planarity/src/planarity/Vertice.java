package planarity;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author cpdeivis
 */
public class Vertice {
    private Circle forma;
    private ArrayList<Aresta> caminhos;
    
    Vertice(double x, double y, Color cor){
        this.forma = new Circle(x, y, 20, cor);
        this.caminhos = new ArrayList<Aresta>();
        
        forma.setOnMouseDragged((MouseEvent e) -> {
            setX(e.getX());
            setY(e.getY());
            setCor(Color.RED);
        });
        forma.setOnMouseReleased((MouseEvent e) -> {
            setCor(Color.DARKSALMON);
        });
    }

    public ArrayList<Aresta> getCaminhos() {
        return caminhos;
    }
    
    public void addCaminhos(Aresta are){
        caminhos.add(are);
    }
    
    public double getX(){
        return forma.getCenterX();
    }
    
    public double getY(){
        return forma.getCenterY();
    }
    
    public void setX(double x){
        x = x < 20 ? 20 : (x > 880 ? 880 : x);
        forma.setCenterX(x);
        
        for (Aresta are : caminhos){
            if(are.getInicio() == this)
                are.getLinha().setStartX(x);
            else
                are.getLinha().setEndX(x);
        }
    }
    
    public void setY(double y){
        y = y < 20 ? 20 : (y > 580 ? 580 : y);
        forma.setCenterY(y);
        
        for (Aresta are : caminhos){
            if(are.getInicio() == this)
                are.getLinha().setStartY(y);
            else
                are.getLinha().setEndY(y);
        }
    }
    
    public void setCor(Color cor){
        forma.setFill(cor);
    }
    
    public Circle getShape(){
        return forma;
    }
}
