package com.example.myapplication;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad_formulario extends Activity implements View.OnClickListener{

    private boolean nombre_correcto = false;
    //Para que haya 3 cadenas deberá haber al menos 3 espacios
    private int cont_espacios = 0;
    private boolean dni_numeros_correcto = false;
    private boolean dni_letra_correcto = false;
    private boolean correo_correcto = false;
    //Si hay más de una arroba no sirve
    private int num_arrobas = 0;
    //Se guarda la posicion del arroba para saber si el punto esta a la derecha
    private int pos_arroba = 0;

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
        Spinner spn_nacionalidad = findViewById(R.id.nacionalidad);
        CheckBox chck_bx_suscripcion = findViewById(R.id.checkBox);

        Intent intent1 = new Intent(this, Actividad_envio_completado.class);
        intent1.putExtra("nombre", edt_txt_nombre_apellidos.getText().toString());
        intent1.putExtra("dni", edt_txt_dni.getText().toString());
        intent1.putExtra("correo",edt_txt_correo.getText().toString());
        intent1.putExtra("nacionalidad",spn_nacionalidad.getSelectedItem().toString());

        if(chck_bx_suscripcion.isChecked())
        {

            intent1.putExtra("suscripcion", "Sí");

        }
        else
        {

            intent1.putExtra("suscripcion","No");

        }


        for(int x=0 ; x<edt_txt_nombre_apellidos.getText().toString().length() ; x++)
        {

            if(edt_txt_nombre_apellidos.getText().toString().substring(x,x+1).equals(" "))
            {
                cont_espacios++;
            }

        }

        if(cont_espacios>=2)
        {
            nombre_correcto=true;
        }

        for(int x=0 ; x<edt_txt_dni.getText().toString().length()-1 ; x++)
        {

            if(Integer.parseInt(edt_txt_dni.getText().toString().substring(x,x+1))>0 && Integer.parseInt(edt_txt_dni.getText().toString().substring(x,x+1))<9)
            {
                dni_numeros_correcto = true;
            }
            else
            {
                dni_numeros_correcto = false;
                break;
            }

        }

        if((int)edt_txt_dni.getText().toString().charAt(edt_txt_dni.getText().toString().length()-1)>=65 && (int)edt_txt_dni.getText().toString().charAt(edt_txt_dni.getText().toString().length()-1)<=90 || (int)edt_txt_dni.getText().toString().charAt(edt_txt_dni.getText().toString().length()-1)>=97 && (int)edt_txt_dni.getText().toString().charAt(edt_txt_dni.getText().toString().length()-1)<=122)
        {
            dni_letra_correcto = true;
        }

        for(int x=0 ; x<edt_txt_correo.getText().toString().length() ; x++)
        {
            if(edt_txt_correo.getText().toString().substring(x,x+1).equals("@"))
            {
                num_arrobas++;
                pos_arroba = x;
            }
        }

        if(num_arrobas==1)
        {
            for(int x=pos_arroba ; x<edt_txt_correo.getText().toString().length() ; x++)
            {
                if(edt_txt_correo.getText().toString().substring(x,x+1).equals("."))
                {
                    correo_correcto = true;
                }
            }
        }

        if(nombre_correcto == true && dni_letra_correcto == true && dni_numeros_correcto == true && correo_correcto == true)
        {
            startActivity(intent1);
        }
        else
        {
            if(nombre_correcto == false)
            {
                Toast message_nombre = Toast.makeText(getApplicationContext(),"Parámetro Nombre y Apellidos incorrecto",Toast.LENGTH_SHORT);
                message_nombre.show();
            }
            else
            {
                if(dni_numeros_correcto == false || dni_letra_correcto == false)
                {
                    Toast message_dni = Toast.makeText(getApplicationContext(),"Parámetro DNI incorrecto",Toast.LENGTH_SHORT);
                    message_dni.show();
                }
                else
                {
                    if(correo_correcto == false)
                    {
                        Toast message_correo = Toast.makeText(getApplicationContext(),"Parámetro Correo electrónico incorrecto",Toast.LENGTH_SHORT);
                        message_correo.show();
                    }
                    else
                    {
                        Toast message_varios = Toast.makeText(getApplicationContext(),"Múltiples parámetros incorrectos",Toast.LENGTH_SHORT);
                        message_varios.show();
                    }
                }
            }
        }
    }
}