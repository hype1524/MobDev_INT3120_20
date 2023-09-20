package com.example.pro6_contextmenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    String [] languages;
    List<String> languagesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView	=	(ListView)findViewById(R.id.list_view);
        languages	=	getResources().getStringArray(R.array.languages);
        languagesList	= new ArrayList<String>(Arrays.asList(languages));
        adapter		=	 new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languagesList);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        String i = adapter.getItem(position);
        if(item.getItemId() == R.id.delete) {
            languagesList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.uppercase) {
            String u = i.toUpperCase();
            languagesList.set(position, u);
            adapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.lowercase) {
            String l = i.toLowerCase();
            languagesList.set(position,l);
            adapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

}