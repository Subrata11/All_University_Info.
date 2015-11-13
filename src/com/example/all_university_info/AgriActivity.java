package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AgriActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agri);
		
		Button button=(Button) findViewById(R.id.bau);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 Intent intent=new Intent(AgriActivity.this, BAU.class);
			 startActivity(intent);
				
			}
		});
		
		Button button1=(Button) findViewById(R.id.sau);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 Intent intent=new Intent(AgriActivity.this, SAU.class);
			 startActivity(intent);
			}
		});
		
		
		Button button2=(Button) findViewById(R.id.syu);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 Intent intent=new Intent(AgriActivity.this, SAU.class);
			 startActivity(intent);
			}
		});
		
		Button button3=(Button) findViewById(R.id.bmu);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 Intent intent=new Intent(AgriActivity.this, BSMRAU.class);
			 startActivity(intent);
			}
		});
		
		Button button4=(Button) findViewById(R.id.cha);
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 Intent intent=new Intent(AgriActivity.this, CVASU.class);
			 startActivity(intent);
			}
		});
	}

	 
}


