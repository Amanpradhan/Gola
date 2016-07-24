package com.zappers.gola.Models;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zappers.gola.Services.MyService;

/**
 * Created by Administrator on 10-02-2016.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyService.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}