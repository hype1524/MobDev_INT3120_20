package com.example.pro10_contentprovider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACT_PERMISSION = 1001;
    AppCompatButton btn;
    AppCompatButton btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    public void solveReadContact() {
        Intent intent = new Intent(MainActivity.this, Contact.class);
        intent.setClassName("com.example.pro10_contentprovider", "com.example.pro10_contentprovider.Contact");
        startActivity(intent);
    }
    public void solveAddContact() {
        Intent intent = new Intent(MainActivity.this, Contact.class);
    }
    public void addEvent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveReadContact();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solveAddContact();
            }
        });
    }
    public void addControl() {
        btn = findViewById(R.id.btn);
        btnadd = findViewById(R.id.btnadd);
    }
}