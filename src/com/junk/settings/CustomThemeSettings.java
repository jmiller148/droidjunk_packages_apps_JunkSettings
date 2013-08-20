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



import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class CustomThemeSettings extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
   
	
	private final String JUNK_THEME_PRESETS = "theme_presets";
	private final String JUNK_THEME_ONE_NAME = "theme_one_name";
	private final String JUNK_THEME_ONE_SAVE = "theme_one_save";
	private final String JUNK_THEME_ONE_APPLY = "theme_one_apply";
	private final String JUNK_THEME_TWO_NAME = "theme_two_name";
	private final String JUNK_THEME_TWO_SAVE = "theme_two_save";
	private final String JUNK_THEME_TWO_APPLY = "theme_two_apply";
	private final String JUNK_THEME_THREE_NAME = "theme_three_name";
	private final String JUNK_THEME_THREE_SAVE = "theme_three_save";
	private final String JUNK_THEME_THREE_APPLY = "theme_three_apply";
	private final String SAVED_THEME = "saved_theme";
	
	private Preference mThemePresets;
	private Preference mThemeOneName;
	private Preference mThemeOneSave;
	private Preference mThemeOneApply;
	private Preference mThemeTwoName;
	private Preference mThemeTwoSave;
	private Preference mThemeTwoApply;
	private Preference mThemeThreeName;
	private Preference mThemeThreeSave;
	private Preference mThemeThreeApply;

	private SharedPreferences prefMgr;
	private SharedPreferences.Editor editor = null;
	private int ThemePresetValue = 0;
	private int SelectedThemePresetValue = 0;
	private String themeOneName, themeTwoName, themeThreeName;
	private int mThemeNum = 0;
	private EditText mEditText;
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(R.xml.custom_theme_settings);
        
        mThemePresets = findPreference(JUNK_THEME_PRESETS);
        mThemePresets.setOnPreferenceChangeListener(this);
        mThemeOneName = findPreference(JUNK_THEME_ONE_NAME);
        mThemeOneName.setOnPreferenceChangeListener(this);
        mThemeOneSave = findPreference(JUNK_THEME_ONE_SAVE);
        mThemeOneSave.setOnPreferenceChangeListener(this);
        mThemeOneApply = findPreference(JUNK_THEME_ONE_APPLY);
        mThemeOneApply.setOnPreferenceChangeListener(this);
        mThemeTwoName = findPreference(JUNK_THEME_TWO_NAME);
        mThemeTwoName.setOnPreferenceChangeListener(this);
        mThemeTwoSave = findPreference(JUNK_THEME_TWO_SAVE);
        mThemeTwoSave.setOnPreferenceChangeListener(this);
        mThemeTwoApply = findPreference(JUNK_THEME_TWO_APPLY);
        mThemeTwoApply.setOnPreferenceChangeListener(this);
        mThemeThreeName = findPreference(JUNK_THEME_THREE_NAME);
        mThemeThreeName.setOnPreferenceChangeListener(this);
        mThemeThreeSave = findPreference(JUNK_THEME_THREE_SAVE);
        mThemeThreeSave.setOnPreferenceChangeListener(this);
        mThemeThreeApply = findPreference(JUNK_THEME_THREE_APPLY);
        mThemeThreeApply.setOnPreferenceChangeListener(this);
        
        prefMgr = getActivity().getBaseContext().getSharedPreferences(
        		"Junk_Theme_One", Context.MODE_WORLD_READABLE);    		
    	mThemeOneApply.setEnabled(prefMgr.getBoolean(SAVED_THEME,false));
    	themeOneName = prefMgr.getString(JUNK_THEME_ONE_NAME,"Theme Name - 1");
    	mThemeOneName.setTitle(themeOneName);

        prefMgr = getActivity().getBaseContext().getSharedPreferences(
           		"Junk_Theme_Two", Context.MODE_WORLD_READABLE);
        mThemeTwoApply.setEnabled(prefMgr.getBoolean(SAVED_THEME,false));
        themeTwoName = prefMgr.getString(JUNK_THEME_TWO_NAME,"Theme Name - 2");
        mThemeTwoName.setTitle(themeTwoName);

        prefMgr = getActivity().getBaseContext().getSharedPreferences(
           		"Junk_Theme_Three", Context.MODE_WORLD_READABLE);
        mThemeThreeApply.setEnabled(prefMgr.getBoolean(SAVED_THEME,false));
        themeThreeName = prefMgr.getString(JUNK_THEME_THREE_NAME,"Theme Name - 3");
        mThemeThreeName.setTitle(themeThreeName);      
        
    }

 
	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}   
	
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
    	
    	if (preference == mThemePresets) {
    		showThemePresetsDialog();
    		
    	} else if (preference == mThemeOneName){
    		showThemeNameDialog(1);
    		
    	} else if (preference == mThemeOneSave){
    		showThemeSaveDialog(1);
    		
    	} else if (preference == mThemeOneApply){
    		showThemeApplyDialog(1);

    	} else if (preference == mThemeTwoName){
    		showThemeNameDialog(2);
    		
    	} else if (preference == mThemeTwoSave){
    		showThemeSaveDialog(2);
    		
    	} else if (preference == mThemeTwoApply){
    		showThemeApplyDialog(2);
    		
    	} else if (preference == mThemeThreeName){
    		showThemeNameDialog(3);

    	} else if (preference == mThemeThreeSave){
    		showThemeSaveDialog(3);
    		
    	} else if (preference == mThemeThreeApply){
    		showThemeApplyDialog(3);
    	}
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
    
  

    private void showThemePresetsDialog() {
    	Builder alertDialog = new AlertDialog.Builder(getActivity());
    	alertDialog.setTitle("Theme Presets");
    	alertDialog.setNegativeButton("Cancel", null);
    	alertDialog.setPositiveButton("Select", themePresetDialogPositiveListener);
    	alertDialog.setSingleChoiceItems(R.array.theme_presets, ThemePresetValue, PresetListListener);
    	alertDialog.show();
    	
    }


    private void showThemeSaveDialog(int whichTheme)	{
		mThemeNum = whichTheme;
    	Builder alertDialog = new AlertDialog.Builder(getActivity());
    	alertDialog.setTitle("Save Theme");
    	alertDialog.setMessage("Save the current colors?");
    	alertDialog.setNegativeButton("Cancel", null);
    	alertDialog.setPositiveButton("Save", themeSaveDialogPositiveListener);
    	alertDialog.show();
    }		

   private void showThemeApplyDialog(int whichTheme)	{
	   	mThemeNum = whichTheme;
    	Builder alertDialog = new AlertDialog.Builder(getActivity());
    	alertDialog.setTitle("Apply Theme");
    	alertDialog.setMessage("Apply this theme?");
    	alertDialog.setNegativeButton("Cancel", null);
    	alertDialog.setPositiveButton("Apply", themeApplyDialogPositiveListener);
    	alertDialog.show();
    }		

   private void showThemeNameDialog(int whichTheme)	{
	   mThemeNum = whichTheme;
	   mEditText = new EditText(getActivity());
	   mEditText.setId(0);
	   if (mThemeNum == 1) mEditText.setText(themeOneName);
	   if (mThemeNum == 2) mEditText.setText(themeTwoName);
	   if (mThemeNum == 3) mEditText.setText(themeThreeName);
	   Builder alertDialog = new AlertDialog.Builder(getActivity());
	   alertDialog.setTitle("Theme Name");
	   alertDialog.setMessage("Give this theme a name.");
	   alertDialog.setView(mEditText);
	   alertDialog.setNegativeButton("Cancel", null);
	   alertDialog.setPositiveButton("Save", themeNameDialogPositiveListener);
	   alertDialog.show();
   	}    
    
    
	// Theme Presets
    
    DialogInterface.OnClickListener PresetListListener =
    		new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					SelectedThemePresetValue = which;
				}
			};    
    
	DialogInterface.OnClickListener themePresetDialogPositiveListener =
	   		new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					String mPreset = "";
					ThemePresetValue = SelectedThemePresetValue;
					
					if (ThemePresetValue == 0) {
						mPreset = "Junk";
					} else if (ThemePresetValue == 1) {
						mPreset = "Blue";
					} else if (ThemePresetValue == 2) {
						mPreset = "Green";
					} else if (ThemePresetValue == 3) {
						mPreset = "Red";
					} else if (ThemePresetValue == 4) {
						mPreset = "Orange";
					} else if (ThemePresetValue == 5) {
						mPreset = "Purple";
					}
						
					editor = prefMgr.edit();
			    	editor.putString(JUNK_THEME_PRESETS, String.valueOf(ThemePresetValue));
			    	editor.commit();
			    	
		            prefMgr = getActivity().getBaseContext().getSharedPreferences(
		            		"Theme_" + mPreset, Context.MODE_WORLD_READABLE);
		            CustomSettingsUtils.GetSettings(prefMgr);
			        
		            prefMgr = getActivity().getBaseContext().getSharedPreferences(
		            		"Junk_Settings", Context.MODE_WORLD_READABLE);

			        CustomSettingsUtils.WriteSettings(prefMgr);
			        CustomSettingsUtils.SendIntents(getActivity().getBaseContext());

			        prefMgr = getActivity().getBaseContext().getSharedPreferences(
		            		"Junk_Settings", Context.MODE_WORLD_READABLE);

				}
			};    

     
			// Save Themes
			DialogInterface.OnClickListener themeSaveDialogPositiveListener =
			  		new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							if (mThemeNum == 1 ) {
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
						        CustomSettingsUtils.GetSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Theme_One", Context.MODE_WORLD_READABLE);
					            editor= prefMgr.edit();
					            editor.putBoolean(SAVED_THEME, true);
					            editor.commit();
					            CustomSettingsUtils.WriteSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
						        Toast.makeText(getActivity().getBaseContext(), themeOneName +
						        		" has been saved", Toast.LENGTH_SHORT).show();
						        mThemeOneApply.setEnabled(true);
						        
							} else if (mThemeNum == 2 ) {				        
						        prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
						        CustomSettingsUtils.GetSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Theme_Two", Context.MODE_WORLD_READABLE);
					            editor= prefMgr.edit();
					            editor.putBoolean(SAVED_THEME, true);
					            editor.commit();
					            CustomSettingsUtils.WriteSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
								Toast.makeText(getActivity().getBaseContext(), themeTwoName +
										" has been saved", Toast.LENGTH_SHORT).show();
								mThemeTwoApply.setEnabled(true);
								
							} else if (mThemeNum == 3 ) {
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
					            CustomSettingsUtils.GetSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Theme_Three", Context.MODE_WORLD_READABLE);
					            editor= prefMgr.edit();
					            editor.putBoolean(SAVED_THEME, true);
					            editor.commit();
					            CustomSettingsUtils.WriteSettings(prefMgr);
						        
					            prefMgr = getActivity().getBaseContext().getSharedPreferences(
					            		"Junk_Settings", Context.MODE_WORLD_READABLE);
								Toast.makeText(getActivity().getBaseContext(), themeThreeName +
										" has been saved", Toast.LENGTH_SHORT).show();
								mThemeThreeApply.setEnabled(true);
							}
							}
						};
					
				// Apply Themes
			    DialogInterface.OnClickListener themeApplyDialogPositiveListener =
			            new DialogInterface.OnClickListener() {
											
							@Override
							public void onClick(DialogInterface dialog, int which) {
								if (mThemeNum == 1 ) {
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Theme_One", Context.MODE_WORLD_READABLE);
						            CustomSettingsUtils.GetSettings(prefMgr);
									        
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Settings", Context.MODE_WORLD_READABLE);
							        CustomSettingsUtils.WriteSettings(prefMgr);
							        CustomSettingsUtils.SendIntents(getActivity().getBaseContext());
									        
									Toast.makeText(getActivity().getBaseContext(), themeOneName +
											" has been applied", Toast.LENGTH_SHORT).show();
											
								} else if (mThemeNum == 2 ) {
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Theme_Two", Context.MODE_WORLD_READABLE);
						            CustomSettingsUtils.GetSettings(prefMgr);
									        
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Settings", Context.MODE_WORLD_READABLE);
						            CustomSettingsUtils.WriteSettings(prefMgr);
							        CustomSettingsUtils.SendIntents(getActivity().getBaseContext());
						
									Toast.makeText(getActivity().getBaseContext(), themeTwoName +
											" has been applied", Toast.LENGTH_SHORT).show();
											
								} else if (mThemeNum == 3 ) {
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Theme_Three", Context.MODE_WORLD_READABLE);
						            CustomSettingsUtils.GetSettings(prefMgr);
									        
						            prefMgr = getActivity().getBaseContext().getSharedPreferences(
						            		"Junk_Settings", Context.MODE_WORLD_READABLE);
						            CustomSettingsUtils.WriteSettings(prefMgr);
							        CustomSettingsUtils.SendIntents(getActivity().getBaseContext());
									        
									Toast.makeText(getActivity().getBaseContext(), themeThreeName +
											" has been applied", Toast.LENGTH_SHORT).show();
								}
							}
						};
		    
				// Theme Names
			    DialogInterface.OnClickListener themeNameDialogPositiveListener =
			            new DialogInterface.OnClickListener() {
													
							@Override
							public void onClick(DialogInterface dialog, int which) {
								if (mThemeNum == 1 ) {
									themeOneName = mEditText.getText().toString();
									mThemeOneName.setTitle(themeOneName);
							        prefMgr = getActivity().getBaseContext().getSharedPreferences(
							        		"Junk_Theme_One", Context.MODE_WORLD_READABLE);   
							        editor = prefMgr.edit();
							    	editor.putString(JUNK_THEME_ONE_NAME, mEditText.getText().toString());
							    	editor.commit();
												
								} else if (mThemeNum == 2 ) {
									themeTwoName = mEditText.getText().toString();
									mThemeTwoName.setTitle(themeTwoName);
							        prefMgr = getActivity().getBaseContext().getSharedPreferences(
							        		"Junk_Theme_Two", Context.MODE_WORLD_READABLE);   
							        editor = prefMgr.edit();
							    	editor.putString(JUNK_THEME_TWO_NAME, mEditText.getText().toString());
							    	editor.commit();
													
								} else if (mThemeNum == 3 ) {
									themeThreeName = mEditText.getText().toString();
									mThemeThreeName.setTitle(themeThreeName);
							        prefMgr = getActivity().getBaseContext().getSharedPreferences(
							        		"Junk_Theme_Three", Context.MODE_WORLD_READABLE);   
							        editor = prefMgr.edit();
							    	editor.putString(JUNK_THEME_THREE_NAME, mEditText.getText().toString());
							    	editor.commit();

								}
							}
						};    
}
