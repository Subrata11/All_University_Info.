package com.example.all_university_info;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Khunla_Varsity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_khunla__varsity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.khulna__university, menu);
		return true;
	}

}
