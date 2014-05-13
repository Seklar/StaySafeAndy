package staysafe.andy;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SelectAdapter extends BaseAdapter {

	private ArrayList<Journey> journeys = new ArrayList<Journey>();
	
	public void addJourney(Journey journey)
	{
		journeys.add(journey);
	}
	
	public SelectAdapter()
	{
		
	}
	
	@Override
	public int getCount() {
		return journeys.size();
	}

	@Override
	public Object getItem(int position) {
		return getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.journey_list_item, parent, false);
		}
		
		Journey journey = journeys.get(position);
		
		TextView nameTextView = (TextView) view.findViewById(R.id.name_view);
		nameTextView.setText(journey.getName());
		
		return view;
	}

}
