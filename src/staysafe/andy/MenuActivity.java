package staysafe.andy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener {

	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.menu);
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
			
		case R.id.btn_addjourney:
			Intent createintent = new Intent(this, CreateActivity.class);
			startActivity(createintent);
			break;
			
		/*case R.id.selectButton:
			Intent selectintent = new Intent(this, SelectActivity.class);
			startActivity(selectintent);
			
		case R.id.contactButton:
			Intent contactintent = new Intent(this, ContactActivity.class);
			startActivity(contactintent);
			
		case R.id.alertButton:
			Intent alertintent = new Intent(this, AlertActivity.class);
			startActivity(alertintent);
			
		case R.id.aboutButton:
			Intent alertintent = new Intent(this, AlertActivity.class);
			startActivity(alertintent);
			*/
		}
	}
	
	public void CreatePage(View v)
	{
		Intent createintent = new Intent(this, CreateActivity.class);
		startActivity(createintent);
	}
	public void AlarmClick(View v)
	{
		Intent createintent = new Intent(this, AlertActivity.class);
		startActivity(createintent);
	}
	
	public void ContactPage(View v)
	{
		Intent createintent = new Intent(this, ContactActivity.class);
		startActivity(createintent);
	}
	
	public void AboutPage(View v)
	{
		Intent createintent = new Intent(this, AboutActivity.class);
		startActivity(createintent);
	}
	
	
	//Silent Message on Volume Down long press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) 
        {
         event.startTracking();
         return true;
        }
     return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
 
       return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) 
        {
        	 Toast.makeText(this, "Silent Message sent!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }
	
}
