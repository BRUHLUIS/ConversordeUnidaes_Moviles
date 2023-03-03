package com.example.unidades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Temperatura extends AppCompatActivity {

    private EditText temperatureInput;
    private RadioButton  fahrenheitRadioButton, kelvinRadioButton;
    private Button convertButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        temperatureInput = findViewById(R.id.temperature_input);

        fahrenheitRadioButton = findViewById(R.id.fahrenheit_radio_button);
        kelvinRadioButton = findViewById(R.id.kelvin_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text_view);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();

                if (input.isEmpty()) {
                    resultTextView.setText("INgrese una temperatura");
                    return;
                }

                double celsius = Double.parseDouble(input);
                double result;


                if  (fahrenheitRadioButton.isChecked()) {
                    result = fahrenheitToCelsius(celsius);
                    resultTextView.setText(String.format("%.2f °C", result));
                } else if (kelvinRadioButton.isChecked()) {
                    result = celsiusToKelvin(celsius);
                    resultTextView.setText(String.format("%.2f K", result));
                }
            }
        });
    }



    private double fahrenheitToCelsius(double celsius) {

        return  1.8*celsius +32  ;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}