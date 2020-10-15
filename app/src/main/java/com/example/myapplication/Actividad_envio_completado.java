package com.example.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Actividad_envio_completado extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_envio_completado);

        Intent intent_completado = getIntent();
        TextView datos_nombre = findViewById(R.id.datos_nombre);
        datos_nombre.setText("-"+intent_completado.getStringExtra("nombre"));
        TextView datos_dni = findViewById(R.id.datos_dni);
        datos_dni.setText("-"+intent_completado.getStringExtra("dni"));
        TextView datos_correo = findViewById(R.id.datos_correo);
        datos_correo.setText("-"+intent_completado.getStringExtra("correo"));
        TextView datos_suscripcion = findViewById(R.id.datos_suscripcion);
        datos_suscripcion.setText("-"+intent_completado.getStringExtra("suscripcion"));
    }

}