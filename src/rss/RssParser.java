package rss;

import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import android.util.Log;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


 

public class RssParser {
	ArrayList<Talk> talks=new ArrayList<Talk>();
	//private static final String TAG = "MyActivity";
	public ArrayList<Talk> parseRss(String feed_url) {  
           
        	   
        	   DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
        	   DocumentBuilder builder = null;
			try {
				builder = fac.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   Document doc = null;
			try {
				doc = builder.parse(feed_url);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   Element root=doc.getDocumentElement();
        	   System.out.println(root.getNodeName());
        	   NodeList talklist=root.getChildNodes();
        	   //NodeList datelist=doc.getElementsByTagName("date");
        	   //NodeList begintimelist=doc.getElementsByTagName("begintime");
        	   //NodeList endtimelist=doc.getElementsByTagName("endtime");
        	   //NodeList locationlist=doc.getElementsByTagName("location");
        	   
        	   if(talklist!=null){
        		   for(int i=0;i<5;i++){
        			   //Node speaker=speakerlist.item(i);
        			   //System.out.println(speaker.getNodeValue());
        			   
        			   Element talk=(Element)talklist.item(i);
        			   NodeList locationList = talk.getElementsByTagName("location");
        			   NodeList speakerList =  talk.getElementsByTagName("speaker");
        			   NodeList titleList = talk.getElementsByTagName("title");
        			   NodeList dateList = talk.getElementsByTagName("date");
        			   NodeList begintimeList = talk.getElementsByTagName("begintime");
        			   NodeList endtimeList = talk.getElementsByTagName("endtime");
        			   
        			   Element locationElement = (Element) locationList.item(0);
        			   Element speakerElement = (Element) speakerList.item(0);
        			   Element titleElement = (Element) titleList.item(0);
        			   Element dateElement = (Element) dateList.item(0);
        			   Element begintimeElement = (Element) begintimeList.item(0);
        			   Element endtimeElement = (Element) endtimeList.item(0);
        			   
        			   String title_value = getCharacterDateFromElement(titleElement);
        			   String speaker_value = getCharacterDateFromElement(speakerElement);
        			   String date_value = getCharacterDateFromElement(dateElement);
        			   String beginTime_value = getCharacterDateFromElement(begintimeElement);
        			   String endTime_value = getCharacterDateFromElement(endtimeElement);
        			   String location_value=getCharacterDateFromElement(locationElement);
        			   System.out.println(i+": "+location_value);
        			   
        			   Talk talk_object=new Talk(speaker_value,location_value,title_value,date_value,beginTime_value,endTime_value);
        			   talks.add(talk_object);
        		   }
        	   }
        	   
        	   System.out.println("talkslist length in RssParser: "+talks.size());
        	   
           
          
           return talks;
      
    }
	public String getCharacterDateFromElement(Element e) {
		// TODO Auto-generated method stub
		Node child = e.getFirstChild();
		if(child instanceof CharacterData){
			CharacterData cd=(CharacterData) child;
			return cd.getData();
		}
		return "";
	}  
}  

