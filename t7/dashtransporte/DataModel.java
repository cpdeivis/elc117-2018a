//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.json.JSONArray;

/**
 *
 * @author cpdeivis
 */
public class DataModel {
    // Data e hora da coleta do dado
    private Date DataHora; // MM-DD-YYYY HH:MM:SS
    // Identificação alfanumérica do veículo
    private String Ordem; // A99999 (ALFANUMÉRICO SEGUIDO DE 5 NUMÉRICOS)
    // Linha de transporte
    private String Linha; // 9999.9 ou AAA9999 (EXEMPLO: 352.00 ou SR335)
    // Latitude do ônibus na coleta (GPS)
    private float Latitude; // -99.999999 (2 DÍGITOS, PONTO E MAIS 6 DÍGITOS. NÚMEROS NEGATIVOS OU POSITIVOS)
    // Longitude do ônibus na coleta (GPS)
    private float Longitude; // -99.999999 (2 DÍGITOS, PONTO E MAIS 6 DÍGITOS. NÚMEROS NEGATIVOS OU POSITIVOS)
    // Velocidade do ônibus na hora do coleta do dado
    private float Velocidade; // 999.99 (ATÉ 3 DÍGITOS, PONTO E MAIS 2 DÍGITOS)

    public DataModel(JSONArray elem){
        try{
            this.DataHora = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(elem.getString(0));
        } catch(Exception e){
            this.DataHora = Date.from(Instant.MIN);
        }
        this.Ordem = elem.getString(1);
        this.Linha = elem.get(2).toString();
        this.Latitude = elem.getFloat(3);
        this.Longitude = elem.getFloat(4);
        this.Velocidade = elem.getFloat(5);
    }

    public String getDataHora(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(DataHora);
    }
    public float getLatitude() {
        return Latitude;
    }
    public String getLinha() {
        return Linha;
    }
    public float getLongitude() {
        return Longitude;
    }
    public String getOrdem() {
        return Ordem;
    }
    public float getVelocidade() {
        return Velocidade;
    }
}
