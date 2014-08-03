package com.example.smart_door;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main_screen extends Activity{
	
	Button nowHomeState;
	Button remoteControl;
	Button setting;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

		nowHomeState = (Button)findViewById(R.id.now_home_state_button);
		
		nowHomeState.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Main_screen.this,NowHomeState.class);
				startActivity(intent);
			}
		});

		 remoteControl = (Button)findViewById(R.id.remote_control_button);
		
		 remoteControl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});

		 setting = (Button)findViewById(R.id.setting_button);//회원가입 버튼
		

	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	       switch(keyCode) {
	        case KeyEvent.KEYCODE_BACK:
	           new AlertDialog.Builder(this)
	                          .setTitle("로그아웃")
	                          .setMessage("로그아웃 하시겠습니까?")
	                         .setPositiveButton("예", new DialogInterface.OnClickListener() {
	                           public void onClick(DialogInterface dialog, int whichButton) {
	                           finish();
	                          }
	                        })
	                         .setNegativeButton("아니요", null).show();
	                         return false;
	          default:
	            return false;
	       }
	 }
}
