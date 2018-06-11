package planarity;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 *
 * @author cpdeivis
 */
public class Aresta {
    private Vertice inicio;
    private Vertice fim;
    private Line linha;
    
    Aresta(Vertice i, Vertice f){
        this.inicio = i;
        this.fim = f;
        this.linha = new Line(i.getX(), i.getY(), f.getX(), f.getY());
    }
    
    public Vertice getInicio() {
        return inicio;
    }
    
    public Vertice getFim() {
        return fim;
    }
    
    public Line getLinha(){
        return linha;
    }
    
    public void setColor(Color cor){
        this.linha.setStroke(cor);
    }
    
    public boolean checkContato(ArrayList<Aresta> arestas) {
        for (Aresta are : arestas) {
            if (are.getInicio()== inicio || are.getFim()== inicio || are.getInicio()== fim || are.getFim()== fim)
                continue;
            Shape intersect = Shape.intersect(linha, are.getLinha());
            if (intersect.getBoundsInLocal().getWidth() != -1) {
                this.setColor(Color.GRAY);
                return true;
            }
        }
        this.setColor(Color.BLACK);
        return false;
    }
}
