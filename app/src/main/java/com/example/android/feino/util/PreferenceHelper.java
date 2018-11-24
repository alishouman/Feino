package com.example.android.feino.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Doha on 03/09/18.
 */
public class PreferenceHelper {

    private final Context context;
    private static final String LANGUAGE = "language";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String NOTIFICATION_Vibrate="vibrate";
    private static final String NOTIFICATION_LIGHT="light";
    private static final String NOTIFICATION_SOUND="sound";

    public String getUsername() {
        return get(USERNAME, null);
    }

    public void setUsername(String username) {
        set(USERNAME, username);
    }

    public String getPassword() {
        return get(PASSWORD, null);
    }

    public void setPassword(String password) {
        set(PASSWORD, password);
    }

    public PreferenceHelper (Context context) {
        this.context = context;
    }

    public String getLanguage() {
        return get(LANGUAGE, "en");
    }

    public void setLanguage(String language) {
        set(LANGUAGE, language);
    }

    private void set(String key, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    private void set(String key, boolean value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private boolean get(String key, boolean defaultValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

    private String get(String key, String defaultValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }


    private void set(String key, int value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private int get(String key, int defaultValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }



}
