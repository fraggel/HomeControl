package es.fraggel.homecontrolapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements View.OnClickListener, AsyncResponse {
    Button btnStatusCalefaccion=null;
    Button btnCalefaccion=null;
    Button btnStatusAireSalon=null;
    Button btnAireSalon=null;
    Button btnStatusAireHabita=null;
    Button btnAireHabita=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String status="status";
                /*if(tgCalefaccion.isChecked()){
                    status="OFF";
                }else if(!tgCalefaccion.isChecked()){
                    status="ON";
                }*/
        HttpThread asyncTask = new HttpThread();
        asyncTask.delegate = this;
        asyncTask.execute(status);
        /*tgCalefaccion=(ToggleButton)findViewById(R.id.toggleButton1);
        tgCalefaccion.setOnClickListener(this);*/
        btnStatusCalefaccion=(Button)findViewById(R.id.buttonStatusCalefaccion);
        btnCalefaccion=(Button)findViewById(R.id.btnCalefaccion);
        btnCalefaccion.setOnClickListener(this);

        btnStatusAireSalon=(Button)findViewById(R.id.buttonStatusAireSalon);
        btnAireSalon=(Button)findViewById(R.id.btnAireSalon);
        btnAireSalon.setOnClickListener(this);

        btnStatusAireHabita=(Button)findViewById(R.id.buttonStatusAireHabita);
        btnAireHabita=(Button)findViewById(R.id.btnAireHabita);
        btnAireHabita.setOnClickListener(this);
        /*WebView wv=(WebView)findViewById(R.id.webView1);
        wv.setEnabled(true);
        wv.setWebViewClient(new HomeControllerWebViewClient());
        wv.loadUrl("http://fraggel.dyndns.info:8080/HomeController/LoginServlet?usuario=fraggel&contrasenya=ak47cold");*/

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==(R.id.btnCalefaccion)){
            try {
                String status="calefaccion";
                /*if(tgCalefaccion.isChecked()){
                    status="OFF";
                }else if(!tgCalefaccion.isChecked()){
                    status="ON";
                }*/
                HttpThread asyncTask = new HttpThread();
                asyncTask.delegate = this;
                asyncTask.execute(status);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==(R.id.btnAireSalon)){
            try {
                String status="aireSalon";
                /*if(tgCalefaccion.isChecked()){
                    status="OFF";
                }else if(!tgCalefaccion.isChecked()){
                    status="ON";
                }*/
                HttpThread asyncTask = new HttpThread();
                asyncTask.delegate = this;
                asyncTask.execute(status);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==(R.id.btnAireHabita)){
            try {
                String status="aireHabita";
                /*if(tgCalefaccion.isChecked()){
                    status="OFF";
                }else if(!tgCalefaccion.isChecked()){
                    status="ON";
                }*/
                HttpThread asyncTask = new HttpThread();
                asyncTask.delegate = this;
                asyncTask.execute(status);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void processFinish(String output) {
        String vuelta[]=output.split("---");
        if(vuelta.length>1){
            if("calefaccion=OFF".equals(vuelta[0])){
                btnStatusCalefaccion.setBackground(getResources().getDrawable(R.drawable.btn_red));
                btnCalefaccion.setText("Encender");
            }else if("calefaccion=ON".equals(vuelta[0])){
                btnStatusCalefaccion.setBackground(getResources().getDrawable(R.drawable.btn_green));
                btnCalefaccion.setText("Apagar");
            }else{
                btnStatusCalefaccion.setBackground(getResources().getDrawable(R.drawable.btn_black));
                btnCalefaccion.setText("No se en qué estado está");
            }
            if("aireSalon=OFF".equals(vuelta[1])){
                btnStatusAireSalon.setBackground(getResources().getDrawable(R.drawable.btn_red));
                btnAireSalon.setText("Encender");
            }else if("aireSalon=ON".equals(vuelta[1])){
                btnStatusAireSalon.setBackground(getResources().getDrawable(R.drawable.btn_green));
                btnAireSalon.setText("Apagar");
            }else{
                btnStatusAireSalon.setBackground(getResources().getDrawable(R.drawable.btn_black));
                btnAireSalon.setText("No se en qué estado está");
            }
            if("aireHabita=OFF".equals(vuelta[2])){
                btnStatusAireHabita.setBackground(getResources().getDrawable(R.drawable.btn_red));
                btnAireHabita.setText("Encender");
            }else if("aireHabita=ON".equals(vuelta[2])){
                btnStatusAireHabita.setBackground(getResources().getDrawable(R.drawable.btn_green));
                btnAireHabita.setText("Apagar");
            }else{
                btnStatusAireHabita.setBackground(getResources().getDrawable(R.drawable.btn_black));
                btnAireHabita.setText("No se en qué estado está");
            }
        }else{
            btnStatusCalefaccion.setBackground(getResources().getDrawable(R.drawable.btn_black));
            btnCalefaccion.setText("No se en qué estado está");
            btnStatusAireSalon.setBackground(getResources().getDrawable(R.drawable.btn_black));
            btnAireSalon.setText("No se en qué estado está");
            btnStatusAireHabita.setBackground(getResources().getDrawable(R.drawable.btn_black));
            btnAireHabita.setText("No se en qué estado está");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

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
