package com.zappers.gola.Services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import android.os.Build;
/**
 * Created by Administrator on 10-02-2016.
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId)
    {
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
    super.onDestroy();
    }
}
