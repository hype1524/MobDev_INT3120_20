package com.example.pro4_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        gridView = (GridView) findViewById(R.id.grid_view);

        DataAdapter adapter = new DataAdapter(this, items);
        gridView.setAdapter(adapter);
    }
}