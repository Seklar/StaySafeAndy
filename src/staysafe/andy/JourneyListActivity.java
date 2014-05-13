package staysafe.andy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class JourneyListActivity extends Activity implements OnClickListener {
	
	JourneyListAdapter journeyListAdapter = new JourneyListAdapter();
	
	private String filename = "Journey.txt";
	private String filepath = "FileStorage";
	File myInternalFile;
	
	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.select);
		
		ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
		File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
		myInternalFile = new File(directory, filename);
		
		ListView listView = (ListView) findViewById(R.id.selectjourneylist);
		listView.setAdapter(journeyListAdapter);
		readFromFile();
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void readFromFile()
	{
		try {
				FileInputStream fis = openFileInput("Journey.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
			    boolean check=true;
			    while (check) 
			    {
			    	try {
			    		Object object = ois.readObject();
			    		journeyListAdapter.addNewJourney((Journey) object);
			    		Log.e("LOOP","LOOPING");
			    		}	
			    	catch(EOFException ex)
			    		{
			    		check=false;
			    		}
			    }
			    ois.close();
			} catch(Exception e) {
			    e.printStackTrace();
			}
			{
				
			}
		}
	}

