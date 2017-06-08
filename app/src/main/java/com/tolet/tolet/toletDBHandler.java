package com.tolet.tolet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class toletDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_ADS = "ads.db";
    public static final String DATABASE_ACCOUNTS = "accounts.db";

    
    public static final String TABLE_ADS = "Ads";   // name of the table
    public static final String TABLE_ACCOUNTS = "Accounts";   // name of the table
    
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_HOUSE_NO = "houseNumber";
    public static final String COLUMN_ROAD_NO = "roadNumber";
    public static final String COLUMN_FLOOR = "floor";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_ROOMS = "rooms";
    public static final String COLUMN_BEDS = "beds";
    public static final String COLUMN_BATHS = "baths";
    public static final String COLUMN_TYPE = "flatType";
    public static final String COLUMN_LIFT = "hasLift";
    public static final String COLUMN_PARKING = "hasParking";
    public static final String COLUMN_RENT = "rent";
    public static final String COLUMN_DESCRIPTION = "description";



    public toletDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_ADS, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TABLE_ADS + "("+
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_HOUSE_NO + " INTEGER, " +
                COLUMN_ROAD_NO + " INTEGER, " +
                COLUMN_FLOOR + " INTEGER, " +
                COLUMN_SIZE + " INTEGER, " +
                COLUMN_ROOMS + " INTEGER, " +
                COLUMN_BEDS + " INTEGER, " +
                COLUMN_BATHS + " INTEGER, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_LIFT + " TEXT, " +
                COLUMN_PARKING + " TEXT, " +
                COLUMN_RENT + " INTEGER, " +
                COLUMN_DESCRIPTION + " TEXT " +


                ");";
        String query2 = "CREATE TABLE " + TABLE_ACCOUNTS + "("+
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT " +
                ");";

        db.execSQL(query1);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        onCreate(db);
    }

    public void addmyAdObjects(myAdsObjects adsObjects){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME , adsObjects.getUsername());
        contentValues.put(COLUMN_PASSWORD , adsObjects.getPassword());
        contentValues.put(COLUMN_LOCATION , adsObjects.getLocation());
        contentValues.put(COLUMN_HOUSE_NO , adsObjects.getHouseNumber());
        contentValues.put(COLUMN_ROAD_NO , adsObjects.getRoadNumber());
        contentValues.put(COLUMN_FLOOR , adsObjects.getFloor());
        contentValues.put(COLUMN_SIZE , adsObjects.getSize());
        contentValues.put(COLUMN_ROOMS , adsObjects.getRooms());
        contentValues.put(COLUMN_BEDS , adsObjects.getBeds());
        contentValues.put(COLUMN_BATHS , adsObjects.getBaths());
        contentValues.put(COLUMN_TYPE , adsObjects.getFlatType());
        contentValues.put(COLUMN_LIFT , adsObjects.getHasLift());
        contentValues.put(COLUMN_PARKING , adsObjects.getHasParking());
        contentValues.put(COLUMN_RENT , adsObjects.getRent());
        contentValues.put(COLUMN_DESCRIPTION , adsObjects.getDescription());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ADS , null , contentValues);
        db.close();
    }


    public ArrayList<myAdsObjects> readAdsDatabase(String username , String password){
        ArrayList<myAdsObjects> myAdsArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+
                TABLE_ADS + " WHERE username = " + "\"" + username + "\"" +
                " and password = " + "\"" + password + "\";";

        Cursor cursor = db.rawQuery(query , null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("username")) != null){
                myAdsObjects objects = new myAdsObjects(cursor.getString(cursor.getColumnIndex("username")),
                        cursor.getString(cursor.getColumnIndex("password")),
                        cursor.getString(cursor.getColumnIndex("location")),
                        cursor.getString(cursor.getColumnIndex("houseNumber")),
                        cursor.getString(cursor.getColumnIndex("roadNumber")),
                        cursor.getString(cursor.getColumnIndex("floor")),
                        cursor.getString(cursor.getColumnIndex("size")),
                        cursor.getString(cursor.getColumnIndex("rooms")),
                        cursor.getString(cursor.getColumnIndex("beds")),
                        cursor.getString(cursor.getColumnIndex("baths")),
                        cursor.getString(cursor.getColumnIndex("flatType")),
                        cursor.getString(cursor.getColumnIndex("hasLift")),
                        cursor.getString(cursor.getColumnIndex("hasParking")),
                        cursor.getString(cursor.getColumnIndex("rent")),
                        cursor.getString(cursor.getColumnIndex("description"))

                        );
                myAdsArrayList.add(objects);
            }
        }

        db.close();
        return myAdsArrayList;
    }
}
