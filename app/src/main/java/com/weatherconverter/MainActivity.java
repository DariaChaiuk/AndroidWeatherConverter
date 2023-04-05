package com.weatherconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner convert_from, convert_to;
    TextView result;
    EditText inputValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignIdForSpinner(convert_from, R.id.convert_from);
        assignIdForSpinner(convert_to, R.id.convert_to);

        inputValue = (EditText) findViewById(R.id.input_from);
        result = (TextView) findViewById(R.id.result_field);

        handleResult();
    }

    void assignIdForSpinner(Spinner spinner, int id) {
        spinner = (Spinner) findViewById(id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.degrees_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    void handleResult() {
        inputValue.setOnEditorActionListener((v, actionId, event) -> {

            String fromType = ((Spinner) findViewById(R.id.convert_from)).getSelectedItem().toString();
            String toType = ((Spinner) findViewById(R.id.convert_to)).getSelectedItem().toString();

            float value = Float.valueOf(inputValue.getText().toString());
            float resValue = 0;

            if (actionId == EditorInfo.IME_ACTION_GO) {
                switch (fromType) {
                    case "Celsius":
                        resValue = Converter.convertFromCelsius(toType, value);
                        break;
                    case "Fahrenheit":
                        resValue = Converter.convertFromFahrenheit(toType, value);
                        break;
                    case "Kelvin":
                        resValue = Converter.convertFromKelvin(toType, value);
                        break;
                }

                result.setText(String.valueOf(resValue));
                return true;
            }
            return false;
        });
    }
}