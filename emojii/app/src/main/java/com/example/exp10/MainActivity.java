package com.example.exp10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button rotate;
boolean isrotated=false;
ImageView smily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotate=findViewById(R.id.rotate);
        smily=findViewById(R.id.smily);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isrotated==false) {
                    smily.setRotation(180);
                    isrotated=true;
                }
                else{
                    smily.setRotation(360);
                    isrotated=false;
                }

            }
        });
    }
}