package com.example.wisher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message body");
        String number = intent.getStringExtra("number");
        Log.i("Message",message);
        Log.i("Number",number);
        try {
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(number,null,message,null,null);
            Toast.makeText(context,"Sms sent",Toast.LENGTH_SHORT).show();

        }catch(Exception e) {
            Toast.makeText(context,"Sms not sent",Toast.LENGTH_SHORT).show();
        }

    }
}
