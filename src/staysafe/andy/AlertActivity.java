package staysafe.andy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends Activity implements OnClickListener {
    public MediaPlayer mp;
    Vibrator vib;
       
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);

        Button btn_safe = (Button)this.findViewById(R.id.btn_safe);
    	Button btn_danger = (Button)this.findViewById(R.id.btn_danger);

    	mp = MediaPlayer.create(this, R.raw.soundfile);
    	vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		
    	btn_safe.setOnClickListener(this);
    	btn_danger.setOnClickListener(this);
    	
    	

		//setting the pattern and telling it to start
		long[] pattern = {100, 200, 400};
		// starting vibration and music player
		vib.vibrate(pattern, 0);
		mp.start();  

    new CountDownTimer(120000, 1000){
				
		public void onFinish()
		{
			Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_SHORT).show();
			SmsManager smsManager = SmsManager.getDefault();
			//Change this stuff to links to saved file
			smsManager.sendTextMessage("0497606270", null, "yo", null, null);
		}

		@Override
		public void onTick(long arg0) {
	
			
		}
				
	}.start();
    }

	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.btn_danger:
			if (mp.isPlaying()) {
				 vib.cancel();
				 mp.stop();
	                mp.prepareAsync();
	                mp.seekTo(0);
				Toast.makeText(getApplicationContext(), "Danger", Toast.LENGTH_SHORT).show();	
				
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
