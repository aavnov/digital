package com.example.licensecheck;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
System.out.println("!!!!!!!!!!!!! SettingsActivity - onCreate:  RESUME  " );
        // Load the preferences from an XML resource
        //addPreferencesFromResource(R.xml.preferences);
    }
}
