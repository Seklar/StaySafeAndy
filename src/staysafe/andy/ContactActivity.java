package staysafe.andy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ContactActivity extends Activity implements OnClickListener {

	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.contact);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void Addnew(View v){
		
	}

	
	public class Contact {

		private String  _name, _phone;

		public Contact(String name, String phone)
		{
		_name = name;
		_phone = phone;
		}

		public String getName()
		{
		return _name;
		}
		public String getPhone()
		{
		return _phone;
		}
	}
}
