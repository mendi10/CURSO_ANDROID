package com.example.a62.imc_application;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textViewresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewresultado = (TextView) findViewById(R.id.textViewIMC);
        Log.d(TAG,"Entra aca");
    }


    public void calcularIMC(View view) {

        Log.d(TAG,"Entra a calcularIMC con el click");

        EditText editTextAltura = (EditText) findViewById(R.id.editTextAltura);
        EditText editTextPeso = (EditText) findViewById(R.id.editTextPeso);

        String altura = editTextAltura.getText().toString();
        String peso = editTextPeso.getText().toString();

            if(altura.isEmpty() & peso.isEmpty()) return;
            if(altura.matches("\\d+") && peso.matches("\\d+")){
                float kg = Integer.valueOf(peso);
                float cm = Integer.valueOf(altura);
                calcular(cm,kg);
            }
    }

    private void calcular(float cm, float kg) {

        int color = 0;
        cm = (cm/100);
        float bmi = kg / (cm *cm);
        String resultado;

            if(bmi < 16){
                resultado = "TU BMI ES: " + bmi + " (Severamente bajo)";
                color = Color.RED;
            }else if(bmi < 18.5){
                resultado = "TU BMI: ES" + bmi + " (Bajo)";
                color = Color.YELLOW;
            }else if(bmi < 25){
                resultado = "TU BMI: ES" + bmi + " (Normal)";
                color = Color.GREEN;
            }else if(bmi < 30){
                resultado = "TU BMI: ES" + bmi + " (sobre peso)";
                color = Color.YELLOW;
            }else {
                resultado = "TU BMI: ES" + bmi + " (Obeso)";
                color = Color.RED;
        }
        Log.i(TAG,resultado);

        textViewresultado.setText(resultado);
        textViewresultado.setTextColor(color);
    }
}
