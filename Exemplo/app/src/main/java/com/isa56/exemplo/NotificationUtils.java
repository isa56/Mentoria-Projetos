package com.isa56.exemplo;

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

public class NotificationUtils {

    private static String CHANNEL_ID = "default";

    @RequiresApi(Build.VERSION_CODES.O)
    public static void createNotificationChannel(Context c){
        NotificationManager manager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);

        String channelName = "Padrão";
        String channelDescription = "Notificações padrão";

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_DEFAULT);

        channel.setDescription(channelDescription);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.enableVibration(true);

        manager.createNotificationChannel(channel);
}

    public static void notificationSimple(Context c, String titulo, String cont){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(c);
        }

        NotificationCompat.BigTextStyle expansivel = new NotificationCompat.BigTextStyle().bigText(cont);


        NotificationCompat.Builder b = new NotificationCompat.Builder(c, CHANNEL_ID);
        b.setSmallIcon(R.drawable.pencil);
        b.setContentTitle("Notificação de teste!");
        b.setStyle(expansivel);
        b.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        b.setColor(ActivityCompat.getColor(c, R.color.pink));
        b.setDefaults(Notification.DEFAULT_ALL);
        b.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(c);
        managerCompat.notify(1, b.build());

    }

}
