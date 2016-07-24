package com.zappers.gola.Services;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;

import com.zappers.gola.Activities.MainActivity;
import com.zappers.gola.R;

/**
 * Created by Administrator on 10-02-2016.
 */
public class MyService extends Service {

    /*public MyService() {
        super("MyService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

    }*/

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        // Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "MyWakelockTag");
        wakeLock.acquire();
        runTimer();
        //createNotification();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }



    //Calendar cal = Calendar.getInstance();
    int second = 0;//cal.get(Calendar.MINUTE);
    int minute = 0;
    static int counter=0;

    private void runTimer() {
        final android.os.Handler handler = new android.os.Handler();
        handler.post(new Runnable() {

            @Override
            public void run() {
                if(second==60)
                {
                    minute++;
                    if(minute==1)
                    {
                        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
                        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                                "MyWakelockTag");
                        wakeLock.acquire();
                        createNotification();
                        minute=0;
                    }
                    second=0;
                }
                second++;
                handler.postDelayed(this, 1000);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int)System.currentTimeMillis(), intent, 0);
// Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Gola")
                .setContentText("Mark attendance of this lecture.").setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .addAction(R.drawable.tick, "Present", pIntent)
                .addAction(R.drawable.cross, "Absent", pIntent).build();
        //.addAction(R.drawable.ic_launcher, "And more", pIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        noti.defaults |= Notification.DEFAULT_SOUND;
        noti.defaults |= Notification.DEFAULT_VIBRATE;
        //startForeground(counter++,noti);
        notificationManager.notify(counter++, noti);
    }

}