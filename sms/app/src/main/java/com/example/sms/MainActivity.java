package com.example.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText mob,msg;
Button send;
//    public static final int PERMISSION=Manifest.permission.SEND_SMS;
    public static final int CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mob=findViewById(R.id.mob);
        msg=findViewById(R.id.msg);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                    try {
                        sendSms(mob.getText().toString(), msg.getText().toString());
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},CODE);
                }
            }
        });
    }
    public void sendSms(String mob,String msg)throws Exception{
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(mob,null,msg,null,null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CODE){
            SmsManager sms=SmsManager.getDefault();
            sms.sendTextMessage(mob.getText().toString(),null,msg.getText().toString(),null,null);
        }
        else{
            Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
        }
    }
}