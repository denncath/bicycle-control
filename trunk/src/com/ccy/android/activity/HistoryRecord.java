package com.ccy.android.activity;

import java.text.SimpleDateFormat;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HistoryRecord {
	private int UID;
	private String location;
	private String time;
	private int activity;
	private String RFID="";
	
	HistoryRecord(int id,String loc, String tm, int act, String rfid)
	{
		UID = id;
		location = loc;
		time = tm;
		activity =act;
		RFID = rfid;
	}
	public int getUID()
	{
		return UID;
	}
	public String getLocation()
	{
		return location;
	}
	public String getTime()
	{
		return time;
	}
	public int getActivity()
	{
		return activity;
	}
	public String getRFID()
	{
		return RFID;
	}
	
	public void add(SQLiteDatabase db)
	{
		ContentValues cv = new ContentValues();
		cv.put("uid",UID);
		cv.put("location", location);
		cv.put("time", time);
		cv.put("activity", activity);
		cv.put("RFID", RFID);
		db.insert("record", null, cv);
	}
	
	public static void insert(int act, String rfid, int uid)
	{
//		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sDateFormat = new SimpleDateFormat("hh:mm:ss");
		String time = sDateFormat.format(new java.util.Date());
		Log.i(MainActivity.DEBUG_TAG,time);
		HistoryRecord historyRecord = new HistoryRecord(uid,"����",time,act,rfid);
		historyRecord.add(MainActivity.db);
	}
}


