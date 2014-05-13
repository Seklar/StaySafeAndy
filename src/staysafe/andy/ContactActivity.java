package staysafe.andy;

import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends Activity implements OnClickListener {

	EditText nameTxt, phoneTxt, emailTxt, addressTxt;
	List<Contact> Contacts = new ArrayList<Contact>();
	ListView contactListView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fragment_main);

	nameTxt = (EditText) findViewById(R.id.txtName);
	phoneTxt = (EditText) findViewById(R.id.txtPhone);
	emailTxt = (EditText) findViewById(R.id.txtEmail);
	addressTxt = (EditText) findViewById(R.id.txtAddress);
	contactListView = (ListView) findViewById(R.id.contactListview);

	TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

	tabHost.setup();

	TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
	tabSpec.setContent(R.id.tabCreator);
	tabSpec.setIndicator("Creator");
	tabHost.addTab(tabSpec);

	TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("store");
	tabSpec1.setContent(R.id.tabContactList);
	tabSpec1.setIndicator("List");
	tabHost.addTab(tabSpec1);

	final Button addBtn = (Button) findViewById(R.id.btnAdd);

	addBtn.setOnClickListener(new View.OnClickListener() {

	@Override
	public void onClick(View view) {
	addContact(nameTxt.getText().toString(), phoneTxt.getText().toString(), emailTxt.getText().toString(), addressTxt.getText().toString());
	populateList();
	Toast.makeText(getApplicationContext(), nameTxt.getText().toString() + "has been added to contact list!", Toast.LENGTH_SHORT).show();

	}
	});

	nameTxt.addTextChangedListener(new TextWatcher()
	{

	@Override
	public void afterTextChanged(Editable s) {
	// TODO Auto-generated method stub

	}

	public void beforeTextChanged(CharSequence s, int start, int count,
	int after) {
	// TODO Auto-generated method stub

	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public void onTextChanged(CharSequence charSequence, int start, int before,
	int count) {
	// TODO Auto-generated method stub
	addBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());

	}

	});

	}

	private void populateList()
	{
	ArrayAdapter<Contact> adapter = new ContactListAdapter();
	contactListView.setAdapter(adapter);
	}
	private void addContact(String name, String phone, String email, String address)
	{
	Contacts.add(new Contact(name, phone, email,address));
	}

	private class ContactListAdapter extends ArrayAdapter<Contact>
	{
	public ContactListAdapter()
	{
	super (ContactActivity.this, R.layout.listview_item, Contacts);
	}

	public View getView(int position, View view, ViewGroup parent)
	{
	if (view == null)
	view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

	Contact currentContact = Contacts.get(position);

	TextView name = (TextView) view.findViewById(R.id.contactName);
	name.setText(currentContact.getName());
	TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
	name.setText(currentContact.getName());
	TextView email = (TextView) view.findViewById(R.id.emailAddress);
	name.setText(currentContact.getName());
	TextView address = (TextView) view.findViewById(R.id.cAddress);
	name.setText(currentContact.getName());

	return view;
	}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
