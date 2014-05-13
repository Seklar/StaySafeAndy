package staysafe.andy;

import java.util.concurrent.TimeUnit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class CountdownActivity extends Activity implements OnClickListener {

	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.countdown);

		Intent intent = getIntent();
		String location = intent.getStringExtra("endlocation");
		String interval = intent.getStringExtra("interval");
		
		final TextView mTextView = (TextView)this.findViewById(R.id.countdownDuration);
		
		final TextView mTextView2 = (TextView)this.findViewById(R.id.defaultDestination);
		mTextView2.setText(location);
		
		new CountDownTimer((Long.valueOf(interval)*60000), 1000){
			
			public void onTick(long millisUntilFinished)
			{
				String t = getDurationBreakdown(millisUntilFinished);
				mTextView.setText(t + " Minutes");
			}
			
			public void onFinish()
			{
				mTextView.setText("ARRIVED");
			}
			
			
		}.start();
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static String getDurationBreakdown(long millis)
    {
        if(millis < 0)
        {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(hours);
        sb.append(":");
        sb.append(minutes);
        sb.append(":");
        sb.append(seconds);
        sb.append("");

        return(sb.toString());
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
