package org.android.perceptionnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent1 = new Intent(getApplicationContext(),TimeChart.class);
        startActivity(intent1);
    }

    public void onButton2Clicked(View v){
        Intent intent2 = new Intent(getApplicationContext(),Notification.class);
        startActivity(intent2);
    }

    public void onButton3Clicked(View v){
        Intent intent3 = new Intent(getApplicationContext(),Messges.class);
        startActivity(intent3);
    }

}
