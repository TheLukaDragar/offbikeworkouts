package com.dragar.luka.offbikeworkouts;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public boolean isFirstStart;
    private ActionBar toolbar1;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar1 = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar1.setTitle("Shop");
        loadFragment(new StoreFragment());






      //  ImageButton buttonViewTutorial = (ImageButton)findViewById(R.id.gg);
       // buttonViewTutorial.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
           //     Intent i = new Intent(MainActivity.this, MyIntro.class);
                //startActivity(i);
          //  }
       // });



      //  Thread t = new Thread(new Runnable() {
           // @Override
          //  public void run() {
        //  Intro App Initialize SharedPreferences
               // SharedPreferences getSharedPreferences = PreferenceManager
                        //.getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
               // isFirstStart = getSharedPreferences.getBoolean("firstStart", true);

                //  Check either activity or app is open very first time or not and do action
               // if (isFirstStart) {

                    //  Launch application introduction screen
               //     Intent i = new Intent(MainActivity.this, MyIntro.class);
              //      startActivity(i);
              //      SharedPreferences.Editor e = getSharedPreferences.edit();
              //      e.putBoolean("firstStart", false);
             //       e.apply();
          //      }
        //    }
       // });
       // t.start();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar1.setTitle("Shop");
                    fragment = new StoreFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    toolbar1.setTitle("My Gifts");
                    fragment = new GiftsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    toolbar1.setTitle("Cart");
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar1.setTitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}


