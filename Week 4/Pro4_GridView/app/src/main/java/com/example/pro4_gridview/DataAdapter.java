package com.example.pro4_gridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {

    private Activity activity;
    private String[] items;

    public DataAdapter(Activity activity, String[] items) {
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        view = inflater.inflate(R.layout.item_name, null);

        TextView textName =(TextView) view.findViewById(R.id.text_name);
        textName.setText(items[i]);

        return view;
    }
}
