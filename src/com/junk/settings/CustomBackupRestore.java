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



import java.io.IOException;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.widget.Toast;



public class CustomBackupRestore extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    
	private final String JUNK_BACKUP = "junk_backup";
	private final String JUNK_RESTORE = "junk_restore";
	private Preference mBackup, mRestore;
	
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        addPreferencesFromResource(R.xml.custom_backup_restore);
        
        mBackup = findPreference(JUNK_BACKUP);
        mBackup.setOnPreferenceChangeListener(this);
        mRestore = findPreference(JUNK_RESTORE);
        mRestore.setOnPreferenceChangeListener(this);
        
        
    }

 
	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}   
	
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
    	
    	if (preference == mBackup) {
    		showBackupDialog();
    	} else if (preference == mRestore){
    		showRestoreDialog();
    	}
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
    
  

    private void showBackupDialog() {
    	Builder alertDialog = new AlertDialog.Builder(getActivity());
    	alertDialog.setTitle("Backup Junk Settings");
    	alertDialog.setMessage("Backup Junk settings and themes?");
    	alertDialog.setNegativeButton("Cancel", null);
    	alertDialog.setPositiveButton("Backup", backupDialogPositiveListener);
    	alertDialog.show();
    }

    private void showRestoreDialog() {
    	Builder alertDialog = new AlertDialog.Builder(getActivity());
    	alertDialog.setTitle("Restore Junk Settings");
    	alertDialog.setMessage("Restore Junk settings and themes?");
    	alertDialog.setNegativeButton("Cancel", null);
    	alertDialog.setPositiveButton("Restore", restoreDialogPositiveListener);
    	alertDialog.show();
    }
    
    
    
	// Backup Settings
    DialogInterface.OnClickListener backupDialogPositiveListener =
    		new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
			        try {
			        	if (BackupUtils.settingsExist()) {
			        		BackupUtils.copyBackup("data/data/com.junk.settings/shared_prefs/Junk_Settings.xml",
			        				"sdcard/.junk/backup/Junk_Settings.xml");
			        		Toast.makeText(getActivity().getBaseContext(), "Backup Successful", Toast.LENGTH_SHORT).show();
			        	}
			        } catch (IOException e) {
			        	Toast.makeText(getActivity().getBaseContext(), "ERROR Backing up settings", Toast.LENGTH_SHORT).show();
			        	Log.e("JUNK: ","ERROR BACKING UP SETTINGS");
			        };	
			        
			        
			        try {        
			        	if (BackupUtils.themeOneExist()) {
			        		BackupUtils.copyBackup("data/data/com.junk.settings/shared_prefs/Junk_Theme_One.xml",
			        				"sdcard/.junk/backup/Junk_Theme_One.xml");
			        	}
			        } catch (IOException e) {
			        	Log.e("JUNK: ","ERROR BACKING UP SETTINGS - Theme One");
			        };	
			        	
			        try {        
			        	if (BackupUtils.themeTwoExist()) {
			        		BackupUtils.copyBackup("data/data/com.junk.settings/shared_prefs/Junk_Theme_Two.xml",
									"sdcard/.junk/backup/Junk_Theme_Two.xml");
			        	}
			        } catch (IOException e) {
			        	Log.e("JUNK: ","ERROR BACKING UP SETTINGS - Theme Two");
			        };	

			        try {        
			        	if (BackupUtils.themeThreeExist()) {
			        		BackupUtils.copyBackup("data/data/com.junk.settings/shared_prefs/Junk_Theme_Three.xml",
									"sdcard/.junk/backup/Junk_Theme_Three.xml");
			        	}
			        } catch (IOException e) {
			        	Log.e("JUNK: ","ERROR BACKING UP SETTINGS - Theme Three");
			        };
				}
			};



			// Restore Settings
			DialogInterface.OnClickListener restoreDialogPositiveListener =
	            new DialogInterface.OnClickListener() {
									
					@Override
					public void onClick(DialogInterface dialog, int which) {
								
				        try {
				        	if (BackupUtils.backupExist(
				        			"sdcard/.junk/backup/Junk_Settings.xml")) {
				        		BackupUtils.copyBackup("sdcard/.junk/backup/Junk_Settings.xml",
										"data/data/com.junk.settings/shared_prefs/Junk_Settings_Temp.xml");
				        		Toast.makeText(getActivity().getBaseContext(), "Restore Successful", Toast.LENGTH_SHORT).show();

				        		SharedPreferences prefTemp = getActivity().getBaseContext().getSharedPreferences("Junk_Settings_Temp",
				        				Context.MODE_WORLD_READABLE);
				        		SharedPreferences prefMgr = getActivity().getBaseContext().getSharedPreferences("Junk_Settings", 
				        				Context.MODE_WORLD_READABLE);
				        		CustomSettingsUtils.GetSettings(prefTemp);
				        		CustomSettingsUtils.WriteSettings(prefMgr);
						        		
				        		CustomSettingsUtils.SendIntents(getActivity().getBaseContext());
						        		
				        	} else {
				        		Toast.makeText(getActivity().getBaseContext(), "No backup exists!", Toast.LENGTH_SHORT).show();	
				        	}
				        } catch (IOException e) {
				        	Log.e("JUNK: ","ERROR RESTORING SETTINGS");
				        };
						        
						        
				        try {        
				        	if (BackupUtils.backupExist("sdcard/.junk/backup/Junk_Theme_One.xml")) {
				        		BackupUtils.copyBackup("sdcard/.junk/backup/Junk_Theme_One.xml",
										"data/data/com.junk.settings/shared_prefs/Junk_Theme_One.xml");
				        	}
				        } catch (IOException e) {
				        	Log.e("JUNK: ","ERROR RESTORING Theme One");
				        };	
						        	
				        try {        
				        	if (BackupUtils.backupExist("sdcard/.junk/backup/Junk_Theme_Two.xml")) {
				        		BackupUtils.copyBackup("sdcard/.junk/backup/Junk_Theme_Two.xml",
										"data/data/com.junk.settings/shared_prefs/Junk_Theme_Two.xml");
				        	}
				        } catch (IOException e) {
				        	Log.e("JUNK: ","ERROR RESTORING Theme Two");
				        };	

				        try {        
				        	if (BackupUtils.backupExist("sdcard/.junk/backup/Junk_Theme_Three.xml")) {
				        		BackupUtils.copyBackup("sdcard/.junk/backup/Junk_Theme_Three.xml",
										"data/data/com.junk.settings/shared_prefs/Junk_Theme_Three.xml");
				        	}
				        } catch (IOException e) {
				        	Log.e("JUNK: ","ERROR RESTORING Theme Three");
				        };
						
					}
				};	



     
    
}
