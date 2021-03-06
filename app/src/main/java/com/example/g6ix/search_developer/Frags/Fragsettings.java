package com.example.g6ix.search_developer.Frags;

/**
 * Created by g6ix on 21-Aug-17.
 */
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import com.example.g6ix.search_developer.R;

public class Fragsettings extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {


    private void setPreferenceSummary(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            ListPreference preference1 = (ListPreference) preference;
            int prefIndex = preference1.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference1.setSummary(preference1.getEntries()[prefIndex]);
            }

        }
    }


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);


        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int count = preferenceScreen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            Preference p = preferenceScreen.getPreference(i);
            String value = sharedPreferences.getString(p.getKey(), "");
            setPreferenceSummary(p, value);
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference p = findPreference(key);
        if (p != null) {
            setPreferenceSummary(p, sharedPreferences.getString(key, ""));
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
