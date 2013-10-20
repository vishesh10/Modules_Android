package example.senddatatoservice.SendDataToService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.telephony.TelephonyManager;


//import Flexytab.app.DB.BroadcastService.LocalBinder;

public class SendDataToService extends Activity {

		private Intent intent;
		
		
		
		
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_send_data_to_service);
		
			
			
			/* 
			 * attempt to send multiple strings to service via putStringArrayListExtra function with help of 
			 * ArrayList
			 * 
			 * ArrayList<String> al = new ArrayList<String>();
			String arr[] = {"844705681" , "vishesh" , "22"}; 
			//Convert string array to a collection 
			Collection l = Arrays.asList(arr);
			al.addAll(l);
			   */ 
			
			
		 intent = new Intent(this, BroadcastService.class);
	    //intent.putStringArrayListExtra("check" ,  al);
		 
		 intent.putExtra("phone", "8447056481");
		 intent.putExtra("name", "vishesh");
		 intent.putExtra("age", 22);
		 startService(intent);
		        		   
		
			 //Toast.makeText(getApplicationContext(), "Database", Toast.LENGTH_SHORT).show();
			
			
		}
		
		
	    

	}
