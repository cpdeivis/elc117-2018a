package planarity;

import java.util.ArrayList;

/**
 *
 * @author cpdeivis
 */
public class GameLogica {

    public GameLogica() {
    }
    
    public Grafo geraGrafo(int fase){
        Grafo cena = new Grafo();
        int n = 4+fase;
        cena.addVertice(20 + Math.random()*860, 20 + Math.random()*560);
        cena.addVertice(20 + Math.random()*860, 20 + Math.random()*560);
        ArrayList<Vertice> verts = cena.getVertices();
        addArestaPlanar(new Aresta(verts.get(0), verts.get(1)), cena.getArestas());
        for (int i = 2; i < n; i++){
            cena.addVertice(20 + Math.random()*860, 20 + Math.random()*560);
            addArestaPlanar(new Aresta(verts.get(i-2), verts.get(i)), cena.getArestas());
            addArestaPlanar(new Aresta(verts.get(i-1), verts.get(i)), cena.getArestas());
        }     
        return cena;
    }
    
    public void addArestaPlanar(Aresta link, ArrayList<Aresta> arestas){
        boolean teste = true;
        for(Aresta are : arestas){
            if((link.getFim() == link.getInicio()) || (link.getInicio() == are.getInicio() && link.getFim() == are.getFim()) || (link.getInicio() == are.getFim() && link.getFim() == are.getInicio())){
               teste = false;
               break;
            }
        }
        if(teste){
            arestas.add(link);
            link.getInicio().addCaminhos(link);
            link.getFim().addCaminhos(link);
        }
    }
}