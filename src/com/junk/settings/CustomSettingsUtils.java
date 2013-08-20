/*
 * Copyright (C) 2008 The Android Open Source Project
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

/**
 * Top-level settings activity to handle single pane and double pane UI layout.
 */
public class CustomSettingsUtils {

    
	private final static String Junk_Pulldown_Settings = "JUNK_PULLDOWN_SETTINGS";
	private final static String SHOW_BATTERY_LABEL = "show_battery_label";
	private final static String BATTERY_LABEL_COLOR = "battery_label_color";
	private final static String BATTERY_LABEL_SIZE = "battery_label_size";
	private final static String SHOW_TEMP_LABEL = "show_temp_label";
	private final static String TEMP_LABEL_COLOR = "temp_label_color";
	private final static String TEMP_LABEL_SIZE = "temp_label_size";
	private final static String SHOW_CARRIER = "show_carrier";
	private final static String CARRIER_COLOR = "carrier_color";
	private final static String CARRIER_CUSTOM = "carrier_custom";
	private final static String CARRIER_CUSTOM_TEXT = "carrier_custom_text";
	private final static String CARRIER_SIZE = "carrier_size";
	private final static String HEADER_CLOCK_SHOW = "header_clock_show";
	private final static String HEADER_CLOCK_SIZE = "header_clock_size";
	private final static String HEADER_DATE_SHOW = "header_date_show";
	private final static String HEADER_DATE_SIZE = "header_date_size";
	private final static String HEADER_BAR_COLOR = "header_bar_color";
	private final static String HEADER_CLOCK_COLOR = "header_clock_color";
	private final static String HEADER_DATE_COLOR = "header_date_color";
	private final static String HEADER_BUTTON_COLOR = "header_button_color";
	private final static String PD_HANDLE_COLOR = "pd_handle_color";
	private final static String PD_SHADE_COLOR = "pd_shade_color";
	private final static String PD_NOTIF_ICON_BG_COLOR = "pd_notif_icon_bg_color";
	private final static String PD_NOTIF_TEXT_BG_COLOR = "pd_notif_text_bg_color";
	private final static String PD_NOTIF_TITLE_COLOR = "pd_notif_title_color";
	private final static String PD_NOTIF_TIME_COLOR = "pd_notif_time_color";
	private final static String PD_NOTIF_TEXT_COLOR = "pd_notif_text_color";
	private final static String PD_NOTIF_DIVIDER_COLOR = "pd_notif_divider_color";
	private final static String PD_NOTIF_SUBTEXT_COLOR = "pd_notif_subtext_color";
	private final static String PD_NOTIF_SMALL_ICON_COLOR = "pd_notif_small_icon_color";


    private final static String Junk_Battery_Settings = "JUNK_BATTERY_SETTINGS";	
	private final static String BATTERY_ICONS = "battery_icon_num";
	private final static String BATTERY_SHOW_CIRCLE = "battery_show_circle";
	private final static String BATTERY_SHOW_SQUARE = "battery_show_square";
	private final static String BATTERY_SHOW_NUMBER = "battery_show_number";
	private final static String BATTERY_CIRCLE_COLOR_ONE = "battery_circle_color_one";
	private final static String BATTERY_CIRCLE_COLOR_TWO = "battery_circle_color_two";
	private final static String BATTERY_CIRCLE_COLOR_THREE = "battery_circle_color_three";
	private final static String BATTERY_NUMBER_COLOR_ONE = "battery_number_color_one";
	private final static String BATTERY_NUMBER_COLOR_TWO = "battery_number_color_two";
	private final static String BATTERY_NUMBER_COLOR_THREE = "battery_number_color_three";
	private final static String BATTERY_BAR_BOTTOM = "battery_bar_bottom";
	private final static String BATTERY_BAR_RIGHT = "battery_bar_right";
	private final static String BATTERY_BAR_WIDTH = "battery_bar_width";
	private final static String BATTERY_LEVEL_ONE = "battery_levels_one";
	private final static String BATTERY_LEVEL_COLOR_ONE = "battery_levels_color_one";
	private final static String BATTERY_LEVEL_TWO = "battery_levels_two";
	private final static String BATTERY_LEVEL_COLOR_TWO = "battery_levels_color_two";
	private final static String BATTERY_LEVEL_COLOR_THREE = "battery_levels_color_three";    
	private final static String DEPLETED_LEVEL_ONE = "depleted_levels_one";
	private final static String DEPLETED_LEVEL_COLOR_ONE = "depleted_levels_color_one";
	private final static String DEPLETED_LEVEL_TWO = "depleted_levels_two";
	private final static String DEPLETED_LEVEL_COLOR_TWO = "depleted_levels_color_two";
	private final static String DEPLETED_LEVEL_COLOR_THREE = "depleted_levels_color_three";    
	private final static String CHARGING_LEVEL_ONE = "charge_levels_one";
	private final static String CHARGING_LEVEL_COLOR_ONE = "charge_levels_color_one";
	private final static String CHARGING_LEVEL_TWO = "charge_levels_two";
	private final static String CHARGING_LEVEL_COLOR_TWO = "charge_levels_color_two";
	private final static String CHARGING_LEVEL_COLOR_THREE = "charge_levels_color_three";    
	
	private final static String Junk_Clock_Settings = "JUNK_CLOCK_SETTINGS";
    private final static String SHOW_CLOCK = "show_clock";
	private final static String SHOW_CLOCK_LEFT = "show_clock_left";
	private final static String SHOW_CLOCK_CENTER = "show_clock_center";
	private final static String SHOW_CLOCK_RIGHT = "show_clock_right";
	private final static String CLOCK_AMPM = "clock_ampm";
	private final static String CLOCK_COLOR = "clock_color";
	private final static String CLOCK_SIZE = "clock_size";
	
