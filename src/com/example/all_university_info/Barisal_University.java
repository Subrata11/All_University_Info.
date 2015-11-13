package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Barisal_University extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_barisal__university);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.barisal__university, menu);
		return true;
	}

}
