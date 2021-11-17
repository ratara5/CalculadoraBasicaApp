package com.example.app_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);

        tv1 = (TextView) findViewById(R.id.tv_resultado);

        spinner1 = (Spinner) findViewById(R.id.spinner);

        String[] opciones = {"sumar", "restar", "multiplicar", "dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_opciones, opciones);
        spinner1.setAdapter(adapter);
    }
    //Método del boton

    public void calcular(View view){
        String valor1_string=et1.getText().toString();
        String valor2_string=et2.getText().toString();

        int valor1_int=Integer.parseInt(valor1_string);
        int valor2_int=Integer.parseInt(valor2_string);

        String seleccion=spinner1.getSelectedItem().toString();

        if(seleccion.equals("sumar")){
            int suma=valor1_int+valor2_int;
            String resultado=String.valueOf(suma);
            tv1.setText(resultado);
        }else if(seleccion.equals("restar")){
            int resta=valor1_int-valor2_int;
            String resultado=String.valueOf(resta);
            tv1.setText(resultado);
        }else if(seleccion.equals("multiplicar")){
            int mult=valor1_int*valor2_int;
            String resultado=String.valueOf(mult);
            tv1.setText(resultado);
        }else if(seleccion.equals("dividir")){
            if (valor2_int!=0) {
                int div=valor1_int/valor2_int;
                String resultado=String.valueOf(div);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "No permitida división entre 0",Toast.LENGTH_LONG);
            }
        }
    }
}