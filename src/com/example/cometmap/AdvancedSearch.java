package com.example.cometmap;
import java.util.ArrayList;
import java.util.Calendar; 

import android.R.string;
import android.app.Activity; 
import android.app.AlertDialog;
import android.app.DatePickerDialog; 
import android.app.Dialog; 
import android.app.TimePickerDialog; 
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle; 
import android.view.Menu;
import android.view.View; 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker; 
import android.widget.EditText; 
import android.widget.TextView;
import android.widget.TimePicker; 
import android.widget.Toast;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class AdvancedSearch extends Activity implements android.view.View.OnClickListener { 
    private static final String String = null;
	private final int DATE_DIALOG = 1; 
    private final int TIME_DIALOG = 2; 
	private int mYear;     
	private int mMonth;     
	private int mDay;     
	private int h;
	private int f;
	private java.lang.String building;
	//EditText editText;
	//EditText editText01;
	TextView textView1;
	TextView textView2;

	Calendar calendar ;
	private final String[] arrayPlace = new String[] { 
			"Thackeray Hall","First Babtist Church", "St. Paul Cathedral", 
			"Information Sciences Building", "Ruskin Hall","Hillman Library","William Pitt Union","Eberly Hall","Mellon Institute (Pgh. Supercomputing center)",
			"Bellefield Hall","Cathedral of Learning","Lutheran University Center"}; 
	 
	 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_advanced_search); 
        
        Button bn = (Button) findViewById(R.id.date);//new button

        //Button bp = (Button)findViewById(R.id.place);
        
		findViewById(R.id.place).setOnClickListener(this);
		
//       Button bs = (Button)findViewById(R.id.adsearch);
        
        
       
		
        
        
        
        bn.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("in onclick;");
				showDialog(TIME_DIALOG);
				showDialog(DATE_DIALOG);
			}
        });
        
        System.out.println("start of advance search");
        building = "Thackeray Hall";
        
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        
        calendar = Calendar.getInstance(); 
        mYear = calendar.get(Calendar.YEAR);     
		mMonth = calendar.get(Calendar.MONTH);     
		mDay = calendar.get(Calendar.DAY_OF_MONTH);  
		h = calendar.get(Calendar.HOUR_OF_DAY);
		f = calendar.get(Calendar.MINUTE);
		updateDisplay();
		updateDispla_place();
    } 
  

	public void onClick(View v) {
		switch (v.getId()) {


		case R.id.place:
			new AlertDialog.Builder(this).setTitle("Select Place").setIcon(
					android.R.drawable.ic_dialog_info).setSingleChoiceItems(
					arrayPlace, 0,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							building = arrayPlace[which];
							dialog.dismiss();
                        	updateDispla_place();
						}
					}).setNegativeButton("Done", null).show();

			break;}

	}
    
    public void AdSearch (View v){
    	Intent intent = new Intent(this, AdSearch.class); //choose the "Search" button
    	

		ArrayList <Integer> date = new ArrayList<Integer>();
    	ArrayList <Integer> time = new ArrayList<Integer>();
    	
    	String place = building;
    	Integer year = mYear;
    	Integer month = mMonth;
    	Integer day =  mDay;
    	Integer hour = h;
    	Integer minute = f;
    	
    	date.add(year);
    	date.add(month);
    	date.add(day);
    	time.add(hour);
    	time.add(minute);
    	
    	intent.putIntegerArrayListExtra("date", date);
  	    intent.putIntegerArrayListExtra("time", time);
    	intent.putExtra("place",place);
    	

    	//final
    	startActivity(intent);
    }
 
    
    
    protected Dialog onCreateDialog(int id) { 

        Dialog dialog = null; 
        switch(id) { 
            case DATE_DIALOG: 
                DatePickerDialog.OnDateSetListener dateListener =  
                    new DatePickerDialog.OnDateSetListener() { 
                        @Override 
                        public void onDateSet(DatePicker datePicker,int year, int month, int dayOfMonth) {
                        	mYear=year;
                        	mMonth = month;
                        	mDay = dayOfMonth;
                        } 
                    }; 
                dialog = new DatePickerDialog(this, 
                        dateListener, 
                        calendar.get(Calendar.YEAR), 
                        calendar.get(Calendar.MONTH), 
                        calendar.get(Calendar.DAY_OF_MONTH)); 
                break; 
            case TIME_DIALOG: 
                TimePickerDialog.OnTimeSetListener timeListener =  
                    new TimePickerDialog.OnTimeSetListener() { 
                         

					@Override
                        public void onTimeSet(TimePicker timerPicker, int hourOfDay, int minute) {
						
                        	h=hourOfDay;
                         	f=minute;
                        	updateDisplay();
                        }

                    }; 
                    dialog = new TimePickerDialog(this, timeListener, 
                            calendar.get(Calendar.HOUR_OF_DAY), 
                            calendar.get(Calendar.MINUTE), 
                            true);  
                break; 
            default: 
                break; 
        } 
        return dialog; 
    } 
    
	private void updateDisplay() {     
		textView1.setText(

				new StringBuilder().append("    Chosen Date: ").append(mYear).append("-")
				.append(mMonth+1).append("-")  
				.append(mDay).append(" ") 
//				.append(h).append(" "));
				.append("\n")

				.append("    Chosen Time:  ")
				.append(h).append(" : ")
				.append(f).append(" "));
	}
	
	private void updateDispla_place() {     
		textView2.setText(     
				new StringBuilder().append("Chosen Place: ").append(building));
	}
	
	
} 
