package com.example.listview_practical_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] items = {"Java","Android","Python","JavaSript","Go Lang","React","Java","Android","Python","JavaSript","Go Lang","React","Java","Android","Python","JavaSript","Go Lang","React","Java","Android","Python","JavaSript","Go Lang","React"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}