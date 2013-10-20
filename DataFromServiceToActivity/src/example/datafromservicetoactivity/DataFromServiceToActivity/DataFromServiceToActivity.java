package example.datafromservicetoactivity.DataFromServiceToActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;


//import Flexytab.app.DB.BroadcastService.LocalBinder;


public class DataFromServiceToActivity extends Activity {


		int s_no;
		//MyReceiver myReceiver;
		private Intent intent;
		
		BroadcastService mServer;
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_data_from_service_to);
			
			
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
		 startService(intent);
		 registerReceiver(broadcastReceiver, new IntentFilter(BroadcastService.BROADCAST_ACTION));
			 	        
		
		        
		        		   
			 //Toast.makeText(getApplicationContext(), "Database", Toast.LENGTH_SHORT).show();
		}
		
		
	/*
	 * broadcast receiver for getting data from service
	 */
		
		private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) {
	        	updateUI(intent);       
	        }
	    };
		
	/*
	* function that is called in broadcast receiver
	*/
	    
	    private void updateUI(Intent intent) {
	    	String number = intent.getStringExtra("number"); 
	    	
	    	Log.d( " Received number  " , number);
	   // 	Log.d( , time);
	    	
	    	unregisterReceiver(broadcastReceiver);
	    	
	    	
	    }  
}
