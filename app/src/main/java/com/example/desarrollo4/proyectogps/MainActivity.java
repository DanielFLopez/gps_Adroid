package com.example.desarrollo4.proyectogps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btn_start, btn_stop;
    private TextView textView;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onResume(){
        super.onResume();

        if(broadcastReceiver == null){
            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    @SuppressLint({"NewApi", "LocalSuppress"}) String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    Modelo record = new Modelo("record1", mydate, 11.22121215484, 12.127894615475);
                    record.save();
                    textView.append("\n" + intent.getExtras().get("longitud") + " " + intent.getExtras().get("latitud") + " " + record.fecha);
                }
            };
        }

        registerReceiver(broadcastReceiver, new IntentFilter("location_update"));

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if(broadcastReceiver != null){
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_start = (Button) findViewById(R.id.button);
        btn_stop = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.editText);

        enabled_buttons();

    }

    private void enabled_buttons() {
        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                startService(i);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), GPS_Service.class);
                stopService(i);
                Modelo m = Modelo.findById(Modelo.class, 3);
                textView.setText(m.fecha + " " + m.nombre + " " + m.getLongitud());
            }
        });
    }
}
