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
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.ColorPickerPreference;
import android.util.Log;
import android.widget.ListView;



public class CustomColorGroups extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

	
	private final String COLOR_GROUP_SIGNAL_ICON = "signal_icon_color";
	private final String COLOR_GROUP_BATTERY_ICONS = "battery_icons_color";
	private final String COLOR_GROUP_BATTERY_EXTRAS = "battery_extras_color";
	private final String COLOR_GROUP_CHARGING_ICON = "charging_icon_color";
	private final String COLOR_GROUP_NAVBAR = "navbar_color";
	private final String COLOR_GROUP_CLOCK = "clock_color";
	private final String COLOR_GROUP_PD_NOTIF = "pd_notif_colors";
	private final String COLOR_GROUP_PD = "pd_colors";
	private final String COLOR_GROUP_TOGGLES = "toggle_colors";

	private PreferenceManager prefMgr;

	private Preference mIconColor;
    private Preference mBatteryIconColors;
    private Preference mBatteryExtraColors;
    private Preference mChargingIconColors;
    private Preference mNavBarColors;
    private Preference mClockColors;
    private Preference mPDNotifColors;
    private Preference mPDColors;
    private Preference mToggleColors;
    
    private int rowid = 0;

	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        rowid = getActivity().getIntent().getIntExtra("junk_color_rowid", 0); 
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
 
       	addPreferencesFromResource(R.xml.custom_color_groups);
       	
        mIconColor = (Preference) findPreference(COLOR_GROUP_SIGNAL_ICON);
		mIconColor.setOnPreferenceChangeListener(this);	
		mBatteryIconColors = (Preference) findPreference(COLOR_GROUP_BATTERY_ICONS);
		mBatteryIconColors.setOnPreferenceChangeListener(this);
		mBatteryExtraColors = (Preference) findPreference(COLOR_GROUP_BATTERY_EXTRAS);
		mBatteryExtraColors.setOnPreferenceChangeListener(this);
		mChargingIconColors = (Preference) findPreference(COLOR_GROUP_CHARGING_ICON);
		mChargingIconColors.setOnPreferenceChangeListener(this);
		mNavBarColors = (Preference) findPreference(COLOR_GROUP_NAVBAR);
		mNavBarColors.setOnPreferenceChangeListener(this);
		mClockColors = (Preference) findPreference(COLOR_GROUP_CLOCK);
		mClockColors.setOnPreferenceChangeListener(this);
		mPDNotifColors = (Preference) findPreference(COLOR_GROUP_PD_NOTIF);
		mPDNotifColors.setOnPreferenceChangeListener(this);
		mPDColors = (Preference) findPreference(COLOR_GROUP_PD);
		mPDColors.setOnPreferenceChangeListener(this);
		mToggleColors = (Preference) findPreference(COLOR_GROUP_TOGGLES);
		mToggleColors.setOnPreferenceChangeListener(this);
    }

    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    	
    	if (preference == mIconColor) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 0);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mBatteryIconColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 2);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    	
    	} else if (preference == mBatteryExtraColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 9);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mChargingIconColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 16);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mNavBarColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 20);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mClockColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 24);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mPDNotifColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 26);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mPDColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 30);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	} else if (preference == mToggleColors) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_COLOR_SETTINGS");
		    i.putExtra("junk_color_rowid", 42);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    	}
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

                 
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        return false;
    }
 
    

    
 
} 