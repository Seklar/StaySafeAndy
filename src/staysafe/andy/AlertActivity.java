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

    }

	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.btn_danger:
			if (mp.isPlaying()) {
				 vib.cancel();
				 mp.stop();
	                mp.prepareAsync();
	                mp.seekTo(0);
				 
				Intent menuintent = new Intent(this, MenuActivity.class);
				startActivity(menuintent);
				Toast.makeText(getApplicationContext(), "Danger", Toast.LENGTH_SHORT).show();
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
				Intent menuintent = new Intent(this, MenuActivity.class);
				startActivity(menuintent);
			  }
			 else {
					Toast.makeText(getApplicationContext(), "Nothing is playing", Toast.LENGTH_SHORT).show();
					  }
			break;
		}
		

	
	}
	




	
}
