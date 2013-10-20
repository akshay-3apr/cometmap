package com.example.cometmap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{
	public static final String TABLE_COORDINATES = "coordinates";
	public static final String DATABASE_NAME = "coordinates.db";
	public static final String COLUMN_ID = "cid";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_ABBR = "abbr";
	public static final String COLUMN_LATITUDE = "latitude";
	public static final String COLUMN_LONGITUDE = "longitude";
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_CREATE = "create table "
			+TABLE_COORDINATES+" ("+COLUMN_ID
			+" integer not null, "+COLUMN_NAME
			+" text not null, "+ COLUMN_ABBR
			+" text not null, "+ COLUMN_LATITUDE
			+" real not null, "+ COLUMN_LONGITUDE
			+" real not null);";
	

	public MySQLiteHelper(Context context){
    	 super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }

	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		database.execSQL(DATABASE_CREATE);
		database.execSQL("INSERT INTO coordinates VALUES(1,'First Babtist Church','BAPST',-79.953215,40.447624);");
		database.execSQL("INSERT INTO coordinates VALUES(2,'St. Paul Cathedral','SPAUL',-79.949843,40.447657);");
		database.execSQL("INSERT INTO coordinates VALUES(3,'Information Sciences Building','IS',-79.952485,40.447447);");
		
		database.execSQL("INSERT INTO coordinates VALUES(4,'Ruskin Hall','RUSKIN',-79.952377,40.447205);");
		database.execSQL("INSERT INTO coordinates VALUES(5,'Charles L. Cost Sports Center','COST',-79.964967,40.445532);");
		database.execSQL("INSERT INTO coordinates VALUES(6,'Music Building','MUSIC',-79.952396,40.446752);");
		database.execSQL("INSERT INTO coordinates VALUES(7,'Mellon Institute (Pgh. Supercomputing center)','MELLI',-79.951534,40.446401);");
		database.execSQL("INSERT INTO coordinates VALUES(8,'Chevron Science Center','CHVRN',-79.957524,40.445767);");
		database.execSQL("INSERT INTO coordinates VALUES(9,'Eberly Hall','EBERL',-79.95817,40.446275);");
		database.execSQL("INSERT INTO coordinates VALUES(10,'Craig Hall','CRAIG',-79.94904,40.446275);");
		database.execSQL("INSERT INTO coordinates VALUES(11,'University Technology Development Center','UTDC',-79.949598,40.446275);");
		database.execSQL("INSERT INTO coordinates VALUES(12,'Fraternity Housing Complex','FRAT',-79.961932,40.44581);");
		database.execSQL("INSERT INTO coordinates VALUES(13,'Alumni Hall','ALUM',-79.95354,40.445707);");
		database.execSQL("INSERT INTO coordinates VALUES(14,'Bellefield Hall','BELLH',-79.951225,40.445361);");
		database.execSQL("INSERT INTO coordinates VALUES(15,'Soldiers & SAilors Memorial Hall','SOSAM',-79.956231,40.444871);");
		database.execSQL("INSERT INTO coordinates VALUES(16,'HEINZ Memorial Chapel','HEINZ',-79.951865,40.445377);");
		database.execSQL("INSERT INTO coordinates VALUES(17,'Pittsburgh Athletic Association','PAA',-79.954724,40.445033);");
		database.execSQL("INSERT INTO coordinates VALUES(18,'Pittsburgh Board of Education','PBE',-79.950911,40.444653);");
		database.execSQL("INSERT INTO coordinates VALUES(19,'Trees Hall','TREES',-79.965235,40.44375);");
		database.execSQL("INSERT INTO coordinates VALUES(20,'Cathedral of Learning','CL',-79.952823,40.444498);");
		database.execSQL("INSERT INTO coordinates VALUES(21,'Gardner Steel Conference Center','GSCC',-79.957861,40.444506);");
		database.execSQL("INSERT INTO coordinates VALUES(22,'Forbes Craig Apartments','FBCRG',-79.949092,40.444443);");
		database.execSQL("INSERT INTO coordinates VALUES(23,'Thackeray Hall','THACK',-79.957346,40.444093);");
		database.execSQL("INSERT INTO coordinates VALUES(24,'University Club','UCLUB',-79.956589,40.44421);");
		database.execSQL("INSERT INTO coordinates VALUES(25,'Lutheran University Center','LUC',-79.949417,40.444365);");
		database.execSQL("INSERT INTO coordinates VALUES(26,'Fitzgerald Field House','FHOUS',-79.964651,40.443408);");
		database.execSQL("INSERT INTO coordinates VALUES(27,'University Place Office Building','UPLAC',-79.955842,40.443824);");
		database.execSQL("INSERT INTO coordinates VALUES(28,'Carnegie Library of Pittsburgh','CARNG',-79.94907,40.444059);");
		database.execSQL("INSERT INTO coordinates VALUES(29,'Stephen Foster Memorial','STEPH',-79.952863,40.443861);");
		database.execSQL("INSERT INTO coordinates VALUES(30,'Parran Hall (Graduate school of Public Health)','PUBHL',-79.957989,40.442612);");
		database.execSQL("INSERT INTO coordinates VALUES(31,'Salk Hall','SALK',-79.962531,40.442478);");
		database.execSQL("INSERT INTO coordinates VALUES(32,'Falk Medical Building','FALKC',-79.959236,40.44142);");
		database.execSQL("INSERT INTO coordinates VALUES(33,'Frick Fine Arts Building','FKART',-79.950697,40.441795);");
		database.execSQL("INSERT INTO coordinates VALUES(34,'Victoria Building','VICTO',-79.96094,40.441443);");
		database.execSQL("INSERT INTO coordinates VALUES(35,'Iroquious Building','IROQU',-79.958091,40.440476);");
		database.execSQL("INSERT INTO coordinates VALUES(36,'Mervis Hall','MERVS',-79.953111,40.440997);");
		database.execSQL("INSERT INTO coordinates VALUES(37,'Forbes Pavilion','PAVLN',-79.958972,40.440356);");
		database.execSQL("INSERT INTO coordinates VALUES(38,'Oxford Building','OXFORD',-79.959363,40.439946);");
		database.execSQL("INSERT INTO coordinates VALUES(39,'Post Office (Oakland Branch','POST',-79.952689,40.439948);");
		database.execSQL("INSERT INTO coordinates VALUES(40,'John M. and Gertrude E.Petersen Events Center','PCNTR',-79.961311,40.444028);");
		database.execSQL("INSERT INTO coordinates VALUES(41,'Pennsylvania Hall','PAHLL',-79.960491,40.445004);");
		database.execSQL("INSERT INTO coordinates VALUES(42,'Panther Hall','PANTH',-79.961799,40.445383);");
		database.execSQL("INSERT INTO coordinates VALUES(43,'Bennadum Hall','BENDM',-79.95896,40.443562);");
		database.execSQL("INSERT INTO coordinates VALUES(44,'Engineering Auditorium','ENGUD',-79.958171,40.443958);");
		database.execSQL("INSERT INTO coordinates VALUES(46,'Van de Graaff Building','VNGRF',-79.958719,40.444474);");
		database.execSQL("INSERT INTO coordinates VALUES(47,'Old Engineering Hall','OEH',-79.957817,40.445003);");
		database.execSQL("INSERT INTO coordinates VALUES(48,'Allen Hall','ALLEN',-79.958248,40.444518);");
		database.execSQL("INSERT INTO coordinates VALUES(49,'Thaw Hall','THAW',-79.957817,40.445003);");
		database.execSQL("INSERT INTO coordinates VALUES(50,'Space Research Center','SRCC',-79.957008,40.445575);");
		database.execSQL("INSERT INTO coordinates VALUES(51,'Biomedical Science Tower','BSTWR',-79.961963,40.441655);");
		database.execSQL("INSERT INTO coordinates VALUES(52,'Scaife Hall','SCAIF',-79.961522,40.443004);");
		database.execSQL("INSERT INTO coordinates VALUES(53,'Lothrop Hall','LOTHP',-79.960073,40.441637);");
		database.execSQL("INSERT INTO coordinates VALUES(54,'Biomedical Science Tower3','BSTW3',-79.960313,40.440754);");
		database.execSQL("INSERT INTO coordinates VALUES(55,'Sutherland Hall','SUTHD',-79.962704,40.445685);");
		database.execSQL("INSERT INTO coordinates VALUES(56,'Crawford Hall','CRAWF',-79.954065,40.446907);");
		database.execSQL("INSERT INTO coordinates VALUES(57,'Langley Hall','LANGY',-79.954065,40.446907);");
		database.execSQL("INSERT INTO coordinates VALUES(58,'Clapp Hall','CALPP',-79.952782,40.446086);");
		database.execSQL("INSERT INTO coordinates VALUES(59,'William Pitt Union','WPU',-79.955032,40.443678);");
		database.execSQL("INSERT INTO coordinates VALUES(60,'Amos Hall','AMOS',-79.955685,40.443437);");
		database.execSQL("INSERT INTO coordinates VALUES(61,'The Book Center','BOOK',-79.956053,40.443152);");
		database.execSQL("INSERT INTO coordinates VALUES(62,'Holland Hall','HOLLD',-79.955848,40.442985);");
		database.execSQL("INSERT INTO coordinates VALUES(63,'Brackenridge Hall','BRACK',-79.955543,40.442867);");
		database.execSQL("INSERT INTO coordinates VALUES(64,'McCormick Hall','MCCOR',-79.95553,40.443204);");
		database.execSQL("INSERT INTO coordinates VALUES(65,'Bruce Hall','BRUCE',-79.955332,40.443017);");
		database.execSQL("INSERT INTO coordinates VALUES(66,'Tower C','C',-79.956787,40.442699);");
		database.execSQL("INSERT INTO coordinates VALUES(67,'Towers B','B',-79.956788,40.442699);");
		database.execSQL("INSERT INTO coordinates VALUES(68,'Tower A','A',-79.956792,40.442696);");
		database.execSQL("INSERT INTO coordinates VALUES(69,'Hillman Library','HLMAN',-79.953691,40.442748);");
		database.execSQL("INSERT INTO coordinates VALUES(70,'wrence Hall','LAWRN',-79.955395,40.442543);");
		database.execSQL("INSERT INTO coordinates VALUES(71,'Wesley W. Posvar Hall','WWPH',-79.954295,40.441796);");
		database.execSQL("INSERT INTO coordinates VALUES(72,'Barco Law Building','LAW',-79.955929,40.442031);");
		database.execSQL("INSERT INTO coordinates VALUES(73,'Sennot Square','SENSQ',-79.956307,40.441772);");
		database.execSQL("INSERT INTO coordinates VALUES(74,'Forbes Tower','FRTOW',-79.957187,40.440578);");
		database.execSQL("INSERT INTO coordinates VALUES(75,'Loeffler Building','LOEFF',-79.958555,40.440863);");
		database.execSQL("INSERT INTO coordinates VALUES(76,'Medical Art Building','MDART',-79.957994,40.441925);");
		database.execSQL("INSERT INTO coordinates VALUES(77,'UPMC Montefiore','MONF',-79.961098,40.440027);");
		database.execSQL("INSERT INTO coordinates VALUES(78,'Kaufmann Medical Building','KAU',-79.960492,40.440484);");
		database.execSQL("INSERT INTO coordinates VALUES(79,'Rangos Research Center','RANGO',-79.960107,40.440217);");
		database.execSQL("INSERT INTO coordinates VALUES(80,'Hill Building','HILL',-79.960905,40.43988);");
		database.execSQL("INSERT INTO coordinates VALUES(81,'Frick Int''l Studies Academy','FRICK',-79.95816,40.443109);");
		database.execSQL("INSERT INTO coordinates VALUES(82,'Western Psychiatric Institute and Clinic','TDH',-79.959961,40.443352);");
		database.execSQL("INSERT INTO coordinates VALUES(83,'UPMC Presbyterian','PRESB',-79.960824,40.442092);");
		database.execSQL("INSERT INTO coordinates VALUES(84,'Children''s Hospital','CHILD',-79.958487,40.442238);");
		database.execSQL("INSERT INTO coordinates VALUES(85,'University Center (UPMC)','UCTR',-79.954846,40.446258);");
		database.execSQL("INSERT INTO coordinates VALUES(86,'Holiday Inn','HOLDY',-79.954362,40.44619);");
		database.execSQL("INSERT INTO coordinates VALUES(87,'WEbster Hall','WEBSR',-79.950798,40.446997);");
		database.execSQL("INSERT INTO coordinates VALUES(88,'COmmunity of Reconcilliation Bldg','CR',-79.951922,40.447009);");
		database.execSQL("INSERT INTO coordinates VALUES(89,'Bellefield Tower','BELLT',-79.951936,40.447041);");
		database.execSQL("INSERT INTO coordinates VALUES(90,'Tepper Faculty Conf','TEPPER',-79.94387,40.442283)");
		database.execSQL("INSERT INTO coordinates VALUES(91,'Baker','BAKER',-79.94422,40.441329)");
		database.execSQL("INSERT INTO coordinates VALUES(92,'Hamburg Hall','HAMBURG',-79.946324,40.442283)");
		database.execSQL("INSERT INTO coordinates VALUES(93,'Gates & Hillman Centers','GATES&HILLMAN',-79.944455,40.444187)");
		database.execSQL("INSERT INTO coordinates VALUES(94,'GSIA','GSIA',-79.94387,40.442283)");
		
		
		//database.execSQL("select count(*) from coordinates;");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
			            + newVersion + ", which will destroy all old data");
		db.execSQL("Drop table if exists "+TABLE_COORDINATES);
		onCreate(db);
	}
	
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
	
	public void clean (){  
        this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS "+TABLE_COORDINATES);  
        System.out.println("clean table");  
        this.onCreate(this.getWritableDatabase());  
        this.getWritableDatabase().close();  
    }
	
	
}
