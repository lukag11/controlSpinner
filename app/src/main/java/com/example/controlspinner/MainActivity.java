package com.example.controlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etvalor1,etvalor2;
    private Spinner spinner;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etvalor1 = (EditText) findViewById(R.id.txtvalor1);
        etvalor2 = (EditText) findViewById(R.id.txtvalor2);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvResultado = (TextView) findViewById(R.id.tViewResultado);

        // CREAMOS UN ARREGLO UNIMEDCIONAL 0,1,2,3;
        String [] opciones = {"SUMAR","RESTAR","DIVIDIR","MULTIPLICAR"};

        //UTILIZAMOS UNA NUEVA CLASE PARA CARGAR LOS DATOS EN EL SPINNER
        // CREAMOS UN OBJETO DE TIPO ARRAY ADAPTER // TIPO DE DATO STRING
        // CONTEXTO - TIPO DE SPINNER - DATOS(OPCIONES)
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item,opciones);
        spinner.setAdapter(adapter); // colocamos todo adentro del spinner.

    }


    public void Calcular(View view) {

        String valor1String = etvalor1.getText().toString(); // RECUPERAR VALORES y CONVERTIR
        String valor2String = etvalor2.getText().toString();

        double valor1Double = Double.parseDouble(valor1String); // TRANSFORMAR STRING A ENTERO
        double valor2Double = Double.parseDouble(valor2String);


        String seleccion = spinner.getSelectedItem().toString(); // GUARDAR LA SELECCION Y GETSELECTITEM(PARA SABER QUE ITEM SELECCIONO EL USUARIO)

        // EQUALS SIRVE PARA COMPARAR CADENAS DE TEXTOS
        if (seleccion.equals("SUMAR")) {

            double suma = valor1Double + valor2Double;

            String resultado = String.valueOf(suma);
            tvResultado.setText(resultado);


        } else if (seleccion.equals("RESTAR")) {
            double restar = valor1Double - valor2Double;

            String resultado = String.valueOf(restar);
            tvResultado.setText(resultado);

        } else if (seleccion.equals("DIVIDIR")) {

            if (valor2Double != 0) {


                double dividir = valor1Double / valor2Double;

                String resultado = String.valueOf(dividir);
                tvResultado.setText(resultado);
            } else {

                Toast.makeText(this, "NO SE PUEDE HACER ESA OPERACION", Toast.LENGTH_LONG).show();

            }


        } else if (seleccion.equals("MULTIPLICAR")) {
            double multi = valor1Double * valor2Double;

            String resultado = String.valueOf(multi);
            tvResultado.setText(resultado);

        }


    }




}
