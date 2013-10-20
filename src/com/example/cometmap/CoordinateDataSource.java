package com.example.cometmap;

//import com.example.cometmap.MySQLiteHelper;
//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CoordinateDataSource {

	   private SQLiteDatabase database;
	   private MySQLiteHelper dbHelper;
	   private String[] allColumns = {
			   MySQLiteHelper.COLUMN_ID, 
			   MySQLiteHelper.COLUMN_NAME,
			   MySQLiteHelper.COLUMN_ABBR,
			   MySQLiteHelper.COLUMN_LONGITUDE,
			   MySQLiteHelper.COLUMN_LATITUDE
	   };
	   
	   public CoordinateDataSource(Context context) {
		   dbHelper = new MySQLiteHelper(context);
	   }
	   
	   public void open() throws SQLException {
		    database = dbHelper.getWritableDatabase();
	   }
	   
	   public void close() {
		    dbHelper.close();
	   }
	   
	   public void clean(){
		   dbHelper.clean();
	   }
	   
	   public List<Coordinates> getAllCoordinates() {
		   List<Coordinates> coordinates = new ArrayList<Coordinates>();

		    Cursor cursor = database.query(MySQLiteHelper.TABLE_COORDINATES,
		        allColumns, null, null, null, null, null);

		    cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
		      Coordinates coordinate = cursorToCoordinates(cursor);
		      coordinates.add(coordinate);
		      cursor.moveToNext();
		    }
		    // Make sure to close the cursor
		    cursor.close();
		    return coordinates;
		  }

		  private Coordinates cursorToCoordinates(Cursor cursor) {
		// TODO Auto-generated method stub
			  Coordinates coordinate =new Coordinates();
			  coordinate.setId(cursor.getInt(0));
			  coordinate.setName(cursor.getString(1));
			  coordinate.setAbbr(cursor.getString(2));
			  coordinate.setLatitude(cursor.getDouble(3));
			  coordinate.setLongitude(cursor.getDouble(4));
		  return coordinate;
	}
}
