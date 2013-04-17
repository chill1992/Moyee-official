package com.example.moyeecoffee;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Preferences {
	SharedPreferences preferences;
	Editor editor;
	
	Preferences(Activity activity){
		preferences = activity.getSharedPreferences("preferences", 0);
		editor = preferences.edit();
	}
	
	//getters
	
	public boolean getBoolean(String key)
	{
		return preferences.getBoolean(key, false);
	}
	
	public void clearPreferences(){
		editor.clear();
		editor.commit();
	}
	
	public float getFloat(String key)
	{
		return preferences.getFloat(key, 0);
	}
	
	public int getInt(String key)
	{
		return preferences.getInt(key, 0);
	}
	
	public long getLong(String key)
	{
		return preferences.getLong(key, 0);
	}
	
	public String getString(String key)
	{
		return preferences.getString(key, "");
	}
	
	//setters
	
	public void setBoolean(String key, boolean value){
		editor.putBoolean(key, value);
		editor.commit();
	}
	
	public void setFloat(String key, float value){
		editor.putFloat(key, value);
		editor.commit();
	}
	
	public void setInt(String key, int value){
		editor.putInt(key, value);
		editor.commit();
	}
	
	public void setLong(String key, long value){
		editor.putLong(key, value);
		editor.commit();
	}
	
	public void setString(String key, String value){
		editor.putString(key, value);
		editor.commit();
	}
}
