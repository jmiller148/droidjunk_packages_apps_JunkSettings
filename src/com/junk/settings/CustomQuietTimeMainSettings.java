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
import android.preference.PreferenceScreen;
import android.preference.CheckBoxPreference;
import android.text.Html;


public class CustomQuietTimeMainSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
	private final String Junk_QuietTime_Settings = "JUNK_QUIET_TIME_SETTINGS";
	private final String QUIET_TIME = "quiet_time_on";
	private final String QUIET_TIME_NOTIF = "quiet_time_notif";
	private final String QUIET_TIME_DAILY = "qt_daily";
	private final String QUIET_TIME_SUN = "qt_sunday";
	private final String QUIET_TIME_MON = "qt_monday";
	private final String QUIET_TIME_TUE = "qt_tuesday";
	private final String QUIET_TIME_WED = "qt_wednesday";
	private final String QUIET_TIME_THUR = "qt_thursday";
	private final String QUIET_TIME_FRI = "qt_friday";
	private final String QUIET_TIME_SAT = "qt_saturday";

	private final String START_HOUR = "qt_start_hour";
	private final String START_MIN = "qt_start_min";
	private final String STOP_HOUR = "qt_stop_hour";
	private final String STOP_MIN = "qt_stop_min";
	private final String NOTIF_LED_ON = "qt_led_on";
	private final String NOTIF_SOUND_ON = "qt_sound_on";
	private final String NOTIF_VIBRATE_ON = "qt_vibrate_on";
	private final String QT_DAILY = "_daily";
	private final String QT_SUN = "_sun";
	private final String QT_MON = "_mon";
	private final String QT_TUE = "_tue";
	private final String QT_WED = "_wed";
	private final String QT_THUR = "_thur";
	private final String QT_FRI = "_fri";
	private final String QT_SAT = "_sat";
    
	
	private CheckBoxPreference mQuietTimeOn;
	private CheckBoxPreference mQtNotifOn;
    private Preference mQtDaily;
    private Preference mQtSunday;
    private Preference mQtMonday;
    private Preference mQtTuesday;
    private Preference mQtWednesday;
    private Preference mQtThursday;
    private Preference mQtFriday;
    private Preference mQtSaturday;
    
    private SharedPreferences sp;
    public String mDayString;
    private boolean dailyOn, sunOn, monOn, tueOn, wedOn, thurOn, friOn, satOn = false;
    private boolean mTurnOffLed = false;
    private boolean mTurnOffSound = false;
    private boolean mTurnOffVibrate = false;
    private int mStopMin = 0;
    private int mStopHour = 0;
    private int mStartMin = 0;
    private int mStartHour = 0;    

    
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        sp = getActivity().getBaseContext().getSharedPreferences(
        		"Junk_Settings", Context.MODE_WORLD_READABLE);
        
        addPreferencesFromResource(R.xml.custom_quiet_time_main_settings);
        
        mQuietTimeOn = (CheckBoxPreference) findPreference(QUIET_TIME);
        mQuietTimeOn.setOnPreferenceChangeListener(this);
        mQtNotifOn = (CheckBoxPreference) findPreference(QUIET_TIME_NOTIF);
        mQtNotifOn.setOnPreferenceChangeListener(this);
        
        mQtDaily = (Preference) findPreference(QUIET_TIME_DAILY);
        mQtDaily.setOnPreferenceChangeListener(this);
        mQtSunday = (Preference) findPreference(QUIET_TIME_SUN);
        mQtSunday.setOnPreferenceChangeListener(this);
        mQtMonday = (Preference) findPreference(QUIET_TIME_MON);
        mQtMonday.setOnPreferenceChangeListener(this);
        mQtTuesday = (Preference) findPreference(QUIET_TIME_TUE);
        mQtTuesday.setOnPreferenceChangeListener(this);
        mQtWednesday = (Preference) findPreference(QUIET_TIME_WED);
        mQtWednesday.setOnPreferenceChangeListener(this);
        mQtThursday = (Preference) findPreference(QUIET_TIME_THUR);
        mQtThursday.setOnPreferenceChangeListener(this);
        mQtFriday = (Preference) findPreference(QUIET_TIME_FRI);
        mQtFriday.setOnPreferenceChangeListener(this);
        mQtSaturday = (Preference) findPreference(QUIET_TIME_SAT);
        mQtSaturday.setOnPreferenceChangeListener(this);

        setSummary();
     }

    
    
    @Override
    public void onResume() {
        super.onResume();
        setSummary();
    }

    
    @Override
    public void onPause() {
        super.onPause();
    }

 
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

    	if (preference == mQtDaily) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 0);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtSunday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 1);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtMonday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 2);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtTuesday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 3);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtWednesday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 4);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtThursday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 5);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtFriday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 6);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;

    	} else if (preference == mQtSaturday) {
		    Intent i = new Intent();
		    i.setAction("com.junk.settings.CUSTOM_QUIET_TIME_SETTINGS");
		    i.putExtra("junk_qt_day", 7);
	        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getActivity().getBaseContext().startActivity(i);
	        i = null;
    		
    	}
    	return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
  
    

    public boolean onPreferenceChange(Preference preference, Object objValue) {
  
     	final String key = preference.getKey();
     	
     	if (QUIET_TIME.equals(key)) {
            Intent i = new Intent();
            i.setAction(Junk_QuietTime_Settings);
            i.putExtra(QUIET_TIME, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        } else if (QUIET_TIME_NOTIF.equals(key)) {
            Intent i = new Intent();
            i.setAction(Junk_QuietTime_Settings);
            i.putExtra(QUIET_TIME_NOTIF, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
        }
     	return true;
    }
    
    
    private void setSummary() {

       	mQtDaily.setSummary(getSettingString(QT_DAILY));
       	mQtSunday.setSummary(getSettingString(QT_SUN));
       	mQtMonday.setSummary(getSettingString(QT_MON));
       	mQtTuesday.setSummary(getSettingString(QT_TUE));
       	mQtWednesday.setSummary(getSettingString(QT_WED));
       	mQtThursday.setSummary(getSettingString(QT_THUR));
       	mQtFriday.setSummary(getSettingString(QT_FRI));
       	mQtSaturday.setSummary(getSettingString(QT_SAT));
    }
    
    
    private String getSettingString(String id) {
        String minPad = "";
        String OnOff = "";
        String notifStop = "";
        String notifStart = "";
        
    	if (sp.getBoolean(QUIET_TIME + id, false) == false) {
    		OnOff = "OFF";
    	} else OnOff = "ON";
        
		mStartHour = sp.getInt(START_HOUR + id, 21);
		mStartMin = sp.getInt(START_MIN + id, 0);
		mStopHour = sp.getInt(STOP_HOUR + id, 7);
		mStopMin = sp.getInt(STOP_MIN + id, 0);
        
        
      	if (mStopMin < 10) minPad = "0";
        if (mStopHour > 12) {
           	notifStop = String.valueOf(mStopHour - 12) + ":" + minPad + String.valueOf(mStopMin) + "pm";;
        } else {
           	notifStop = String.valueOf(mStopHour) + ":" + minPad + String.valueOf(mStopMin) + "am";;
        }
        minPad = "";
      	if (mStartMin < 10) minPad = "0";
        if (mStartHour > 12) {
           	notifStart = String.valueOf(mStartHour - 12) + ":" + minPad + String.valueOf(mStartMin) + "pm";
        } else {
           	notifStart = String.valueOf(mStartHour) + ":" + minPad + String.valueOf(mStartMin) + "am";;
        }
        
    	return OnOff + " : " + notifStart + " - " + notifStop;
    }		
		
		
    
}