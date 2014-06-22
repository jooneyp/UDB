package com.example.ummdeliciousbook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Search extends Activity implements OnClickListener{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		ImageButton today_rmd = (ImageButton)findViewById(R.id.today_rmd);
		today_rmd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.cook.miznet.daum.net/top")));
	}

}
