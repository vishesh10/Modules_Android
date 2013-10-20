package example.datafromservicetoactivity.DataFromServiceToActivity;

import java.util.Date;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BroadcastService  extends Service {
    private static final String TAG = "BroadcastService";
    public static final String BROADCAST_ACTION = "com.websmithing.broadcasttest.displayevent";
//    private final Handler handler = new Handler();
    
    
    Intent intent;
    int counter = 0;
    
    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent(BROADCAST_ACTION);  
    }   
    
    @Override
    public void onStart(Intent intent, int startId) {
        /*handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 1000); // 1 second
   */
        DisplayLoggingInfo();
        
        
    }   
    
/*    public int onStartCommand(Intent intent , int flag , int startid)
    {
    	DisplayLoggingInfo(intent);
    	return START_NOT_STICKY; 
    }
/*
    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();    
            handler.postDelayed(this, 10000); // 10 seconds
        }   
    };  */    
  
    
    private void DisplayLoggingInfo( ) {
        Log.d(TAG, "entered DisplayLoggingInfo");

      //intent.putExtra("time", new Date().toLocaleString());
      //  intent.putExtra("counter", String.valueOf(++counter));
        
    	Log.d(" Inserting: ", " Inserting values ..");
    
        TelephonyManager phoneManager = (TelephonyManager) 
    		    getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
    		String phoneNumber = phoneManager.getLine1Number();
    		Log.d(" Sending Phone number : ", phoneNumber );
    		intent.putExtra("number" , phoneNumber);
        
       
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        //handler.removeCallbacks(sendUpdatesToUI);
        super.onDestroy();
    }
}
