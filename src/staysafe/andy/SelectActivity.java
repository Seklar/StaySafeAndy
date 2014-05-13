package staysafe.andy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class SelectActivity extends Activity implements OnClickListener {

	SelectAdapter selectAdapter;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.select);
		
		ListView listView = (ListView)
				findViewById(R.id.selectjourneylist);
				selectAdapter = new SelectAdapter();
				listView.setAdapter(selectAdapter);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
