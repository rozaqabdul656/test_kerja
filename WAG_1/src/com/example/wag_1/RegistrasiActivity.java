package com.example.wag_1;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrasiActivity extends Activity {
	
	String[] merk={"Acer","Dell","HTC","HUAWEI"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrasi_registrasi);

		String user=getIntent().getExtras().getString("user");
		String pass=getIntent().getExtras().getString("password");
		TextView username=(TextView) findViewById(R.id.usernameid);
		TextView passwordtext=(TextView) findViewById(R.id.passwordid);
		Spinner spin=(Spinner)findViewById(R.id.spinnerid);
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, merk);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);

		username.setText("User  = " + user);
		passwordtext.setText("Password = " + pass);
		
		
	}
	public void kirim(View x){
		RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);
		 int id = rg.getCheckedRadioButtonId();
		 String val = null;
		 RadioButton rb;
         switch (id){
             case R.id.windowsid :
                 rb= (RadioButton) findViewById(R.id.windowsid);
                 val=(String) rb.getText();
                 break;
             case R.id.linuxid :
                 rb= (RadioButton) findViewById(R.id.linuxid);
                 val=(String) rb.getText();
                 break;
             case R.id.macid :
                 rb= (RadioButton) findViewById(R.id.macid);
                 val=(String) rb.getText();
                 break;
                 
         }
         EditText et=(EditText) findViewById(R.id.editText1);
         
		Spinner spn=(Spinner) findViewById(R.id.spinnerid);
		Toast.makeText(RegistrasiActivity.this,val+(CharSequence) spn.getSelectedItem() +et.getText() ,Toast.LENGTH_LONG).show();
      	
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registrasi, menu);
		return true;
	}

}
