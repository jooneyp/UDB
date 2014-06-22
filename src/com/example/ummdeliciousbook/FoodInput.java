package com.example.ummdeliciousbook;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FoodInput extends Activity implements OnCheckedChangeListener{
	SQLiteDatabase db;
	String dbName = "food";
	String createTable = "create table food_input (id integer primary key, name text, date text, state text);";
	
	EditText itemname;
	EditText duedate;
	ToggleButton alarm;
	ImageButton foodinfoinput;
	RadioButton freeze, coldstorage;
	String state;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frigeinput);
	/*
		createDatabase();
		createTable();
		
		itemname = (EditText)findViewById(R.id.itemname);
		duedate = (EditText)findViewById(R.id.duedate);
		freeze = (RadioButton)findViewById(R.id.freeze);
		freeze.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				state="freeze";
			}
		});
		coldstorage = (RadioButton)findViewById(R.id.cold_storage);
		coldstorage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				state = "cold_stoarge";
			}
		});*/
		alarm = (ToggleButton)findViewById(R.id.alarm);
		alarm.setOnCheckedChangeListener(this);
		
		foodinfoinput = (ImageButton)findViewById(R.id.foodinfoinput);
		/*foodinfoinput.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String foodname_db = itemname.getText().toString();
				String duedate_db = duedate.getText().toString();
				String fre_or_cold = state;
				
				Insert_info(fre_or_cold, foodname_db, duedate_db);
				Toast.makeText(FoodInput.this, "냉장고에 저장되었습니다", Toast.LENGTH_LONG).show();
				
				startActivity(new Intent(FoodInput.this, Refrigerator.class));
			}

			
		});*/
	}
	
/*	private void Insert_info(String fre_or_cold, String foodname_db,
			String duedate_db) {
		// TODO Auto-generated method stub
		db.beginTransaction();
		try{
			String sql = "insert into food_input (state, name, date) values ("+ fre_or_cold +","+foodname_db+","
					+duedate_db+");";
			db.execSQL(sql);
			db.setTransactionSuccessful();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.endTransaction();
		}
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		db.close();
	}

	private void createTable() {
		// TODO Auto-generated method stub
		try{
			db.execSQL(createTable);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void createDatabase() {
		// TODO Auto-generated method stub
		db = openOrCreateDatabase(dbName, MODE_WORLD_WRITEABLE, null);
		
	}*/

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(isChecked){
			startActivity(new Intent(this, Alarm.class));
		}
	}
	

}
