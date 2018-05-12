package com.example.max.mainwindow;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.max.mainwindow.museumpackage.ListFragment;
import com.example.max.mainwindow.newslistpackage.NewsParserFragment;

public class MainActivity extends AppCompatActivity {

    Boolean newsShowed, museumsShowed;

   NewsParserFragment newsFragment = new NewsParserFragment();
   ListFragment listFragment = new ListFragment();
   MapFragment mapFragment = new MapFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setTitle("Новости на Znak.com");
        if(savedInstanceState == null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.placeholder, newsFragment).commit();
            setTitle("Новости на Znak.com");
        }


    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            //NewsParserFragment newsParserFragment = new NewsParserFragment();


            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_news:


                            //FragmentManager fragment1Manager = getFragmentManager();
                            //NewsParserFragment newsFragment = new NewsParserFragment();
                            //fragment1Manager.beginTransaction().add(R.id.placeholder, newsFragment).commit();
                    transaction.replace(R.id.placeholder, newsFragment).show(new NewsParserFragment());
                    transaction.commit();
                    setTitle("Новости на Znak.com");
                    return true;
                case R.id.navigation_museums:


                    transaction.replace(R.id.placeholder, listFragment).show(new ListFragment());
                    transaction.commit();
                    setTitle("Музеи Екатеринбурга");
                    return true;

                case R.id.navigation_map:
                    setTitle("Карта музеев в Екатеринбурге");

                    transaction.replace(R.id.placeholder, mapFragment).show(new MapFragment());
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };
}
