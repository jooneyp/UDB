package com.example.ummdeliciousbook;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore.Audio;
import android.sax.StartElementListener;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	private int YOURAPP_NOTIFICATION_ID;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		try{
			intent = new Intent(context, AlarmOffPage.class);
			Log.i("HSReceiver1", "success");
			PendingIntent pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
			Log.i("HSReceiver2", "success");
			pi.send();
			Log.i("HSReceiver3", "success");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*private void showNotification(Context context, int statusBarIconID,
			String statusBarTExtID, String detailedTextID) {
		// TODO Auto-generated method stub
		Intent contentintent = new Intent(context, Refrigerator.class);
		PendingIntent theappIntent = PendingIntent.getActivity(context, 0, contentintent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		CharSequence from = "알람";
		CharSequence message = "유통기한이 만료되었습니다";
		
		Notification noti = new Notification.Builder(context)
		.setContentTitle(statusBarTExtID)
		.setContentText(message)
		.setContentIntent(theappIntent)
		.build();
		
		noti.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "6");
		noti.flags = Notification.FLAG_INSISTENT;
		noti.setLatestEventInfo(context, from, message, theappIntent);
		noti.ledARGB = Color.CYAN;
		NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		nm.notify(1234, noti);
		
	}*/

}
