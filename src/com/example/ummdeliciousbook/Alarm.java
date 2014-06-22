package com.example.ummdeliciousbook;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class Alarm extends Activity implements OnDateChangedListener, OnTimeChangedListener, OnClickListener{
	private AlarmManager mManager;
	private GregorianCalendar mCalendar;
	private DatePicker mDate;
	private TimePicker mTime;
	
	private NotificationManager mNotification;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mNotification = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		mManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		mCalendar = new GregorianCalendar();
		Log.i("HS", mCalendar.getTime().toString());
		
		setContentView(R.layout.activity_alarm);
		
		ImageButton a_set = (ImageButton)findViewById(R.id.alarmset);
		a_set.setOnClickListener(this);
		
		mDate = (DatePicker)findViewById(R.id.datePicker1);
		mDate.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), 
				mCalendar.get(Calendar.DAY_OF_MONTH), this);
		mTime = (TimePicker)findViewById(R.id.timePicker1);
		mTime.setCurrentHour(mCalendar.get(Calendar.HOUR_OF_DAY));
		mTime.setCurrentMinute(mCalendar.get(Calendar.MINUTE));
		mTime.setOnTimeChangedListener(this);
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
		Log.i("HS", "success");
		PendingIntent pi = PendingIntent.getBroadcast(Alarm.this, 0, intent, 0);
		Log.i("HS", "success");
		mManager.set(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), pi);
		Log.i("HS", "success");
		Toast.makeText(getBaseContext(), "알람이 설정되었습니다", Toast.LENGTH_LONG).show();
		Log.i("HS", "success");
		Log.i("HS", mCalendar.getTime().toString());
	}

	/*private void setAlarm() {
		// TODO Auto-generated method stub
	}*/
	/*private PendingIntent pendingIntent() {
		// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(), AlarmReceiver.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
		Log.i("HS", mCalendar.getTime().toString());
		return pi;
	}*/
	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		// TODO Auto-generated method stub
		mCalendar.set(mDate.getYear(), mDate.getMonth(), mDate.getDayOfMonth(), hourOfDay, minute);
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		mCalendar.set(year, monthOfYear, dayOfMonth, mTime.getCurrentHour(), mTime.getCurrentMinute());
		Log.i("HS", mCalendar.getTime().toString());
	}




}
