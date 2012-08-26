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
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;



public class CustomBatteryIconSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

	private final String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";
	private final String BATTERY_ICONS = "battery_icon_num";
	private final String BATTERY_STOCK = "battery_stock";
	private final String BATTERY_NUMBER = "battery_number";
	private final String BATTERY_CIRCLE = "battery_circle";
	private final String BATTERY_PIE = "battery_pie";
	private final String BATTERY_THINKING = "battery_thinking";
	private final String BATTERY_DOT = "battery_dot";
	private final String BATTERY_NONE = "battery_none";

	private PreferenceManager prefMgr;

	private CheckBoxPreference mBatteryStock;
    private CheckBoxPreference mBatteryNumber;
    private CheckBoxPreference mBatteryCircle;
    private CheckBoxPreference mBatteryPie;
    private CheckBoxPreference mBatteryThinking;
    private CheckBoxPreference mBatteryDot;
    private CheckBoxPreference mBatteryNone;
    
    private SharedPreferences sp;
    private int mBatteryNum = 0;
	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
 
       	addPreferencesFromResource(R.xml.custom_battery_icons);
       	
       	mBatteryStock = (CheckBoxPreference) findPreference(BATTERY_STOCK);
       	mBatteryStock.setOnPreferenceChangeListener(this);	
       	mBatteryNumber = (CheckBoxPreference) findPreference(BATTERY_NUMBER);
       	mBatteryNumber.setOnPreferenceChangeListener(this);
       	mBatteryCircle = (CheckBoxPreference) findPreference(BATTERY_CIRCLE);
       	mBatteryCircle.setOnPreferenceChangeListener(this);
       	mBatteryPie = (CheckBoxPreference) findPreference(BATTERY_PIE);
       	mBatteryPie.setOnPreferenceChangeListener(this);
       	mBatteryThinking = (CheckBoxPreference) findPreference(BATTERY_THINKING);
       	mBatteryThinking.setOnPreferenceChangeListener(this);
       	mBatteryDot = (CheckBoxPreference) findPreference(BATTERY_DOT);
       	mBatteryDot.setOnPreferenceChangeListener(this);
       	mBatteryNone = (CheckBoxPreference) findPreference(BATTERY_NONE);
       	mBatteryNone.setOnPreferenceChangeListener(this);

        mBatteryStock.setChecked(false);
		mBatteryNumber.setChecked(false);
		mBatteryCircle.setChecked(false);
		mBatteryPie.setChecked(false);
		mBatteryThinking.setChecked(false);
		mBatteryDot.setChecked(false);
		mBatteryNone.setChecked(false);
		
        sp = prefMgr.getSharedPreferences();
        mBatteryNum = sp.getInt(BATTERY_ICONS, 0);
		
       	if (mBatteryNum == 0) {
       		mBatteryStock.setChecked(true);
       	} else if (mBatteryNum == 1) {
       		mBatteryNumber.setChecked(true);
       	} else if (mBatteryNum == 2) {
       		mBatteryCircle.setChecked(true);
       	} else if (mBatteryNum == 3) {
        		mBatteryPie.setChecked(true);
       	} else if (mBatteryNum == 4) {
    		mBatteryThinking.setChecked(true);
       	} else if (mBatteryNum == 5) {
    		mBatteryDot.setChecked(true);
       	} else if (mBatteryNum == 6) {
    		mBatteryNone.setChecked(true);
       	}
       	 
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
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

                 
    public boolean onPreferenceChange(Preference preference, Object objValue) {
    	if (preference == mBatteryStock) {
    		mBatteryStock.setChecked(true);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 0);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 0);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	} else if (preference == mBatteryNumber) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(true);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 1);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 1);
            getActivity().sendBroadcast(i);
            i = null;  			
    	
    	} else if (preference == mBatteryCircle) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(true);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 2);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 2);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	} else if (preference == mBatteryPie) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(true);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 3);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 3);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	} else if (preference == mBatteryThinking) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(true);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 4);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 4);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	} else if (preference == mBatteryDot) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(true);
    		mBatteryNone.setChecked(false);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 5);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 5);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	} else if (preference == mBatteryNone) {
    		mBatteryStock.setChecked(false);
    		mBatteryNumber.setChecked(false);
    		mBatteryCircle.setChecked(false);
    		mBatteryPie.setChecked(false);
    		mBatteryThinking.setChecked(false);
    		mBatteryDot.setChecked(false);
    		mBatteryNone.setChecked(true);
    		
           	sp = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sp.edit();
            editor.putInt(BATTERY_ICONS, 6);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_ICONS, 6);
            getActivity().sendBroadcast(i);
            i = null;  			
    		
    	}
        return false;
    }
 
    

    
 
} 