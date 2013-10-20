package com.example.cometmap;

import java.util.ArrayList;

import rss.RssParser;
import rss.Talk;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class AdSearch extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad_search);
		//Toast.makeText(this, "Button1 clicked.", Toast.LENGTH_SHORT).show(); 
		// Show the Up button in the action bar.
		setupActionBar();
//		
		
		
//		Intent intent = getIntent();
//		String year=intent.getStringExtra("mYear");
//		
//		TextView tv = (TextView)findViewById(R.id.tv1);
//		tv.setText(year);
		
		
		Intent intent = getIntent();
		
//		ArrayList <String> date = new ArrayList<String>();
//    	ArrayList <String> time = new ArrayList<String>();
//		
//		date = intent.getStringArrayListExtra("date");
//		time = intent.getStringArrayListExtra("time");
//		
//		
//		String year = date.get(0);
//		String month = date.get(1);
//		String day = date.get(2);
//		String hour = time.get(0);
//		String minute = time.get(1);
		
		ArrayList <Integer> date = new ArrayList<Integer>();
    	ArrayList <Integer> time = new ArrayList<Integer>();

    	String place;
		
		date = intent.getIntegerArrayListExtra("date");
		time = intent.getIntegerArrayListExtra("time");
		place = intent.getStringExtra("place");
		
		
		Integer year = date.get(0);
		Integer month = date.get(1)+1;
		Integer day = date.get(2);
		Integer hour = time.get(0);
		Integer minute = time.get(1);
		String desired_start;
		
		/*if(hour>12){
			hour=hour-12;
			desired_start=hour.toString()+":00 PM";
		}
		else{
			desired_start=hour.toString()+":00 AM";
		}*/
		
		final ArrayList<Talk> searchResults=GetSearchResults(year,month,day);
		final ArrayList<Talk> filterResults=new ArrayList<Talk>();
		if(searchResults==null){
			System.out.println("searchResults is null.");
			Toast.makeText(this, "Button1 clicked.", Toast.LENGTH_SHORT).show(); 
		}
		else{
			System.out.println("searchResults is not null.");
		}
		String startTime;
		String[] latter=new String[2];
		String[] former=new String[2];
		int time_int=0;
		for(int i=0;i<searchResults.size();i++){
			startTime=searchResults.get(i).getBeginTime();
			latter=startTime.split(" ");
			System.out.println("latter:"+latter[1]);
			former=latter[0].split(":");
			System.out.println("former:"+former[0]);
			time_int=Integer.parseInt(former[0]);
			if((latter[1].equals("PM"))&&(time_int!=12)){
				time_int=time_int+12;
				System.out.println(time_int);
			}
			System.out.println("hour:"+hour);
			if(hour<time_int){
				
				System.out.println("time_int:"+time_int);
				Talk talk=searchResults.get(i);
				filterResults.add(talk);
			}
		}
		
		
		System.out.println("filter result size:"+filterResults.size());
		
		final ListView listView = (ListView) findViewById(android.R.id.list);
		System.out.println("afterlistview");
		
		listView.setAdapter(new MyCustomBaseAdapter(this,filterResults));
		System.out.println("set");
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), ShowDetail.class);
                
                Bundle bundle=new Bundle();
               bundle.putString("Title",filterResults.get((int) id).getTitle() );
               bundle.putString("Speaker",filterResults.get((int) id).getSpeaker() );
               bundle.putString("Location", filterResults.get((int) id).getPlace());
               bundle.putString("Date", filterResults.get((int) id).getDate());
               bundle.putString("BeginTime", filterResults.get((int) id).getBeginTime());
               bundle.putString("EndTime",filterResults.get((int) id).getEndTime());
                intent.putExtras(bundle);
                startActivity(intent);
				/*Object o = listView.getItemAtPosition(position);
                Talk fullObject = (Talk)o;
                Toast.makeText(TalklistActivity.this, "You have chosen: " + " " + fullObject.getDate(), Toast.LENGTH_LONG).show();
               */
			}
		});
		
		
		
		
		
		
	}
	
	private ArrayList<Talk> GetSearchResults(int year, int month, int day) {
		ArrayList<Talk> results=new ArrayList<Talk>();
		RssParser parser=new RssParser();
		
		String feed_url="http://halley.exp.sis.pitt.edu/comet/utils/loadTalkXML.jsp?year="+year+"&month="+month+"&day="+day;
		results=parser.parseRss(feed_url);
		
		if(results==null){
			System.out.println("results is null");
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
		getMenuInflater().inflate(R.menu.ad_search, menu);
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
