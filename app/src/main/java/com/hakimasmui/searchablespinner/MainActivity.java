package com.hakimasmui.searchablespinner;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SearchableSpinner spinner;

    List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add("UMKM");
        items.add("Singa");
        items.add("Harimau");
        items.add("Bus");
        items.add(" ");

        spinner = findViewById(R.id.spinner);
        spinner.setItems(items);
        spinner.setOnItemSelected(new SearchableSpinner.OnItemSelected() {
            @Override
            public void onSelected(String string) {
                Log.d("fatih", string);
            }
        });
    }
}