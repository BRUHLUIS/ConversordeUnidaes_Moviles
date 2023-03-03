package com.example.unidades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Peso extends AppCompatActivity {
    private EditText temperatureInput;
    private RadioButton  librasRadioButton, onzasRadioButton;
    private Button convertButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        temperatureInput = findViewById(R.id.temperature_input);

        librasRadioButton = findViewById(R.id.libras_radio_button);
        onzasRadioButton = findViewById(R.id.onzas_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text_view);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();

                if (input.isEmpty()) {
                    resultTextView.setText("Ingrese el peso");
                    return;
                }

                double kilos = Double.parseDouble(input);
                double result;


                if  (librasRadioButton.isChecked()) {
                    result = kilostolibras(kilos);
                    resultTextView.setText(String.format("%.8f °Lb", result));
                } else if (onzasRadioButton.isChecked()) {
                    result = kilostoonzas(kilos);
                    resultTextView.setText(String.format("%.8f Oz", result));
                }
            }
        });
    }



    private double kilostolibras(double kilos) {

        return  kilos*2.205  ;
    }

    private double kilostoonzas(double kilos) {

        return kilos*35.274;
    }
}