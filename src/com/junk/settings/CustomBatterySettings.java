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
import android.preference.CheckBoxPreference;



public class CustomBatterySettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
    private final String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";
	private final String BATTERY_ICONS = "battery_icon_num";
	private final String BATTERY_BAR_BOTTOM = "battery_bar_bottom";
	private final String BATTERY_BAR_RIGHT = "battery_bar_right";
	private final String BATTERY_BAR_WIDTH = "battery_bar_width";
	private final String BATTERY_LEVEL_ONE = "battery_levels_one";
	private final String BATTERY_LEVEL_TWO = "battery_levels_two";
	
	private final String DEPLETED_LEVEL_ONE = "depleted_levels_one";
	private final String DEPLETED_LEVEL_TWO = "depleted_levels_two";

	private final String BATTERY_SHOW_CIRCLE = "battery_show_circle";
	private final String BATTERY_SHOW_SQUARE = "battery_show_square";
	private final String BATTERY_SHOW_NUMBER = "battery_show_number";
	
	
	private final int BATTERY_STOCK = 0;
    private final int BATTERY_NUMBER = 1;
    private final int BATTERY_CIRCLE = 2;
    private final int BATTERY_PIE = 3;
    private final int BATTERY_THINKING_MAN = 4;
    private final int BATTERY_THE_DOT = 5;
    private final int BATTERY_NONE = 6;

	private PreferenceManager prefMgr;
	private SharedPreferences sp;
	private int mBatteryIconValue = 0;
	
	private CheckBoxPreference mBatteryShowCircle;
	private CheckBoxPreference mBatteryShowSquare;
	private CheckBoxPreference mBatteryShowNumber;
	
	private CheckBoxPreference mBatteryBarBottom;
	private CheckBoxPreference mBatteryBarRight;
	
	private DJSeekBarPreference mBatteryBarWidth;
	private DJSeekBarPreference mBatteryLevelOne;
	private DJSeekBarPreference mBatteryLevelTwo;
    
	private DJSeekBarPreference mDepletedLevelOne;
	private DJSeekBarPreference mDepletedLevelTwo;
    
    private int batBarWidth = 5;
    private int batLevelOne = 10;
    private int batLevelTwo = 30;

    private int depletedLevelOne = 10;
    private int depletedLevelTwo = 30;
	
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
        sp = prefMgr.getSharedPreferences();
        
        mBatteryIconValue = sp.getInt(BATTERY_ICONS, 0);
 
        // Set the preferences based on what battery is chosen

		batLevelOne = sp.getInt(BATTERY_LEVEL_ONE, 10);
		batLevelTwo = sp.getInt(BATTERY_LEVEL_TWO, 30);
		batBarWidth = sp.getInt(BATTERY_BAR_WIDTH, 5);
		depletedLevelOne = sp.getInt(DEPLETED_LEVEL_ONE, 10);
		depletedLevelTwo = sp.getInt(DEPLETED_LEVEL_TWO, 30);

        
        switch (mBatteryIconValue) {

        case BATTERY_STOCK:
        	addPreferencesFromResource(R.xml.custom_bat_stock_settings);
    		
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;
            
        case BATTERY_NUMBER:
        	addPreferencesFromResource(R.xml.custom_bat_number_settings);
    		
            mBatteryShowCircle = (CheckBoxPreference) findPreference(BATTERY_SHOW_CIRCLE);
    		mBatteryShowCircle.setOnPreferenceChangeListener(this);
    		mBatteryShowSquare = (CheckBoxPreference) findPreference(BATTERY_SHOW_SQUARE);
    		mBatteryShowSquare.setOnPreferenceChangeListener(this);
            mBatteryBarBottom = (CheckBoxPreference) findPreference(BATTERY_BAR_BOTTOM);
    		mBatteryBarBottom.setOnPreferenceChangeListener(this);
            mBatteryBarRight = (CheckBoxPreference) findPreference(BATTERY_BAR_RIGHT);
    		mBatteryBarRight.setOnPreferenceChangeListener(this);
            mBatteryBarWidth = (DJSeekBarPreference) findPreference(BATTERY_BAR_WIDTH);
    		mBatteryBarWidth.setOnPreferenceChangeListener(this);
    		mBatteryBarWidth.setMax(5);
    		mBatteryBarWidth.setMin(1);
    		mBatteryBarWidth.setProgress(batBarWidth);
    		
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		
    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;

        case BATTERY_CIRCLE:
        	addPreferencesFromResource(R.xml.custom_bat_circle_settings);
 
            mBatteryShowNumber = (CheckBoxPreference) findPreference(BATTERY_SHOW_NUMBER);
    		mBatteryShowNumber.setOnPreferenceChangeListener(this);
        	
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		
    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;

        case BATTERY_PIE:
        	addPreferencesFromResource(R.xml.custom_bat_circle_settings);

            mBatteryShowNumber = (CheckBoxPreference) findPreference(BATTERY_SHOW_NUMBER);
    		mBatteryShowNumber.setOnPreferenceChangeListener(this);
    		
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		
    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;  
            
        case BATTERY_THINKING_MAN:
        	addPreferencesFromResource(R.xml.custom_bat_clock_settings);

            mBatteryShowCircle = (CheckBoxPreference) findPreference(BATTERY_SHOW_CIRCLE);
    		mBatteryShowCircle.setOnPreferenceChangeListener(this);

            mBatteryShowNumber = (CheckBoxPreference) findPreference(BATTERY_SHOW_NUMBER);
    		mBatteryShowNumber.setOnPreferenceChangeListener(this);
    		
        	
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		
    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;
            
            
        case BATTERY_THE_DOT:
        	addPreferencesFromResource(R.xml.custom_bat_pointer_settings);

            mBatteryShowCircle = (CheckBoxPreference) findPreference(BATTERY_SHOW_CIRCLE);
    		mBatteryShowCircle.setOnPreferenceChangeListener(this);
    		
            mBatteryShowNumber = (CheckBoxPreference) findPreference(BATTERY_SHOW_NUMBER);
    		mBatteryShowNumber.setOnPreferenceChangeListener(this);
        	
    		mBatteryLevelOne = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_ONE);
       		mBatteryLevelOne.setOnPreferenceChangeListener(this);
    		mBatteryLevelOne.setMax(100);
    		mBatteryLevelOne.setMin(0);
    		mBatteryLevelOne.setProgress(batLevelOne);
 
    		mBatteryLevelTwo = (DJSeekBarPreference) findPreference(BATTERY_LEVEL_TWO);
    		mBatteryLevelTwo.setOnPreferenceChangeListener(this);
    		mBatteryLevelTwo.setMax(100);
    		mBatteryLevelTwo.setMin(0);
    		mBatteryLevelTwo.setProgress(batLevelTwo);

    		
    		mDepletedLevelOne = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_ONE);
    		mDepletedLevelOne.setOnPreferenceChangeListener(this);
    		mDepletedLevelOne.setMax(100);
    		mDepletedLevelOne.setMin(0);
    		mDepletedLevelOne.setProgress(depletedLevelOne);

    		mDepletedLevelTwo = (DJSeekBarPreference) findPreference(DEPLETED_LEVEL_TWO);
    		mDepletedLevelTwo.setOnPreferenceChangeListener(this);
    		mDepletedLevelTwo.setMax(100);
    		mDepletedLevelTwo.setMin(0);
    		mDepletedLevelTwo.setProgress(depletedLevelTwo);
            break;
            
            
        case BATTERY_NONE:
            break;           
            
       default:
            break;
        } 
        
        resendIntents();
        
        
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


     	if (BATTERY_BAR_BOTTOM.equals(key)) {
        	if ((Boolean) objValue == true) {
        		mBatteryBarRight.setChecked(false);
        		
            	Intent i = new Intent();
            	i.setAction(Junk_Battery_Settings);
           	   	i.putExtra(BATTERY_BAR_RIGHT, false);
           	   	getActivity().sendBroadcast(i);
           	   	i = null;  
        	}
        	
        	Intent i = new Intent();
        	i.setAction(Junk_Battery_Settings);
       	   	i.putExtra(BATTERY_BAR_BOTTOM, (Boolean) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;    
 
        } else if (BATTERY_BAR_RIGHT.equals(key)) {
        	if ((Boolean) objValue == true) {
        		mBatteryBarBottom.setChecked(false);
        		
            	Intent i = new Intent();
            	i.setAction(Junk_Battery_Settings);
           	   	i.putExtra(BATTERY_BAR_BOTTOM, false);
           	   	getActivity().sendBroadcast(i);
           	   	i = null; 
        	}
        	
        	Intent i = new Intent();
        	i.setAction(Junk_Battery_Settings);
       	   	i.putExtra(BATTERY_BAR_RIGHT, (Boolean) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	   	
       	   	
        } else if (BATTERY_BAR_WIDTH.equals(key)) {

        	Intent i = new Intent();
        	i.setAction(Junk_Battery_Settings);
       	   	i.putExtra(BATTERY_BAR_WIDTH, (Integer) objValue + 1);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	   	
  
        } else if (BATTERY_SHOW_CIRCLE.equals(key)) {
            if (mBatteryIconValue == BATTERY_CIRCLE) {
            	mBatteryShowSquare.setChecked(false);
            	Intent i = new Intent();
            	i.setAction(Junk_Battery_Settings);
            	i.putExtra(BATTERY_SHOW_SQUARE, false);
            	getActivity().sendBroadcast(i);
                i = null;
            }
        	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_SHOW_CIRCLE, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        } else if (BATTERY_SHOW_SQUARE.equals(key)) {
            if (mBatteryIconValue == BATTERY_CIRCLE) {
                mBatteryShowCircle.setChecked(false);
            	Intent i = new Intent();
            	i.setAction(Junk_Battery_Settings);
            	i.putExtra(BATTERY_SHOW_CIRCLE, false);
            	getActivity().sendBroadcast(i);
                i = null;
            }

        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_SHOW_SQUARE, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            
        } else if (BATTERY_SHOW_NUMBER.equals(key)) {
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_SHOW_NUMBER, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
       	   	
        } else if (DEPLETED_LEVEL_ONE.equals(key)) {
        	depletedLevelOne = (Integer) objValue;
        	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_ONE, depletedLevelOne);
            getActivity().sendBroadcast(i);
            i = null;
        
        } else if (DEPLETED_LEVEL_TWO.equals(key)) {
        	depletedLevelTwo = (Integer) objValue;
            
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_TWO, depletedLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;
        
       	   	
        } else if (BATTERY_LEVEL_ONE.equals(key)) {
        	batLevelOne = (Integer) objValue;
        	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_LEVEL_ONE, batLevelOne);
            getActivity().sendBroadcast(i);
            i = null;
        
        } else if (BATTERY_LEVEL_TWO.equals(key)) {
        	batLevelTwo = (Integer) objValue;
        	
            Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_LEVEL_TWO, batLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;
        
        }
     	
     	
        return true;
    }
 
    

    
    private void resendIntents() {
    	
    		Intent i = new Intent();
    		i.setAction(Junk_Battery_Settings );
   	   		i.putExtra(BATTERY_ICONS, sp.getInt(BATTERY_ICONS, 0));
   	   		getActivity().sendBroadcast(i);
   	   		i = null;
 
    		i = new Intent();
    		i.setAction(Junk_Battery_Settings );
   	   		i.putExtra(BATTERY_SHOW_CIRCLE, sp.getBoolean(BATTERY_SHOW_CIRCLE, false));
   	   		getActivity().sendBroadcast(i);
   	   		i = null;

    		i = new Intent();
    		i.setAction(Junk_Battery_Settings );
   	   		i.putExtra(BATTERY_SHOW_NUMBER, sp.getBoolean(BATTERY_SHOW_NUMBER, false));
   	   		getActivity().sendBroadcast(i);
   	   		i = null;
   	   		
        	i = new Intent();
        	i.setAction(Junk_Battery_Settings );
       	   	i.putExtra(BATTERY_BAR_BOTTOM, sp.getBoolean(BATTERY_BAR_BOTTOM, false));
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	   	
 
        	i = new Intent();
        	i.setAction(Junk_Battery_Settings );
       	   	i.putExtra(BATTERY_BAR_RIGHT, sp.getBoolean(BATTERY_BAR_RIGHT, false));
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	   	

            i = new Intent();
        	i.setAction(Junk_Battery_Settings );
       	   	i.putExtra(BATTERY_BAR_WIDTH, sp.getInt(BATTERY_BAR_WIDTH, 5));
       	   	getActivity().sendBroadcast(i);
       	   	i = null;       	   	
       	   	
            i = new Intent();
            i.setAction(Junk_Battery_Settings );
            i.putExtra(BATTERY_LEVEL_ONE, batLevelOne);
            getActivity().sendBroadcast(i);
            i = null;
        
            i = new Intent();
            i.setAction(Junk_Battery_Settings );
            i.putExtra(BATTERY_LEVEL_TWO, batLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;
            
            i = new Intent();
            i.setAction(Junk_Battery_Settings );
            i.putExtra(DEPLETED_LEVEL_ONE, depletedLevelOne);
            getActivity().sendBroadcast(i);
            i = null;            

            i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_TWO, depletedLevelTwo);
            getActivity().sendBroadcast(i);
            i = null;

    }
    
} 