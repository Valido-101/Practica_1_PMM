package com.example.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Actividad_formulario extends Activity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_formulario);
        Button btn_enviar = (Button) findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edt_txt_nombre_apellidos = findViewById(R.id.nombre_apellidos);
        EditText edt_txt_dni = findViewById(R.id.dni);
        EditText edt_txt_correo = findViewById(R.id.correo_electronico);
        CheckBox chck_bx_suscripcion = findViewById(R.id.checkBox);

        Intent intent1 = new Intent(this, Actividad_envio_completado.class);
        intent1.putExtra("nombre", edt_txt_nombre_apellidos.getText().toString());
        intent1.putExtra("dni", edt_txt_dni.getText().toString());
        intent1.putExtra("correo",edt_txt_correo.getText().toString());

        if(chck_bx_suscripcion.isChecked())
        {

            intent1.putExtra("suscripcion", "Sí");

        }
        else
        {

            intent1.putExtra("suscripcion","No");

        }

        startActivity(intent1);
    }
}