package org.android.perceptionnotification;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimeChart extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    SQLiteDatabase database;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timechart);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);


        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String databaseName = editText.getText().toString();
                openDatabase(databaseName);

            }
        });

        Button button2 = (Button) findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String tableName = editText2.getText().toString();
                createTable(tableName);
            }
        });

        Button button3 = (Button) findViewById(R.id.button6);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = editText3.getText().toString().trim();
                String tel = editText4.getText().toString().trim();
                String contents = editText5.getText().toString().trim();

                insertData(name, tel, contents);
            }
        });
    }

    public void openDatabase(String databaseName){
        println("openDatabase() 호출됨.");

        database = openOrCreateDatabase(databaseName,MODE_PRIVATE,null);

        if(database != null){
            println("데이터베이스 오픈됨.");
        }

    }

    public void createTable(String tableName){
        println("createTable() 호출됨.");

        if(database != null){
            String sql = "create table " + tableName + "("
                                                        + "_id integer PRIMARY KEY autoincrement, "
                                                        + "name text, "
                                                        + "tel text, "
                                                        + "contens text);";
            database.execSQL(sql);


            println("테이블 생성됨.");
        }else{
            println("먼저 데이터베이스를 오픈하세요.");
        }
    }

    public void insertData(String name, String tel, String contents){
        println("insertData() 호출됨.");

        if(database != null){
            String sql = "insert into Teachers(name, tel, contents) values (?, ?, ?);";
            Object[] params = {name, tel, contents};
            database.execSQL(sql, params);

            println("데이터 추가함.");
        }else{
            println("먼저 데이터베이스를 오픈하세요.");
        }
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}
