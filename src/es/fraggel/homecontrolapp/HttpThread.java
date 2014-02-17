package es.fraggel.homecontrolapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpThread extends AsyncTask<String, Void, String> {
    public AsyncResponse delegate = null;
    String urlActualizacion = "";

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String updateContenido="";
        InputStreamReader isr = null;
        BufferedReader in = null;
        try {
            if("status".equals(params[0])){
                URL jsonUrl = new URL("http://fraggel.dyndns.info:8080/HomeController/HomeControllerServlet?accion=4");
                in = new BufferedReader(new InputStreamReader(jsonUrl.openStream()));
                result = in.readLine();
            }else if("calefaccion".equals(params[0])){
                URL jsonUrl = new URL("http://fraggel.dyndns.info:8080/HomeController/HomeControllerServlet?accion=5&calefaccion=1");
                in = new BufferedReader(new InputStreamReader(jsonUrl.openStream()));
                result = in.readLine();

            }
        } catch (Exception ex) {
            result = "TIMEOUT";
            urlActualizacion = "";
            try {
                if (in != null) {
                    in.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
                if (isr != null) {
                    try {
                        isr.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
       return result;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }
}
