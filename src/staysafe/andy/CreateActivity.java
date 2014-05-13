package staysafe.andy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.AlertDialog;

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
		File directory = contextWrapper.getDir(filepath, Context.MODE_APPEND);
		myInternalFile = new File(directory, filename);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void addJourney(View v)
	{
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		EditText interval = (EditText) findViewById(R.id.createIntervalEntry);
		
		if(validationCheck())
		{
		saveToStorage();
		Intent createintent = new Intent(this, CountdownActivity.class);
		createintent.putExtra("endlocation",endLocation.getText().toString());
		createintent.putExtra("interval",interval.getText().toString());
		startActivity(createintent);
		}
	}
	
	public void saveJourney(View v)
	{
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		EditText interval = (EditText) findViewById(R.id.createIntervalEntry);
		
		if(validationCheck())
		{
		saveToStorage();
		Intent createintent = new Intent(getApplicationContext(), CountdownActivity.class);
		createintent.putExtra("endlocation",endLocation.getText().toString());
		createintent.putExtra("interval",interval.getText().toString());
		startActivity(createintent);
		}
		else
		{
		}
		
	}
	
	public boolean validationCheck()
	{
		EditText interval = (EditText) findViewById(R.id.createIntervalEntry);
		EditText startLocation = (EditText) findViewById(R.id.createLocationEntry);
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		boolean retval = true;
		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		builder1.setTitle("ERROR");
		String intervalcheck = interval.getText().toString();
		if(intervalcheck.equalsIgnoreCase("")){
			builder1.setMessage("Interval must be 5 or more minutes.");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder1.create();
            alert11.show();
			interval.setText("5");
			retval = false;
		}
		else
		{
		
		if(Double.parseDouble(interval.getText().toString()) < 5.0)
		{
            builder1.setMessage("Interval must be 5 or more minutes.");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder1.create();
            alert11.show();
			retval = false;
			interval.setText("5");
		}
		else
		{
		}
		
		if ("".equals(startLocation.getText().toString().trim()))
		{
			builder1.setMessage("Please enter a valid Start Location.");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder1.create();
            alert11.show();
			retval = false;
		}
		else
		{
		}
		
		if ("".equals(endLocation.getText().toString().trim()))
		{
			builder1.setMessage("Please enter a valid End Location");
            builder1.setCancelable(true);
            builder1.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder1.create();
            alert11.show();
			retval = false;
		}
		else
		{
		}
		}
		
		return retval;
	}
	
	private void saveToStorage()
	{
		EditText interval = (EditText) findViewById(R.id.createIntervalEntry);
		EditText startLocation = (EditText) findViewById(R.id.createLocationEntry);
		EditText endLocation = (EditText) findViewById(R.id.createDestinationEntry);
		Spinner transport = (Spinner) findViewById(R.id.createTransport);
		String selectedtransport = transport.getSelectedItem().toString();
		
		Journey newjourney = new Journey(startLocation.getText().toString() + " to " + endLocation.getText().toString(), startLocation.getText().toString(), endLocation.getText().toString(), Double.parseDouble(interval.getText().toString()));
		
		String entry = startLocation.getText().toString() + " to " + endLocation.getText().toString() + " , " + startLocation.getText().toString() + " , "
				+ endLocation.getText().toString() + " , " + interval.getText().toString() + "\n";
		
		/*try {
			//FileOutputStream fos = openFileOutput("Journey.txt", MODE_PRIVATE | MODE_APPEND);
			//ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//oos.writeObject(newjourney);
			//oos.close();
			
			FileOutputStream fos = new FileOutputStream(myInternalFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.append(entry);
			osw.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Context context = getApplicationContext();
		String text = "Journey saved as " + startLocation.getText().toString() + " to " + endLocation.getText().toString() + " (" + selectedtransport + ")";
		int length = Toast.LENGTH_SHORT;
		
		Toast toast = Toast.makeText(context, text, length);
		toast.show();
	}
	
}
