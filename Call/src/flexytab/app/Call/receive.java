package flexytab.app.Call;

import com.android.internal.telephony.ITelephony;

import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;
import android.util.Log;

import java.lang.reflect.Method; 


public class receive extends BroadcastReceiver {



	@Override
	public void onReceive(Context context, Intent intent)
		{
		
	 if(intent.getAction().equals("com.end.end_call")){
	    Toast.makeText(context, "sample", Toast.LENGTH_LONG).show();
	 		 
	
	String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	String info = "Detect Calls sample application\nOutgoing number: " + phonenumber;
	//call(context);
	TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	
		try {
		
					Class c = Class.forName(tm.getClass().getName());
					Method m = c.getDeclaredMethod("getITelephony");
					m.setAccessible(true);

					com.android.internal.telephony.ITelephony telephonyService = (ITelephony) m.invoke(tm);
					telephonyService.endCall();

			} 
		catch (Exception e) 
			{
				System.out.println("error on end call : "+e.getMessage());

				e.printStackTrace();

			}

	}
}

}

