package com.example.wag_1;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	JSONParser jsonparser =new JSONParser();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void login(View x) {
    	EditText etcode = (EditText) findViewById(R.id.editText1);
    	EditText etcode2 = (EditText) findViewById(R.id.editText2);
    	String username = etcode.getText().toString();
    	String pasword = etcode2.getText().toString();
    		String s="";
    		HttpClient httpClient =new DefaultHttpClient();
			HttpPost httpPost=new HttpPost("http://127.0.0.1:8000/api/login");
			List <NameValuePair> list=new ArrayList <NameValuePair>();
			list.add(new BasicNameValuePair("email",username));
			list.add(new BasicNameValuePair("password",pasword));
			JSONObject json=jParser.makeHttpRequest(httpPost,"POST",list);
			Log.d("Response : ",json.toString());
//			Toast.makeText(MainActivity.this,json.toString(),Toast.LENGTH_LONG).show();
	      	if(json.toString() == "succes"){
	      		Intent Form_register=new Intent(MainActivity.this,RegistrasiActivity.class);
	      		Bundle bd = new Bundle();
	    		bd.putString("user", username);
	    		bd.putString("password", pasword);
	    		
	      		Form_register.putExtras(bd);
	    		startActivity(Form_register);
	    		
	      	}else{
	      		Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_LONG).show();
		      	
	      	}
			
    		
    	
    		   
    }
    
      
}
