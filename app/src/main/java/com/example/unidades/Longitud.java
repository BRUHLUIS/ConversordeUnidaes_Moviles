package com.example.unidades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Longitud extends AppCompatActivity {
    private EditText temperatureInput;
    private RadioButton millasadioButton, yardasRadioButton, piesRadioButton,pulgadasRadioButton;
    private Button convertButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);
        temperatureInput = findViewById(R.id.temperature_input);
        millasadioButton = findViewById(R.id.millas_radio_button);
        yardasRadioButton = findViewById(R.id.yardas_radio_button);
        piesRadioButton = findViewById(R.id.pies_radio_button);
        pulgadasRadioButton = findViewById(R.id.pulgadas_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text_view);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();

                if (input.isEmpty()) {
                    resultTextView.setText("Ingrese una longitud en metros");
                    return;
                }

                double metros = Double.parseDouble(input);
                double result;

                if (millasadioButton.isChecked()) {
                    result = metrostomillas(metros);
                    resultTextView.setText(String.format("%.8f °Mi", result));
                } else if (yardasRadioButton.isChecked()) {
                    result = metrostoyardas(metros);
                    resultTextView.setText(String.format("%.2f °Y", result));
                } else if (piesRadioButton.isChecked()) {
                    result = metrostopies(metros);
                    resultTextView.setText(String.format("%.2f Ft", result));
                } else if (pulgadasRadioButton.isChecked()) {
                    result = metrostopulgadas(metros);
                    resultTextView.setText(String.format("%.2f In", result));
                }
            }
        });
    }

    private double metrostomillas(double metros) {
        return metros/1609;
    }

    private double metrostoyardas(double metros) {
        return metros*1.094;
    }

    private double metrostopies(double metros) {
        return metros*3.281;
    }
    private double metrostopulgadas(double metros) {
        return metros *39.37;
    }
}