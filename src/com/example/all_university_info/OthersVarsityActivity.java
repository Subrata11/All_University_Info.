package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OthersVarsityActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_others_varsity);
		
		Button button=(Button) findViewById(R.id.butx);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 
				Intent intent=new Intent(OthersVarsityActivity.this, BUTex.class);
				startActivity(intent);
				
			}
		});
		
		
		
		Button button1=(Button) findViewById(R.id.bauu);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 
				Intent intent=new Intent(OthersVarsityActivity.this, Bangladesh_Open_University.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button2=(Button) findViewById(R.id.medical);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 
				Intent intent=new Intent(OthersVarsityActivity.this, BSMMMU.class);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.others_varsity, menu);
		return true;
	}

}
