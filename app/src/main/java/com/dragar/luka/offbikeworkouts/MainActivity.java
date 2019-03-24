package com.dragar.luka.offbikeworkouts;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    public boolean isFirstStart;
    public ActionBar toolbar1;
    private InterstitialAd mInterstitialAd;
    private FirebaseAnalytics mFirebaseAnalytics;
    boolean doubleBackToExitPressedOnce = false;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-4526692710511158~5477844156");
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        startads();
        Bundle params = new Bundle();
        String name= "test";
        params.putString("image_name", name);

        mFirebaseAnalytics.logEvent("my_event", params);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String duration = prefs.getString("key_gallery_name","");
       // android:duration="@integer/anim_duration_long"

      //  Toast.makeText(this,
           //     duration, Toast.LENGTH_LONG).show();






       // Bundle bundle = new Bundle();
        //bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf((R.id.navigation_cart)));
        //bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, String.valueOf(R.id.navigation_cart));
        //bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "NAVIGATION");
       // mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar1 = getSupportActionBar();




       // BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //navigation.setSelectedItemId(R.id.navigation_shop);


       // toolbar1.setTitle("Core");

        //loadFragment(new CoreFragment());










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

        ViewPager pager = findViewById(R.id.viewPager);
        TabLayout tabs = findViewById(R.id.tabLayout);
        //TabItem item1 = findViewById(R.id.tabItem);





        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
       pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        toolbar1.setTitle("Core");
                        break;
                    case 1:
                        toolbar1.setTitle("Stretching");
                        break;
                    case 2:
                        toolbar1.setTitle("HIT");
                        break;
                    case 3:
                        toolbar1.setTitle("Support");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        tabs.setupWithViewPager(pager);
        int[] icons = {
                R.drawable.pushupp,
                R.drawable.coree,
                R.drawable.squatt,
                R.drawable.hartt
        };

        for (int i = 0; i < tabs.getTabCount(); i++) {
            tabs.getTabAt(i).setIcon(icons[i]);
        }
      //      <android.support.design.widget.BottomNavigationView
       // android:id="@+id/navigation"
       // android:layout_width="match_parent"
       // android:layout_height="wrap_content"
       // android:layout_gravity="bottom"
       // android:background="@color/backdark"
      //  android:foreground="?attr/selectableItemBackground"
       // app:itemBackground="@color/backdark"
       // app:itemIconTint="@color/green"
       // app:itemTextColor="@android:color/white"
       // app:menu="@menu/navigatio" >
   // </android.support.design.widget.BottomNavigationView>


    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        private String[] tabTitles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4"};


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
            //tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    //toolbar1.setTitle("Core");
                    return new CoreFragment();
                case 1:
                   // toolbar1.setTitle("Stretching");
                    return new StrechFragment();
                case 2:
                   // toolbar1.setTitle("Hit");
                    return new HitFragment();
                case 3:
                   // toolbar1.setTitle("Support");
                    return new ProfileFragment();
                default:
                    return null; // shouldn't happen
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
            //return 4;
        }






    }


    private void startads() {
        mInterstitialAd = new InterstitialAd(this);


        mInterstitialAd.setAdUnitId("ca-app-pub-4526692710511158/7659733486");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                // .addTestDevice("BDD0B79D56C9AA2F03AB5BBFB78AFCC8")
                // .addTestDevice("381A1B4E5B4A7F573A066D54374CDD5B")
                .build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
             //   mInterstitialAd.loadAd(new AdRequest.Builder().build());
               // Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                //   intent.putExtra(CoverActivity3.WORKOUT_KEY3,"2");
                //intent.putExtra(WorkoutActivity.TTS_KEY,0);
               /// startActivity(intent);
            }

        });


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar1.setTitle("Core Workouts");
                    fragment = new CoreFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
                    toolbar1.setTitle("Streching");
                    fragment = new StrechFragment();
                    loadFragment(fragment);


                    return true;
                case R.id.navigation_cart:
                    toolbar1.setTitle("HIT Workouts");
                    fragment = new HitFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar1.setTitle("Support");

                    showad();

                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }

        private void showad() {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Toast.makeText(MainActivity.this, "Ad did not load", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(getActivity(),OverviewActivity.class);
                //   intent.putExtra(CoverActivity3.WORKOUT_KEY3,"2");
                //intent.putExtra(WorkoutActivity.TTS_KEY,0);
                //startActivity(intent);

            }


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
       // transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    public void start(View view) {

        Fragment fragment;
        fragment = new ProfileFragment();
        loadFragment(fragment);
    }
    @Override
    public void onBackPressed() {





       // BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

       // int seletedItemId = bottomNavigationView.getSelectedItemId();
      //  if (R.id.navigation_shop != seletedItemId) {
       //     setHomeItem(MainActivity.this);
       // } else {
        if (doubleBackToExitPressedOnce) {
               finish();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
  //  }

   // public static void setHomeItem(Activity activity) {
    //    BottomNavigationView bottomNavigationView = (BottomNavigationView)
      //          activity.findViewById(R.id.navigation);
      //  bottomNavigationView.setSelectedItemId(R.id.navigation_shop);
//






  //  }

    private void ref() {


    }

    public void follow(View view) {
        Uri uri = Uri.parse("http://instagram.com/_u/thelukadragar");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/thelukadragar")));
        }


    }


    public void github(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/TheLukaDragar/offbikeworkouts")));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


