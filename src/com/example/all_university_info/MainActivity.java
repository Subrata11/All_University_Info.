package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=(Button) findViewById(R.id.button2);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(MainActivity.this, GovtActivity.class);
				 startActivity(intent);
			}
		});
		
	Button button2=(Button) findViewById(R.id.button3);
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(MainActivity.this, NonGovtActivity.class);
				 startActivity(intent);
			}
		});
		
		
		Button button3=(Button) findViewById(R.id.button4);
		
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 				 Intent intent=new Intent(MainActivity.this, National_Varsity.class);
 				 startActivity(intent);
			}
		});
		
		Button button4=(Button) findViewById(R.id.button5);
		
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(MainActivity.this, OthersVarsityActivity.class);
				 startActivity(intent);
			}
		});
		
		Button button5=(Button) findViewById(R.id.button6);
		
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(MainActivity.this,International_Varsity.class);
				 startActivity(intent);
			}
		});
		
		
		Button button6=(Button) findViewById(R.id.Me);
		
		
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(MainActivity.this,About_MeActivity.class);
				 startActivity(intent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
