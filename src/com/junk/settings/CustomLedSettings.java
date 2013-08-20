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



public class CustomLedSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
 

	private final String Junk_Led_Settings = "JUNK_LED_SETTINGS";
	private final String USE_LED = "use_led";
	private final String DEFAULT_LED_COLOR_ON = "default_led_color_on";	
	private final String DEFAULT_LED_COLOR = "default_led_color";	
	private final String DEFAULT_LED_ON_MS = "default_led_on_ms";
	private final String DEFAULT_LED_OFF_MS = "default_led_off_ms";
	private final String PULSE_LED_SCREEN_ON = "pulse_led_screen_on";
	
	private final String INCOMING_CALL_LED_ON = "incoming_call_led_on";
	private final String INCOMING_CALL_LED_COLOR = "incoming_call_color";
	private final String INCOMING_CALL_LED_PULSE = "incoming_call_pulse";
	private final String INCOMING_CALL_LED_ON_MS = "incoming_led_on_ms";
	private final String INCOMING_CALL_LED_OFF_MS = "incoming_led_off_ms";
	
	private final String MISSED_CALL_LED_ON = "missed_call_led_on";
	private final String MISSED_CALL_LED_COLOR = "missed_call_color";
	private final String MISSED_CALL_LED_PULSE = "missed_call_pulse";
	private final String MISSED_CALL_LED_ON_MS = "missed_call_led_on_ms";
	private final String MISSED_CALL_LED_OFF_MS = "missed_call_led_off_ms";
	
	private final String VOICE_MAIL_LED_ON = "voice_mail_led_on";
	private final String VOICE_MAIL_LED_COLOR = "voice_mail_color";
	private final String VOICE_MAIL_LED_PULSE = "voice_mail_pulse";
	private final String VOICE_MAIL_LED_ON_MS = "voice_mail_led_on_ms";
	private final String VOICE_MAIL_LED_OFF_MS = "voice_mail_led_off_ms";
	
	private PreferenceManager prefMgr;

	private CheckBoxPreference mUseLed;
	private CheckBoxPreference mDefaultLedColorOn;
	private Preference mDefaultLedColor;
	private DJSeekBarPreference mDefaultLedOnMs;
	private DJSeekBarPreference mDefaultLedOffMs;
	private CheckBoxPreference mPulseLedScreenOn;

    private CheckBoxPreference mIncomingCallLedOn;
    private Preference mIncomingCallColor;
	private CheckBoxPreference mIncomingCallPulse;
	private DJSeekBarPreference mIncomingCallLedOnMs;
	private DJSeekBarPreference mIncomingCallLedOffMs;

	private CheckBoxPreference mMissedCallLedOn;
    private Preference mMissedCallColor;
	private CheckBoxPreference mMissedCallPulse;
	private DJSeekBarPreference mMissedCallLedOnMs;
	private DJSeekBarPreference mMissedCallLedOffMs;

	private CheckBoxPreference mVoiceMailLedOn;
    private Preference mVoiceMailColor;
	private CheckBoxPreference mVoiceMailPulse;
	private DJSeekBarPreference mVoiceMailLedOnMs;
	private DJSeekBarPreference mVoiceMailLedOffMs;
	
	
    /** If there is no setting in the provider, use this. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("Junk_Settings");
        prefMgr.setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        prefMgr.getSharedPreferences();
        
        addPreferencesFromResource(R.xml.custom_led_settings);
        
        mUseLed = (CheckBoxPreference) findPreference(USE_LED);
        mUseLed.setOnPreferenceChangeListener(this);
        mDefaultLedColorOn = (CheckBoxPreference) findPreference(DEFAULT_LED_COLOR_ON);
        mDefaultLedColorOn.setOnPreferenceChangeListener(this);
        mDefaultLedColor = (Preference) findPreference(DEFAULT_LED_COLOR);
        mDefaultLedColor.setOnPreferenceChangeListener(this);
        mDefaultLedOnMs = (DJSeekBarPreference) findPreference(DEFAULT_LED_ON_MS);
        mDefaultLedOnMs.setOnPreferenceChangeListener(this);
        mDefaultLedOffMs = (DJSeekBarPreference) findPreference(DEFAULT_LED_OFF_MS);
        mDefaultLedOffMs.setOnPreferenceChangeListener(this);

        mPulseLedScreenOn = (CheckBoxPreference) findPreference(PULSE_LED_SCREEN_ON);
        mPulseLedScreenOn.setOnPreferenceChangeListener(this);

        mIncomingCallLedOn = (CheckBoxPreference) findPreference(INCOMING_CALL_LED_ON);
        mIncomingCallLedOn.setOnPreferenceChangeListener(this);
        mIncomingCallColor = (Preference) findPreference(INCOMING_CALL_LED_COLOR);
        mIncomingCallColor.setOnPreferenceChangeListener(this);
        mIncomingCallPulse = (CheckBoxPreference) findPreference(INCOMING_CALL_LED_PULSE);
        mIncomingCallPulse.setOnPreferenceChangeListener(this);
        mIncomingCallLedOnMs = (DJSeekBarPreference) findPreference(INCOMING_CALL_LED_ON_MS);
        mIncomingCallLedOnMs.setOnPreferenceChangeListener(this);
        mIncomingCallLedOffMs = (DJSeekBarPreference) findPreference(INCOMING_CALL_LED_OFF_MS);
        mIncomingCallLedOffMs.setOnPreferenceChangeListener(this);        

        mMissedCallLedOn = (CheckBoxPreference) findPreference(MISSED_CALL_LED_ON);
        mMissedCallLedOn.setOnPreferenceChangeListener(this);
        mMissedCallColor = (Preference) findPreference(MISSED_CALL_LED_COLOR);
        mMissedCallColor.setOnPreferenceChangeListener(this);
        mMissedCallPulse = (CheckBoxPreference) findPreference(MISSED_CALL_LED_PULSE);
        mMissedCallPulse.setOnPreferenceChangeListener(this);
        mMissedCallLedOnMs = (DJSeekBarPreference) findPreference(MISSED_CALL_LED_ON_MS);
        mMissedCallLedOnMs.setOnPreferenceChangeListener(this);
        mMissedCallLedOffMs = (DJSeekBarPreference) findPreference(MISSED_CALL_LED_OFF_MS);
        mMissedCallLedOffMs.setOnPreferenceChangeListener(this);                
        
        mVoiceMailLedOn = (CheckBoxPreference) findPreference(VOICE_MAIL_LED_ON);
        mVoiceMailLedOn.setOnPreferenceChangeListener(this);
        mVoiceMailColor = (Preference) findPreference(VOICE_MAIL_LED_COLOR);
        mVoiceMailColor.setOnPreferenceChangeListener(this);
        mVoiceMailPulse = (CheckBoxPreference) findPreference(VOICE_MAIL_LED_PULSE);
        mVoiceMailPulse.setOnPreferenceChangeListener(this);
        mVoiceMailLedOnMs = (DJSeekBarPreference) findPreference(VOICE_MAIL_LED_ON_MS);
        mVoiceMailLedOnMs.setOnPreferenceChangeListener(this);
        mVoiceMailLedOffMs = (DJSeekBarPreference) findPreference(VOICE_MAIL_LED_OFF_MS);
        mVoiceMailLedOffMs.setOnPreferenceChangeListener(this);            
        
        
        mDefaultLedOnMs.setMax(50);
        mDefaultLedOnMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(DEFAULT_LED_ON_MS, 3));
        mDefaultLedOnMs.setProgress(prefMgr.getSharedPreferences().getInt(DEFAULT_LED_ON_MS, 3));      
        mDefaultLedOffMs.setMax(50);
        mDefaultLedOffMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(DEFAULT_LED_OFF_MS, 3));
        mDefaultLedOffMs.setProgress(prefMgr.getSharedPreferences().getInt(DEFAULT_LED_OFF_MS, 3));        
        
        
        mIncomingCallLedOnMs.setMax(50);
        mIncomingCallLedOnMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(INCOMING_CALL_LED_ON_MS, 3));
        mIncomingCallLedOnMs.setProgress(prefMgr.getSharedPreferences().getInt(INCOMING_CALL_LED_ON_MS, 3)); 
        mIncomingCallLedOffMs.setMax(50);
        mIncomingCallLedOffMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(INCOMING_CALL_LED_OFF_MS, 3));
        mIncomingCallLedOffMs.setProgress(prefMgr.getSharedPreferences().getInt(INCOMING_CALL_LED_OFF_MS, 3)); 

        mMissedCallLedOnMs.setMax(50);
        mMissedCallLedOnMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(MISSED_CALL_LED_ON_MS, 3));
        mMissedCallLedOnMs.setProgress(prefMgr.getSharedPreferences().getInt(MISSED_CALL_LED_ON_MS, 3)); 
        mMissedCallLedOffMs.setMax(50);
        mMissedCallLedOffMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(MISSED_CALL_LED_OFF_MS, 3));
        mMissedCallLedOffMs.setProgress(prefMgr.getSharedPreferences().getInt(MISSED_CALL_LED_OFF_MS, 3)); 
        
        mVoiceMailLedOnMs.setMax(50);
        mVoiceMailLedOnMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(VOICE_MAIL_LED_ON_MS, 3));
        mVoiceMailLedOnMs.setProgress(prefMgr.getSharedPreferences().getInt(VOICE_MAIL_LED_ON_MS, 3)); 
        mVoiceMailLedOffMs.setMax(50);
        mVoiceMailLedOffMs.setDefaultValue(prefMgr.getSharedPreferences().getInt(VOICE_MAIL_LED_OFF_MS, 3));
        mVoiceMailLedOffMs.setProgress(prefMgr.getSharedPreferences().getInt(VOICE_MAIL_LED_OFF_MS, 3)); 
		
    }

 
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
    

    public boolean onPreferenceChange(Preference preference, Object objValue) {
    	
    	final String key = preference.getKey();

     	if (USE_LED.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(USE_LED, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 
    	
     	} else if (DEFAULT_LED_COLOR_ON.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(DEFAULT_LED_COLOR_ON, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

     	} else if (DEFAULT_LED_COLOR.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(DEFAULT_LED_COLOR, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

        } else if (DEFAULT_LED_ON_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(DEFAULT_LED_ON_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

        } else if (DEFAULT_LED_OFF_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(DEFAULT_LED_OFF_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

        } else if (PULSE_LED_SCREEN_ON.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(PULSE_LED_SCREEN_ON, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

        } else if (INCOMING_CALL_LED_ON.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(INCOMING_CALL_LED_ON, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 

        } else if (INCOMING_CALL_LED_PULSE.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(INCOMING_CALL_LED_PULSE, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null; 
        
        } else if (INCOMING_CALL_LED_COLOR.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(INCOMING_CALL_LED_COLOR, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
        
        } else if (INCOMING_CALL_LED_ON_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(INCOMING_CALL_LED_ON_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
       
        } else if (INCOMING_CALL_LED_OFF_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(INCOMING_CALL_LED_OFF_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
          
        } else if (MISSED_CALL_LED_ON.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(MISSED_CALL_LED_ON, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
            
        } else if (MISSED_CALL_LED_PULSE.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(MISSED_CALL_LED_PULSE, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
        
        } else if (MISSED_CALL_LED_COLOR.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(MISSED_CALL_LED_COLOR, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
        
        } else if (MISSED_CALL_LED_ON_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(MISSED_CALL_LED_ON_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
       
        } else if (MISSED_CALL_LED_OFF_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(MISSED_CALL_LED_OFF_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
      
        } else if (VOICE_MAIL_LED_ON.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(VOICE_MAIL_LED_ON, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
            
        }  else if (VOICE_MAIL_LED_PULSE.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(VOICE_MAIL_LED_PULSE, (Boolean) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
        
        } else if (VOICE_MAIL_LED_COLOR.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(VOICE_MAIL_LED_COLOR, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
        
        } else if (VOICE_MAIL_LED_ON_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(VOICE_MAIL_LED_ON_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
       
        } else if (VOICE_MAIL_LED_OFF_MS.equals(key)) {
         	Intent i = new Intent();
         	i.setAction(Junk_Led_Settings);
         	i.putExtra(VOICE_MAIL_LED_OFF_MS, (Integer) objValue);
         	getActivity().sendBroadcast(i);
         	i = null;
            
        }
     	

        return true;
    }
    
    
    
    
    
    
    
                
}