package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TechonolgActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_techonolg);
		
		Button button=(Button) findViewById(R.id.sust);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, SUST.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button1=(Button) findViewById(R.id.mbstu);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, MBSTU.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button2=(Button) findViewById(R.id.hstu);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, HSTU.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button3=(Button) findViewById(R.id.pstu);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, PSTU.class);
				startActivity(intent);
				
			}
		});
		
		Button button4=(Button) findViewById(R.id.nstu);
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, NSTU.class);
				startActivity(intent);
				
			}
		});
		
		Button button5=(Button) findViewById(R.id.jstu);
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, JSTU.class);
				startActivity(intent);
				
			}
		});
		
		Button button6=(Button) findViewById(R.id.pabna);
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, Pabna_PSTU.class);
				startActivity(intent);
				
			}
		});
		
		Button button7=(Button) findViewById(R.id.bs);
		button7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TechonolgActivity.this, BSMRSTU.class);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.techonolg, menu);
		return true;
	}

}
