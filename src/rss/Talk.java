package rss;

public class Talk {
	  private String speaker;
	  private String place;
	  private String title;
	  private String date;
	  private String beginTime;
	  private String endTime;
	  
	  public Talk(String speaker, String place, String title, String date, String beginTime, String endTime){
		  this.speaker=speaker;
		  this.place=place;
		  this.title=title;
		  this.date=date;
		  this.beginTime=beginTime;
		  this.endTime=endTime;
	  }
	 
	public String getSpeaker(){
		  return speaker;
	  }
	  public void setSpeaker(String speaker){
		  this.speaker=speaker;
	  }
	  public String getPlace(){
		  return place;
	  }
	  public void setPlace(String place){
		  this.place=place;
	  }
	  public String getTitle(){
		  return title;
	  }
	  public void setTitle(String title){
		  this.title=title;
	  }
	  public String getDate(){
		  return date;
	  }
	  public void setDate(String date){
		  this.date=date;
	  }
	  public String getBeginTime(){
		  return beginTime;
	  }
	  public void setBeginTime(String beginTime){
		  this.beginTime=beginTime;
	  }
	  public String getEndTime(){
		  return endTime;
	  }
	  public void setEndTime(String endTime){
		  this.endTime=endTime;
	  }
	   
}
