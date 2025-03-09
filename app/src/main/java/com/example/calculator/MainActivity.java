package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private RadioGroup rgOperations;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        rgOperations = findViewById(R.id.rgOperations);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(view -> {
            if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Masukkan kedua angka!", Toast.LENGTH_SHORT).show();
                return;
            }

            double num1 = Double.parseDouble(etNum1.getText().toString());
            double num2 = Double.parseDouble(etNum2.getText().toString());
            double result = 0;

            int selectedId = rgOperations.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(MainActivity.this, "Pilih operasi!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedOperation = findViewById(selectedId);
            String operation = selectedOperation.getText().toString();

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "×":
                    result = num1 * num2;
                    break;
                case "÷":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(MainActivity.this, "Tidak bisa membagi dengan nol!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("RESULT", result);
            startActivity(intent);
        });
    }
}
