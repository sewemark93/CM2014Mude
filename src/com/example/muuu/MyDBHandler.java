package com.example.muuu;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 12;
	private static final String DATABASE_NAME = "MudeDB.db";
	public static final String TABLE_ITEMS = "Items";
	
	//helper for types
	public static final String VARCHAR_TYPE = " VARCHAR(50)";
	public static final String INT_TYPE = " INTEGER";
	
	//helper for column names
    public static final String COLUMN_ENTRY_ID = "id"; //integer
    public static final String COLUMN_TITLE = "itemtitle"; //varchar(50)
    public static final String COLUMN_AUTHOR = "author"; //varchar(50)
    public static final String COLUMN_MANUFACTURER = "manufacturer"; //varchar(50)
    public static final String COLUMN_CATEGORY = "category"; //varchar(50)
    public static final String COLUMN_DATE = "date"; //int
    public static final String COLUMN_TYPE = "type"; //varchar(50)
    public static final String COLUMN_COUNTRY = "country"; //varchar(50)
    public static final String COLUMN_COLOUR = "colour"; //varchar(50)
    public static final String COLUMN_MATERIAL = "material"; //varchar(50)
    public static final String COLUMN_FAVOURITE = "is_favourite"; //boolean
    public static final String COLUMN_IMGRES = "imgres"; //varchar(50)
    public static final String COLUMN_NUMBER_OF_PICS = "nr_of_pics"; // integer
	
	public MyDBHandler(Context context, String name, 
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + 
				"("
		             + COLUMN_ENTRY_ID 		+ INT_TYPE +" PRIMARY KEY AUTOINCREMENT, " 
					 + COLUMN_TITLE			+ VARCHAR_TYPE 	+ "UNIQUE, "
					 + COLUMN_AUTHOR 		+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_MANUFACTURER  + VARCHAR_TYPE 	+ ", "
					 + COLUMN_CATEGORY 		+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_DATE			+ INT_TYPE		+ ", "
					 + COLUMN_TYPE			+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_COUNTRY 		+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_COLOUR 		+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_MATERIAL 		+ VARCHAR_TYPE 	+ ", "
					 + COLUMN_FAVOURITE 	+ INT_TYPE		+ ", "
					 + COLUMN_IMGRES		+ VARCHAR_TYPE	+ "UNIQUE, "
					 + COLUMN_NUMBER_OF_PICS + INT_TYPE + 
				")";
	      db.execSQL(CREATE_ITEMS_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
	      onCreate(db);
	}
	
	public void addItem(Item item) {
		
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, item.getItemTitle());
        values.put(COLUMN_AUTHOR, item.getAuthor());
        values.put(COLUMN_MANUFACTURER, item.getManufacturer());
        values.put(COLUMN_CATEGORY, item.getCategory());
        values.put(COLUMN_DATE, item.getDate());
        values.put(COLUMN_TYPE, item.getType());
        values.put(COLUMN_COUNTRY, item.getCountry());
        values.put(COLUMN_COLOUR, item.getColour());
        values.put(COLUMN_MATERIAL, item.getMaterial());
        values.put(COLUMN_FAVOURITE, item.getFavourite());
        values.put(COLUMN_IMGRES, item.getImgRes());
        values.put(COLUMN_NUMBER_OF_PICS, item.getNumberOfPics());
 
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.insert(TABLE_ITEMS, null, values);
        db.close();
        
	}
	
	public int findPictureNumber(String itemtitle) {
		String query = "SELECT nr_of_pics FROM " + TABLE_ITEMS + " WHERE " +COLUMN_TITLE + "=" + "'"+itemtitle+"'" ;
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		
		int PicsNumber=0;
		
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			PicsNumber=Integer.parseInt(cursor.getString(0));
			cursor.close();
			return PicsNumber;
		} else {
			//wtf?
		}
	        db.close();
	        return 0;
	}

	public void changeFavourite(String itemtitle, int isFavourite)
	{
		
		SQLiteDatabase db = this.getWritableDatabase();
		String strSQL = "UPDATE "+TABLE_ITEMS+" SET "+COLUMN_FAVOURITE +"="+ isFavourite +" WHERE " + COLUMN_TITLE +  "=" + "'"+itemtitle+"'";

		db.execSQL(strSQL);
		
	}

	public String AuthorName(String itemtitle) {
		String query = "SELECT " +COLUMN_AUTHOR+ " FROM " + TABLE_ITEMS + " WHERE " +COLUMN_TITLE + "=" + "'"+itemtitle+"'" ;
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		String authorname="Author not found or not known.";
		
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			authorname=cursor.getString(0);
			cursor.close();
		} else {
			//wtf?
		}
	        db.close();
		return authorname;
	}
	public Item findItem(String resource) {
		String query = "Select * FROM " + TABLE_ITEMS + " WHERE " + COLUMN_IMGRES + " =  \"" + resource + "\"";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		Item item = new Item();
		
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			item.setID(Integer.parseInt(cursor.getString(0)));
			item.setItemTitle(cursor.getString(1));
			item.setAuthor(cursor.getString(2));
			item.setManufacturer(cursor.getString(3));
			item.setCategory(cursor.getString(4));
			item.setDate(Integer.parseInt(cursor.getString(5)));
			item.setType(cursor.getString(6));
			item.setCountry(cursor.getString(7));
			item.setColour(cursor.getString(8));
			item.setMaterial(cursor.getString(9));
			item.setFavourite(Integer.parseInt(cursor.getString(10)));
			item.setImgRes(cursor.getString(11));
			item.setNumberOfPics(Integer.parseInt(cursor.getString(12)));
			cursor.close();
		} else {
			item = null;
		}
	        db.close();
		return item;
	}

	public ArrayList<String> searchByCategory(String category) {
		ArrayList<String> listCat = new ArrayList<String>();
		String query = "SELECT "+ COLUMN_IMGRES + " FROM " + TABLE_ITEMS + " WHERE " + COLUMN_CATEGORY + "=" + "'"+category+"'";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		while (cursor.moveToNext()) {
			listCat.add(cursor.getString(0));
		}
		return listCat;
	}
	public ArrayList<String> searchByDate(int date) {
		ArrayList<String> listCat = new ArrayList<String>();
		String query = "SELECT "+ COLUMN_IMGRES + " FROM " + TABLE_ITEMS + " WHERE " + COLUMN_DATE + "=" + "'"+date+"'";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		while (cursor.moveToNext()) {
			listCat.add(cursor.getString(0));
		}
		return listCat;
	}
	public ArrayList<String> searchByAuthor(String author) {
		ArrayList<String> listCat = new ArrayList<String>();
		String query = "SELECT "+ COLUMN_IMGRES + " FROM " + TABLE_ITEMS + " WHERE " + COLUMN_AUTHOR + "=" + "'"+author+"'";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		while (cursor.moveToNext()) {
			listCat.add(cursor.getString(0));
		}
		return listCat;
	}
	public ArrayList<String> searchByFavourite(int favourite) {
		ArrayList<String> listCat = new ArrayList<String>();
		String query = "SELECT "+ COLUMN_IMGRES + " FROM " + TABLE_ITEMS + " WHERE " + COLUMN_FAVOURITE + "=" + "'"+favourite+"'";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		while (cursor.moveToNext()) {
			listCat.add(cursor.getString(0));
		}
		return listCat;
	}
}


