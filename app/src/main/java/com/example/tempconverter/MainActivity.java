package com.example.tempconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button btnConvert;
    private EditText etInput;
    private TextView tvCelsius, tvFahr, tvKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radio_groupButtons);
        btnConvert = (Button) findViewById(R.id.button_convert);
        etInput = (EditText) findViewById(R.id.text_input);
        tvCelsius = (TextView) findViewById(R.id.text_cOutput);
        tvFahr= (TextView) findViewById(R.id.text_fOutput);
        tvKelvin = (TextView) findViewById(R.id.text_kOutput);

        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Get what's in the edittext

                double inputTemp = Double.parseDouble(etInput.getText().toString());// converting input value to double
                double temperatureC;
                double temperatureF;
                double temperatureK;

                // Check which button is selected


                if(radioGroup.getCheckedRadioButtonId()== R.id.radio_c){
                    temperatureF = (inputTemp * 9.0/5.0) + 32.0;
                    temperatureK = inputTemp+ 273.15;
                    temperatureC = inputTemp;


                }else if(radioGroup.getCheckedRadioButtonId()== R.id.radio_f){
                    temperatureC = (inputTemp - 32.0) / (9.0/5.0);
                    temperatureK =(inputTemp + 459.67) * 5.0/9.0;
                    temperatureF =inputTemp;

                }else{
                    temperatureK = inputTemp;
                    temperatureC = inputTemp- 273.15;
                    temperatureF = (inputTemp * 9.0/5.0) - 459.67;

                }

                double temperatureC2 = (int)Math.round(temperatureC * 100)/(double)100; // getting 2 decimal after dot
                double temperatureF2 = (int)Math.round(temperatureF * 100)/(double)100;
                double temperatureK2 = (int)Math.round(temperatureK * 100)/(double)100;



                // Convert based on that, and display
                tvCelsius.setText(String.valueOf(temperatureC2)+ "  °C");
                tvFahr.setText(String.valueOf(temperatureF2) + "  °F");
                tvKelvin.setText(String.valueOf(temperatureK2)+ "  °K");

            }
        });

    }

}