	private final static String Junk_Toggle_Settings = "JUNK_TOGGLE_SETTINGS";
	private final static String TOGGLES_UPDATE = "toggles_update";
	private final static String TOGGLES_ON = "toggles_show_toggles";
	private final static String TOGGLES_TOP = "toggles_top";
	private final static String TOGGLE_COLOR = "toggle_color";
	private final static String TOGGLE_ICON_ON_COLOR = "toggles_icon_on_color";
	private final static String TOGGLE_ICON_INTER_COLOR = "toggles_icon_inter_color";
	private final static String TOGGLE_ICON_OFF_COLOR = "toggles_icon_off_color";
	private final static String TOGGLE_SHOW_INDICATOR = "toggle_show_indicator";
	private final static String TOGGLE_IND_ON_COLOR = "toggle_ind_on_color";
	private final static String TOGGLE_IND_OFF_COLOR = "toggle_ind_off_color";
	private final static String TOGGLE_SHOW_TEXT = "toggle_show_text";
	private final static String TOGGLE_TEXT_ON_COLOR = "toggle_text_on_color";
	private final static String TOGGLE_TEXT_OFF_COLOR = "toggle_text_off_color";
	private final static String TOGGLE_SHOW_DIVIDER = "toggle_show_divider";
	private final static String TOGGLE_DIVIDER_COLOR = "toggle_divider_color";
	private final static String TOGGLES_TORCH_ON = "toggles_show_torch";
	private final static String TOGGLES_4G_ON = "toggles_show_fourg";
	private final static String TOGGLES_WIFI_ON = "toggles_show_wifi";
	private final static String TOGGLES_GPS_ON = "toggles_show_gps";
	private final static String TOGGLES_BLUETOOTH_ON = "toggles_show_bluetooth";
	private final static String TOGGLES_SOUND_ON = "toggles_show_sound";
	private final static String TOGGLES_AIRPLANE_ON = "toggles_show_airplane";
	private final static String TOGGLES_BRIGHTNESS_ON = "toggles_show_brightness";
	private final static String TOGGLES_ROTATE_ON = "toggles_show_rotate";
	private final static String TOGGLES_SYNC_ON = "toggles_show_sync";
	private final static String TOGGLES_DATA_ON = "toggles_show_data";
	
	private final static String Junk_Icon_Settings = "JUNK_ICON_SETTINGS";
	private final static String ICON_COLOR = "icon_color";
	
	private final static String Junk_NavBar_Settings = "JUNK_NAVBAR_SETTINGS";
	private final static String NAV_BAR_COLOR = "nav_bar_color";
    private final static String NAV_BAR_BUTTON_COLOR = "nav_button_color";
    private final static String NAV_BAR_GLOW_COLOR = "nav_button_glow_color";
    private final static String NAV_BAR_ANIM_SPEED = "nav_anim_speed";
	private final static String SHOW_LEFT_MENU_BUTTON = "left_menu_button";
	private final static String SHOW_RIGHT_MENU_BUTTON = "right_menu_button";
	private final static String SHOW_TOP_MENU_BUTTON_LAND = "top_menu_button_land";
	private final static String SHOW_BOT_MENU_BUTTON_LAND = "bottom_menu_button_land";
	private final static String NAV_BAR_LIGHTSOUT_COLOR = "nav_lightsout_color";

    private static boolean batteryBarBottom, batteryBarRight, clockLeft, clockCenter, clockRight;
    private static int batteryLabelLevelColor, batteryLabelLevelSize, batteryLabelTempColor, batteryLabelTempSize;
    private static int batteryBarWidth, batteryLevelOne, batteryLevelOneColor;
    private static int batteryLevelTwo, batteryLevelTwoColor, batteryLevelThreeColor, depletedLevelOne;
    private static int depletedLevelOneColor, depletedLevelTwo, depletedLevelTwoColor, depletedLevelThreeColor;
    private static int chargingLevelOne, chargingLevelOneColor, chargingLevelTwo, chargingLevelTwoColor, chargingLevelThreeColor;
    
    private static boolean showCarrier, carrierCustom, showBatteryLabel, showTempLabel;
    private static boolean showClock, clockAmPm, togglesShowToggles, togglesTop; 
    private static boolean togglesShowIndicator, toggleShowText, toggleShowDivider;
    private static boolean showTorch, showFourg, showWifi, showGps, showBluetooth, showSound, showAirplane;
    private static boolean showBrightness, showRotate, showSync, showData;
    private static boolean showLeftMenuButton, showLeftMenuButtonLand;
    private static boolean showRightMenuButton, showRightMenuButtonLand;
    private static boolean showTopMenuButtonLand, showBotMenuButtonLand;
    private static boolean showBatCircle, showBatNumber, showBatSquare;
    private static boolean showHeaderClock, showHeaderDate;
    private static int circleLevelOneColor, circleLevelTwoColor, circleLevelThreeColor;
    private static int numberLevelOneColor, numberLevelTwoColor, numberLevelThreeColor;
    private static int shadeColor, headerClockSize, headerDateSize, headerBarColor;
    private static int headerClockColor, headerDateColor, headerButtonColor, closeHandleColor;
    private static int navBarColor, navBarButtonColor, navBarGlowColor, navBarAnim;
    private static int carrierColor, iconColor, clockColor, clockSize, toggleColor, toggleIconOnColor;
    private static int toggleIconInterColor, toggleIconOffColor, toggleIndOnColor, toggleIndOffColor;
    private static int toggleTextOnColor, toggleTextOffColor, toggleDividerColor;
    private static int carrierSize, pdTextBgColor, pdIconBgColor, pdTitleColor, pdTimeColor;
    private static int pdTextColor, pdDividerColor, pdSubtextColor, pdSmallIconColor   ;
	private static String batteryIconNum, carrierCustomText;
	private static int navBarLightsout;



    
    
