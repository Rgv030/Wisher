package com.example.wisher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Create_Screen extends AppCompatActivity {
Button new_reminder;
ListView namelist;
 public void setNew_reminder(View viw){
     Intent intent1 = new Intent(this,MainActivity.class);
     startActivity(intent1);
 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__screen);
        new_reminder = (Button)findViewById(R.id.reminder);
        namelist = (ListView)findViewById(R.id.list);
    }
}
