package com.example.pro8_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        MyBroadcastReceiver receiver = new MyBroadcastReceiver(textView);
        IntentFilter intentFilter = new IntentFilter("com.example.ACTION_MY_EVENT");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter);

        Intent intent = new Intent("com.example.ACTION_MY_EVENT");
        intent.putExtra("message", "POWER DISCONNECTED");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        textView.setText(receiver.getTextView());
    }
}
