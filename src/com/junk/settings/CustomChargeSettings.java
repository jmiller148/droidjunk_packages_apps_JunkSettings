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
import android.preference.DJSeekBarPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;



public class CustomChargeSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
    private final String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";

	private final String CHARGING_LEVEL_ONE = "charge_levels_one";
	private final String CHARGING_LEVEL_TWO = "charge_levels_two";

	


	private PreferenceManager prefMgr;
	private SharedPreferences sharedPref;
	private DJSeekBarPreference mChargingLevelOne;
	private DJSeekBarPreference mChargingLevelTwo;
    
    public int chargeLevelOne = 10;
    public int chargeLevelTwo = 30;


	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
        sharedPref = prefMgr.getSharedPreferences();
        
        addPreferencesFromResource(R.xml.custom_charging_settings);
 
		mChargingLevelOne = (DJSeekBarPreference) findPreference(CHARGING_LEVEL_ONE);
		mChargingLevelOne.setOnPreferenceChangeListener(this);
		chargeLevelOne = sharedPref.getInt(CHARGING_LEVEL_ONE, chargeLevelOne);
		mChargingLevelOne.setMax(100);
		mChargingLevelOne.setProgress(chargeLevelOne);
		mChargingLevelTwo = (DJSeekBarPreference) findPreference(CHARGING_LEVEL_TWO);
		mChargingLevelTwo.setOnPreferenceChangeListener(this);
		chargeLevelTwo = sharedPref.getInt(CHARGING_LEVEL_TWO, chargeLevelTwo);
		mChargingLevelTwo.setMax(100);
		mChargingLevelTwo.setProgress(chargeLevelTwo);
        resendIntents();
    }

    
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }


                 
                 
    public boolean onPreferenceChange(Preference preference, Object objValue) {
    	  
     	final String key = preference.getKey();


        if (CHARGING_LEVEL_ONE.equals(key)) {
        	chargeLevelOne = (Integer) objValue;
        	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(CHARGING_LEVEL_ONE, chargeLevelOne);
            getActivity().sendBroadcast(i);
            i = null;

        
        } else if (CHARGING_LEVEL_TWO.equals(key)) {
        	chargeLevelTwo = (Integer) objValue;
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(CHARGING_LEVEL_TWO, chargeLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;

        }
        resendIntents();
        return true;
    }
 
    

    
    private void resendIntents() {
    	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings );
            i.putExtra(CHARGING_LEVEL_ONE, chargeLevelOne);
            getActivity().sendBroadcast(i);
            i = null;
        
            i = new Intent();
            i.setAction(Junk_Battery_Settings );
            i.putExtra(CHARGING_LEVEL_TWO, chargeLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;
        
    	
    }
    
} 