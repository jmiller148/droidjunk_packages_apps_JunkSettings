/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.junk.settings;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.DJSeekBarPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;



public class CustomClockSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
	private final String Junk_Clock_Settings = "JUNK_CLOCK_SETTINGS";
	private final String SHOW_CLOCK_LEFT = "show_clock_left";
	private final String SHOW_CLOCK_CENTER = "show_clock_center";
	private final String SHOW_CLOCK_RIGHT = "show_clock_right";
	private final String CLOCK_AMPM = "clock_ampm";
	private final String CLOCK_SIZE = "clock_size";
    
	private PreferenceManager prefMgr;
	private SharedPreferences sharedPref;
	private CheckBoxPreference mShowClockLeft;
	private CheckBoxPreference mShowClockCenter;
	private CheckBoxPreference mShowClockRight;
	private CheckBoxPreference mClockAmPm;
    private DJSeekBarPreference mClockSize;
    public int mSize = 17;
    


	
	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();

        addPreferencesFromResource(R.xml.custom_clock_settings);
        
        mShowClockLeft = (CheckBoxPreference) findPreference(SHOW_CLOCK_LEFT);
		mShowClockLeft.setOnPreferenceChangeListener(this);
        mShowClockCenter = (CheckBoxPreference) findPreference(SHOW_CLOCK_CENTER);
		mShowClockCenter.setOnPreferenceChangeListener(this);
        mShowClockRight = (CheckBoxPreference) findPreference(SHOW_CLOCK_RIGHT);
		mShowClockRight.setOnPreferenceChangeListener(this);
        mClockAmPm = (CheckBoxPreference) findPreference(CLOCK_AMPM);
		mClockAmPm.setOnPreferenceChangeListener(this);
	    mClockSize = (DJSeekBarPreference) findPreference(CLOCK_SIZE);
		mClockSize.setOnPreferenceChangeListener(this);
		mSize = prefMgr.getSharedPreferences().getInt(CLOCK_SIZE, 17);  
		mClockSize.setMin(10);
		mClockSize.setMax(20);
		mClockSize.setProgress(mSize);
    }

    
    @Override
    public void onResume() {
        super.onResume();
    }

    
    @Override
    public void onPause() {
        super.onPause();
    }

 
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
    
 
    
    
    public boolean onPreferenceChange(Preference preference, Object objValue) {
  
     	final String key = preference.getKey();

        if (SHOW_CLOCK_LEFT.equals(key)) {
    		mShowClockCenter.setChecked(false);
    		mShowClockRight.setChecked(false);
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_LEFT, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_CENTER, false);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_RIGHT, false);
            getActivity().sendBroadcast(i);
            i = null;

        } else if (SHOW_CLOCK_CENTER.equals(key)) {
    		mShowClockLeft.setChecked(false);
    		mShowClockRight.setChecked(false);
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_CENTER, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_LEFT, false);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_RIGHT, false);
            getActivity().sendBroadcast(i);
            i = null;
            
            
        } else if (SHOW_CLOCK_RIGHT.equals(key)) {
    		mShowClockCenter.setChecked(false);
    		mShowClockLeft.setChecked(false);
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_RIGHT, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_LEFT, false);
            getActivity().sendBroadcast(i);
            i = null;
            
        	i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK_CENTER, false);
            getActivity().sendBroadcast(i);
            i = null;

            
        } else if (CLOCK_AMPM.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(CLOCK_AMPM, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
        
        } else if (CLOCK_SIZE.equals(key)) {

        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(CLOCK_SIZE, (Integer) objValue + 10);
            getActivity().sendBroadcast(i);
            i = null;
        }
       return true;
    }
    
    
    
}
