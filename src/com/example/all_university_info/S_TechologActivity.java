package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class S_TechologActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s__techolog);
		Button button=(Button) findViewById(R.id.buet);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(S_TechologActivity.this, BUET.class);
				startActivity(intent);
			}
		});
		
		
		Button button1=(Button) findViewById(R.id.ruet);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(S_TechologActivity.this, RUET.class);
			     startActivity(intent);
			}
		});
		

		Button button2=(Button) findViewById(R.id.cuet);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(S_TechologActivity.this, CUET.class);
			     startActivity(intent);
			}
		});
		
		Button button3=(Button) findViewById(R.id.kuet);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(S_TechologActivity.this, KUET.class);
			     startActivity(intent);
			}
		});
		
		Button button4=(Button) findViewById(R.id.duet);
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(S_TechologActivity.this, DUET.class);
			     startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.s__techolog, menu);
		return true;
	}

}
