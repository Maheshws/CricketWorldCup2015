package ws.mahesh.cwc2015.webservices.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Mahesh on 2/6/2015.
 */
public class WebHelperService {

    private final String MAIN_URL="http://app.wc15.co/";

    public String getResponse(String req){
        String result = null;
        try {
            URL url = new URL(MAIN_URL+req);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp;
            while (null != (strTemp = br.readLine())) {
                result=result+strTemp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
