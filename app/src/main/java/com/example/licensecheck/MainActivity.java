package com.example.licensecheck;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;


import com.example.licensecheck.Entity.Inet;
import com.example.licensecheck.Entity.ListUsers;
import com.example.licensecheck.Interfaces.DataPassFromActivityToFragment;
import com.example.licensecheck.Interfaces.OnDataPassFromFragmentToActivity;
import com.example.licensecheck.adapter.ViewPagerAdapter;

import com.example.licensecheck.fragment.Request;
import com.example.licensecheck.fragment.Result;
import com.example.licensecheck.http_request.HttpRequestTaskGetLicense;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements OnDataPassFromFragmentToActivity {


    ViewPager viewPager;




    @Override
    public void passDataFromFragmentToActivity(ListUsers data) {
        DataPassFromActivityToFragment dataPassFromActivityToFragment;
        Fragment fragmentResultFragment = ((ViewPagerAdapter) viewPager.getAdapter()).getItem(1);
        dataPassFromActivityToFragment = (DataPassFromActivityToFragment) fragmentResultFragment;

        dataPassFromActivityToFragment.passDataFromActivityToFragment(data);
    }



    public Inet inets;
    public ListUsers listUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);//drawable.top_logo);

//Альтернатива для строки выше три строчки ниже
        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.top_logo);
        actionBar.setDisplayHomeAsUpEnabled(true);*/


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(9); // Количество сохраненных экранов-фрагментов
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        setupViewPager(viewPager);////////////////ниже закоментирован








    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Request(),    "Запрос");
        adapter.addFragment(new Result(),    "Результат");
        viewPager.setAdapter(adapter);
    }









}
