package com.example.ummdeliciousbook;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.*;

public class Refrigerator extends Activity {
	private DBHelper dbHelper;
	SQLiteDatabase database = openOrCreateDatabase("database.db", Context.MODE_PRIVATE, null);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frige);
		
		ListView list = (ListView) findViewById(R.id.list);
			Cursor cursor = executeRawQueryParam();
			startManagingCursor(cursor);
			
			String[] columns = new String[] {"itemname", "date", "location"};
			int[] to = new int[] { R.id.name_item, R.id.due_date, R.id.location};
			
			SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.activity_frige, cursor, columns, to);
			
			list.setAdapter(mAdapter);
		
		Button btn_input = (Button)findViewById(R.id.button1);
		/*
		btn_input.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Refrigerator.this, FoodInput.class);
				startActivity(intent);
			}
		});
		*/
		
		

	}

	/*
	@Override
	public boolean onItemLongClick(AdapterView<?> adapterView, View v, int i, long l) {
		// TODO Auto-generated method stub
		final Integer selectedPos = i;
		AlertDialog.Builder alertDlg = new AlertDialog.Builder(v.getContext());
		alertDlg.setTitle("�����Ͻðڽ��ϱ�?");
		Log.i("delete", "1");
		alertDlg.setPositiveButton("��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String position = arr_id_list.get(selectedPos);
				final String sql = "delete from food where id = "+position;
				dialog.dismiss();
				Log.i("yes", "onclick");
				db.execSQL(sql);
			}
		});
		
		alertDlg.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String position = arr_id_list.get(selectedPos);
				dialog.dismiss();
				Log.i("no", "1");
			}
		});
		return false;
	}
	*/
	
	private Cursor executeRawQueryParam() {
		String SQL = "SELECT * from tb1;";
		String[] args = {"10"};
		Cursor c1 = database.rawQuery(SQL, args);
		
		return c1;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		database.close();
	}
}

	