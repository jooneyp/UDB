package com.example.ummdeliciousbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	public static final String PACKAGE_DIR = "/data/data/com.example.ummdeliciousbook/";
	public static final String DATABASE_NAME = "database.db";
	public static final String DATABASE2_NAME = "database.db";
	public static void initialize(Context ctx) {
	//check
		File folder = new File(PACKAGE_DIR + "databases");
		folder.mkdirs();
		File outfile = new File(PACKAGE_DIR + "databases/" + DATABASE2_NAME);

		if(outfile.length() <= 0) {
			AssetManager assetManager = ctx.getResources().getAssets();
			try {
				InputStream is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
				long filesize = is.available();
				byte [] tempdata = new byte[(int)filesize];
				is.read(tempdata);
				is.close();
				outfile.createNewFile();
				FileOutputStream fo = new FileOutputStream(outfile);
				fo.write(tempdata);
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivity(new Intent(this, Loading.class));
		
		Button btn_refri = (Button) findViewById(R.id.refrigerator);
		btn_refri.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Refrigerator.class);
				startActivity(intent);
			}
		});

		Button btn_search = (Button) findViewById(R.id.search);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Search.class);
				startActivity(intent);
			}
		});
		
	}

	

}
