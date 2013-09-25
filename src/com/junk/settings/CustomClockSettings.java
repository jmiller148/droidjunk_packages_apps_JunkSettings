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
	private final String SHOW_CLOCK = "show_clock";
	private final String CLOCK_AMPM = "clock_ampm";
	private final String CLOCK_SIZE = "clock_size";
	private final String CLOCK_COLOR = "clock_color";
    
	private PreferenceManager prefMgr;
	private SharedPreferences sharedPref;
	private CheckBoxPreference mShowClock;
	private CheckBoxPreference mClockAmPm;
    private DJSeekBarPreference mClockSize;
	private Preference mClockColor;
    public int mSize = 17;
    


	
	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_PRIVATE);
        prefMgr.getSharedPreferences();

        addPreferencesFromResource(R.xml.custom_clock_settings);
        
        mShowClock = (CheckBoxPreference) findPreference(SHOW_CLOCK);
		mShowClock.setOnPreferenceChangeListener(this);
        mClockAmPm = (CheckBoxPreference) findPreference(CLOCK_AMPM);
		mClockAmPm.setOnPreferenceChangeListener(this);
        mClockColor = (Preference) findPreference(CLOCK_COLOR);
		mClockColor.setOnPreferenceChangeListener(this);
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

        if (SHOW_CLOCK.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(SHOW_CLOCK, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        } else if (CLOCK_AMPM.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(CLOCK_AMPM, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
        
        } else if (CLOCK_COLOR.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Clock_Settings );
            i.putExtra(CLOCK_COLOR, (Integer) objValue);
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
