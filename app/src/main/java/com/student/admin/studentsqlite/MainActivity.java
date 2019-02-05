package com.student.admin.studentsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
    Button b;
    String getname,getrollno,getadmno,getcollege;
    studenthelper Studenthelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.rollno);
        ed3 = (EditText) findViewById(R.id.admno);
        ed4 = (EditText) findViewById(R.id.college);
        Studenthelper=new studenthelper(this);
        Studenthelper.getWritableDatabase();
        b = (Button) findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname=ed1.getText().toString();
                getrollno = ed2.getText().toString();
                getadmno= ed3.getText().toString();
                getcollege= ed4.getText().toString();
                Log.d("name",getname);
                Log.d("rollno",getrollno);
                Log.d("admn",getadmno);
                Log.d("college",getcollege);
                boolean status=Studenthelper.insertData(getname,getrollno,getadmno,getcollege);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
