package org.android.perceptionnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1 = new Intent(getApplicationContext(),TimeChart.class);
                startActivity(intent1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent2 = new Intent(getApplicationContext(),Notification.class);
                startActivity(intent2);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent3 = new Intent(getApplicationContext(),Messges.class);
                startActivity(intent3);
            }
        });
    }
}
