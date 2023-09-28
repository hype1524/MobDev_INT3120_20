package com.example.pro8_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private TextView textView;

    public MyBroadcastReceiver(TextView textView) {
        this.textView = textView;
    }
    public void setTextView(String message) {
        textView.setText(message);
    }
    public String getTextView() {
        return textView.toString();
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
        setTextView(message);
    }
}
