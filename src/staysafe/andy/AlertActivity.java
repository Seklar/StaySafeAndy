package staysafe.andy;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends Activity implements OnClickListener {
    public MediaPlayer mp;
    Vibrator vib;
    WakeLock wL , fL;

    PowerManager pm;
    CountDownTimer waitTimer;
    
    public void sendSMS(){
    	String phnumber;
    	String message;
    	phnumber = "0497606270";
    	message = "Yo Broseppi";
    	
		Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_SHORT).show();
		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage(phnumber, null , message , null, null);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);

        Button btn_safe = (Button)this.findViewById(R.id.btn_safe);
    	Button btn_danger = (Button)this.findViewById(R.id.btn_danger);

    	mp = MediaPlayer.create(this, R.raw.soundfile);
    	vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    	btn_safe.setOnClickListener(this);
    	btn_danger.setOnClickListener(this);
    	
    	//allowing the app to run in the background
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wL = pm.newWakeLock(pm.PARTIAL_WAKE_LOCK, "My Tag");
		fL = pm.newWakeLock((pm.SCREEN_BRIGHT_WAKE_LOCK | pm.FULL_WAKE_LOCK | pm.ACQUIRE_CAUSES_WAKEUP), "My Tag");
		wL.acquire();
		wakeDevice();
		
		//setting the pattern and telling it to start
		long[] pattern = {100, 200, 400};
		// starting vibration and music player
		vib.vibrate(pattern, 0);
		mp.start();  

		
	   waitTimer = new CountDownTimer(120000, 1000){
		public void onFinish()
		{
			
			sendSMS();
		}
		@Override
		public void onTick(long arg0) {
	
			
		}
				
	}.start();
    }
    
    public void wakeDevice() {
        fL.acquire();
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("TAG");
        keyguardLock.disableKeyguard();
    }
    
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.btn_danger:
			if (mp.isPlaying()) {
				Toast.makeText(getApplicationContext(), "Danger", Toast.LENGTH_SHORT).show();
				
				vib.cancel();
				mp.stop();
	            mp.prepareAsync();
	            mp.seekTo(0);
				wL.release();
				waitTimer.cancel();
				sendSMS();	
				
				Intent createintent = new Intent(this, MenuActivity.class);
				startActivity(createintent);
			  }
			 else {
					Toast.makeText(getApplicationContext(), "Nothing is playing", Toast.LENGTH_SHORT).show();
					  }
			break;
			
		case R.id.btn_safe:
			if (mp.isPlaying()) {
				
				vib.cancel();
				mp.stop();
	            mp.prepareAsync();
	            mp.seekTo(0);    
	            wL.release();
				waitTimer.cancel();
					
				Intent createintent = new Intent(this, MenuActivity.class);
				startActivity(createintent);
			  }
			 else {
					Toast.makeText(getApplicationContext(), "Nothing is playing", Toast.LENGTH_SHORT).show();
					  }
			break;
		}
		

	
	}
	




	
}
