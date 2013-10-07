package flexytab.app.Call;

import android.widget.TextView;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;
//import android.util.Log;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import android.app.Dialog;




public class MainActivity extends Activity {
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.edittext1);

        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        tm.listen(mPhoneListener, PhoneStateListener.LISTEN_CALL_STATE);



    }
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

    public void call(View view) {
        //Toast.makeText(MainActivity.this,text.getText().toString(),Toast.LENGTH_LONG).show();
        //try {
/*        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.main);
        dialog.setTitle("This is my custom dialog box");
        dialog.setCancelable(true);
        dialog.show();
*/
        //Uri number = Uri.parse("tel:"+text.getText().toString());


        Intent callIntent = new Intent(Intent.ACTION_CALL);
        //   callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        callIntent.setData(Uri.parse("tel:"+text.getText().toString()));
        startActivity(callIntent);
        //  Uri number = Uri.parse("tel:"+text.getText().toString());
        //Intent dial = new Intent(Intent.ACTION_CALL_BUTTON, number);
        //startActivity(dial);





        //}

        // catch (ActivityNotFoundException activityException) {
        // Log.e("helloandroid dialing example", "Call failed", e);
        //}
    }
    	public void end_call(View aview)
    	{
    		Intent intent = new Intent();
  	      intent.setAction("com.end.end_call");
  	      sendBroadcast(intent);
    	}

}