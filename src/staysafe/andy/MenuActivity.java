package staysafe.andy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MenuActivity extends Activity implements OnClickListener {

	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.menu);
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		
		case R.id.createButton:
			Intent createintent = new Intent(this, CreateActivity.class);
			startActivity(createintent);
			
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
	
	public void ContactPage(View v)
	{
		Intent createintent = new Intent(this, ContactActivity.class);
		startActivity(createintent);
	}

}
