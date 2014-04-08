package staysafe.andy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.*;

public class CreateActivity extends Activity implements OnClickListener{

	private String filename = "Journey.txt";
	private String filepath = "FileStorage";
	File myInternalFile;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.create);
		
		ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
		File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
		myInternalFile = new File(directory, filename);
		
		Button addNewJourney = (Button) findViewById(R.id.createSaveStart);
		addNewJourney.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void addJourney(View v)
	{
		saveToStorage();
		Intent createintent = new Intent(this, CountdownActivity.class);
		startActivity(createintent);
	}
	
	public void saveJourney(View v)
	{
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		EditText duration = (EditText) findViewById(R.id.createDurationEntry);
		EditText interval = (EditText) findViewById(R.id.createIntervalEntry);
		
		saveToStorage();
		Intent createintent = new Intent(getApplicationContext(), CountdownActivity.class);
		createintent.putExtra("endlocation",endLocation.getText().toString());
		createintent.putExtra("duration",duration.getText().toString());
		createintent.putExtra("interval",interval.getText().toString());
		startActivity(createintent);
		
	}
	
	private void saveToStorage()
	{
		EditText startLocation = (EditText) findViewById(R.id.createLocationEntry);
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		Spinner transport = (Spinner) findViewById(R.id.createTransport);
		String selectedtransport = transport.getSelectedItem().toString();
		
		try {
			FileOutputStream fos = new FileOutputStream(myInternalFile);
			fos.write(startLocation.getText().toString().getBytes());
			fos.write(endLocation.getText().toString().getBytes());
			fos.write(transport.getSelectedItem().toString().getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Context context = getApplicationContext();
		String text = "Journey saved as " + startLocation.getText().toString() + " to " + endLocation.getText().toString() + " (" + selectedtransport + ")";
		int duration = Toast.LENGTH_SHORT;
		
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
}
