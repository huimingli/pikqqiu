package com.celt.estation.template.base;



import android.app.Application;
import android.app.Service;
import android.os.Vibrator;
import android.util.Log;

public class BaseApp extends Application {
	private static final String TAG = "DemoApplication";
	 public Vibrator mVibrator;
 	public double lat = 0;
	public double lng = 0; 
	
	private String s;
	private long l;
	private int i;
	
	public int getInt () {
		return i;
	}
	
	public void setInt (int i) {
		this.i = i;
	}
	
	public long getLong () {
		return l;
	}
	
	public void setLong (long l) {
		this.l = l;
	}
	
	public String getString () {
		return s;
	}
	
	public void setString (String s) {
		this.s = s;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	 	Log.i("BaiduLocationApiDem", "init success");

		
		mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
	}



		


	}
