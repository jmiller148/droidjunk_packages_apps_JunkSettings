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


import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.CheckBoxPreference;
import android.widget.TimePicker;


public class CustomQuietTimeSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
	private final String Junk_QuietTime_Settings = "JUNK_QUIET_TIME_SETTINGS";
	private final String QUIET_TIME = "quiet_time_on";
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
    
	private SharedPreferences sp;
	
	private CheckBoxPreference mQuietTimeOn;
	
    private Preference mQtStartHour;
    private Preference mQtStartMin;
    private Preference mQtStopHour;
    private Preference mQtStopMin;
    private CheckBoxPreference mQtNotifLedOn;
    private CheckBoxPreference mQtNotifSoundOn;
    private CheckBoxPreference mQtNotifVibrateOn;
  
    public String mDayString;
    public int QtStartTime = 21;
    public int QtStartHour = 0;
    public int QtStartMin = 0;
    public int QtStopTime = 7;
    public int QtStopHour = 0;
    public int QtStopMin = 0;
    
    public int day;
    private String mTitle, mSummaryOn, mSummaryOff;
    
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        day = getActivity().getIntent().getIntExtra("junk_qt_day", 0); 
        
        sp = getActivity().getBaseContext().getSharedPreferences("Junk_Settings", Context.MODE_WORLD_READABLE);
        
        addPreferencesFromResource(R.xml.custom_quiet_time_settings);
        
        mQuietTimeOn = (CheckBoxPreference) findPreference(QUIET_TIME);
        mQuietTimeOn.setOnPreferenceChangeListener(this);
        mQtStartHour = (Preference) findPreference(START_HOUR);
        mQtStartHour.setOnPreferenceChangeListener(this);
        mQtStartMin = (Preference) findPreference(START_MIN);
        mQtStopHour = (Preference) findPreference(STOP_HOUR);
        mQtStopHour.setOnPreferenceChangeListener(this);
        mQtStopMin = (Preference) findPreference(STOP_MIN);
        mQtNotifLedOn = (CheckBoxPreference) findPreference(NOTIF_LED_ON);
		mQtNotifLedOn.setOnPreferenceChangeListener(this);
		mQtNotifSoundOn = (CheckBoxPreference) findPreference(NOTIF_SOUND_ON);
		mQtNotifSoundOn.setOnPreferenceChangeListener(this);
		mQtNotifVibrateOn = (CheckBoxPreference) findPreference(NOTIF_VIBRATE_ON);
		mQtNotifVibrateOn.setOnPreferenceChangeListener(this);
		
		

        if (day == 0) {
        	mTitle = "Daily";
        	mSummaryOn = "Daily is on";
        	mSummaryOff = "Daily is off";
        	mDayString = QT_DAILY;
        } else if (day == 1) {
        	mTitle = "Sunday";
        	mSummaryOn = "Sunday is on";
        	mSummaryOff = "Sunday is off";
        	mDayString = QT_SUN;
        } else if (day == 2) {
        	mTitle = "Monday";
        	mSummaryOn = "Monday is on";
        	mSummaryOff = "Monday is off";
        	mDayString = QT_MON;
        } else if (day == 3) {
        	mTitle = "Tuesday";
        	mSummaryOn = "Tuesday is on";
        	mSummaryOff = "Tuesday is off";
        	mDayString = QT_TUE;
        } else if (day == 4) {
        	mTitle = "Wednesday";
        	mSummaryOn = "Wednesday is on";
        	mSummaryOff = "Wednesday is off";
        	mDayString = QT_WED;
        } else if (day == 5) {
        	mTitle = "Thursday";
        	mSummaryOn = "Thursday is on";
        	mSummaryOff = "Thursday is off";
        	mDayString = QT_THUR;
        } else if (day == 6) {
        	mTitle = "Friday";
        	mSummaryOn = "Friday is on";
        	mSummaryOff = "Friday is off";
        	mDayString = QT_FRI;
        } else if (day == 7) {
        	mTitle = "Saturday";
        	mSummaryOn = "Saturday is on";
        	mSummaryOff = "Saturday is off";
        	mDayString = QT_SAT;
        };
        
        mQuietTimeOn.setChecked(sp.getBoolean(QUIET_TIME + mDayString, false));
        mQuietTimeOn.setTitle(mTitle);
        mQuietTimeOn.setSummaryOn(mSummaryOn);
        mQuietTimeOn.setSummaryOff(mSummaryOff);
        mQtNotifLedOn.setChecked(sp.getBoolean(NOTIF_LED_ON + mDayString, false));
        mQtNotifSoundOn.setChecked(sp.getBoolean(NOTIF_SOUND_ON + mDayString, false));
        mQtNotifVibrateOn.setChecked(sp.getBoolean(NOTIF_VIBRATE_ON + mDayString, false));
		QtStartHour = sp.getInt(START_HOUR + mDayString, 21);
		QtStartMin = sp.getInt(START_MIN + mDayString, 0);
		QtStopHour = sp.getInt(STOP_HOUR + mDayString, 7);
		QtStopMin = sp.getInt(STOP_MIN + mDayString, 0);
		
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

    	if (preference == mQtStartHour) {
			new TimePickerDialog(preferenceScreen.getContext(),
                    startTimeListener,
            		QtStartHour,
                    QtStartMin,
                    false).show();
        } else if (preference == mQtStopHour) {
        	new TimePickerDialog(preferenceScreen.getContext(),
                    stopTimeListener,
            		QtStopHour,
                    QtStopMin,
                    false).show();
        }
 
    	return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
  
    

    public boolean onPreferenceChange(Preference preference, Object objValue) {
  
     	final String key = preference.getKey();
     	
     	if (QUIET_TIME.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putBoolean(QUIET_TIME + mDayString, (Boolean) objValue);
            editor.commit();

            Intent i = new Intent();
            i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(QUIET_TIME, (Boolean) objValue);
            getActivity().sendBroadcast(i);
            i = null;
            
        } else if (START_HOUR.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putInt(START_HOUR + mDayString, QtStartHour);
            editor.putInt(START_MIN + mDayString, QtStartMin);
            editor.commit();

            Intent i = new Intent();
        	i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(START_HOUR, QtStartHour);
            i.putExtra(START_MIN, QtStartMin);
        	getActivity().sendBroadcast(i);
        	i = null;

        } else if (STOP_HOUR.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putInt(STOP_HOUR + mDayString, QtStopHour);
            editor.putInt(STOP_MIN + mDayString, QtStopMin);
            editor.commit();

            Intent i = new Intent();
        	i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(STOP_HOUR, QtStopHour);
            i.putExtra(STOP_MIN, QtStopMin);
        	getActivity().sendBroadcast(i);
        	i = null;
                
        }  else if (NOTIF_LED_ON.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putBoolean(NOTIF_LED_ON + mDayString, (Boolean) objValue);
            editor.commit();

            Intent i = new Intent();
        	i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(NOTIF_LED_ON, (Boolean) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;
            
        } else if (NOTIF_SOUND_ON.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putBoolean(NOTIF_SOUND_ON + mDayString, (Boolean) objValue);
            editor.commit();

            Intent i = new Intent();
        	i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(NOTIF_SOUND_ON, (Boolean) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;
            
        } else if (NOTIF_VIBRATE_ON.equals(key)) {
           	SharedPreferences.Editor editor = sp.edit();
           	editor.putBoolean(NOTIF_VIBRATE_ON + mDayString, (Boolean) objValue);
            editor.commit();

            Intent i = new Intent();
        	i.setAction(Junk_QuietTime_Settings + mDayString);
            i.putExtra(NOTIF_VIBRATE_ON, (Boolean) objValue);
        	getActivity().sendBroadcast(i);
        	i = null;
        }
        return true;
    }
    
    
    
    TimePickerDialog.OnTimeSetListener startTimeListener =
            new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				
					QtStartHour = hourOfDay;
					QtStartMin = minute;
		    		mQtStartHour.getOnPreferenceChangeListener().onPreferenceChange(mQtStartHour, hourOfDay);
				}
			}; 
   
			
    TimePickerDialog.OnTimeSetListener stopTimeListener =
            new TimePickerDialog.OnTimeSetListener() {
						
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
							
				QtStopHour = hourOfDay;
				QtStopMin = minute;
				mQtStopHour.getOnPreferenceChangeListener().onPreferenceChange(mQtStopHour, hourOfDay);
			}
		}; 
    
    
		
		
		
    
}