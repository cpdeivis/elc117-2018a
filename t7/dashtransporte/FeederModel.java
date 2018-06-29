//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author cpdeivis
 */
public class FeederModel {
    private ArrayList<DataModel> dados = new ArrayList<>();
    // 0 -> Num de Veículos, 1 -> Última leitura, 2 -> Data + Recente Servidor, 3 -> Data + Antiga Servidor
    private String[] information = new String[]{"Não Informado", "Não Informado", "Não Informado", "Não Informado"};

    public int[] getInercia(){
        int inercia[] = new int[2];
        inercia[0] = dados.stream().filter(x -> x.getVelocidade() > 0).collect(Collectors.<DataModel>toList()).size();
        inercia[1] = dados.size() - inercia[0];
        return inercia;
    }

    public Map<String, Long> getLinhas(){
        Map<String, Long> ocorrencias =
            dados.stream().filter(x -> x.getVelocidade() > 0 && !x.getLinha().isEmpty()).collect(Collectors.groupingBy(
                DataModel::getLinha, Collectors.counting()
            ));

        return ocorrencias;
    }

    public ArrayList<DataModel> getLista(){
        return dados;
    }

    public String[] getInfo(){
        return information;
    }

    public ArrayList<DataModel> getDados(String url){
        JSONObject dataJSON = null;
        try{
            dataJSON = getFromURL(url);
            dados.clear();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            information[1] = df.format(Date.from(Instant.now()));
        } catch(Exception e){
            if(dados.isEmpty()){
                try{
                    dataJSON = getFromFile("./offline.json");
                }
                catch(Exception ex){
                    System.out.println("Não foi possível ler o arquivo local");
                    System.out.println(ex.getMessage());
                    return dados;
                }
            } else{
                System.out.println("Não foi possível conectar ao servidor");
                System.out.println(e.getMessage());
            }
        }
        JSONArray DATA = dataJSON.getJSONArray("DATA");
        for (int i = 0; i < DATA.length(); i++) {
            JSONArray element = new JSONArray(DATA.get(i).toString());
            dados.add(new DataModel(element));
        }
        int qtd = dados.size();
        information[0] = String.valueOf(qtd);
        information[2] = dados.get(qtd-1).getDataHora();
        information[3] = dados.get(0).getDataHora();

        return dados;
    }
    private JSONObject getFromURL(String url) throws IOException, JSONException{
        InputStream is = new URL(url).openStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(response.toString());
        return json;
    }
    private JSONObject getFromFile(String absPath) throws IOException, JSONException{
        File file = new File(absPath);
        InputStream is = new FileInputStream(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        StringBuilder scanner = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            scanner.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(scanner.toString());
        return json;
    }
}
