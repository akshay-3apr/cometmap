package com.example.cometmap;

public class Coordinates {
private int id;
private String name;
private String abbr;
private double latitude;
private double longitude;

public void setId(int id){
	this.id=id;
}
public int getId(){
	return id;
}
public void setName(String name){
	this.name=name;
}
public String getName(){
	return name;
}
public void setAbbr(String abbr){
	this.abbr=abbr;
}
public String getAbbr(){
	return abbr;
}
public void setLatitude(double latitude){
	this.latitude=latitude;
}
public double getLatitude(){
	return latitude;
}
public void setLongitude(double longitude){
	this.longitude=longitude;
}
public double getLongitude(){
	return longitude;
}
	
}
