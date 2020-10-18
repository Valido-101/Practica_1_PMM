package com.example.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad_principal extends Activity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn1 = (Button) findViewById(R.id.btn_formulario);
        Button btn2 = (Button) findViewById(R.id.btn_email);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent act_form = new Intent(this,Actividad_formulario.class);
        Intent act_correo = new Intent(this,Activity_email.class);
        if (v.getId()==findViewById(R.id.btn_formulario).getId())
        {
            startActivity(act_form);
        }
        else
        {
            startActivity(act_correo);
        }



    }
}