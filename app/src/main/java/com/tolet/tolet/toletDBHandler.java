package com.tolet.tolet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class toletDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_ADS = "ads_2.db";
    private static final String DATABASE_ACCOUNTS = "accounts_2.db";

    
    public static final String TABLE_ADS = "ads_2";   // name of the table
    public  static final String TABLE_ACCOUNTS = "accounts_2";   // name of the table
    
    
    public static final String COLUMN_ID = "id";
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
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_HOUSE_NO + " TEXT, " +
                COLUMN_ROAD_NO + " TEXT, " +
                COLUMN_FLOOR + " TEXT, " +
                COLUMN_SIZE + " TEXT, " +
                COLUMN_ROOMS + " TEXT, " +
                COLUMN_BEDS + " TEXT, " +
                COLUMN_BATHS + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_LIFT + " TEXT, " +
                COLUMN_PARKING + " TEXT, " +
                COLUMN_RENT + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT " +


                ")";
        String query2 = "CREATE TABLE " + TABLE_ACCOUNTS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT " +
                ")";

        db.execSQL(query1);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        onCreate(db);
    }


    
    

    public void addAccount(Accounts accounts){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME, accounts.getUsername());
        contentValues.put(COLUMN_PASSWORD, accounts.getPassword());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ACCOUNTS , null , contentValues);
        db.close();
    }



    public void insertAd(Ads ad){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME , ad.getUsername());;
        values.put(COLUMN_PASSWORD , ad.getPassword());;
        values.put(COLUMN_LOCATION , ad.getLocation());;
        values.put(COLUMN_HOUSE_NO , ad.getHouseNumber());;
        values.put(COLUMN_ROAD_NO , ad.getRoadNumber());;
        values.put(COLUMN_FLOOR , ad.getFloor());;
        values.put(COLUMN_SIZE , ad.getSize());;
        values.put(COLUMN_ROOMS , ad.getRooms());;
        values.put(COLUMN_BEDS , ad.getBeds());;
        values.put(COLUMN_BATHS , ad.getBaths());;
        values.put(COLUMN_TYPE , ad.getFlatType());;
        values.put(COLUMN_LIFT , ad.getHasLift());;
        values.put(COLUMN_PARKING , ad.getHasParking());;
        values.put(COLUMN_RENT , ad.getRent());;
        values.put(COLUMN_DESCRIPTION , ad.getDescription());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ADS , null , values);
        db.close();
    }





    public boolean isRegistered(String username , String password){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNTS + " WHERE username=\"" +username+"\" AND password=\"" +
                password + "\""
                ,null);

        boolean val = false;
        if(cursor.moveToFirst()){
            val = true;
        }
        return  val;

    }


    public void DeleteAd(Ads ad){
        SQLiteDatabase db= getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_ADS + " WHERE " +
            COLUMN_USER_NAME + "=\"" + ad.getUsername() + "\"" + " and "+
                COLUMN_PASSWORD + "=\"" + ad.getPassword() + "\"" + " and "+
                COLUMN_LOCATION + "=\"" + ad.getLocation() + "\"" + " and "+
                COLUMN_ROAD_NO + "=\"" + ad.getRoadNumber() + "\"" + " and "+
                COLUMN_FLOOR + "=\"" + ad.getFloor() + "\"" + " and "+
                COLUMN_SIZE + "=\"" + ad.getSize() + "\"" + " and "+
                COLUMN_ROOMS + "=\"" + ad.getRooms() + "\"" + " and "+
                COLUMN_BEDS + "=\"" + ad.getBeds() + "\"" + " and "+
                COLUMN_BATHS + "=\"" + ad.getBaths() + "\"" + " and "+
                COLUMN_TYPE + "=\"" + ad.getFlatType() + "\"" + " and "+
                COLUMN_RENT + "=\"" + ad.getRent() + "\""

        );

    }
    
    
    
    

    
    
    
    public ArrayList<Ads> fetchMyAds(String username , String password){
        ArrayList<Ads> ads = new ArrayList<>();
        
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ADS + " WHERE username=\"" +username+"\" AND password=\"" +
                        password + "\""
                ,null
        );
        
        Ads adObject = null;
        if(cursor.moveToFirst()){
            do{
                adObject = new Ads();
                adObject.setId(Integer.parseInt(cursor.getString(0)));
                adObject.setUsername(cursor.getString(1));
                adObject.setPassword(cursor.getString(2));
                adObject.setLocation(cursor.getString(3));
                adObject.setHouseNumber(cursor.getString(4));
                adObject.setRoadNumber(cursor.getString(5));
                adObject.setFloor(cursor.getString(6));
                adObject.setSize(cursor.getString(7));
                adObject.setRooms(cursor.getString(8));
                adObject.setBeds(cursor.getString(9));
                adObject.setBaths(cursor.getString(10));
                adObject.setFlatType(cursor.getString(11));
                adObject.setHasLift(cursor.getString(12));
                adObject.setHasParking(cursor.getString(13));
                adObject.setRent(cursor.getString(14));
                adObject.setDescription(cursor.getString(15));
                ads.add(adObject);
            }while( cursor.moveToNext());

        }
        return  ads;
    }


    public ArrayList<Ads> fetchAllAds(){
        ArrayList<Ads> ads = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ADS + " WHERE 1"
                ,null
        );

        Ads adObject = null;
        if(cursor.moveToFirst()){
            do{
                adObject = new Ads();
                adObject.setId(Integer.parseInt(cursor.getString(0)));
                adObject.setUsername(cursor.getString(1));
                adObject.setPassword(cursor.getString(2));
                adObject.setLocation(cursor.getString(3));
                adObject.setHouseNumber(cursor.getString(4));
                adObject.setRoadNumber(cursor.getString(5));
                adObject.setFloor(cursor.getString(6));
                adObject.setSize(cursor.getString(7));
                adObject.setRooms(cursor.getString(8));
                adObject.setBeds(cursor.getString(9));
                adObject.setBaths(cursor.getString(10));
                adObject.setFlatType(cursor.getString(11));
                adObject.setHasLift(cursor.getString(12));
                adObject.setHasParking(cursor.getString(13));
                adObject.setRent(cursor.getString(14));
                adObject.setDescription(cursor.getString(15));
                ads.add(adObject);
            }while( cursor.moveToNext());

        }
        return  ads;
    }





    public ArrayList<Accounts> getAccount( String username , String password){
        ArrayList<Accounts> accounts = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNTS + " WHERE username=\"" +username+"\" AND password=\"" +
                        password + "\""
                ,null
        );


        Accounts account = null;
        if(cursor.moveToFirst()){
            do{
                account = new Accounts();
                account.setId( Integer.parseInt(cursor.getString(0)));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                accounts.add(account);
            }while(cursor.moveToNext());
        }


        Log.d("getallbooks()" , accounts.toString());
        return accounts;
    }



















    public ArrayList<Ads> readAdsDatabase(String username , String password){
        ArrayList<Ads> myAdsArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+
                TABLE_ADS + " WHERE username = " + "\"" + username + "\"" +
                " and password = " + "\"" + password + "\";";

        Cursor cursor = db.rawQuery(query , null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("username")) != null){
                Ads objects = new Ads(cursor.getString(cursor.getColumnIndex("username")),
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
    
    
    
    public void updateAd(Ads newad , Ads oldad){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        
        values.put(COLUMN_LOCATION, newad.getLocation());
        values.put(COLUMN_HOUSE_NO, newad.getHouseNumber());
        values.put(COLUMN_ROAD_NO, newad.getRoadNumber());
        values.put(COLUMN_FLOOR, newad.getFloor());
        values.put(COLUMN_SIZE, newad.getSize());
        values.put(COLUMN_ROOMS, newad.getRooms());
        values.put(COLUMN_BEDS, newad.getBeds());
        values.put(COLUMN_BATHS, newad.getBaths());
        values.put(COLUMN_TYPE, newad.getFlatType());
        values.put(COLUMN_LIFT, newad.getHasLift());
        values.put(COLUMN_PARKING, newad.getHasParking());
        values.put(COLUMN_RENT, newad.getRent());
        values.put(COLUMN_DESCRIPTION, newad.getDescription());


        String ss =  COLUMN_LOCATION + "=\""+ newad.getLocation() + "\" " +
                COLUMN_HOUSE_NO+ "=\""+ newad.getHouseNumber() + "\" " +
                COLUMN_ROAD_NO + "=\""+newad.getRoadNumber() + "\" " +
                COLUMN_FLOOR + "=\""+newad.getFloor() + "\" " +
                COLUMN_SIZE + "=\""+newad.getSize() + "\" " +
                COLUMN_ROOMS + "=\""+newad.getRooms() + "\" " +
                COLUMN_BEDS + "=\""+newad.getBeds() + "\" " +
                COLUMN_BATHS+ "=\""+ newad.getBaths() + "\" " +
                COLUMN_TYPE + "=\""+newad.getFlatType() + "\" " +
                COLUMN_LIFT + "=\""+newad.getHasLift() + "\" " +
                COLUMN_PARKING + "=\""+newad.getHasParking() + "\" " +
                COLUMN_RENT+ "=\""+ newad.getRent() + "\" " +
                COLUMN_DESCRIPTION + "=\""+newad.getDescription() + "\" ";
        
        
        
        String qq = " WHERE " + COLUMN_LOCATION + "=\""+ oldad.getLocation() + "\" " +
        COLUMN_HOUSE_NO+ "=\""+ oldad.getHouseNumber() + "\" " + 
        COLUMN_ROAD_NO + "=\""+oldad.getRoadNumber() + "\" " + 
        COLUMN_FLOOR + "=\""+oldad.getFloor() + "\" " + 
        COLUMN_SIZE + "=\""+oldad.getSize() + "\" " + 
        COLUMN_ROOMS + "=\""+oldad.getRooms() + "\" " + 
        COLUMN_BEDS + "=\""+oldad.getBeds() + "\" " + 
        COLUMN_BATHS+ "=\""+ oldad.getBaths() + "\" " + 
        COLUMN_TYPE + "=\""+oldad.getFlatType() + "\" " + 
        COLUMN_LIFT + "=\""+oldad.getHasLift() + "\" " + 
        COLUMN_PARKING + "=\""+oldad.getHasParking() + "\" " + 
        COLUMN_RENT+ "=\""+ oldad.getRent() + "\" " + 
        COLUMN_DESCRIPTION + "=\""+oldad.getDescription() + "\" ";
        
        
        db.execSQL("UPDATE " + TABLE_ADS + " SET WHERE location =\"" + "mirpur\"");
        db.close();
    }
    
}
