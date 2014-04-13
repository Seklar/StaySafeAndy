package staysafe.andy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends Activity implements OnClickListener {
	

	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);
                
   	Button btn_safe = (Button)this.findViewById(R.id.btn_safe);
    	Button btn_vib = (Button)this.findViewById(R.id.btn_vib);

    	btn_safe.setOnClickListener(this);
    	btn_vib.setOnClickListener(this);

    	   

    }


	public void onClick(View v) {
		

		/*
		switch(v.getId()){
		case R.id.btn_vib:

			break;

		case R.id.btn_safe:

			//please for god sake stop	
			  if (mp.isPlaying()) {
				  Toast.makeText(getApplicationContext(), "yep", Toast.LENGTH_SHORT).show();
					
			    }
			   
	            
			//cancel the vibrator
			vib.cancel();
			Toast.makeText(getApplicationContext(), "Should stop now", Toast.LENGTH_SHORT).show();
			
			//Intent myIntent = new Intent(this, MenuActivity.class);
            //startActivityForResult(myIntent, 0); 
           
			break;
		

			}*/
		
		}

	public void startAlarm(View v)
	{
		Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    MediaPlayer mp = MediaPlayer.create(AlertActivity.this, R.raw.soundfile);
		Toast.makeText(getApplicationContext(), "Starting Now", Toast.LENGTH_SHORT).show();
		//setting the pattern and telling it to start
		long[] pattern = {100, 200, 400};
		vib.vibrate(pattern, 0);
		mp.start();  

	}
	
	public void safeClick(View v)
	{
		Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    MediaPlayer mp = MediaPlayer.create(AlertActivity.this, R.raw.soundfile);
		//please for god sake stop	
		  if (mp.isPlaying()) {
			  Toast.makeText(getApplicationContext(), "yep", Toast.LENGTH_SHORT).show();
		  }
		   
          mp.pause();
		//cancel the vibrator
		vib.cancel();

	}
	
	
	
	public void onClick1(View arg0) {
        setResult(RESULT_OK);
        finish();
	}



	
}
