package com.example.unidades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Volumen extends AppCompatActivity {

    private EditText temperatureInput;
    private RadioButton  gallonesRadioButton, pinesRadioButton;
    private Button convertButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        temperatureInput = findViewById(R.id.temperature_input);

        gallonesRadioButton = findViewById(R.id.gallones_radio_button);
        pinesRadioButton = findViewById(R.id.pines_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text_view);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();

                if (input.isEmpty()) {
                    resultTextView.setText("Ingrese el Volumen");
                    return;
                }

                double litros = Double.parseDouble(input);
                double result;


                if  (gallonesRadioButton.isChecked()) {
                    result = litrostogallones(litros);
                    resultTextView.setText(String.format("%.8f °G", result));
                } else if (pinesRadioButton.isChecked()) {
                    result = litrostopines(litros);
                    resultTextView.setText(String.format("%.8f P", result));
                }
            }
        });
    }



    private double litrostogallones(double litros) {

        return  litros/ 3.785 ;
    }

    private double litrostopines(double litros) {

        return litros*2.113;
    }
}