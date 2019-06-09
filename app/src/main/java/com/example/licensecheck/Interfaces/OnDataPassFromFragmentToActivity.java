package com.example.licensecheck.Interfaces;

import com.example.licensecheck.Entity.ListUsers;

/**
 * Created by andrey on 14.09.18.
 */

public interface OnDataPassFromFragmentToActivity {
    public void passDataFromFragmentToActivity(ListUsers data); // text for time period

/*    public void passAddDataFromFragmentToActivity(String data); // text for time period
    public void passDelDataFromFragmentToActivity(Integer integer); //id fragment's
    public void passUpdateDataFromFragmentToActivity(String data, Integer integer);*/
}
