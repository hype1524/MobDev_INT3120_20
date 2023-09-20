package com.example.pro6_optionmenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        MenuItem menuItem = (MenuItem) menu.findItem(R.id.item1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1) {
            Toast.makeText(getBaseContext(),"item1",Toast.LENGTH_LONG).show();
        } else if (id == R.id.item2) {
            Toast.makeText(getBaseContext(),"item2",Toast.LENGTH_LONG).show();
        } else if (id == R.id.item3) {
            Toast.makeText(getBaseContext(),"item3",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}