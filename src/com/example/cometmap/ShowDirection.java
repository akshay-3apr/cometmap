package com.example.cometmap;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class ShowDirection extends FragmentActivity implements LocationListener{

	GoogleMap mMap;
    GMapV2Direction md;
    LatLng dest;
    LatLng current;
    String end;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_direction);
		
		Bundle bundle=new Bundle();
		bundle=this.getIntent().getExtras();
		Double lng=bundle.getDouble("target_longitude");
		Double lat=bundle.getDouble("target_latitude");
		end = bundle.getString("end");
		if(end==null)
			end="destination";

		//System.out.println("lat:"+lat);
		//System.out.println("lng:"+lng);
		dest = new LatLng(lat, lng);
		md = new GMapV2Direction();
		mMap = ((SupportMapFragment)getSupportFragmentManager()
							.findFragmentById(R.id.map)).getMap();
		mMap.setMyLocationEnabled(true);
		
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
	    Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);
		current=new LatLng(location.getLatitude(), location.getLongitude());
		
		// Enabling MyLocation Layer of Google Map
		mMap.setMyLocationEnabled(true);	
				

		if(location!=null){
		   onLocationChanged(location);
		}

		        locationManager.requestLocationUpdates(provider, 20000, 0, this);
		        
		        mMap.addMarker(new MarkerOptions().position(current).title("Start").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
				mMap.addMarker(new MarkerOptions().position(dest).title(end).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))).showInfoWindow();
		       //
				GMapV2Direction dr = new GMapV2Direction();
				Document doc = md.getDocument(current, dest, GMapV2Direction.MODE_WALKING);
				int duration = md.getDurationValue(doc);
				String distance = md.getDistanceText(doc);
				String start_address = md.getStartAddress(doc);
				String copy_right = md.getCopyRights(doc);

				ArrayList<LatLng> directionPoint = md.getDirection(doc);
				PolylineOptions rectLine = new PolylineOptions().width(6).color(Color.rgb(26, 92, 100));
				
				for(int i = 0 ; i < directionPoint.size() ; i++) {			
					rectLine.add(directionPoint.get(i));
				}
				
				mMap.addPolyline(rectLine);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_direction, menu);	
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
    double latitude = location.getLatitude();
		
		// Getting longitude of the current location
		double longitude = location.getLongitude();		
		
		// Creating a LatLng object for the current location
		current = new LatLng(latitude, longitude);
		
		// Showing the current location in Google Map
		mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
		
		// Zoom in the Google Map
		mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}


}
