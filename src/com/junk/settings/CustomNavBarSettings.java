package com.junk.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ColorPickerPreference;
import android.preference.DJSeekBarPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;



public class CustomNavBarSettings extends PreferenceFragment 
	implements Preference.OnPreferenceChangeListener {

	private final String Junk_NavBar_Settings = "JUNK_NAVBAR_SETTINGS";
    private final String NAV_BAR_ANIM_SPEED = "nav_anim_speed";
    private final String NAV_BAR_BUTTON_INTENS = "nav_button_intens";
	private final String SHOW_LEFT_MENU_BUTTON = "left_menu_button";
	private final String SHOW_RIGHT_MENU_BUTTON = "right_menu_button";
	private final String SHOW_TOP_MENU_BUTTON_LAND = "top_menu_button_land";
	private final String SHOW_BOT_MENU_BUTTON_LAND = "bottom_menu_button_land";

	private PreferenceManager prefMgr;

	private DJSeekBarPreference mNavBarAnimSpeed;
	private DJSeekBarPreference mNavBarButtonIntens;
	private CheckBoxPreference mShowLeftMenuButton;
	private CheckBoxPreference mShowRightMenuButton;
	private CheckBoxPreference mShowTopMenuButtonLand;
	private CheckBoxPreference mShowBotMenuButtonLand;
	

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            prefMgr = getPreferenceManager();
            prefMgr.setSharedPreferencesName("Junk_Settings");
            prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
            prefMgr.getSharedPreferences();
            
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.custom_navbar_settings);

            mNavBarAnimSpeed = (DJSeekBarPreference) findPreference(NAV_BAR_ANIM_SPEED);
            mNavBarAnimSpeed.setOnPreferenceChangeListener(this);
            mNavBarAnimSpeed.setMax(5);
            mNavBarAnimSpeed.setProgress(prefMgr.getSharedPreferences().getInt(NAV_BAR_ANIM_SPEED, 5));  
            mNavBarButtonIntens = (DJSeekBarPreference) findPreference(NAV_BAR_BUTTON_INTENS);
            mNavBarButtonIntens.setOnPreferenceChangeListener(this);
            mNavBarButtonIntens.setMax(5);
            mNavBarButtonIntens.setProgress(prefMgr.getSharedPreferences().getInt(NAV_BAR_BUTTON_INTENS, 0));  
            mShowLeftMenuButton = (CheckBoxPreference) findPreference(SHOW_LEFT_MENU_BUTTON);
            mShowLeftMenuButton.setOnPreferenceChangeListener(this);
            mShowRightMenuButton = (CheckBoxPreference) findPreference(SHOW_RIGHT_MENU_BUTTON);
            mShowRightMenuButton.setOnPreferenceChangeListener(this);
            mShowTopMenuButtonLand = (CheckBoxPreference) findPreference(SHOW_TOP_MENU_BUTTON_LAND);
            mShowTopMenuButtonLand.setOnPreferenceChangeListener(this);
            mShowBotMenuButtonLand = (CheckBoxPreference) findPreference(SHOW_BOT_MENU_BUTTON_LAND);
            mShowBotMenuButtonLand.setOnPreferenceChangeListener(this);
        }


       public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                Preference preference) {

            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
       
       

        @Override
        public boolean onPreferenceChange(Preference preference, Object objValue) {
 
        	final String key = preference.getKey();
        	
            if (NAV_BAR_ANIM_SPEED.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
           	   	i.putExtra(NAV_BAR_ANIM_SPEED, (Integer) objValue);
           	   	getActivity().sendBroadcast(i);
           	   	i = null;           	   	
           	   	
            } else if (NAV_BAR_BUTTON_INTENS.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
            	i.putExtra(NAV_BAR_BUTTON_INTENS, (Integer) objValue);
            	getActivity().sendBroadcast(i);
            	i = null;        
           	   	
            } else if (SHOW_LEFT_MENU_BUTTON.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
            	i.putExtra(SHOW_LEFT_MENU_BUTTON, (Boolean) objValue);
            	getActivity().sendBroadcast(i);
            	i = null;        

            } else if (SHOW_RIGHT_MENU_BUTTON.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
            	i.putExtra(SHOW_RIGHT_MENU_BUTTON, (Boolean) objValue);
            	getActivity().sendBroadcast(i);
            	i = null;        

            } else if (SHOW_TOP_MENU_BUTTON_LAND.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
            	i.putExtra(SHOW_TOP_MENU_BUTTON_LAND, (Boolean) objValue);
            	getActivity().sendBroadcast(i);
            	i = null;        

            } else if (SHOW_BOT_MENU_BUTTON_LAND.equals(key)) {
            	Intent i = new Intent();
            	i.setAction(Junk_NavBar_Settings );
            	i.putExtra(SHOW_BOT_MENU_BUTTON_LAND, (Boolean) objValue);
            	getActivity().sendBroadcast(i);
            	i = null;        

            }
            
			return true;
        }

}
