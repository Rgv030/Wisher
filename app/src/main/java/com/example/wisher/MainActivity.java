package com.example.wisher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

import static android.app.PendingIntent.FLAG_NO_CREATE;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity{
    EditText contact_name;
    EditText contact_number;
    EditText message;
    TextView dateview;
    int year,month,date;

public  void date_picker(View view){

         Calendar calendar = Calendar.getInstance();

    DatePickerDialog datePicker = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        String datestring = date + "/"+ month + "/" + year;
        dateview.setText(datestring);
        }

        }, year = calendar.get(Calendar.YEAR),month = calendar.get(Calendar.MONTH),date =calendar.get(Calendar.DAY_OF_MONTH));
    datePicker.show();

    }

public void Alarm (View view){
    SetAlarm();
    Toast.makeText(this,"Message Scheduled",Toast.LENGTH_SHORT).show();
    Intent return_class = new Intent(this,Create_Screen.class);
    startActivity(return_class);
}

public void SetAlarm (){

    Calendar cal_alarm = Calendar.getInstance();
    cal_alarm.setTimeInMillis(System.currentTimeMillis());
    cal_alarm.set(Calendar.YEAR,year);
    cal_alarm.set(Calendar.MONTH,month);
    cal_alarm.set(Calendar.DAY_OF_MONTH,date);
    cal_alarm.set(Calendar.HOUR_OF_DAY,12);
    cal_alarm.set(Calendar.MINUTE,23);
    cal_alarm.set(Calendar.SECOND,0);

    AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(this,Receiver.class);
    Bundle b = new Bundle();
    b.putString("message body",message.getText().toString());
    b.putString("number",contact_number.getText().toString());
    intent.putExtras(b);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
    alarmManager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(),pendingIntent);
}

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_name = (EditText) findViewById(R.id.Name);
        contact_number = (EditText) findViewById(R.id.Number);
        message = (EditText)findViewById(R.id.message);
        dateview = (TextView)findViewById(R.id.dateview);
        message.setText("Happy Birthday God Bless you");


        }
    }

