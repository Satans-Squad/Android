package com.example.practical_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = findViewById(R.id.radiogrp);
        RadioButton male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (i){
                    case R.id.male:
                        Fragment malefragment = new MaleFragment();
                        fragmentTransaction.replace(R.id.container,malefragment);
                        break;
                    case R.id.female:
                        Fragment femalefragment =  new FemaleFragment();
                        fragmentTransaction.replace(R.id.container,femalefragment);
                        break;
                }
                fragmentTransaction.commit();

            }
        });
    }
}