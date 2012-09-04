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
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.CheckBoxPreference;



public class CustomQuickColorSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

	private final String QK_COLOR = "qk_color";
	private final String QK_CLEAR_ALL = "qk_clear_all";

	//Icons - Signal/Wifi
	private final String Junk_Icon_Settings = "JUNK_ICON_SETTINGS";
	private final String QK_ICON_COLOR = "qk_icon_color";
	private final String ICON_COLOR = "icon_color";

	// Battery
    private final String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";
	private final String QK_BATTERY_CIRCLE_COLOR_ONE = "qk_battery_circle_color_one";
	private final String QK_BATTERY_CIRCLE_COLOR_TWO = "qk_battery_circle_color_two";
	private final String QK_BATTERY_CIRCLE_COLOR_THREE = "qk_battery_circle_color_three";
	private final String QK_BATTERY_NUMBER_COLOR_ONE = "qk_battery_number_color_one";
	private final String QK_BATTERY_NUMBER_COLOR_TWO = "qk_battery_number_color_two";
	private final String QK_BATTERY_NUMBER_COLOR_THREE = "qk_battery_number_color_three";
	private final String QK_BATTERY_LEVEL_COLOR_ONE = "qk_battery_levels_color_one";
	private final String QK_BATTERY_LEVEL_COLOR_TWO = "qk_battery_levels_color_two";
	private final String QK_BATTERY_LEVEL_COLOR_THREE = "qk_battery_levels_color_three";   
	private final String BATTERY_CIRCLE_COLOR_ONE = "battery_circle_color_one";
	private final String BATTERY_CIRCLE_COLOR_TWO = "battery_circle_color_two";
	private final String BATTERY_CIRCLE_COLOR_THREE = "battery_circle_color_three";
	private final String BATTERY_NUMBER_COLOR_ONE = "battery_number_color_one";
	private final String BATTERY_NUMBER_COLOR_TWO = "battery_number_color_two";
	private final String BATTERY_NUMBER_COLOR_THREE = "battery_number_color_three";
	private final String BATTERY_LEVEL_COLOR_ONE = "battery_levels_color_one";
	private final String BATTERY_LEVEL_COLOR_TWO = "battery_levels_color_two";
	private final String BATTERY_LEVEL_COLOR_THREE = "battery_levels_color_three";    

	private final String QK_DEPLETED_LEVEL_COLOR_ONE = "qk_depleted_levels_color_one";
	private final String QK_DEPLETED_LEVEL_COLOR_TWO = "qk_depleted_levels_color_two";
	private final String QK_DEPLETED_LEVEL_COLOR_THREE = "qk_depleted_levels_color_three";    
	private final String DEPLETED_LEVEL_COLOR_ONE = "depleted_levels_color_one";
	private final String DEPLETED_LEVEL_COLOR_TWO = "depleted_levels_color_two";
	private final String DEPLETED_LEVEL_COLOR_THREE = "depleted_levels_color_three";    

	// Charge
	private final String QK_CHARGING_LEVEL_COLOR_ONE = "qk_charge_levels_color_one";
	private final String QK_CHARGING_LEVEL_COLOR_TWO = "qk_charge_levels_color_two";
	private final String QK_CHARGING_LEVEL_COLOR_THREE = "qk_charge_levels_color_three";    
	private final String CHARGING_LEVEL_COLOR_ONE = "charge_levels_color_one";
	private final String CHARGING_LEVEL_COLOR_TWO = "charge_levels_color_two";
	private final String CHARGING_LEVEL_COLOR_THREE = "charge_levels_color_three";    


	//Navbar
	private final String Junk_NavBar_Settings = "JUNK_NAVBAR_SETTINGS";
	private final String QK_NAV_BAR_COLOR = "qk_nav_bar_color";
    private final String QK_NAV_BAR_BUTTON_COLOR = "qk_nav_button_color";
    private final String QK_NAV_BAR_GLOW_COLOR = "qk_nav_button_glow_color";
    private final String QK_NAV_BAR_LIGHTSOUT_COLOR = "qk_nav_lightsout_color";
	private final String NAV_BAR_COLOR = "nav_bar_color";
    private final String NAV_BAR_BUTTON_COLOR = "nav_button_color";
    private final String NAV_BAR_GLOW_COLOR = "nav_button_glow_color";
    private final String NAV_BAR_LIGHTSOUT_COLOR = "nav_lightsout_color";


    
    //Pulldown
    private final String Junk_Pulldown_Settings = "JUNK_PULLDOWN_SETTINGS";
	private final String QK_HEADER_BAR_COLOR = "qk_header_bar_color";
	private final String QK_HEADER_CLOCK_COLOR = "qk_header_clock_color";
	private final String QK_HEADER_DATE_COLOR = "qk_header_date_color";
	private final String QK_HEADER_BUTTON_COLOR = "qk_header_button_color";
    private final String QK_BATTERY_LABEL_COLOR = "qk_battery_label_color";
	private final String QK_TEMP_LABEL_COLOR = "qk_temp_label_color";
	private final String QK_CARRIER_COLOR = "qk_carrier_color";
	private final String HEADER_BAR_COLOR = "header_bar_color";
	private final String HEADER_CLOCK_COLOR = "header_clock_color";
	private final String HEADER_DATE_COLOR = "header_date_color";
	private final String HEADER_BUTTON_COLOR = "header_button_color";
	private final String BATTERY_LABEL_COLOR = "battery_label_color";
	private final String TEMP_LABEL_COLOR = "temp_label_color";
	private final String CARRIER_COLOR = "carrier_color";




	private final String QK_PD_HANDLE_COLOR = "qk_pd_handle_color";
	private final String QK_PD_SHADE_COLOR = "qk_pd_shade_color";
	private final String QK_PD_NOTIF_ICON_BG_COLOR = "qk_pd_notif_icon_bg_color";
	private final String QK_PD_NOTIF_TEXT_BG_COLOR = "qk_pd_notif_text_bg_color";
	private final String QK_PD_NOTIF_TEXT_COLOR = "qk_pd_notif_text_color";
	private final String QK_PD_NOTIF_TITLE_COLOR = "qk_pd_notif_title_color";
	private final String QK_PD_NOTIF_TIME_COLOR = "qk_pd_notif_time_color";
	private final String QK_PD_NOTIF_DIVIDER_COLOR = "qk_pd_notif_divider_color";
	private final String QK_PD_NOTIF_SUBTEXT_COLOR = "qk_pd_notif_subtext_color";
	private final String QK_PD_NOTIF_SMALL_ICON_COLOR = "qk_pd_notif_small_icon_color";
	private final String PD_HANDLE_COLOR = "pd_handle_color";
	private final String PD_SHADE_COLOR = "pd_shade_color";
	private final String PD_NOTIF_ICON_BG_COLOR = "pd_notif_icon_bg_color";
	private final String PD_NOTIF_TEXT_BG_COLOR = "pd_notif_text_bg_color";
	private final String PD_NOTIF_TITLE_COLOR = "pd_notif_title_color";
	private final String PD_NOTIF_TIME_COLOR = "pd_notif_time_color";
	private final String PD_NOTIF_TEXT_COLOR = "pd_notif_text_color";
	private final String PD_NOTIF_DIVIDER_COLOR = "pd_notif_divider_color";
	private final String PD_NOTIF_SUBTEXT_COLOR = "pd_notif_subtext_color";
	private final String PD_NOTIF_SMALL_ICON_COLOR = "pd_notif_small_icon_color";

	
	//Clock
	private final String Junk_Clock_Settings = "JUNK_CLOCK_SETTINGS";
	private final String QK_CLOCK_COLOR = "qk_clock_color";
	private final String CLOCK_COLOR = "clock_color";

	//Toggles
	private final String Junk_Toggle_Settings = "JUNK_TOGGLE_SETTINGS";
	private final String TOGGLES_UPDATE = "toggles_update";
	private final String QK_TOGGLE_COLOR = "qk_toggle_color";
	private final String QK_TOGGLE_ICON_ON_COLOR = "qk_toggle_icon_on_color";
	private final String QK_TOGGLE_ICON_INTER_COLOR = "qk_toggle_icon_inter_color";
	private final String QK_TOGGLE_ICON_OFF_COLOR = "qk_toggle_icon_off_color";
	private final String QK_TOGGLE_IND_ON_COLOR = "qk_toggle_ind_on_color";
	private final String QK_TOGGLE_IND_OFF_COLOR = "qk_toggle_ind_off_color";
	private final String QK_TOGGLE_TEXT_ON_COLOR = "qk_toggle_text_on_color";
	private final String QK_TOGGLE_TEXT_OFF_COLOR = "qk_toggle_text_off_color";
	private final String QK_TOGGLE_DIVIDER_COLOR = "qk_toggle_divider_color";
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
	private SharedPreferences sharedPref;

	private Preference mQkColor;
	private Preference mQkClearAll;

	//Icons - Signal/Wifi
	private CheckBoxPreference mIconColor;

	// Battery
    private CheckBoxPreference mBatteryCircleColorOne;
    private CheckBoxPreference mBatteryCircleColorTwo;
    private CheckBoxPreference mBatteryCircleColorThree;
    private CheckBoxPreference mBatteryNumberColorOne;
    private CheckBoxPreference mBatteryNumberColorTwo;
    private CheckBoxPreference mBatteryNumberColorThree;
    private CheckBoxPreference mBatteryLevelColorOne;
    private CheckBoxPreference mBatteryLevelColorTwo;
    private CheckBoxPreference mBatteryLevelColorThree;
    private CheckBoxPreference mDepletedLevelColorOne;
    private CheckBoxPreference mDepletedLevelColorTwo;
    private CheckBoxPreference mDepletedLevelColorThree;
    private CheckBoxPreference mChargingLevelColorOne;
    private CheckBoxPreference mChargingLevelColorTwo;
    private CheckBoxPreference mChargingLevelColorThree;

	//Navbar
    private CheckBoxPreference mNavBarColor;
    private CheckBoxPreference mNavBarButtonColor;
    private CheckBoxPreference mNavBarGlowColor;
    private CheckBoxPreference mNavLightsoutColor;

    //Pulldown
	private CheckBoxPreference mHeaderBar;
	private CheckBoxPreference mHeaderClock;
	private CheckBoxPreference mHeaderDate;
	private CheckBoxPreference mHeaderButton;
    private CheckBoxPreference mShadeColor;
    private CheckBoxPreference mNotifIconBgColor;
    private CheckBoxPreference mNotifTextBgColor;
    private CheckBoxPreference mNotifTitleColor;
    private CheckBoxPreference mNotifTimeColor;
    private CheckBoxPreference mNotifTextColor;
    private CheckBoxPreference mNotifDividerColor;
    private CheckBoxPreference mNotifSubtextColor;
    private CheckBoxPreference mNotifSmallIconColor;
    private CheckBoxPreference mCarrierColor;
    private CheckBoxPreference mBatteryColor;
    private CheckBoxPreference mTempColor;
    private CheckBoxPreference mCloseBarColor;

	//Clock
    private CheckBoxPreference mClockColor;
 
	//Toggles
	private CheckBoxPreference mToggleColor;
	private CheckBoxPreference mToggleIconOnColor;
	private CheckBoxPreference mToggleIconInterColor;
	private CheckBoxPreference mToggleIconOffColor;
    private CheckBoxPreference mToggleIndOnColor;
    private CheckBoxPreference mToggleIndOffColor;
    private CheckBoxPreference mToggleTextOnColor;
    private CheckBoxPreference mToggleTextOffColor;
    private CheckBoxPreference mToggleDividerColor;




    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
        sharedPref = prefMgr.getSharedPreferences();
 
       	addPreferencesFromResource(R.xml.custom_quickcolor_settings);

        mQkClearAll = (Preference) findPreference(QK_CLEAR_ALL);
		mQkClearAll.setOnPreferenceChangeListener(this);	
        mQkColor = (Preference) findPreference(QK_COLOR);
		mQkColor.setOnPreferenceChangeListener(this);	

       	mIconColor = (CheckBoxPreference) findPreference(QK_ICON_COLOR);
		mIconColor.setOnPreferenceChangeListener(this);	
		mBatteryCircleColorOne = (CheckBoxPreference) findPreference(QK_BATTERY_CIRCLE_COLOR_ONE);
		mBatteryCircleColorOne.setOnPreferenceChangeListener(this);
		mBatteryCircleColorTwo = (CheckBoxPreference) findPreference(QK_BATTERY_CIRCLE_COLOR_TWO);
		mBatteryCircleColorTwo.setOnPreferenceChangeListener(this);
		mBatteryCircleColorThree = (CheckBoxPreference) findPreference(QK_BATTERY_CIRCLE_COLOR_THREE);
		mBatteryCircleColorThree.setOnPreferenceChangeListener(this);
		mBatteryNumberColorOne = (CheckBoxPreference) findPreference(QK_BATTERY_NUMBER_COLOR_ONE);
		mBatteryNumberColorOne.setOnPreferenceChangeListener(this);
		mBatteryNumberColorTwo = (CheckBoxPreference) findPreference(QK_BATTERY_NUMBER_COLOR_TWO);
		mBatteryNumberColorTwo.setOnPreferenceChangeListener(this);
		mBatteryNumberColorThree = (CheckBoxPreference) findPreference(QK_BATTERY_NUMBER_COLOR_THREE);
		mBatteryNumberColorThree.setOnPreferenceChangeListener(this);
		mDepletedLevelColorOne = (CheckBoxPreference) findPreference(QK_DEPLETED_LEVEL_COLOR_ONE);
		mDepletedLevelColorOne.setOnPreferenceChangeListener(this);
		mDepletedLevelColorTwo = (CheckBoxPreference) findPreference(QK_DEPLETED_LEVEL_COLOR_TWO);
		mDepletedLevelColorTwo.setOnPreferenceChangeListener(this);
		mDepletedLevelColorThree = (CheckBoxPreference) findPreference(QK_DEPLETED_LEVEL_COLOR_THREE);
		mDepletedLevelColorThree.setOnPreferenceChangeListener(this);
		mBatteryLevelColorOne = (CheckBoxPreference) findPreference(QK_BATTERY_LEVEL_COLOR_ONE);
		mBatteryLevelColorOne.setOnPreferenceChangeListener(this);
		mBatteryLevelColorTwo = (CheckBoxPreference) findPreference(QK_BATTERY_LEVEL_COLOR_TWO);
		mBatteryLevelColorTwo.setOnPreferenceChangeListener(this);
		mBatteryLevelColorThree = (CheckBoxPreference) findPreference(QK_BATTERY_LEVEL_COLOR_THREE);
		mBatteryLevelColorThree.setOnPreferenceChangeListener(this);
		mChargingLevelColorOne = (CheckBoxPreference) findPreference(QK_CHARGING_LEVEL_COLOR_ONE);
		mChargingLevelColorOne.setOnPreferenceChangeListener(this);
		mChargingLevelColorTwo = (CheckBoxPreference) findPreference(QK_CHARGING_LEVEL_COLOR_TWO);
		mChargingLevelColorTwo.setOnPreferenceChangeListener(this);
		mChargingLevelColorThree = (CheckBoxPreference) findPreference(QK_CHARGING_LEVEL_COLOR_THREE);
		mChargingLevelColorThree.setOnPreferenceChangeListener(this);
        mNavBarColor = (CheckBoxPreference) findPreference(QK_NAV_BAR_COLOR);
        mNavBarColor.setOnPreferenceChangeListener(this);
        mNavBarButtonColor = (CheckBoxPreference) findPreference(QK_NAV_BAR_BUTTON_COLOR);
        mNavBarButtonColor.setOnPreferenceChangeListener(this);
        mNavBarGlowColor = (CheckBoxPreference) findPreference(QK_NAV_BAR_GLOW_COLOR);
        mNavBarGlowColor.setOnPreferenceChangeListener(this);
        mNavLightsoutColor = (CheckBoxPreference) findPreference(QK_NAV_BAR_LIGHTSOUT_COLOR);
        mNavLightsoutColor.setOnPreferenceChangeListener(this);
		mCarrierColor = (CheckBoxPreference) findPreference(QK_CARRIER_COLOR);
		mCarrierColor.setOnPreferenceChangeListener(this);        
	    mBatteryColor = (CheckBoxPreference) findPreference(QK_BATTERY_LABEL_COLOR);
		mBatteryColor.setOnPreferenceChangeListener(this);
	    mTempColor = (CheckBoxPreference) findPreference(QK_TEMP_LABEL_COLOR);
		mTempColor.setOnPreferenceChangeListener(this);
        mCloseBarColor = (CheckBoxPreference) findPreference(QK_PD_HANDLE_COLOR);
		mCloseBarColor.setOnPreferenceChangeListener(this);
    	mHeaderBar = (CheckBoxPreference) findPreference(QK_HEADER_BAR_COLOR);
    	mHeaderBar.setOnPreferenceChangeListener(this);
    	mHeaderClock = (CheckBoxPreference) findPreference(QK_HEADER_CLOCK_COLOR);
    	mHeaderClock.setOnPreferenceChangeListener(this);
    	mHeaderDate = (CheckBoxPreference) findPreference(QK_HEADER_DATE_COLOR);
    	mHeaderDate.setOnPreferenceChangeListener(this);
    	mHeaderButton = (CheckBoxPreference) findPreference(QK_HEADER_BUTTON_COLOR);
    	mHeaderButton.setOnPreferenceChangeListener(this);
        mShadeColor = (CheckBoxPreference) findPreference(QK_PD_SHADE_COLOR);
		mShadeColor.setOnPreferenceChangeListener(this);        
        mNotifIconBgColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_ICON_BG_COLOR);
        mNotifIconBgColor.setOnPreferenceChangeListener(this);        
        mNotifTextBgColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_TEXT_BG_COLOR);
        mNotifTextBgColor.setOnPreferenceChangeListener(this);        
        mNotifTitleColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_TITLE_COLOR);
        mNotifTitleColor.setOnPreferenceChangeListener(this);        
        mNotifTimeColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_TIME_COLOR);
        mNotifTimeColor.setOnPreferenceChangeListener(this);        
        mNotifTextColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_TEXT_COLOR);
        mNotifTextColor.setOnPreferenceChangeListener(this);        
        mNotifDividerColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_DIVIDER_COLOR);
        mNotifDividerColor.setOnPreferenceChangeListener(this);        
        mNotifSubtextColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_SUBTEXT_COLOR);
        mNotifSubtextColor.setOnPreferenceChangeListener(this);        
        mNotifSmallIconColor = (CheckBoxPreference) findPreference(QK_PD_NOTIF_SMALL_ICON_COLOR);
        mNotifSmallIconColor.setOnPreferenceChangeListener(this);        
        mClockColor = (CheckBoxPreference) findPreference(QK_CLOCK_COLOR);
		mClockColor.setOnPreferenceChangeListener(this);
    	mToggleColor = (CheckBoxPreference) findPreference(QK_TOGGLE_COLOR);
    	mToggleColor.setOnPreferenceChangeListener(this);
    	mToggleIconOnColor = (CheckBoxPreference) findPreference(QK_TOGGLE_ICON_ON_COLOR);
    	mToggleIconOnColor.setOnPreferenceChangeListener(this);
    	mToggleIconInterColor = (CheckBoxPreference) findPreference(QK_TOGGLE_ICON_INTER_COLOR);
    	mToggleIconInterColor.setOnPreferenceChangeListener(this);
    	mToggleIconOffColor = (CheckBoxPreference) findPreference(QK_TOGGLE_ICON_OFF_COLOR);
    	mToggleIconOffColor.setOnPreferenceChangeListener(this);
        mToggleIndOnColor = (CheckBoxPreference) findPreference(QK_TOGGLE_IND_ON_COLOR);
        mToggleIndOnColor.setOnPreferenceChangeListener(this);
        mToggleIndOffColor = (CheckBoxPreference) findPreference(QK_TOGGLE_IND_OFF_COLOR);
        mToggleIndOffColor.setOnPreferenceChangeListener(this);
        mToggleTextOnColor = (CheckBoxPreference) findPreference(QK_TOGGLE_TEXT_ON_COLOR);
        mToggleTextOnColor.setOnPreferenceChangeListener(this);
        mToggleTextOffColor = (CheckBoxPreference) findPreference(QK_TOGGLE_TEXT_OFF_COLOR);
        mToggleTextOffColor.setOnPreferenceChangeListener(this);
        mToggleDividerColor = (CheckBoxPreference) findPreference(QK_TOGGLE_DIVIDER_COLOR);
        mToggleDividerColor.setOnPreferenceChangeListener(this);
        
        
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

    	if (preference == mQkClearAll) {
    		clearCheckMarks();
        }  
    	
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

                 
    public boolean onPreferenceChange(Preference preference, Object objValue) {
    	  
     	final String key = preference.getKey();
     	
     	
     	
     	if (QK_COLOR.equals(key)) {
     		

  		if (mIconColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(ICON_COLOR, (Integer) objValue);
            editor.commit();
  			
  	     	Intent i = new Intent();
  	     	i.setAction(Junk_Icon_Settings);
  	   	   	i.putExtra(ICON_COLOR, (Integer) objValue);
  	   	   	getActivity().sendBroadcast(i);
  	   	   	i = null;
  		}
 
  		if (mBatteryCircleColorOne.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_CIRCLE_COLOR_ONE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_CIRCLE_COLOR_ONE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		

  		if (mBatteryCircleColorTwo.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_CIRCLE_COLOR_TWO, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_CIRCLE_COLOR_TWO, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		

  		if (mBatteryCircleColorThree.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_CIRCLE_COLOR_THREE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_CIRCLE_COLOR_THREE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		
  		
  		
  		if (mBatteryNumberColorOne.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_NUMBER_COLOR_ONE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_NUMBER_COLOR_ONE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		  		

  		if (mBatteryNumberColorTwo.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_NUMBER_COLOR_TWO, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_NUMBER_COLOR_TWO, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		  		

  		if (mBatteryNumberColorThree.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_NUMBER_COLOR_THREE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_NUMBER_COLOR_THREE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		  		
  		
  		if (mDepletedLevelColorOne.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(DEPLETED_LEVEL_COLOR_ONE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_COLOR_ONE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		
  		
  		if (mDepletedLevelColorTwo.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(DEPLETED_LEVEL_COLOR_TWO, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_COLOR_TWO, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		

  		if (mDepletedLevelColorThree.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(DEPLETED_LEVEL_COLOR_THREE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(DEPLETED_LEVEL_COLOR_THREE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		

  		
  		if (mBatteryLevelColorOne.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_LEVEL_COLOR_ONE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_LEVEL_COLOR_ONE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		
  		
  		if (mBatteryLevelColorTwo.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_LEVEL_COLOR_TWO, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_LEVEL_COLOR_TWO, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;  			
  		} 		
  		
  		
  		if (mBatteryLevelColorThree.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_LEVEL_COLOR_THREE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(BATTERY_LEVEL_COLOR_THREE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;  			
  		} 		
  		
  		if (mChargingLevelColorOne.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(CHARGING_LEVEL_COLOR_ONE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(CHARGING_LEVEL_COLOR_ONE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
  		} 		
  		
  		if (mChargingLevelColorTwo.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(CHARGING_LEVEL_COLOR_TWO, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(CHARGING_LEVEL_COLOR_TWO, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;  			
  		} 		
  		
  		
  		if (mChargingLevelColorThree.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(CHARGING_LEVEL_COLOR_THREE, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Battery_Settings);
            i.putExtra(CHARGING_LEVEL_COLOR_THREE, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;  			
  		} 		

  		if (mNavBarColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(NAV_BAR_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_NavBar_Settings );
       	   	i.putExtra(NAV_BAR_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;
   	   	}
  		
  		if (mNavBarButtonColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(NAV_BAR_BUTTON_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_NavBar_Settings );
       	   	i.putExtra(NAV_BAR_BUTTON_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null; 		
  		}   		
  		
  		if (mNavBarGlowColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(NAV_BAR_GLOW_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_NavBar_Settings );
       	   	i.putExtra(NAV_BAR_GLOW_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null; 		
  		}   		

  		if (mNavLightsoutColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(NAV_BAR_LIGHTSOUT_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_NavBar_Settings );
       	   	i.putExtra(NAV_BAR_LIGHTSOUT_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null; 		
  		}   		
  		
  		if (mBatteryColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(BATTERY_LABEL_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(BATTERY_LABEL_COLOR, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;           	  
  		
  		}
   	   	
  		if (mTempColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TEMP_LABEL_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(TEMP_LABEL_COLOR, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;           	  
 		
  		}

  		if (mCarrierColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(CARRIER_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
            i.setAction(Junk_Pulldown_Settings );
            i.putExtra(CARRIER_COLOR, (Integer) objValue);
            getActivity().sendBroadcast(i);
            i = null;
     		
  		}

  		if (mToggleColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Toggle_Settings);
       	   	i.putExtra(TOGGLE_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;
  		}
    
  		if (mToggleIconOnColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_ICON_ON_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Toggle_Settings);
       	   	i.putExtra(TOGGLE_ICON_ON_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;
  		}
    
  		if (mToggleIconInterColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_ICON_INTER_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Toggle_Settings);
       	   	i.putExtra(TOGGLE_ICON_INTER_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;
       	   	
        	i = new Intent();
            i.setAction(Junk_Toggle_Settings);
            i.putExtra(TOGGLES_UPDATE, true);
            getActivity().sendBroadcast(i);
            i = null;

  		}
  		
  		if (mToggleIconOffColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_ICON_OFF_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Toggle_Settings);
       	   	i.putExtra(TOGGLE_ICON_OFF_COLOR, (Integer) objValue);
       	   	getActivity().sendBroadcast(i);
       	   	i = null;      
       	   	
        	i = new Intent();
            i.setAction(Junk_Toggle_Settings);
            i.putExtra(TOGGLES_UPDATE, true);
            getActivity().sendBroadcast(i);
            i = null;

  		}
  		
  		if (mToggleIndOnColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_IND_ON_COLOR, (Integer) objValue);
            editor.commit();
  			
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

  		}
        
  		if (mToggleIndOffColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_IND_OFF_COLOR, (Integer) objValue);
            editor.commit();
  			
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

        }

  		if (mToggleTextOnColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_TEXT_ON_COLOR, (Integer) objValue);
            editor.commit();
  			
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
        }
  	
  		if (mToggleTextOffColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_TEXT_OFF_COLOR, (Integer) objValue);
            editor.commit();
  			
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
        }
  		
  		if (mToggleDividerColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(TOGGLE_DIVIDER_COLOR, (Integer) objValue);
            editor.commit();
  			
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
        }
  		
  		if (mClockColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(CLOCK_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Clock_Settings );
        	i.putExtra(CLOCK_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;      
        }  		
  		
  		if (mCloseBarColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_HANDLE_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_HANDLE_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        }
  		
  		if (mHeaderBar.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(HEADER_BAR_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(HEADER_BAR_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        } 
  
  		if (mHeaderClock.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(HEADER_CLOCK_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(HEADER_CLOCK_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        }  
  		
  		if (mHeaderDate.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(HEADER_DATE_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(HEADER_DATE_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        }   		

  		if (mHeaderButton.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(HEADER_BUTTON_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(HEADER_BUTTON_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        }   		
  		
  		if (mShadeColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_SHADE_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_SHADE_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
        }  		

  		if (mNotifIconBgColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_ICON_BG_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_ICON_BG_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifTextBgColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_TEXT_BG_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_TEXT_BG_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		
  		
  		if (mNotifTitleColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_TITLE_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_TITLE_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifTimeColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_TIME_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_TIME_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifTextColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_TEXT_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_TEXT_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifDividerColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_DIVIDER_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_DIVIDER_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifSubtextColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_SUBTEXT_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_SUBTEXT_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		if (mNotifSmallIconColor.isChecked()) {
  			
        	sharedPref = prefMgr.getSharedPreferences();
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(PD_NOTIF_SMALL_ICON_COLOR, (Integer) objValue);
            editor.commit();
  			
        	Intent i = new Intent();
        	i.setAction(Junk_Pulldown_Settings );
        	i.putExtra(PD_NOTIF_SMALL_ICON_COLOR, (Integer) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;              	
  		}  		

  		
  		
  		
  		
  		
  	}
     	return true;
    }    	

    
    private void clearCheckMarks() {
    	
       	mIconColor.setChecked(false);
       	mBatteryCircleColorOne.setChecked(false);
       	mBatteryCircleColorTwo.setChecked(false);
       	mBatteryCircleColorThree.setChecked(false);
       	mBatteryNumberColorOne.setChecked(false);
       	mBatteryNumberColorTwo.setChecked(false);
       	mBatteryNumberColorThree.setChecked(false);
       	mDepletedLevelColorOne.setChecked(false);
		mDepletedLevelColorTwo.setChecked(false);
		mDepletedLevelColorThree.setChecked(false);
		mBatteryLevelColorOne.setChecked(false);
		mBatteryLevelColorTwo.setChecked(false);
		mBatteryLevelColorThree.setChecked(false);
		mChargingLevelColorOne.setChecked(false);
		mChargingLevelColorTwo.setChecked(false);
		mChargingLevelColorThree.setChecked(false);
	    mNavBarColor.setChecked(false);
	    mNavBarButtonColor.setChecked(false);
	    mNavBarGlowColor.setChecked(false);
	    mNavLightsoutColor.setChecked(false);
		mCarrierColor.setChecked(false);
	    mBatteryColor.setChecked(false);
	    mTempColor.setChecked(false);
        mCloseBarColor.setChecked(false);
    	mHeaderBar.setChecked(false);
    	mHeaderClock.setChecked(false);
    	mHeaderDate.setChecked(false);
    	mHeaderButton.setChecked(false);
        mShadeColor.setChecked(false);
        mNotifIconBgColor.setChecked(false);
        mNotifTextBgColor.setChecked(false);
        mNotifTitleColor.setChecked(false);
        mNotifTimeColor.setChecked(false);
        mNotifTextColor.setChecked(false);
        mNotifDividerColor.setChecked(false);
        mNotifSubtextColor.setChecked(false);
        mNotifSmallIconColor.setChecked(false);
        mClockColor.setChecked(false);
    	mToggleColor.setChecked(false);
    	mToggleIconOnColor.setChecked(false);
    	mToggleIconInterColor.setChecked(false);
    	mToggleIconOffColor.setChecked(false);
        mToggleIndOnColor.setChecked(false);
        mToggleIndOffColor.setChecked(false);
        mToggleTextOnColor.setChecked(false);
        mToggleTextOffColor.setChecked(false);
        mToggleDividerColor.setChecked(false);
    }
    
}