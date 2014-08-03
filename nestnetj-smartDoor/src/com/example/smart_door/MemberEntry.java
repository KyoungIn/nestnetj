package com.example.smart_door;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MemberEntry extends Activity{

	EditText idText;//ID 받는 텍스트
	String ID;//edit text에서 받을 아이디
	EditText pwText;//pw 받는 텍스트
	String PW;//받을 페스워드
	
	TextView NFCtext;//NFC ID 나타낼 텍스트
	String NFCnum;
	TextView uniqueNumT;//고유변호 나타낼 텍스트
	String uniqueNum;
	
	Spinner labelSpinner;//직책 고르는 스피너
	
	Button checkrepeatness;//중복확인 검사 버튼
	Button NFCid;//NFC_id 버튼
	Button uniqueNumB;//고유번호 나타내는 버튼
	Button entry;//회원가입 버튼
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.entry); //회원 가입 화면 출력
		
		idText = (EditText)findViewById(R.id.ID_text);
		pwText = (EditText)findViewById(R.id.PW_editText);
		
		labelSpinner = (Spinner)findViewById(R.id.label_spinner);
		
		checkrepeatness = (Button)findViewById(R.id.check_repeatness);
		NFCid = (Button)findViewById(R.id.NFC_ID_button);
		uniqueNumB = (Button)findViewById(R.id.unique_number_button);
		entry = (Button)findViewById(R.id.entry_button);
		
		checkrepeatness.setOnClickListener(new checkB_Handler());
		NFCid.setOnClickListener(new NFCid_Handler());
		uniqueNumB.setOnClickListener(new uniqueB_Handler());
		entry.setOnClickListener(new entryB_Handler());
		
		//스피너 코드 부분
		  ArrayAdapter adapter = ArrayAdapter.createFromResource(
		            this, R.array.planets, android.R.layout.simple_spinner_item);
		     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		     labelSpinner.setAdapter(adapter); //
		
		
	}
	private class checkB_Handler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				ID = idText.getText().toString(); //문자열로 아이디 받기
			}catch(Exception ex){
				Toast.makeText(getBaseContext(),"중복 첵트 오류", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	private class NFCid_Handler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				Random random = new Random();
			//	int data=random.nextInt(1000);
				NFCnum = String.valueOf(random.nextInt(1000));//정수를 문자열로 바꿔서 받기
				
				NFCtext = (TextView)findViewById(R.id.NFC_text);
				NFCtext.setText(NFCnum);
				
			}catch(Exception ex){
				Toast.makeText(getBaseContext()," NFC ID 오류", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	private class uniqueB_Handler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				Random random = new Random();
			//	int data=random.nextInt(1000);
				uniqueNum = String.valueOf(random.nextInt(1000));//정수를 문자열로 바꿔서 받기
				
				uniqueNumT = (TextView)findViewById(R.id.unique_text);
				uniqueNumT.setText(uniqueNum);
				
			}catch(Exception ex){
				Toast.makeText(getBaseContext(),"고유번호 오류", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	private class entryB_Handler implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				PW = pwText.getText().toString(); //문자열로 아이디 받기
				String selitem = (String)labelSpinner.getSelectedItem();//가족 직책 스피너에서 받기
			
					
					Toast.makeText(getBaseContext(), ID, Toast.LENGTH_SHORT).show();
					Toast.makeText(getBaseContext(), PW, Toast.LENGTH_SHORT).show();
					Toast.makeText(getBaseContext(),NFCnum, Toast.LENGTH_SHORT).show();
					Toast.makeText(getBaseContext(),uniqueNum, Toast.LENGTH_SHORT).show();
					Toast.makeText(getBaseContext(),selitem, Toast.LENGTH_SHORT).show();
					
					
			}catch(Exception ex){
				Toast.makeText(getBaseContext(), "회원가입 오류", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		       switch(keyCode) {
		        case KeyEvent.KEYCODE_BACK:
		           new AlertDialog.Builder(this)
		                          .setTitle("회원가입 취소")
		                          .setMessage("취소하시겠습니까?")
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
