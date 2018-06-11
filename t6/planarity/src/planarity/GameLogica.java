package planarity;

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
        for(int i =0; i < n; i++){
            cena.addVertice(Math.random()*901,Math.random()*601);
        }
        cena.getVertices().forEach((Vertice v) -> {
            cena.addAresta(v, cena.getVertices().get(0));
        });
        return cena;
    }
}