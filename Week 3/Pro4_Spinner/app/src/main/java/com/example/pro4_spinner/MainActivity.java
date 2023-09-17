package com.example.pro4_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        spinner = (Spinner) findViewById(R.id.spinner);

        DataAdapter adapter = new DataAdapter(this, items);
        spinner.setAdapter(adapter);
    }
}