package es.fraggel.homecontrolapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements View.OnClickListener, AsyncResponse {
    ToggleButton tgCalefaccion=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*tgCalefaccion=(ToggleButton)findViewById(R.id.toggleButton1);
        tgCalefaccion.setOnClickListener(this);*/

        WebView wv=(WebView)findViewById(R.id.webView1);
        wv.setEnabled(true);
        wv.setWebViewClient(new HomeControllerWebViewClient());
        wv.loadUrl("http://fraggel.dyndns.info:8080/HomeController/LoginServlet?usuario=fraggel&contrasenya=ak47cold");

    }

    @Override
    public void onClick(View v) {
        /*if(v.getId()==(R.id.toggleButton1)){
            try {
                String status="OFF";
                if(tgCalefaccion.isChecked()){
                    status="OFF";
                }else if(!tgCalefaccion.isChecked()){
                    status="ON";
                }
                HttpThread asyncTask = new HttpThread();
                asyncTask.delegate = this;
                asyncTask.execute(status, "calefaccion");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    @Override
    public void processFinish(String output) {

    }
}
    class HomeControllerWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            /*urlDestino = url;
            if (urlDestino.lastIndexOf("/desarrollo/") != -1 && urlDestino.lastIndexOf("appsoft") == -1) {
                try {
                    String nombreFichero = "";
                    nombreFichero = urlDestino.split("/")[urlDestino.split("/").length - 1];
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDestino));
                    request.setDescription(nombreFichero);
                    request.setTitle(nombreFichero);
                    File f1 = new File(Environment.getExternalStorageDirectory() + "/TEAMFORCE/APP/");
                    if (!f1.exists()) {
                        f1.mkdirs();
                    }
                    File f2 = new File(Environment.getExternalStorageDirectory() + "/TEAMFORCE/ROMS/");
                    if (!f2.exists()) {
                        f2.mkdirs();
                    }

                    if (Build.VERSION.SDK_INT >= 11) {
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        if (".apk".equals(nombreFichero.substring(nombreFichero.length() - 4, nombreFichero.length()).toLowerCase())) {
                            request.setMimeType("application/vnd.android.package-archive");
                            if (nombreFichero.indexOf("TeamForce.apk") == -1) {
                                try {
                                    new File(f1.getAbsolutePath() + "/TeamForce.apk").delete();
                                } catch (Exception e) {

                                }

                            }
                        }

                    }
                    String rutaDescarga = null;
                    if (nombreFichero.indexOf(".apk") != -1) {
                        rutaDescarga = "/TEAMFORCE/APP/";
                    } else if (nombreFichero.indexOf("signed_") != -1) {
                        rutaDescarga = "/TEAMFORCE/ROMS/";
                    }
                    request.setDestinationInExternalPublicDir(rutaDescarga, nombreFichero);

                    DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    //Toast.makeText(getBaseContext(), getResources().getString(R.string.msgIniciandoDescarga) + " " + nombreFichero, Toast.LENGTH_SHORT).show();
                    AppActivity.listaDescargas.put(String.valueOf(manager.enqueue(request)), nombreFichero);

                    //manager.enqueue(request);

                } catch (Exception e) {
                    //Toast.makeText(getBaseContext(), getResources().getString(R.string.msgGenericError), Toast.LENGTH_SHORT).show();
                }

                return true;
            } else if(urlDestino.lastIndexOf("appsoft") != -1){
                lastURL=urlDestino;
                return false;
            }else{
                Uri uri = Uri.parse(urlDestino);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                return true;
            }

        }*/
            return false;
    }
}
