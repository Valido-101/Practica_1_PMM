package com.example.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_email extends Activity implements View.OnClickListener {

    Button btn_enviar = findViewById(R.id.btn_email);
    EditText remitente = findViewById(R.id.correo_remitente);
    EditText mensaje = findViewById(R.id.mensaje);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        btn_enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String direcciones_correo [] = {"jesus.valido.zafra@alumnos.fesac.es"};

        Intent correo = new Intent(Intent.ACTION_SENDTO);

        correo.setData(Uri.parse("mailto:"));
        correo.putExtra(Intent.EXTRA_EMAIL, direcciones_correo);
        correo.putExtra(Intent.EXTRA_SUBJECT,"Sugerencias");

        startActivity(Intent.createChooser(correo,"Elige el correo:"));
    }
}