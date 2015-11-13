package com.example.all_university_info;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class All_uviersityActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_uviersity);
		
		Button button=(Button) findViewById(R.id.du);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Dhaka_University.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button1=(Button) findViewById(R.id.ru);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Rajshahi_University.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button2=(Button) findViewById(R.id.cu);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Chittagong_University.class);
				startActivity(intent);
				
			}
		});
		
		Button button3=(Button) findViewById(R.id.ju);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Jahangirnagar_University.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button4=(Button) findViewById(R.id.bu);
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Barisal_University.class);
				startActivity(intent);
				
			}
		});
		
		Button button5=(Button) findViewById(R.id.iu);
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Islamic_University.class);
				startActivity(intent);
				
			}
		});
		
		
		Button button6=(Button) findViewById(R.id.khu);
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(All_uviersityActivity.this, Khunla_Varsity.class);
				startActivity(intent);
				
			}
		});
		
	
	
	Button button7=(Button) findViewById(R.id.chu);
	button7.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent=new Intent(All_uviersityActivity.this, Comilla_University.class);
			startActivity(intent);
			
		}
	});
	
	
	
	Button button8=(Button) findViewById(R.id.jnu);
	button8.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent=new Intent(All_uviersityActivity.this, Jagannath_University.class);
			startActivity(intent);
			
			
		}
	});
	
	
	Button button9=(Button) findViewById(R.id.knu);
	button9.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent=new Intent(All_uviersityActivity.this, Kabi_Nazrul_University.class);
			startActivity(intent);
			
			
		}
	});
	
	Button button10=(Button) findViewById(R.id.bru);
	button10.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent=new Intent(All_uviersityActivity.this, Begum_Rokeya_University.class);
			startActivity(intent);
			
			
		}
	});
	
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_uviersity, menu);
		return true;
	}

}
