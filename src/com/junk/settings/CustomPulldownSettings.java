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
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.DJSeekBarPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;


public class CustomPulldownSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
	private final String Junk_Pulldown_Settings = "JUNK_PULLDOWN_SETTINGS";
	private final String SHOW_BATTERY_LABEL = "show_battery_label";
	private final String BATTERY_LABEL_SIZE = "battery_label_size";
	private final String SHOW_TEMP_LABEL = "show_temp_label";
	private final String TEMP_LABEL_SIZE = "temp_label_size";
	private final String SHOW_CARRIER = "show_carrier";
	private final String CARRIER_CUSTOM = "carrier_custom";
	private final String CARRIER_CUSTOM_TEXT = "carrier_custom_text";
	private final String CARRIER_SIZE = "carrier_size";
	private final String DATE_SIZE = "date_size";
    
	private PreferenceManager prefMgr;
	private CheckBoxPreference mShowCarrier;
	private CheckBoxPreference mShowBattery;
	private CheckBoxPreference mShowTemp;

    private CheckBoxPreference mCarrierCustom;
    private Preference mCarrierCustomText;
    private DJSeekBarPreference mCarrierSize;
    private DJSeekBarPreference mBatterySize;
    private DJSeekBarPreference mTempSize;
    public int carrierSize = 15;
    public int batterySize = 12;
    public int tempSize = 12;
    private DJSeekBarPreference mDateSize;
    public int dateSize = 17;
    
    
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
       
        addPreferencesFromResource(R.xml.custom_pulldown_settings);
        
        mShowCarrier = (CheckBoxPreference) findPreference(SHOW_CARRIER);
		mShowCarrier.setOnPreferenceChangeListener(this);
        mShowBattery = (CheckBoxPreference) findPreference(SHOW_BATTERY_LABEL);
		mShowBattery.setOnPreferenceChangeListener(this);
	    mBatterySize = (DJSeekBarPreference) findPreference(BATTERY_LABEL_SIZE);
		mBatterySize.setOnPreferenceChangeListener(this);
		batterySize = prefMgr.getSharedPreferences().getInt(BATTERY_LABEL_SIZE, batterySize);  
		mBatterySize.setMin(5);
		mBatterySize.setMax(25);
		mBatterySize.setProgress(batterySize);
        mShowTemp = (CheckBoxPreference) findPreference(SHOW_TEMP_LABEL);
		mShowTemp.setOnPreferenceChangeListener(this);
	    mTempSize = (DJSeekBarPreference) findPreference(TEMP_LABEL_SIZE);
		mTempSize.setOnPreferenceChangeListener(this);
		tempSize = prefMgr.getSharedPreferences().getInt(TEMP_LABEL_SIZE, tempSize);
		mTempSize.setMin(5);
		mTempSize.setMax(25);
		mTempSize.setProgress(tempSize);
        mCarrierCustom = (CheckBoxPreference) findPreference(CARRIER_CUSTOM);
		mCarrierCustom.setOnPreferenceChangeListener(this);
        mCarrierCustomText = (Preference) findPreference(CARRIER_CUSTOM_TEXT);
		mCarrierCustomText.setOnPreferenceChangeListener(this);
	    mCarrierSize = (DJSeekBarPreference) findPreference(CARRIER_SIZE);
		mCarrierSize.setOnPreferenceChangeListener(this);
		carrierSize = prefMgr.getSharedPreferences().getInt(CARRIER_SIZE, carrierSize);  
		mCarrierSize.setMin(5);
		mCarrierSize.setMax(25);
		mCarrierSize.setProgress(carrierSize);
		mDateSize = (DJSeekBarPreference) findPreference(DATE_SIZE);
		mDateSize.setOnPreferenceChangeListener(this);
		dateSize = prefMgr.getSharedPreferences().getInt(DATE_SIZE, dateSize);  
		mDateSize.setMin(5);
		mDateSize.setMax(25);
		mDateSize.setProgress(dateSize);

		
		
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
        if (SHOW_CARRIER.equals(key)) {
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
       	   	i.putExtra(SHOW_CARRIER, (Boolean) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;
       	   	
        } else if (SHOW_BATTERY_LABEL.equals(key)) {
           	Intent i = new Intent();
           	i.setAction(Junk_Pulldown_Settings );
       	   	i.putExtra(SHOW_BATTERY_LABEL, (Boolean) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	
           	   	
        } else if (BATTERY_LABEL_SIZE.equals(key)) {
        	batterySize = (Integer) objValue + 5;
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(BATTERY_LABEL_SIZE, (Integer) batterySize);
            getActivity().sendBroadcast(i);
            i = null;            

        } else if (TEMP_LABEL_SIZE.equals(key)) {
        	tempSize = (Integer) objValue + 5;
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(TEMP_LABEL_SIZE, (Integer) tempSize);
            getActivity().sendBroadcast(i);
            i = null;             
            
        } else if (SHOW_TEMP_LABEL.equals(key)) {
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
       	   	i.putExtra(SHOW_TEMP_LABEL, (Boolean) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;               	   	
           	   	
        } else if (CARRIER_CUSTOM.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(CARRIER_CUSTOM, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
              
        } else if (CARRIER_CUSTOM_TEXT.equals(key)) {
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(CARRIER_CUSTOM_TEXT, (String) objValue);
            getActivity().sendBroadcast(i);
            i = null;
        	
        } else if (CARRIER_SIZE.equals(key)) {
        	carrierSize = (Integer) objValue + 5;
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(CARRIER_SIZE, (Integer) carrierSize);
            getActivity().sendBroadcast(i);
            i = null;
        	
        } else if (DATE_SIZE.equals(key)) {
        	dateSize = (Integer) objValue + 5;
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(DATE_SIZE, (Integer) dateSize);
            getActivity().sendBroadcast(i);
            i = null;
        	
        }
        
        return true;
    }
    
    
    
}
