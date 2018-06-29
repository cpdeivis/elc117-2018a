//Caso use o NetBeans, descomentar a linha abaixo
//package dashtransporte;

import java.security.GeneralSecurityException;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author cpdeivis
 */
public class GMapsController{
    @FXML
    private WebView wbGMaps;

    public void initialize(float Lat, float Lon, String Ordem) {
        TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
                    }
                @Override
                public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException e) {
        }
        wbGMaps.setDisable(true);
        wbGMaps.getEngine().load("https://maps.googleapis.com/maps/api/staticmap?size=500x500&zoom=16&maptype=roadmap&markers=icon:https://goo.gl/xpmPM1%7C"+Lat+","+Lon);
    }

}
