package example.blockcall.Blockcall;

import java.lang.reflect.Method;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.android.internal.telephony.ITelephony;
import android.widget.RelativeLayout;
import android.view.View;


public class receive extends BroadcastReceiver {
		static receive r;
	//Context context ;
		//final RelativeLayout mDateTimeDialogView = (RelativeLayout)getLayoutInflater().inflate(R.layout.date_time_dialog, null);
//	TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	
//	ITelephony telephonyService;

	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		//this.context=context;
		/*Bundle bundle = intent.getExtras();
		if(null == bundle)
			return;
*/
		
		 if(intent.getAction().equals("com.test.CUSTOM_INTENT")){
		    Toast.makeText(context, "sample", Toast.LENGTH_LONG).show();
		 		 
		
		String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
		String info = "Detect Calls sample application\nOutgoing number: " + phonenumber;
		//call(context);
	//}
	//public void call(Context context)
	//{
		
		
		//Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
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

//}
	

