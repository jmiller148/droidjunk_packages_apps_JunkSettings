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
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.ColorPickerPreference;
import android.util.Log;
import android.widget.ListView;



public class CustomColorSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

	
	
	//Icons - Signal/Wifi
	private final String Junk_Icon_Settings = "JUNK_ICON_SETTINGS";
	private final String ICON_COLOR = "icon_color";
	
	// Battery
    private final String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";
	private final String BATTERY_CIRCLE_COLOR_ONE = "battery_circle_color_one";
	private final String BATTERY_CIRCLE_COLOR_TWO = "battery_circle_color_two";
	private final String BATTERY_CIRCLE_COLOR_THREE = "battery_circle_color_three";
	private final String BATTERY_NUMBER_COLOR_ONE = "battery_number_color_one";
	private final String BATTERY_NUMBER_COLOR_TWO = "battery_number_color_two";
	private final String BATTERY_NUMBER_COLOR_THREE = "battery_number_color_three";
    
	private final String BATTERY_LEVEL_COLOR_ONE = "battery_levels_color_one";
	private final String BATTERY_LEVEL_COLOR_TWO = "battery_levels_color_two";
	private final String BATTERY_LEVEL_COLOR_THREE = "battery_levels_color_three";    
	
	private final String DEPLETED_LEVEL_COLOR_ONE = "depleted_levels_color_one";
	private final String DEPLETED_LEVEL_COLOR_TWO = "depleted_levels_color_two";
	private final String DEPLETED_LEVEL_COLOR_THREE = "depleted_levels_color_three";    
	
	// Charge
	private final String CHARGING_LEVEL_COLOR_ONE = "charge_levels_color_one";
	private final String CHARGING_LEVEL_COLOR_TWO = "charge_levels_color_two";
	private final String CHARGING_LEVEL_COLOR_THREE = "charge_levels_color_three";    
	
	//Navbar
	private final String Junk_NavBar_Settings = "JUNK_NAVBAR_SETTINGS";
	private final String NAV_BAR_COLOR = "nav_bar_color";
    private final String NAV_BAR_BUTTON_COLOR = "nav_button_color";
    private final String NAV_BAR_GLOW_COLOR = "nav_button_glow_color";

    
    //Pulldown
    private final String Junk_Pulldown_Settings = "JUNK_PULLDOWN_SETTINGS";
	private final String BATTERY_LABEL_COLOR = "battery_label_color";
	private final String TEMP_LABEL_COLOR = "temp_label_color";
	private final String CARRIER_COLOR = "carrier_color";
	private final String DATE_COLOR = "date_color";
	private final String DATE_BAR_COLOR = "date_bar_color";
	
	private final String CLEAR_BUTTON_COLOR = "clear_button_color";
	private final String CLEAR_BUTTON_TEXT_COLOR = "clear_button_text_color";
	private final String PD_HANDLE_COLOR = "pd_handle_color";
	private final String PD_SHADE_COLOR = "pd_shade_color";
	private final String PD_GRIP_COLOR = "pd_grip_color";
	private final String PD_CARRIER_FRAME_COLOR = "pd_carrier_frame_color";
	private final String PD_NOTIF_ICON_BG_COLOR = "pd_notif_icon_bg_color";
	private final String PD_NOTIF_TEXT_COLOR = "pd_notif_text_color";
	private final String PD_NOTIF_TEXT_BG_COLOR = "pd_notif_text_bg_color";


	//Clock
	private final String Junk_Clock_Settings = "JUNK_CLOCK_SETTINGS";
	private final String CLOCK_COLOR = "clock_color";
	
	//Toggles
	private final String Junk_Toggle_Settings = "JUNK_TOGGLE_SETTINGS";
	private final String TOGGLES_UPDATE = "toggles_update";
	private final String TOGGLE_COLOR = "toggle_color";
	private final String TOGGLE_ICON_ON_COLOR = "toggles_icon_on_color";
	private final String TOGGLE_ICON_INTER_COLOR = "toggles_icon_inter_color";
	private final String TOGGLE_ICON_OFF_COLOR = "toggles_icon_off_color";
	private final String TOGGLE_IND_ON_COLOR = "toggle_ind_on_color";
	private final String TOGGLE_IND_OFF_COLOR = "toggle_ind_off_color";
	private final String TOGGLE_TEXT_ON_COLOR = "toggle_text_on_color";
	private final String TOGGLE_TEXT_OFF_COLOR = "toggle_text_off_color";
	private final String TOGGLE_DIVIDER_COLOR = "toggle_divider_color";


	private PreferenceManager prefMgr;

	private Preference mIconColor;
	
    private Preference mBatteryCircleColorOne;
    private Preference mBatteryCircleColorTwo;
    private Preference mBatteryCircleColorThree;
    private Preference mBatteryNumberColorOne;
    private Preference mBatteryNumberColorTwo;
    private Preference mBatteryNumberColorThree;
    
    private Preference mBatteryLevelColorOne;
    private Preference mBatteryLevelColorTwo;
    private Preference mBatteryLevelColorThree;
	
	private Preference mChargingLevelColorOne;
	private Preference mChargingLevelColorTwo;
    private Preference mChargingLevelColorThree;   
    
    private Preference mDepletedLevelColorOne;
    private Preference mDepletedLevelColorTwo;
    private Preference mDepletedLevelColorThree;
    
	private Preference mNavBarColor;
	private Preference mNavBarButtonColor;
	private Preference mNavBarGlowColor;
	
    private Preference mCarrierColor;
    private Preference mBatteryColor;
    private Preference mTempColor;
    private Preference mDateColor;
    private Preference mDateBarColor;
    private Preference mCloseBarColor;
    private Preference mClearButtonColor;
    private Preference mClearButtonTextColor;
    private Preference mShadeColor;
    private Preference mGripColor;
    private Preference mCarrierFrameColor;
    private Preference mNotifIconBgColor;
    private Preference mNotifTextColor;
    private Preference mNotifTextBgColor;

    
    private Preference mClockColor;
    
	private Preference mToggleColor;
	private Preference mToggleIconOnColor;
	private Preference mToggleIconInterColor;
	private Preference mToggleIconOffColor;
    private Preference mToggleIndOnColor;
    private Preference mToggleIndOffColor;
    private Preference mToggleTextOnColor;
    private Preference mToggleTextOffColor;
    private Preference mToggleDividerColor;
    
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
 
       	addPreferencesFromResource(R.xml.custom_color_settings);
       	
        mIconColor = (Preference) findPreference(ICON_COLOR);
		mIconColor.setOnPreferenceChangeListener(this);	
		mBatteryCircleColorOne = (Preference) findPreference(BATTERY_CIRCLE_COLOR_ONE);
		mBatteryCircleColorOne.setOnPreferenceChangeListener(this);
		mBatteryCircleColorTwo = (Preference) findPreference(BATTERY_CIRCLE_COLOR_TWO);
		mBatteryCircleColorTwo.setOnPreferenceChangeListener(this);
		mBatteryCircleColorThree = (Preference) findPreference(BATTERY_CIRCLE_COLOR_THREE);
		mBatteryCircleColorThree.setOnPreferenceChangeListener(this);

		mBatteryNumberColorOne = (Preference) findPreference(BATTERY_NUMBER_COLOR_ONE);
		mBatteryNumberColorOne.setOnPreferenceChangeListener(this);
		mBatteryNumberColorTwo = (Preference) findPreference(BATTERY_NUMBER_COLOR_TWO);
		mBatteryNumberColorTwo.setOnPreferenceChangeListener(this);
		mBatteryNumberColorThree = (Preference) findPreference(BATTERY_NUMBER_COLOR_THREE);
		mBatteryNumberColorThree.setOnPreferenceChangeListener(this);

		mDepletedLevelColorOne = (Preference) findPreference(DEPLETED_LEVEL_COLOR_ONE);
		mDepletedLevelColorOne.setOnPreferenceChangeListener(this);
		mDepletedLevelColorTwo = (Preference) findPreference(DEPLETED_LEVEL_COLOR_TWO);
		mDepletedLevelColorTwo.setOnPreferenceChangeListener(this);
		mDepletedLevelColorThree = (Preference) findPreference(DEPLETED_LEVEL_COLOR_THREE);
		mDepletedLevelColorThree.setOnPreferenceChangeListener(this);
		mBatteryLevelColorOne = (Preference) findPreference(BATTERY_LEVEL_COLOR_ONE);
		mBatteryLevelColorOne.setOnPreferenceChangeListener(this);
		mBatteryLevelColorTwo = (Preference) findPreference(BATTERY_LEVEL_COLOR_TWO);
		mBatteryLevelColorTwo.setOnPreferenceChangeListener(this);
		mBatteryLevelColorThree = (Preference) findPreference(BATTERY_LEVEL_COLOR_THREE);
		mBatteryLevelColorThree.setOnPreferenceChangeListener(this);
		mChargingLevelColorOne = (Preference) findPreference(CHARGING_LEVEL_COLOR_ONE);
		mChargingLevelColorOne.setOnPreferenceChangeListener(this);
		mChargingLevelColorTwo = (Preference) findPreference(CHARGING_LEVEL_COLOR_TWO);
		mChargingLevelColorTwo.setOnPreferenceChangeListener(this);
		mChargingLevelColorThree = (Preference) findPreference(CHARGING_LEVEL_COLOR_THREE);
		mChargingLevelColorThree.setOnPreferenceChangeListener(this);
        mNavBarColor = (ColorPickerPreference) findPreference(NAV_BAR_COLOR);
        mNavBarColor.setOnPreferenceChangeListener(this);
        mNavBarButtonColor = (ColorPickerPreference) findPreference(NAV_BAR_BUTTON_COLOR);
        mNavBarButtonColor.setOnPreferenceChangeListener(this);
        mNavBarGlowColor = (ColorPickerPreference) findPreference(NAV_BAR_GLOW_COLOR);
        mNavBarGlowColor.setOnPreferenceChangeListener(this);
		mCarrierColor = (Preference) findPreference(CARRIER_COLOR);
		mCarrierColor.setOnPreferenceChangeListener(this);        
	    mBatteryColor = (Preference) findPreference(BATTERY_LABEL_COLOR);
		mBatteryColor.setOnPreferenceChangeListener(this);
	    mTempColor = (Preference) findPreference(TEMP_LABEL_COLOR);
		mTempColor.setOnPreferenceChangeListener(this);
        mDateColor = (Preference) findPreference(DATE_COLOR);
        mDateBarColor = (Preference) findPreference(DATE_BAR_COLOR);
		mDateBarColor.setOnPreferenceChangeListener(this);
        mCloseBarColor = (Preference) findPreference(PD_HANDLE_COLOR);
		mCloseBarColor.setOnPreferenceChangeListener(this);
        mClearButtonColor = (Preference) findPreference(CLEAR_BUTTON_COLOR);
		mClearButtonColor.setOnPreferenceChangeListener(this);
        mClearButtonTextColor = (Preference) findPreference(CLEAR_BUTTON_TEXT_COLOR);
		mClearButtonTextColor.setOnPreferenceChangeListener(this);
		mDateColor.setOnPreferenceChangeListener(this);
        mClockColor = (Preference) findPreference(CLOCK_COLOR);
		mClockColor.setOnPreferenceChangeListener(this);
        mShadeColor = (Preference) findPreference(PD_SHADE_COLOR);
		mShadeColor.setOnPreferenceChangeListener(this);        
        mGripColor = (Preference) findPreference(PD_GRIP_COLOR);
		mGripColor.setOnPreferenceChangeListener(this);        
        mCarrierFrameColor = (Preference) findPreference(PD_CARRIER_FRAME_COLOR);
		mCarrierFrameColor.setOnPreferenceChangeListener(this);        
        mNotifIconBgColor = (Preference) findPreference(PD_NOTIF_ICON_BG_COLOR);
        mNotifIconBgColor.setOnPreferenceChangeListener(this);        
        mNotifTextColor = (Preference) findPreference(PD_NOTIF_TEXT_COLOR);
        mNotifTextColor.setOnPreferenceChangeListener(this);        
        mNotifTextBgColor = (Preference) findPreference(PD_NOTIF_TEXT_BG_COLOR);
        mNotifTextBgColor.setOnPreferenceChangeListener(this);        
    	mToggleColor = (Preference) findPreference(TOGGLE_COLOR);
    	mToggleColor.setOnPreferenceChangeListener(this);
    	mToggleIconOnColor = (Preference) findPreference(TOGGLE_ICON_ON_COLOR);
    	mToggleIconOnColor.setOnPreferenceChangeListener(this);
    	mToggleIconInterColor = (Preference) findPreference(TOGGLE_ICON_INTER_COLOR);
    	mToggleIconInterColor.setOnPreferenceChangeListener(this);
    	mToggleIconOffColor = (Preference) findPreference(TOGGLE_ICON_OFF_COLOR);
    	mToggleIconOffColor.setOnPreferenceChangeListener(this);
        mToggleIndOnColor = (Preference) findPreference(TOGGLE_IND_ON_COLOR);
        mToggleIndOnColor.setOnPreferenceChangeListener(this);
        mToggleIndOffColor = (Preference) findPreference(TOGGLE_IND_OFF_COLOR);
        mToggleIndOffColor.setOnPreferenceChangeListener(this);
        mToggleTextOnColor = (Preference) findPreference(TOGGLE_TEXT_ON_COLOR);
        mToggleTextOnColor.setOnPreferenceChangeListener(this);
        mToggleTextOffColor = (Preference) findPreference(TOGGLE_TEXT_OFF_COLOR);
        mToggleTextOffColor.setOnPreferenceChangeListener(this);
        mToggleDividerColor = (Preference) findPreference(TOGGLE_DIVIDER_COLOR);
        mToggleDividerColor.setOnPreferenceChangeListener(this);
        
        

        
    }

    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView lView = this.getListView();
        lView.clearFocus();
        lView.setSelection(rowid);
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
     	
     	
  	if (ICON_COLOR.equals(key)) {
     	Intent i = new Intent();
     	i.setAction(Junk_Icon_Settings);
   	   	i.putExtra(ICON_COLOR, (Integer) objValue);
   	   	getActivity().sendBroadcast(i);
   	   	i = null;
  	} else if (BATTERY_CIRCLE_COLOR_ONE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_ONE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
  	} else if (BATTERY_CIRCLE_COLOR_TWO.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_TWO, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
  	} else if (BATTERY_CIRCLE_COLOR_THREE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_THREE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;        
        
  	} else if (BATTERY_NUMBER_COLOR_ONE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_ONE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;        

  	} else if (BATTERY_NUMBER_COLOR_TWO.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_TWO, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;        

  	} else if (BATTERY_NUMBER_COLOR_THREE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_THREE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;        
        
  	} else if (DEPLETED_LEVEL_COLOR_ONE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_ONE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;

  	} else if (DEPLETED_LEVEL_COLOR_TWO.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_TWO, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;

  	} else if (DEPLETED_LEVEL_COLOR_THREE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_THREE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
        
    } else if (BATTERY_LEVEL_COLOR_ONE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_ONE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
         
    } else if (BATTERY_LEVEL_COLOR_TWO.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_TWO, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;

    } else if (BATTERY_LEVEL_COLOR_THREE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_THREE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
    
    } else if (CHARGING_LEVEL_COLOR_ONE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_ONE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
         
    } else if (CHARGING_LEVEL_COLOR_TWO.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_TWO, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;

    } else if (CHARGING_LEVEL_COLOR_THREE.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_THREE, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;

    } else if (NAV_BAR_COLOR.equals(key)) {
        Intent i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_COLOR, (Integer) objValue);
       	getActivity().sendBroadcast(i);
       	i = null;

    } else if (NAV_BAR_BUTTON_COLOR.equals(key)) {
       	Intent i = new Intent();
       	i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_BUTTON_COLOR, (Integer) objValue);
       	getActivity().sendBroadcast(i);
       	i = null;      

    } else if (NAV_BAR_GLOW_COLOR.equals(key)) {
       	Intent i = new Intent();
       	i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_GLOW_COLOR, (Integer) objValue);
       	getActivity().sendBroadcast(i);
       	i = null;           	   	
       	   	
    } else if (BATTERY_LABEL_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Pulldown_Settings );
        i.putExtra(BATTERY_LABEL_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;           	  

    } else if (TEMP_LABEL_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Pulldown_Settings );
        i.putExtra(TEMP_LABEL_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;           	  

    } else if (CARRIER_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Pulldown_Settings );
        i.putExtra(CARRIER_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
    } else if (DATE_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(DATE_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;        

    } else if (DATE_BAR_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(DATE_BAR_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;        
    	
    } else if (CLOCK_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Clock_Settings );
        i.putExtra(CLOCK_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
	} else if (TOGGLE_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_COLOR, (Integer) objValue);
   	   	getActivity().sendBroadcast(i);
   	   	i = null;
   
	} else if (TOGGLE_ICON_ON_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_ON_COLOR, (Integer) objValue);
   	   	getActivity().sendBroadcast(i);
   	   	i = null;

	} else if (TOGGLE_ICON_INTER_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_INTER_COLOR, (Integer) objValue);
   	   	getActivity().sendBroadcast(i);
   	   	i = null;
   	   	
	} else if (TOGGLE_ICON_OFF_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_OFF_COLOR, (Integer) objValue);
   	   	getActivity().sendBroadcast(i);
   	   	i = null;       	   	
   	   	
    } else if (TOGGLE_IND_ON_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_IND_ON_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;
        
    	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        getActivity().sendBroadcast(i);
        i = null;
        
    } else if (TOGGLE_IND_OFF_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_IND_OFF_COLOR, (Integer) objValue);
         getActivity().sendBroadcast(i);
        i = null;
        
    	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        getActivity().sendBroadcast(i);
        i = null;

    } else if (TOGGLE_TEXT_ON_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_TEXT_ON_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;        
        
    	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        getActivity().sendBroadcast(i);
        i = null;

    } else if (TOGGLE_TEXT_OFF_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_TEXT_OFF_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;     
        
    	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        getActivity().sendBroadcast(i);
        i = null;
    
    } else if (TOGGLE_DIVIDER_COLOR.equals(key)) {
    	Intent i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_DIVIDER_COLOR, (Integer) objValue);
        getActivity().sendBroadcast(i);
        i = null;  
        
    	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        getActivity().sendBroadcast(i);
        i = null;
  	
    } else if (CLEAR_BUTTON_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(CLEAR_BUTTON_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;      

    } else if (CLEAR_BUTTON_TEXT_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(CLEAR_BUTTON_TEXT_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;      	
    	
    } else if (PD_HANDLE_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_HANDLE_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;              	
        
    	
    } else if (PD_HANDLE_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_HANDLE_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;              	
    	
    } else if (PD_SHADE_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_SHADE_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;         	

    } else if (PD_GRIP_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_GRIP_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;           	

    } else if (PD_CARRIER_FRAME_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_CARRIER_FRAME_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;           	

    } else if (PD_NOTIF_ICON_BG_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_NOTIF_ICON_BG_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;          	

    } else if (PD_NOTIF_TEXT_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_NOTIF_TEXT_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;          	
    	
    } else if (PD_NOTIF_TEXT_BG_COLOR.equals(key)) {
    	Intent i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_NOTIF_TEXT_BG_COLOR, (Integer) objValue);
    	getActivity().sendBroadcast(i);
    	i = null;         	
    }
    
    
        return true;
    }
 
    

    
 
} 