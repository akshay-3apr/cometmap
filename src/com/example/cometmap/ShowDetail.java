package com.example.cometmap;

import java.io.IOException;
import java.util.List;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

@SuppressLint("NewApi")
public class ShowDetail extends Activity {
	public String location;
	public Double target_latitude;
	public Double target_longitude;
	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_detail);
		// Show the Up button in the action bar.
		Bundle bundle=new Bundle();
		bundle=this.getIntent().getExtras();
		String title=bundle.getString("Title");
		String speaker=bundle.getString("Speaker");
		location=bundle.getString("Location");
		String date=bundle.getString("Date");
		String begintime=bundle.getString("BeginTime");
		String endtime=bundle.getString("EndTime");
		String datetime=date+" "+begintime+" "+endtime;
				
		
		//TextView titleView=(TextView)findViewById(R.id.);
		TextView titleView=(TextView)findViewById(R.id.detail_title);
		TextView speakerView=(TextView)findViewById(R.id.detail_speaker);
		
		TextView locationView=(TextView)findViewById(R.id.detail_location);
		TextView datetimeView=(TextView)findViewById(R.id.detail_datetime);
		titleView.setText(title);
		speakerView.setText(speaker);
		locationView.setText(location);
		datetimeView.setText(datetime);
		
		/*Button show_direction_button = (Button) findViewById(R.id.show_direction_button);
		show_direction_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, TalklistActivity.class);
                startActivity(intent);
			}
			
		});
		
	}*/
		CoordinateDataSource datasource=new CoordinateDataSource(this);
		datasource.open();
		
		List<Coordinates> coordinatesList = datasource.getAllCoordinates();
		/*
		ArrayAdapter<Coordinates> adapter = new ArrayAdapter<Coordinates>(this,android.R.layout.simple_list_item_1, coordinatesList);
		    setListAdapter(adapter);*/
		
		
		for(int i=0;i<coordinatesList.size();i++){
			//System.out.println("For loop: "+location.toLowerCase().indexOf(coordinatesList.get(i).getName())+" "+location.toLowerCase());
			//System.out.println(coordinatesList.size());
			//System.out.println(coordinatesList.get(i).getName().toLowerCase());
			if(location.toLowerCase().indexOf(coordinatesList.get(i).getName().toLowerCase())!=-1){
				target_latitude=coordinatesList.get(i).getLatitude();
				target_longitude=coordinatesList.get(i).getLongitude();
				System.out.println(coordinatesList.get(0).getLatitude());
				System.out.println(target_latitude);
				System.out.println(target_longitude);
				break;	
			}
			
		}
		if(target_latitude==0.0){
				Geocoder gc = new Geocoder(getApplicationContext());

				if(gc.isPresent()){
				  try {
					  
					String destination=location+",Pittsburgh";
					System.out.println(destination);
					List<Address> found_list = gc.getFromLocationName(destination, 1);
					System.out.println("Succeed!");
					Address address = found_list.get(0);
					
					target_latitude=address.getLatitude();
					target_longitude=address.getLongitude();
					
					System.out.println("target_latitude:"+target_latitude);
					System.out.println("target longitude:"+target_longitude);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Cannot find the place.");
					e.printStackTrace();
				}
				  
				}
				else{
					System.out.println("Cannot find the place.");
				}
			
		}
		int x=coordinatesList.get(1).getId();
		System.out.println(x);
		
		datasource.clean();
        datasource.close();
		
		addListenerOnButton();
		setupActionBar();
	}

	private void addListenerOnButton() {
		// TODO Auto-generated method stub
		final Context context = this;
		Button show_direction_button = (Button) findViewById(R.id.show_direction_button);
		show_direction_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, ShowDirection.class);
				
                
                Bundle bundle=new Bundle();
                bundle.putDouble("target_latitude",target_latitude);
                bundle.putDouble("target_longitude",target_longitude);
                bundle.putString("location",location);
                bundle.putString("end", location);
                intent.putExtras(bundle);
				
				
				startActivity(intent);
			}
			
		});
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
		getMenuInflater().inflate(R.menu.show_detail, menu);
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
