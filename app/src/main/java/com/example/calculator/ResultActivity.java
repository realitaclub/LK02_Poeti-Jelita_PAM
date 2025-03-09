package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResult , tvName , tvNim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tvResult);
        tvName = findViewById(R.id.tvName);
        tvNim = findViewById(R.id.tvNim);

        double result = getIntent().getDoubleExtra("RESULT", 0);
        tvResult.setText("Hasil: " + result);
        tvName.setText("Nama : Poeti Jelita");
        tvNim.setText("NIM: 235150701111032");
    }
}
