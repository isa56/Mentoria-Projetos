package com.meteoro.recyclerandnotificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class    NotificationUtils {

    private static String CHANNEL_ID = "default";

    @RequiresApi(Build.VERSION_CODES.O)
    private static void createNotificationChannel(Context context) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String channelName = "Padrão";
        String channelDescription = "Um channel padrão";
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(channelDescription);
        channel.enableLights(true);
        channel.setLightColor(Color.GREEN);
        channel.enableVibration(true);

        manager.createNotificationChannel(channel);
    }

    public static void notificationSimple(Context context, String title, String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // create channel
            createNotificationChannel(context);
        }
        // create notification
        NotificationCompat.BigTextStyle textStyle = new NotificationCompat.BigTextStyle().bigText(content);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setStyle(textStyle);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setColor(ActivityCompat.getColor(context, R.color.purple_200));
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setAutoCancel(true);

        NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(context);
        notificationCompat.notify(1, builder.build());
    }
}
