package com.example.cometmap;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import rss.RssParser;

import rss.Talk;

import android.os.Bundle;

import android.app.Activity;
import android.app.ListActivity;

//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.ViewGroup.LayoutParams;

public class TalklistActivity extends Activity{
	//private static final String TAG = "MyActivity";
	String[] months = {"January", "February",
			  "March", "April", "May", "June", "July",
			  "August", "September", "October", "November",
			  "December"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talklist);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
		
		//RssParser parser=new RssParser();
		//String feed_url="http://halley.exp.sis.pitt.edu/comet/utils/loadTalkXML.jsp?year=2013&month=4&week=4";
		//ArrayList<Talk> talks=new ArrayList<Talk>();
		//talks=parser.parseRss(feed_url);
		//System.out.println(talks.size());
		LinearLayout talklist_layout=(LinearLayout) findViewById(R.id.talklist_layout);
		LinearLayout inner_talklist_layout=new LinearLayout(this);
		inner_talklist_layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		inner_talklist_layout.setOrientation(LinearLayout.VERTICAL);
		
		final ArrayList<Talk> searchResults=GetSearchResults();
		if(searchResults==null){
			System.out.println("searchResults is null.");
			Toast.makeText(this, "Button1 clicked.", Toast.LENGTH_SHORT).show(); 
		}
		else{
			System.out.println("searchResults is not null.");
		}
		final ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(new MyCustomBaseAdapter(this,searchResults));
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), ShowDetail.class);
                
                Bundle bundle=new Bundle();
               bundle.putString("Title",searchResults.get((int) id).getTitle() );
               bundle.putString("Speaker",searchResults.get((int) id).getSpeaker() );
               bundle.putString("Location", searchResults.get((int) id).getPlace());
               bundle.putString("Date", searchResults.get((int) id).getDate());
               bundle.putString("BeginTime", searchResults.get((int) id).getBeginTime());
               bundle.putString("EndTime",searchResults.get((int) id).getEndTime());
                intent.putExtras(bundle);
                startActivity(intent);
				/*Object o = listView.getItemAtPosition(position);
                Talk fullObject = (Talk)o;
                Toast.makeText(TalklistActivity.this, "You have chosen: " + " " + fullObject.getDate(), Toast.LENGTH_LONG).show();
               */
			}
		});
		//listView.setTextFilterEnabled(true);
		
		//final StableArrayAdapter adapter=new StableArrayAdapter(this,android.R.layout.simple_list_item_1,title_list);
		//talklist_layout.addView(inner_talklist_layout);
		//talk_listview.setAdapter(adapter);
		
	}
	/*private class StableArrayAdapter extends ArrayAdapter<String>{
		public StableArrayAdapter (Context context, int textViewResourceId, List<String> objects){
			super(context,textViewResourceId,objects);
		}
	}*/

	private ArrayList<Talk> GetSearchResults() {
		// TODO Auto-generated method stub
		
		ArrayList<Talk> results=new ArrayList<Talk>();
		RssParser parser=new RssParser();
		
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DAY_OF_MONTH);
		
		String feed_url="http://halley.exp.sis.pitt.edu/comet/utils/loadTalkXML.jsp?year="+year+"&month="+month+"&day="+day;
		
		results=parser.parseRss(feed_url);
		
		//ArrayList<String> title_list=new ArrayList<String>();
		//final ArrayList<String> 
		/** for(int i=0;i<5;i++){
			TextView text1=new TextView(this);
			TextView text2=new TextView(this);
			text1.setText(talks.get(i).getDate());
			text2.setText(talks.get(i).getTitle());
			inner_talklist_layout.addView(text1);
			inner_talklist_layout.addView(text2);
			inner_talklist_layout.setBaselineAligned(true);
			inner_talklist_layout.setBackgroundColor(color.light_gray);
			
			Talk talk=new Talk();
			
			title_list.add(results.get(i).getTitle());
			System.out.println(title_list.get(i));
			talk.setTitle(results.get(i).getTitle());
		    talk.setSpeaker(results.get(i).getTitle());
		    talk.setAffiliation(results.get(i).get);
			
			
		}*/
		if(results==null){
			System.out.println("results is null");
			Toast.makeText(this, "No talk to show", Toast.LENGTH_SHORT).show(); 
		}
		else{
			System.out.println("results is not null");
		}
		return results;
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.talklist, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

