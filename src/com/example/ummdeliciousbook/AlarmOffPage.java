package com.example.ummdeliciousbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmOffPage extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarmoffpage);
		
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(AlarmOffPage.this, "냉장고로 이동합니다", Toast.LENGTH_LONG).show();
				startActivity(new Intent(AlarmOffPage.this, Refrigerator.class));
			}
		});
	
	}
	
}
