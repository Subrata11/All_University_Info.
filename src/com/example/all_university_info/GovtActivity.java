package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GovtActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_govt);
		
		Button button=(Button) findViewById(R.id.button2);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(GovtActivity.this, All_uviersityActivity.class);
				 startActivity(intent);
			}
		});
		
		
			Button button2=(Button) findViewById(R.id.button3);
		
			button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(GovtActivity.this, TechonolgActivity.class);
				 startActivity(intent);
			}
		});
			
			
			Button button3=(Button) findViewById(R.id.button4);
			
			button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(GovtActivity.this, AgriActivity.class);
				 startActivity(intent);
			}
		});
			
			Button button4=(Button) findViewById(R.id.button5);
			
			button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(GovtActivity.this, S_TechologActivity.class);
				 startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.govt, menu);
		return true;
	}

}
