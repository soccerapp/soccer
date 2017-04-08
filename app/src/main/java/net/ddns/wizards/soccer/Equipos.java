package net.ddns.wizards.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

public class Equipos extends AppCompatActivity {
    ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);
        listado = (ListView) findViewById(R.id.listView);
        ObtDatosEquipos();
    }

    public void principal (View view){
        Intent i = new Intent(this, principal.class);
        startActivity(i);
        finish();
    }

    public void ObtDatosEquipos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://wizards.ddns.net:8080/api.soccer.ddns.net/equipos.php";
        RequestParams parametros = new RequestParams();
        parametros.put("WIZARDS",1);

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, byte[] responseBody) {
                if (statusCode==200){

                    CargarListaEquipos(ObtDatosEquiposJSON(new String(responseBody)));
                }
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void CargarListaEquipos(ArrayList<String> equipos){
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,equipos);
        listado.setAdapter(adapter);
    }

    public ArrayList<String> ObtDatosEquiposJSON(String response){
        ArrayList<String> listado = new ArrayList<String>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            String texto;
            for(int i=0;i<jsonArray.length();i++) {
                texto = jsonArray.getJSONObject(i).getString("id_equipos") +"  - "+
                        jsonArray.getJSONObject(i).getString("nombre_equipo") +" -  "+
                        jsonArray.getJSONObject(i).getString("fecha_alta") + " ";
                listado.add(texto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listado;
    }
}