    public static void GetSettings(SharedPreferences prefMgr) {
  
    	batteryIconNum = prefMgr.getString(BATTERY_ICONS, "0");
    	showBatCircle = prefMgr.getBoolean(BATTERY_SHOW_CIRCLE, false);
    	showBatNumber = prefMgr.getBoolean(BATTERY_SHOW_NUMBER, false);
    	showBatSquare = prefMgr.getBoolean(BATTERY_SHOW_SQUARE, false);
    	circleLevelOneColor = prefMgr.getInt(BATTERY_CIRCLE_COLOR_ONE, 0xff3fa2c7);
    	circleLevelTwoColor = prefMgr.getInt(BATTERY_CIRCLE_COLOR_TWO, 0xffff9000);
    	circleLevelThreeColor = prefMgr.getInt(BATTERY_CIRCLE_COLOR_THREE, 0xffff0000);    	
    	numberLevelOneColor = prefMgr.getInt(BATTERY_NUMBER_COLOR_ONE, 0xff3fa2c7);
    	numberLevelTwoColor = prefMgr.getInt(BATTERY_NUMBER_COLOR_TWO, 0xffff9000);
    	numberLevelThreeColor = prefMgr.getInt(BATTERY_NUMBER_COLOR_THREE, 0xffff0000);    	
    	batteryBarBottom = prefMgr.getBoolean(BATTERY_BAR_BOTTOM, false);
    	batteryBarRight = prefMgr.getBoolean(BATTERY_BAR_RIGHT, false);
    	batteryBarWidth = prefMgr.getInt(BATTERY_BAR_WIDTH, 5);
    	batteryLevelOne = prefMgr.getInt(BATTERY_LEVEL_ONE, 10);
    	batteryLevelOneColor = prefMgr.getInt(BATTERY_LEVEL_COLOR_ONE, 0xffff0000);
    	batteryLevelTwo = prefMgr.getInt(BATTERY_LEVEL_TWO, 30);
    	batteryLevelTwoColor = prefMgr.getInt(BATTERY_LEVEL_COLOR_TWO, 0xffff9000);
    	batteryLevelThreeColor = prefMgr.getInt(BATTERY_LEVEL_COLOR_THREE, 0xff3792b4);
    	depletedLevelOne = prefMgr.getInt(DEPLETED_LEVEL_ONE, 10);
    	depletedLevelOneColor = prefMgr.getInt(DEPLETED_LEVEL_COLOR_ONE, 0xff800000);
    	depletedLevelTwo = prefMgr.getInt(DEPLETED_LEVEL_TWO, 30);
    	depletedLevelTwoColor = prefMgr.getInt(DEPLETED_LEVEL_COLOR_TWO, 0xffba6900);
    	depletedLevelThreeColor = prefMgr.getInt(DEPLETED_LEVEL_COLOR_THREE, 0xff296c85);
    	chargingLevelOne = prefMgr.getInt(CHARGING_LEVEL_ONE, 10);
    	chargingLevelOneColor = prefMgr.getInt(CHARGING_LEVEL_COLOR_ONE, 0xff800000);
    	chargingLevelTwo = prefMgr.getInt(CHARGING_LEVEL_TWO, 30);
    	chargingLevelTwoColor = prefMgr.getInt(CHARGING_LEVEL_COLOR_TWO, 0xffba6900);
    	chargingLevelThreeColor = prefMgr.getInt(CHARGING_LEVEL_COLOR_THREE, 0xff296c85);
    	showClock = prefMgr.getBoolean(SHOW_CLOCK, true);
    	clockAmPm = prefMgr.getBoolean(CLOCK_AMPM, false);
    	clockColor = prefMgr.getInt(CLOCK_COLOR, 0xff3F9BBF);
    	clockLeft = prefMgr.getBoolean(SHOW_CLOCK_LEFT, false);
    	clockCenter = prefMgr.getBoolean(SHOW_CLOCK_CENTER, false);
    	clockRight = prefMgr.getBoolean(SHOW_CLOCK_RIGHT, true);
    	clockSize = prefMgr.getInt(CLOCK_SIZE, 17);
    	togglesShowToggles = prefMgr.getBoolean(TOGGLES_ON, true);
    	togglesTop = prefMgr.getBoolean(TOGGLES_TOP, true);
    	toggleColor = prefMgr.getInt(TOGGLE_COLOR, 0xff141414);
    	toggleIconOnColor = prefMgr.getInt(TOGGLE_ICON_ON_COLOR, 0xff3792b4);
        toggleIconInterColor = prefMgr.getInt(TOGGLE_ICON_INTER_COLOR, 0xffff0000);
        toggleIconOffColor = prefMgr.getInt(TOGGLE_ICON_OFF_COLOR, 0xff555555);
        togglesShowIndicator = prefMgr.getBoolean(TOGGLE_SHOW_INDICATOR, false);
        toggleIndOnColor = prefMgr.getInt(TOGGLE_IND_ON_COLOR, 0xffffffff);
        toggleIndOffColor = prefMgr.getInt(TOGGLE_IND_OFF_COLOR, 0xff555555);
        toggleShowText = prefMgr.getBoolean(TOGGLE_SHOW_TEXT, false);
        toggleTextOnColor = prefMgr.getInt(TOGGLE_TEXT_ON_COLOR, 0xffffffff);
        toggleTextOffColor = prefMgr.getInt(TOGGLE_TEXT_OFF_COLOR, 0xff555555);
        toggleShowDivider = prefMgr.getBoolean(TOGGLE_SHOW_DIVIDER, true);
        toggleDividerColor = prefMgr.getInt(TOGGLE_DIVIDER_COLOR, 0xff2c2c2c);
    	showTorch = prefMgr.getBoolean(TOGGLES_TORCH_ON, true);
        showFourg = prefMgr.getBoolean(TOGGLES_4G_ON, true);
    	showWifi = prefMgr.getBoolean(TOGGLES_WIFI_ON, true);
    	showGps = prefMgr.getBoolean(TOGGLES_GPS_ON, true);
    	showBluetooth = prefMgr.getBoolean(TOGGLES_BLUETOOTH_ON, true);
    	showSound = prefMgr.getBoolean(TOGGLES_SOUND_ON, true);
    	showAirplane = prefMgr.getBoolean(TOGGLES_AIRPLANE_ON, true);
    	showBrightness = prefMgr.getBoolean(TOGGLES_BRIGHTNESS_ON, true);
    	showRotate = prefMgr.getBoolean(TOGGLES_ROTATE_ON, true);
    	showSync = prefMgr.getBoolean(TOGGLES_SYNC_ON, true);
    	showData = prefMgr.getBoolean(TOGGLES_DATA_ON, true);    	
    	showLeftMenuButton = prefMgr.getBoolean(SHOW_LEFT_MENU_BUTTON, true);
    	showRightMenuButton = prefMgr.getBoolean(SHOW_RIGHT_MENU_BUTTON, true);
    	showTopMenuButtonLand = prefMgr.getBoolean(SHOW_TOP_MENU_BUTTON_LAND, true);
    	showBotMenuButtonLand = prefMgr.getBoolean(SHOW_BOT_MENU_BUTTON_LAND, true);
    	showCarrier = prefMgr.getBoolean(SHOW_CARRIER, true);
    	carrierColor = prefMgr.getInt(CARRIER_COLOR, 0xff3F9BBF);
    	carrierSize = prefMgr.getInt(CARRIER_SIZE, 15);
    	carrierCustom = prefMgr.getBoolean(CARRIER_CUSTOM, false);
        carrierCustomText = prefMgr.getString(CARRIER_CUSTOM_TEXT, "- J U N K -");
    	showHeaderClock = prefMgr.getBoolean(HEADER_CLOCK_SHOW, true);
    	headerClockSize = prefMgr.getInt(HEADER_CLOCK_SIZE, 35);
    	showHeaderDate = prefMgr.getBoolean(HEADER_DATE_SHOW, true);
    	headerDateSize = prefMgr.getInt(HEADER_DATE_SIZE, 10);
    	headerBarColor = prefMgr.getInt(HEADER_BAR_COLOR, 0xff000000);
    	headerClockColor = prefMgr.getInt(HEADER_CLOCK_COLOR, 0xffffffff);
    	headerDateColor = prefMgr.getInt(HEADER_DATE_COLOR, 0xffffffff);
    	headerButtonColor = prefMgr.getInt(HEADER_BUTTON_COLOR, 0xffffffff);
    	shadeColor = prefMgr.getInt(PD_SHADE_COLOR, 0xbd000000);
    	pdIconBgColor = prefMgr.getInt(PD_NOTIF_ICON_BG_COLOR, 0xee111111);
    	pdTextBgColor = prefMgr.getInt(PD_NOTIF_TEXT_BG_COLOR, 0xee111111);
    	pdTitleColor = prefMgr.getInt(PD_NOTIF_TITLE_COLOR, 0xffffffff);
    	pdTimeColor = prefMgr.getInt(PD_NOTIF_TIME_COLOR, 0xffffffff);
    	pdTextColor = prefMgr.getInt(PD_NOTIF_TEXT_COLOR, 0xfff6f6f6);
    	pdDividerColor = prefMgr.getInt(PD_NOTIF_DIVIDER_COLOR, 0xfff6f6f6);
    	pdSubtextColor = prefMgr.getInt(PD_NOTIF_SUBTEXT_COLOR, 0xffffffff);
    	pdSmallIconColor = prefMgr.getInt(PD_NOTIF_SMALL_ICON_COLOR, 0xffffffff);
    	showBatteryLabel = prefMgr.getBoolean(SHOW_BATTERY_LABEL, true);
    	batteryLabelLevelColor = prefMgr.getInt(BATTERY_LABEL_COLOR, 0xff3792b4);
    	batteryLabelLevelSize = prefMgr.getInt(BATTERY_LABEL_SIZE, 12);
    	showTempLabel = prefMgr.getBoolean(SHOW_TEMP_LABEL, true);
    	batteryLabelTempColor = prefMgr.getInt(TEMP_LABEL_COLOR, 0xff3792b4);
    	batteryLabelTempSize = prefMgr.getInt(TEMP_LABEL_SIZE, 12);
    	closeHandleColor = prefMgr.getInt(PD_HANDLE_COLOR, 0xff3792b4);
    	iconColor = prefMgr.getInt(ICON_COLOR, 0xff3F9BBF);
        navBarColor = prefMgr.getInt(NAV_BAR_COLOR, 0xff000000);
        navBarButtonColor = prefMgr.getInt(NAV_BAR_BUTTON_COLOR, 0xffffffff);
        navBarGlowColor = prefMgr.getInt(NAV_BAR_GLOW_COLOR, 0xffffffff);
        navBarAnim = prefMgr.getInt(NAV_BAR_ANIM_SPEED, 5);
        navBarLightsout = prefMgr.getInt(NAV_BAR_LIGHTSOUT_COLOR, 0xeeffffff);
        
    }    

    
    public static void WriteSettings(SharedPreferences prefMgr) {
    	
    	SharedPreferences.Editor editor = prefMgr.edit();
    	
    	editor.putString(BATTERY_ICONS, batteryIconNum);
    	editor.putBoolean(BATTERY_SHOW_CIRCLE, showBatCircle);
    	editor.putBoolean(BATTERY_SHOW_NUMBER, showBatNumber);
    	editor.putBoolean(BATTERY_SHOW_SQUARE, showBatSquare);
    	editor.putInt(BATTERY_CIRCLE_COLOR_ONE, circleLevelOneColor);
    	editor.putInt(BATTERY_CIRCLE_COLOR_TWO, circleLevelTwoColor);
    	editor.putInt(BATTERY_CIRCLE_COLOR_THREE, circleLevelThreeColor);
    	editor.putInt(BATTERY_NUMBER_COLOR_ONE, numberLevelOneColor);
    	editor.putInt(BATTERY_NUMBER_COLOR_TWO, numberLevelTwoColor);
    	editor.putInt(BATTERY_NUMBER_COLOR_THREE, numberLevelThreeColor);
    	editor.putBoolean(BATTERY_BAR_BOTTOM, batteryBarBottom);
    	editor.putBoolean(BATTERY_BAR_RIGHT, batteryBarRight);
    	editor.putInt(BATTERY_BAR_WIDTH, batteryBarWidth);
    	editor.putInt(BATTERY_LEVEL_ONE, batteryLevelOne);
    	editor.putInt(BATTERY_LEVEL_COLOR_ONE, batteryLevelOneColor);
    	editor.putInt(BATTERY_LEVEL_TWO, batteryLevelTwo);
    	editor.putInt(BATTERY_LEVEL_COLOR_TWO, batteryLevelTwoColor);
    	editor.putInt(BATTERY_LEVEL_COLOR_THREE, batteryLevelThreeColor);    	
    	editor.putInt(DEPLETED_LEVEL_ONE, depletedLevelOne);
    	editor.putInt(DEPLETED_LEVEL_COLOR_ONE, depletedLevelOneColor);
    	editor.putInt(DEPLETED_LEVEL_TWO, depletedLevelTwo);
    	editor.putInt(DEPLETED_LEVEL_COLOR_TWO, depletedLevelTwoColor);
    	editor.putInt(DEPLETED_LEVEL_COLOR_THREE, depletedLevelThreeColor);    	
    	editor.putInt(CHARGING_LEVEL_ONE, chargingLevelOne);
    	editor.putInt(CHARGING_LEVEL_COLOR_ONE, chargingLevelOneColor);
    	editor.putInt(CHARGING_LEVEL_TWO, chargingLevelTwo);
    	editor.putInt(CHARGING_LEVEL_COLOR_TWO, chargingLevelTwoColor);
    	editor.putInt(CHARGING_LEVEL_COLOR_THREE, chargingLevelThreeColor);    	
        editor.putBoolean(SHOW_CARRIER, showCarrier);  
        editor.putBoolean(CARRIER_CUSTOM, carrierCustom);
        editor.putInt(CARRIER_SIZE, carrierSize);
        editor.putBoolean(HEADER_CLOCK_SHOW, showHeaderClock);
        editor.putInt(HEADER_CLOCK_SIZE, headerClockSize);
        editor.putBoolean(HEADER_DATE_SHOW, showHeaderDate);
        editor.putInt(HEADER_DATE_SIZE, headerDateSize);
        editor.putInt(HEADER_BAR_COLOR, headerBarColor);
        editor.putInt(HEADER_CLOCK_COLOR, headerClockColor);
        editor.putInt(HEADER_DATE_COLOR, headerDateColor);
        editor.putInt(HEADER_BUTTON_COLOR, headerButtonColor);
    	editor.putBoolean(SHOW_BATTERY_LABEL, showBatteryLabel);
    	editor.putInt(BATTERY_LABEL_COLOR, batteryLabelLevelColor);
    	editor.putInt(BATTERY_LABEL_SIZE, batteryLabelLevelSize);
    	editor.putBoolean(SHOW_TEMP_LABEL, showTempLabel);
    	editor.putInt(TEMP_LABEL_COLOR, batteryLabelTempColor);
    	editor.putInt(TEMP_LABEL_SIZE, batteryLabelTempSize);
        editor.putBoolean(SHOW_CLOCK, showClock);
        editor.putBoolean(SHOW_CLOCK_LEFT, clockLeft);
        editor.putBoolean(SHOW_CLOCK_CENTER, clockCenter);
        editor.putBoolean(SHOW_CLOCK_RIGHT, clockRight);
        editor.putBoolean(CLOCK_AMPM, clockAmPm);
        editor.putBoolean(TOGGLES_ON, togglesShowToggles);
        editor.putBoolean(TOGGLES_TOP, togglesTop);
        editor.putBoolean(TOGGLE_SHOW_INDICATOR, togglesShowIndicator);
        editor.putBoolean(TOGGLE_SHOW_TEXT, toggleShowText);
        editor.putBoolean(TOGGLE_SHOW_DIVIDER, toggleShowDivider);
        editor.putBoolean(TOGGLES_TORCH_ON, showTorch);
        editor.putBoolean(TOGGLES_4G_ON, showFourg);
        editor.putBoolean(TOGGLES_WIFI_ON, showWifi);
        editor.putBoolean(TOGGLES_GPS_ON, showGps);
        editor.putBoolean(TOGGLES_BLUETOOTH_ON, showBluetooth);
        editor.putBoolean(TOGGLES_SOUND_ON, showSound);
        editor.putBoolean(TOGGLES_AIRPLANE_ON, showAirplane);
        editor.putBoolean(TOGGLES_BRIGHTNESS_ON, showBrightness);
        editor.putBoolean(TOGGLES_ROTATE_ON, showRotate);
        editor.putBoolean(TOGGLES_SYNC_ON, showSync);
        editor.putBoolean(TOGGLES_DATA_ON, showData);
        editor.putBoolean(SHOW_LEFT_MENU_BUTTON, showLeftMenuButton);
        editor.putBoolean(SHOW_RIGHT_MENU_BUTTON, showRightMenuButton);
        editor.putBoolean(SHOW_TOP_MENU_BUTTON_LAND, showTopMenuButtonLand);
        editor.putBoolean(SHOW_BOT_MENU_BUTTON_LAND, showBotMenuButtonLand);
        editor.putInt(CARRIER_COLOR, carrierColor);
        editor.putInt(ICON_COLOR, iconColor);
        editor.putInt(CLOCK_COLOR, clockColor);
        editor.putInt(CLOCK_SIZE, clockSize);
        editor.putInt(TOGGLE_COLOR, toggleColor);
        editor.putInt(TOGGLE_ICON_ON_COLOR, toggleIconOnColor);
        editor.putInt(TOGGLE_ICON_INTER_COLOR, toggleIconInterColor);
        editor.putInt(TOGGLE_ICON_OFF_COLOR, toggleIconOffColor);
        editor.putInt(TOGGLE_IND_ON_COLOR, toggleIndOnColor);
        editor.putInt(TOGGLE_IND_OFF_COLOR, toggleIndOffColor);
        editor.putInt(TOGGLE_TEXT_ON_COLOR, toggleTextOnColor);
        editor.putInt(TOGGLE_TEXT_OFF_COLOR, toggleTextOffColor);
        editor.putInt(TOGGLE_DIVIDER_COLOR, toggleDividerColor);
        editor.putString(CARRIER_CUSTOM_TEXT, carrierCustomText);
        editor.putInt(CARRIER_SIZE, carrierSize);
        editor.putInt(PD_HANDLE_COLOR, closeHandleColor);
        editor.putInt(PD_SHADE_COLOR, shadeColor);
        editor.putInt(PD_NOTIF_ICON_BG_COLOR, pdIconBgColor);
        editor.putInt(PD_NOTIF_TEXT_BG_COLOR, pdTextBgColor);
        editor.putInt(PD_NOTIF_TITLE_COLOR, pdTitleColor);
        editor.putInt(PD_NOTIF_TIME_COLOR, pdTimeColor);
        editor.putInt(PD_NOTIF_TEXT_COLOR, pdTextColor);
        editor.putInt(PD_NOTIF_DIVIDER_COLOR, pdDividerColor);
        editor.putInt(PD_NOTIF_SUBTEXT_COLOR, pdSubtextColor);
        editor.putInt(PD_NOTIF_SMALL_ICON_COLOR, pdSmallIconColor);
        editor.putBoolean(SHOW_LEFT_MENU_BUTTON, showLeftMenuButton);
        editor.putBoolean(SHOW_RIGHT_MENU_BUTTON, showRightMenuButton);
        editor.putBoolean(SHOW_TOP_MENU_BUTTON_LAND, showLeftMenuButtonLand);
        editor.putBoolean(SHOW_BOT_MENU_BUTTON_LAND, showRightMenuButtonLand);
        editor.putInt(NAV_BAR_COLOR, navBarColor);
        editor.putInt(NAV_BAR_BUTTON_COLOR, navBarButtonColor);
        editor.putInt(NAV_BAR_GLOW_COLOR, navBarGlowColor);
        editor.putInt(NAV_BAR_ANIM_SPEED, navBarAnim);
        editor.putInt(NAV_BAR_LIGHTSOUT_COLOR, navBarLightsout);
        editor.commit();
    }    

