package com.example.cometmap;

import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SearchnearbyActivity extends FragmentActivity implements LocationListener{

	GoogleMap gMap;
	LatLng current;
	double lat;
	double lng;
	LatLng marker;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchnearby);
		// Show the Up button in the action bar.
		setupActionBar();
		//chao 
		gMap = ((SupportMapFragment)getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		gMap.setMyLocationEnabled(true);

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);
		lat=location.getLatitude();
		lng=location.getLongitude();
		current=new LatLng(lat, lng);
		
		CoordinateDataSource datasource=new CoordinateDataSource(this);
		datasource.open();
		
		List<Coordinates> coordinatesList = datasource.getAllCoordinates();
		final List<Coordinates> nearCoordinates = new ArrayList<Coordinates>();
        List<LatLng> addOneMarker = new ArrayList<LatLng>();
        List<String> name = new ArrayList<String>();
        final List<Marker> markers = new ArrayList<Marker>();
		double near_latitude, near_longitude;
		for(int i=0;i<coordinatesList.size();i++){
			near_latitude=coordinatesList.get(i).getLatitude();
			near_longitude=coordinatesList.get(i).getLongitude();
			marker = new LatLng(near_latitude+0.01, near_longitude+0.01);
			if((Math.abs(near_latitude-lat)<0.01)&&(Math.abs(near_longitude-lng)<0.001)){
				nearCoordinates.add(coordinatesList.get(i));
				addOneMarker.add(new LatLng(near_latitude, near_longitude));
				if(nearCoordinates.size()>=5)
					break;
			}
		}
		
		int size = nearCoordinates.size();
		final Marker m0 = gMap.addMarker(new MarkerOptions().position(new LatLng(
				nearCoordinates.get(0).getLatitude(), nearCoordinates.get(0).getLongitude())
		).title(nearCoordinates.get(0).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
		
		gMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker m0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ShowDirection.class);
				double latt = m0.getPosition().latitude;
				double lngg = m0.getPosition().longitude;
				String end = m0.getTitle();
				intent.putExtra("end", end);
				System.out.println("this is the first spot"+end);
				intent.putExtra("target_latitude", latt);
				intent.putExtra("target_longitude", lngg);
				System.out.println("lat: "+lat);
				System.out.println("lng: "+lng);
				startActivity(intent);
			}
			
		});
		
		final Marker m1 = gMap.addMarker(new MarkerOptions().position(new LatLng(
				nearCoordinates.get(1).getLatitude(), nearCoordinates.get(1).getLongitude())
		).title(nearCoordinates.get(1).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
		
		gMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker m1) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ShowDirection.class);
				double latt = m1.getPosition().latitude;
				double lngg = m1.getPosition().longitude;
				intent.putExtra("target_latitude", latt);
				intent.putExtra("target_longitude", lngg);
				String end = m1.getTitle();
				intent.putExtra("end", end);
				System.out.println("this is the second spot"+end);
				System.out.println("lat: "+lat);
				System.out.println("lng: "+lng);
				startActivity(intent);
			}
			
		});
		
		final Marker m2 = gMap.addMarker(new MarkerOptions().position(new LatLng(
				nearCoordinates.get(2).getLatitude(), nearCoordinates.get(2).getLongitude())
		
				).title(nearCoordinates.get(2).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
		
		gMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker m2) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ShowDirection.class);
				double latt = m2.getPosition().latitude;
				double lngg = m2.getPosition().longitude;
				intent.putExtra("target_latitude", latt);
				intent.putExtra("target_longitude", lngg);
				String end = m2.getTitle();
				intent.putExtra("end", end);
				System.out.println("this is the third spot"+end);
				System.out.println("lat: "+lat);
				System.out.println("lng: "+lng);
				startActivity(intent);
			}
			
		});
		
		final Marker m3 = gMap.addMarker(new MarkerOptions().position(new LatLng(
				nearCoordinates.get(3).getLatitude(), nearCoordinates.get(3).getLongitude())
		        ).title(nearCoordinates.get(3).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
		
		gMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker m3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ShowDirection.class);
				double latt = m3.getPosition().latitude;
				double lngg = m3.getPosition().longitude;
				intent.putExtra("target_latitude", latt);
				intent.putExtra("target_longitude", lngg);
				String end = m3.getTitle();
				intent.putExtra("end", end);
				System.out.println("this is the forth spot"+end);
				System.out.println("lat: "+lat);
				System.out.println("lng: "+lng);
				startActivity(intent);
			}
			
		});
		
		final Marker m4 = gMap.addMarker(new MarkerOptions().position(new LatLng(
				nearCoordinates.get(4).getLatitude(), nearCoordinates.get(4).getLongitude())
		).title(nearCoordinates.get(4).getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
		//gMap.addMarker(new MarkerOptions().i
		gMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){

			@Override
			public void onInfoWindowClick(Marker m4) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ShowDirection.class);
				double latt = m4.getPosition().latitude;
				double lngg = m4.getPosition().longitude;
				intent.putExtra("target_latitude", latt);
				intent.putExtra("target_longitude", lngg);
				String end = m4.getTitle();
				intent.putExtra("end", end);
				System.out.println("this is the fifth spot"+end);
				System.out.println("lat: "+lat);
				System.out.println("lng: "+lng);
				startActivity(intent);
			}
			
		});
		
		if(nearCoordinates.size()>0){
			for(int x=0;x<nearCoordinates.size();x++){
				System.out.println("nearCoordinate name:"+nearCoordinates.get(x).getName());
			}
		}
		datasource.clean();
		datasource.close();
		
		
		// Enabling MyLocation Layer of Google Map
		gMap.setMyLocationEnabled(true);	
		
		if(location!=null){
			   onLocationChanged(location);
		}

	    locationManager.requestLocationUpdates(provider, 20000, 0, this);
			        

		//chao
	}
    //no need to see lines below
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
		getMenuInflater().inflate(R.menu.searchnearby, menu);
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

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
    double latitude = location.getLatitude();
		
		// Getting longitude of the current location
		double longitude = location.getLongitude();		
		
		// Creating a LatLng object for the current location
		current = new LatLng(latitude, longitude);
		
		// Showing the current location in Google Map
		gMap.moveCamera(CameraUpdateFactory.newLatLng(current));
		
		// Zoom in the Google Map
		gMap.animateCamera(CameraUpdateFactory.zoomTo(16));
		
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
