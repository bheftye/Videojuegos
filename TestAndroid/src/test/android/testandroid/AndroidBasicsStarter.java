package test.android.testandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class AndroidBasicsStarter extends ListActivity {
String tests[] = {"LifeCycle", "Touch"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
		// Show the Up button in the action bar.
	}
	
	protected void onListItemClick(ListView list, View view, int position, long id){
		super.onListItemClick(list, view, position, id);
		String testName = tests[position];
		try{
			Class clazz = Class.forName("test.android.testandroid"+testName);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