    public static void SendIntents(Context context) {

    	Intent i = new Intent();
 
		i = new Intent();
		i.setAction(Junk_Battery_Settings );
	   		i.putExtra(BATTERY_ICONS, batteryIconNum);
	   		context.sendBroadcast(i);
	   		i = null;
    	
       	if ((Boolean) batteryBarBottom == true) {
            	i = new Intent();
            	i.setAction(Junk_Battery_Settings);
           	   	i.putExtra(BATTERY_BAR_RIGHT, false);
           	   	context.sendBroadcast(i);
           	   	i = null;  
        	}
        	
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
       	i.putExtra(BATTERY_BAR_BOTTOM, (Boolean) batteryBarBottom);
       	context.sendBroadcast(i);
       	i = null;    
 
       	if ((Boolean) batteryBarRight == true) {
               	i = new Intent();
            	i.setAction(Junk_Battery_Settings);
           	   	i.putExtra(BATTERY_BAR_BOTTOM, false);
           	   	context.sendBroadcast(i);
           	   	i = null; 
        	}
        
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_SHOW_CIRCLE, showBatCircle);
        context.sendBroadcast(i);
        i = null;
 
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_SHOW_SQUARE, showBatSquare);
        context.sendBroadcast(i);
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_SHOW_NUMBER, showBatNumber);
        context.sendBroadcast(i);
        i = null;
        
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_ONE, circleLevelOneColor);
        context.sendBroadcast(i);
        i = null;
        
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_TWO, circleLevelTwoColor);
        context.sendBroadcast(i);
        i = null;
        
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_CIRCLE_COLOR_THREE, circleLevelThreeColor);
        context.sendBroadcast(i);
        i = null;        
        
    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_ONE, numberLevelOneColor);
        context.sendBroadcast(i);
        i = null;        

    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_TWO, numberLevelTwoColor);
        context.sendBroadcast(i);
        i = null;        

    	i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_NUMBER_COLOR_THREE, numberLevelThreeColor);
        context.sendBroadcast(i);
        i = null;        
        
       	i = new Intent();
        i.setAction(Junk_Battery_Settings);
       	i.putExtra(BATTERY_BAR_RIGHT, (Boolean) batteryBarRight);
       	context.sendBroadcast(i);
       	i = null;       	   	
       	   	
       	i = new Intent();
        i.setAction(Junk_Battery_Settings);
       	i.putExtra(BATTERY_BAR_WIDTH, (Integer) batteryBarWidth);
       	context.sendBroadcast(i);
       	i = null;       	   	
       	   	
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_ONE, batteryLevelOne);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_ONE, (Integer) batteryLevelOneColor);
        context.sendBroadcast(i);
        i = null;
             
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_TWO, batteryLevelTwo);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_TWO, (Integer) batteryLevelTwoColor);
        context.sendBroadcast(i);
        i = null;

        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(BATTERY_LEVEL_COLOR_THREE, (Integer) batteryLevelThreeColor);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_ONE, depletedLevelOne);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_ONE, (Integer) depletedLevelOneColor);
        context.sendBroadcast(i);
        i = null;
             
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_TWO, depletedLevelTwo);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_TWO, (Integer) depletedLevelTwoColor);
        context.sendBroadcast(i);
        i = null;

        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(DEPLETED_LEVEL_COLOR_THREE, (Integer) depletedLevelThreeColor);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_ONE, chargingLevelOne);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_ONE, (Integer) chargingLevelOneColor);
        context.sendBroadcast(i);
        i = null;
             
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_TWO, chargingLevelTwo);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_TWO, (Integer) chargingLevelTwoColor);
        context.sendBroadcast(i);
        i = null;

        i = new Intent();
        i.setAction(Junk_Battery_Settings);
        i.putExtra(CHARGING_LEVEL_COLOR_THREE, (Integer) chargingLevelThreeColor);
        context.sendBroadcast(i);
        i = null;
        
     	i = new Intent();        
    	i.setAction(Junk_Clock_Settings);
   	   	i.putExtra(SHOW_CLOCK, showClock);
   	   	context.sendBroadcast(i);
   	   	i = null;

     	i = new Intent();        
    	i.setAction(Junk_Clock_Settings);
   	   	i.putExtra(SHOW_CLOCK_LEFT, clockLeft);
   	   	context.sendBroadcast(i);
   	   	i = null;

     	i = new Intent();        
    	i.setAction(Junk_Clock_Settings);
   	   	i.putExtra(SHOW_CLOCK_CENTER, clockCenter);
   	   	context.sendBroadcast(i);
   	   	i = null;

     	i = new Intent();        
    	i.setAction(Junk_Clock_Settings);
   	   	i.putExtra(SHOW_CLOCK_RIGHT, clockRight);
   	   	context.sendBroadcast(i);
   	   	i = null;
   	   	
   	   	
     	i = new Intent();
        i.setAction(Junk_Clock_Settings);
        i.putExtra(CLOCK_AMPM, (Boolean) clockAmPm);
        context.sendBroadcast(i);
        i = null;
    
    	i = new Intent();
        i.setAction(Junk_Clock_Settings);
        i.putExtra(CLOCK_COLOR, (Integer) clockColor);
        context.sendBroadcast(i);
        i = null;

    	i = new Intent();
        i.setAction(Junk_Clock_Settings);
        i.putExtra(CLOCK_SIZE, (Integer) clockSize);
        context.sendBroadcast(i);
        i = null;
        
        i = new Intent();
        i.setAction(Junk_Icon_Settings);
       	i.putExtra(ICON_COLOR, (Integer) iconColor);
       	context.sendBroadcast(i);
       	i = null;
        
       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_ON, (Boolean) togglesShowToggles);
   	   	context.sendBroadcast(i);
   	   	i = null;
       	   	
       	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
       	i.putExtra(TOGGLES_TOP, (Boolean) togglesTop);
       	context.sendBroadcast(i);
       	i = null;
       	   	
       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_COLOR, (Integer) toggleColor);
   	   	context.sendBroadcast(i);
   	   	i = null;

       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_ON_COLOR, (Integer) toggleIconOnColor);
   	   	context.sendBroadcast(i);
   	   	i = null;

       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_INTER_COLOR, (Integer) toggleIconInterColor);
   	   	context.sendBroadcast(i);
   	   	i = null;
       	   	
       	i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLE_ICON_OFF_COLOR, (Integer) toggleIconOffColor);
   	   	context.sendBroadcast(i);
   	   	i = null;       	   	
       	   	
       	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_SHOW_INDICATOR, (Boolean) togglesShowIndicator);
        	if ((Boolean) togglesShowIndicator) {
        		i.putExtra(TOGGLE_IND_ON_COLOR, toggleIndOnColor);
            	i.putExtra(TOGGLE_IND_OFF_COLOR, toggleIndOffColor);
            	} else {
            		i.putExtra(TOGGLE_IND_ON_COLOR,0);
            		i.putExtra(TOGGLE_IND_OFF_COLOR,0);
            }
        context.sendBroadcast(i);
        i = null;

       	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLE_SHOW_TEXT, (Boolean) toggleShowText);
        	if ((Boolean) toggleShowText) {
        		i.putExtra(TOGGLE_TEXT_ON_COLOR, (Integer) toggleTextOnColor);
            	i.putExtra(TOGGLE_TEXT_OFF_COLOR, (Integer) toggleTextOffColor);
            	} else {
            		i.putExtra(TOGGLE_TEXT_ON_COLOR,0);
            		i.putExtra(TOGGLE_TEXT_OFF_COLOR,0);
            }
        context.sendBroadcast(i);
        i = null;

       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
       	i.putExtra(TOGGLE_SHOW_DIVIDER, (Boolean) toggleShowDivider);
        if ((Boolean) toggleShowDivider) {
           	i.putExtra(TOGGLE_DIVIDER_COLOR, (Integer) toggleDividerColor);
           	} else {
           		i.putExtra(TOGGLE_DIVIDER_COLOR,0);
            }
       	context.sendBroadcast(i);
       	i = null;      
        
       	i = new Intent();
        i.setAction(Junk_Toggle_Settings);
        i.putExtra(TOGGLES_UPDATE, true);
        context.sendBroadcast(i);
        i = null;

      	i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_TORCH_ON, (Boolean) showTorch);
   	   	context.sendBroadcast(i);
   	   	i = null;
        
        i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_4G_ON, (Boolean) showFourg);
   	   	context.sendBroadcast(i);
   	   	i = null;
        	   	
       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_WIFI_ON, (Boolean) showWifi);
   	   	context.sendBroadcast(i);
   	   	i = null;
        	   	
       	i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_GPS_ON, (Boolean) showGps);
   	   	context.sendBroadcast(i);
   	   	i = null;
       
       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_BLUETOOTH_ON, (Boolean) showBluetooth);
   	   	context.sendBroadcast(i);
   	   	i = null;
            
       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_SOUND_ON, (Boolean) showSound);
   	   	context.sendBroadcast(i);
   	   	i = null;
           
       	i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_AIRPLANE_ON, (Boolean) showAirplane);
   	   	context.sendBroadcast(i);
   	   	i = null;

       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_BRIGHTNESS_ON, (Boolean) showBrightness);
   	   	context.sendBroadcast(i);
   	   	i = null;

       	i = new Intent();
      	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_ROTATE_ON, (Boolean) showRotate);
   	   	context.sendBroadcast(i);
   	   	i = null;
 
       	i = new Intent();
      	i.setAction(Junk_Toggle_Settings );
   	   	i.putExtra(TOGGLES_SYNC_ON, (Boolean) showSync);
   	   	context.sendBroadcast(i);
   	   	i = null;

       	i = new Intent();
       	i.setAction(Junk_Toggle_Settings);
   	   	i.putExtra(TOGGLES_DATA_ON, (Boolean) showData);
   	   	context.sendBroadcast(i);
   	   	i = null;            
   	   	
      	i = new Intent();
       	i.setAction(Junk_Pulldown_Settings);
   	   	i.putExtra(SHOW_CARRIER, (Boolean) showCarrier);
   	   	context.sendBroadcast(i);
   	   	i = null;
       
      	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(CARRIER_COLOR, (Integer) carrierColor);
        context.sendBroadcast(i);
        i = null;
            
       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(CARRIER_CUSTOM, (Boolean) carrierCustom);
        context.sendBroadcast(i);
        i = null;
              
       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(CARRIER_CUSTOM_TEXT, (String) carrierCustomText);
        context.sendBroadcast(i);
        i = null;
        	
       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(CARRIER_SIZE, (Integer) carrierSize);
        context.sendBroadcast(i);
        i = null;
        
      	i = new Intent();
      	i.setAction(Junk_Pulldown_Settings);
       	i.putExtra(HEADER_CLOCK_SHOW, (Boolean) showHeaderClock);
       	context.sendBroadcast(i);
       	i = null;        

      	i = new Intent();
      	i.setAction(Junk_Pulldown_Settings);
       	i.putExtra(HEADER_CLOCK_SIZE, (Integer) headerClockSize);
       	context.sendBroadcast(i);
       	i = null;        
       	
       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_DATE_SHOW, (Boolean) showHeaderDate);
        context.sendBroadcast(i);
        i = null;       	 

       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_DATE_SIZE, (Integer) headerDateSize);
        context.sendBroadcast(i);
        i = null;       	 
        
       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_BAR_COLOR, (Integer) headerBarColor);
        context.sendBroadcast(i);
        i = null;       	 

       	i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_CLOCK_COLOR, (Integer) headerClockColor);
        context.sendBroadcast(i);
        i = null;       	 

        i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_DATE_COLOR, (Integer) headerDateColor);
        context.sendBroadcast(i);
        i = null;       	 

        i = new Intent();
        i.setAction(Junk_Pulldown_Settings);
        i.putExtra(HEADER_BUTTON_COLOR, (Integer) headerButtonColor);
        context.sendBroadcast(i);
        i = null;       	 
        
    	i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(SHOW_BATTERY_LABEL, (Boolean) showBatteryLabel);
   	   	context.sendBroadcast(i);
   	   	i = null;       	

   	   	i = new Intent();
   	   	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(BATTERY_LABEL_COLOR, (Integer) batteryLabelLevelColor);
   	   	context.sendBroadcast(i);
   	   	i = null;           	  

   	   	i = new Intent();
   	   	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(BATTERY_LABEL_SIZE, (Integer) batteryLabelLevelSize);
   	   	context.sendBroadcast(i);
   	   	i = null;            

    	i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(SHOW_TEMP_LABEL, (Boolean) showTempLabel);
   	   	context.sendBroadcast(i);
   	   	i = null;               	   	
   	   	
   	   	i = new Intent();
   	   	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(TEMP_LABEL_COLOR, (Integer) batteryLabelTempColor);
   	   	context.sendBroadcast(i);
   	   	i = null;           	  

   	   	i = new Intent();
   	   	i.setAction(Junk_Pulldown_Settings );
   	   	i.putExtra(TEMP_LABEL_SIZE, (Integer) batteryLabelTempSize);
   	   	context.sendBroadcast(i);
   	   	i = null;             
   	   	
    	
    	i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_HANDLE_COLOR, (Integer) closeHandleColor);
    	context.sendBroadcast(i);
    	i = null;              	
    	
    	i = new Intent();
    	i.setAction(Junk_Pulldown_Settings );
    	i.putExtra(PD_SHADE_COLOR, (Integer) shadeColor);
    	context.sendBroadcast(i);
    	i = null;              	
 	
    	// No pd notif intents - reboot required
    	
    	
   	   	i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_COLOR, (Integer) navBarColor);
       	context.sendBroadcast(i);
       	i = null;    	
    	
   	   	i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_BUTTON_COLOR, (Integer) navBarButtonColor);
       	context.sendBroadcast(i);
       	i = null;
       
   	   	i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_GLOW_COLOR, (Integer) navBarGlowColor);
       	context.sendBroadcast(i);
       	i = null;       	
       	
   	   	i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_ANIM_SPEED, (Integer) navBarAnim);
       	context.sendBroadcast(i);
       	i = null;       	

   	   	i = new Intent();
        i.setAction(Junk_NavBar_Settings );
       	i.putExtra(NAV_BAR_LIGHTSOUT_COLOR, (Integer) navBarLightsout);
       	context.sendBroadcast(i);
       	i = null;       	
       	
        i = new Intent();
        i.setAction(Junk_NavBar_Settings );
        i.putExtra(SHOW_LEFT_MENU_BUTTON, (Boolean) showLeftMenuButton);
        context.sendBroadcast(i);
        i = null;        

        i = new Intent();
        i.setAction(Junk_NavBar_Settings );
        i.putExtra(SHOW_RIGHT_MENU_BUTTON, (Boolean) showRightMenuButton);
        context.sendBroadcast(i);
        i = null;        

        i = new Intent();
        i.setAction(Junk_NavBar_Settings );
        i.putExtra(SHOW_TOP_MENU_BUTTON_LAND, (Boolean) showLeftMenuButtonLand);
        context.sendBroadcast(i);
        i = null;        

        i = new Intent();
        i.setAction(Junk_NavBar_Settings );
        i.putExtra(SHOW_BOT_MENU_BUTTON_LAND, (Boolean) showRightMenuButtonLand);
        context.sendBroadcast(i);
        i = null;   	   	
   	   	
}     
    
    
    
    
}
