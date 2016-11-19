package com.mendi10.conversor_unidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    EditText editTextMetros,editTextCent,editTextFar ;
    TextView textViewMetros,textViewCent,textViewFar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     editTextMetros = (EditText)findViewById(R.id.editTextMetros);
     editTextCent = (EditText)findViewById(R.id.editTextCentigrados);
     editTextFar = (EditText)findViewById(R.id.editTextFaren);
     textViewMetros = (TextView)findViewById(R.id.textViewMetros);
     textViewCent = (TextView)findViewById(R.id.textViewCen);
     textViewFar= (TextView)findViewById(R.id.textViewFaren);



    }

    public void calcular_distancia(View view) {

        String metros = editTextMetros.getText().toString();

        if(validar(metros)){

            float m = Integer.valueOf(metros);
            double mi,in,km;
            String resultado;

            in = m * 39.3701;
            mi = m * 0.000621371;
            km = m * 0.01;

            Double newin = cambiar_fromato(in,3);
            Double newmi = cambiar_fromato(mi,3);
            Double newkm = cambiar_fromato(km,3);

            resultado = newmi + "\n"+ newkm +"\n"+ newin;

            textViewMetros.setText(resultado);

        }

    }

    public void calcular_Cent(View view) {

        String far = editTextFar.getText().toString();

        if(validar(far)){

            float F = Integer.valueOf(far);
            double C;
            String resultado;

            C = (F-32)/1.8;

            Double newC = cambiar_fromato(C,3);

            resultado = "\n"+ newC + " °C";

            textViewFar.setText(resultado);

        }

    }

    public void calcular_Kelvin(View view) {

        String cent = editTextCent.getText().toString();

        if(validar(cent)){

            float C = Integer.valueOf(cent);
            double K;
            String resultado;

            K = C + 273.15;

            Double newK = cambiar_fromato(K,3);

            resultado = "\n"+ newK + " °K";

            textViewCent.setText(resultado);

        }

    }

    public void calcular_Farent(View view) {

        String cent = editTextCent.getText().toString();

        if(validar(cent)){

            float C = Integer.valueOf(cent);
            double F;
            String resultado;

            F = (C *1.8) + 32;

            Double newF = cambiar_fromato(F,3);

            resultado = "\n"+ newF + " °F";

            textViewCent.setText(resultado);

        }

    }

    public static boolean validar(String valor) {

        boolean result = false;

        if(valor.isEmpty()) {

            }

        else if(valor.matches("\\d+") ) {
            result =true;
        }

        return result;
    }

    public Double cambiar_fromato(Double text,int prec){


        Double toBeTruncated = new Double(text);

        Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
                .setScale(prec, RoundingMode.HALF_UP)
                .doubleValue();

        return truncatedDouble;
    }


}


