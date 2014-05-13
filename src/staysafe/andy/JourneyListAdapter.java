package staysafe.andy;

import java.io.File;
import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class JourneyListAdapter extends BaseAdapter {
	
	private ArrayList<Journey> jlisting = new ArrayList<Journey>();
	
	private static final String FILENAME = "Journey.txt";
	
	private File myInternalFile; 
	
	public JourneyListAdapter()
	{		

	}
	
	public void addNewJourney(String name, String startloc, String destination, double interval)
	{
		jlisting.add(new Journey(name,startloc,destination, interval));
	}
	
	public View getView(int position, View view, ViewGroup parent)
	{
		if(view == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.journey_list_item, parent, false);
		}
		
		Journey journey = jlisting.get(position);
		
		TextView nameTextView = (TextView) view.findViewById(R.id.name_view);
		nameTextView.setText(journey.getName());
		
		TextView nameTextView1 = (TextView) view.findViewById(R.id.duration_view);
		nameTextView1.setText("Interval : " + journey.getIntervalString() + " Minutes");
		
		return view;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jlisting.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public void addNewJourney(Journey newjourney) {
		jlisting.add(newjourney);
	}
}
