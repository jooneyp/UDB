package com.example.ummdeliciousbook;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load);
		
		Handler hd = new Handler();
		hd.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				
			}
		}, 3000);
	}
	
}
