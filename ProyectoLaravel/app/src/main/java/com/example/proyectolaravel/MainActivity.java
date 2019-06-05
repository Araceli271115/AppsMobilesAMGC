package com.example.proyectolaravel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private final String BASEURL = "http://10.0.25.102:8000/api/persona/";
    private EditText et_id, et_nombre,et_apellidop, et_apellidom, et_edad, et_telefono, et_direccion, et_correo;
    private Button btn_guardar, btn_editar, btn_buscar, btn_eliminar;
    private Context ctx;
    private StringRequest strq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        requestQueue = Volley.newRequestQueue(ctx);

        et_id = (EditText) findViewById(R.id.EditTextId);
        et_nombre = (EditText) findViewById(R.id.EditTextNombre);
        et_apellidop = (EditText) findViewById(R.id.EditTextApellidoP);
        et_apellidom = (EditText) findViewById(R.id.EditTextApellidoM);
        et_edad = (EditText) findViewById(R.id.EditTextEdad);
        et_telefono = (EditText) findViewById(R.id.EditTextTelefono);
        et_direccion = (EditText) findViewById(R.id.EditTextDireccion);
        et_correo = (EditText) findViewById(R.id.EditTextCorreo);


        btn_guardar = (Button) findViewById(R.id.btnGuardar);
        btn_buscar = (Button) findViewById(R.id.btnConsultar);
        btn_editar= (Button) findViewById(R.id.btnModificar);
        btn_eliminar= (Button) findViewById(R.id.btnEliminar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crear();
            }
        });
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar();
            }
        });
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }
    private void crear() {

        strq = new StringRequest(Request.Method.POST, BASEURL+"insertar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("apellidop", et_apellidop.getText().toString());
                parametros.put("apellidom", et_apellidom.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                parametros.put("telefono", et_telefono.getText().toString());
                parametros.put("direccion", et_direccion.getText().toString());
                parametros.put("correo", et_correo.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);

    }

    private void actualizar() {

        strq = new StringRequest(Request.Method.POST, BASEURL+"actualizar/"+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("apellidop", et_apellidop.getText().toString());
                parametros.put("apellidom", et_apellidom.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                parametros.put("telefono", et_telefono.getText().toString());
                parametros.put("direccion", et_direccion.getText().toString());
                parametros.put("correo", et_correo.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);

    }

    private void eliminar() {

        strq = new StringRequest(Request.Method.DELETE, BASEURL+"eliminar/"+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("apellidop", et_apellidop.getText().toString());
                parametros.put("apellidom", et_apellidom.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                parametros.put("telefono", et_telefono.getText().toString());
                parametros.put("direccion", et_direccion.getText().toString());
                parametros.put("correo", et_correo.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    private void show() {

        strq = new StringRequest(Request.Method.GET, BASEURL+et_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", et_nombre.getText().toString());
                parametros.put("apellidop", et_apellidop.getText().toString());
                parametros.put("apellidom", et_apellidom.getText().toString());
                parametros.put("edad", et_edad.getText().toString());
                parametros.put("telefono", et_telefono.getText().toString());
                parametros.put("direccion", et_direccion.getText().toString());
                parametros.put("correo", et_correo.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }


  /*  public void responseHandler(String res){
        try {
            JSONArray response = new JSONArray(res);
            //Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            for(int i = 0, e = response.length(); i < e; i++){
                JSONObject persona = (JSONObject) response.get(i);

                String nombre = persona.get("nombre").toString();

                Persona cat = new Persona(
                        Integer.parseInt(persona.get("id").toString()),
                        (String) persona.get("nombre"),
                        (String) persona.get("apellidop"),
                        (String) persona.get("apellidom"),
                        (String) persona.get("edad"),
                        (String) persona.get("telefono"),
                        (String) persona.get("direccion"),
                        (String) persona.get("correo")
                );


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
}
