package planarity;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author cpdeivis
 */
public class Grafo {
    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice> vertices;

    public Grafo() {
        this.arestas = new ArrayList<Aresta>();
        this.vertices = new ArrayList<Vertice>();
    }
    
    public Vertice addVertice(double x, double y){
        Vertice nVer = new Vertice(x, y, Color.DARKSALMON);
        vertices.add(nVer);
        return nVer;
    }
    
    public Aresta addAresta(Vertice ini, Vertice fim){
        Aresta nAre = new Aresta(ini, fim);
        arestas.add(nAre);
        ini.addCaminhos(nAre);
        fim.addCaminhos(nAre);
        return nAre;
    }
    
    public ArrayList<Aresta> getArestas(){
        return this.arestas;
    }
    
    public ArrayList<Vertice> getVertices(){
        return this.vertices;
    }
    
    public boolean bContato(){
        boolean bTeste = false;
        for(Aresta are : arestas)
            bTeste = bTeste && are.checkContato(arestas);
            
        return bTeste;
    }
    
}
