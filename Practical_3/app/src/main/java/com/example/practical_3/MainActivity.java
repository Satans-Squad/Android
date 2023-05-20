package com.example.practical_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
Button convert;
EditText number;
Spinner sp;
TextView ans;
String option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert=findViewById(R.id.convert);
        number=findViewById(R.id.number);
        sp=findViewById(R.id.spinner);
        ans=findViewById(R.id.ans);
        String s[]={"Binary","Hex"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,s);
        sp.setAdapter(arrayAdapter);
        sp.setSelection(0);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                option=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ip=Integer.parseInt(number.getText().toString());
                if(option.equals("Hex")){
                    ans.setText("Ans:"+Integer.toHexString(ip).toUpperCase());
                }
                else{
                    ans.setText("Ans:"+Integer.toBinaryString(ip));
                }
            }
        });
    }
}