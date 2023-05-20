package com.example.practical_6;

//import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String []lang={"c","c++","java","python","GO","Kotlin","JavaScript","HTML","CSS","Node.js","React.js","Angular.js","Next.js","c#","R","Ruby","Swift"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l;
        l=findViewById(R.id.list);
        ArrayAdapter<String> a=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lang);
        l.setAdapter(a);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=l.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}