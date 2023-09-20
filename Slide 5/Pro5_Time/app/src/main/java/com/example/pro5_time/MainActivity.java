package com.example.pro5_time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.time_picker);
        timePicker.setIs24HourView(false);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timePicker.is24HourView()) {
                    String time = "Thời gian: " + timePicker.getHour() + ":" + timePicker.getMinute();
                    Toast.makeText(MainActivity.this, time, Toast.LENGTH_LONG).show();
                }
                else {
                    if(timePicker.getHour() >= 12) {
                        String time = "Thời gian: " + (timePicker.getHour() - 12) + ":" + timePicker.getMinute() + " PM";
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_LONG).show();
                    }
                    else {
                        String time = "Thời gian: " + timePicker.getHour() + ":" + timePicker.getMinute() + " AM";
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}