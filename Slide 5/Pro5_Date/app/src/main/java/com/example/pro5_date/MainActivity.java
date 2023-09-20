package com.example.pro5_date;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.date_picker);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = "Ngày: " + datePicker.getDayOfMonth();
                String month = "\nTháng: " + (datePicker.getMonth() + 1);
                String year = "\nNăm: " + datePicker.getYear();
                Toast.makeText(MainActivity.this, day + month + year, Toast.LENGTH_LONG).show();
            }
        });

    }
}