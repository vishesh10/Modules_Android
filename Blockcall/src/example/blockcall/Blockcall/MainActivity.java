package example.blockcall.Blockcall;


import android.net.Uri;
import android.os.Bundle;
import example.blockcall.Blockcall.receive;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.telephony.PhoneStateListener;
import android.widget.Toast;
import android.util.Log;
import android.telephony.TelephonyManager;



public class MainActivity extends Activity {
	
	receive rec = new receive();
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	    tm.listen(mPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
	
	}

	/*public void call(){
	//public class receive {}
	rec.endcall();
		}*/
	
	private final PhoneStateListener mPhoneListener = new PhoneStateListener() {
        public void onCallStateChanged(int state, String incomingNumber) {
            try {
                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                        Toast.makeText(getApplicationContext(), "CALL_STATE_RINGING", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        Intent check=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(check);
                     /*   Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.maindialog);
                        dialog.setTitle("This is my custom dialog box");
                        dialog.setCancelable(true);
                        dialog.show(); */
                        Toast.makeText(getApplicationContext(), "CALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
                        break;
                    case TelephonyManager.CALL_STATE_IDLE:
                        Toast.makeText(getApplicationContext(), "CALL_STATE_IDLE", Toast.LENGTH_SHORT).show();
                        break;//CaptureCall.this
                    default:
                        Toast.makeText(getApplicationContext(), "default", Toast.LENGTH_SHORT).show();
                        Log.i("Default", "Unknown phone state=" + state);
                }
            } catch (Exception e) {
                Log.i("Exception", "PhoneStateListener() e = " + e);
            }
        }
    };
	
	public void call(View view)
	{
		Intent callIntent = new Intent(Intent.ACTION_CALL);
        //   callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        callIntent.setData(Uri.parse("tel:8447056481"));
        startActivity(callIntent);
	}
	public void end(View aview) 
	{	//   Context c = receive.r.getApplicationContext();
		//rec.call(Context context));
		 //broadcastMsg();
		Intent intent = new Intent();
	      intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
	      sendBroadcast(intent);
	
	
	}
	/*
	public void broadcastMsg() {
        final Intent intent = new Intent();
        intent.setAction("borad.cast");
        sendBroadcast(intent);
    }
	*/
	
}
