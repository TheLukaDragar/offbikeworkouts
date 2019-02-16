package com.dragar.luka.offbikeworkouts;


import android.content.Intent;
import android.widget.Toast;


import com.daimajia.androidanimations.library.Techniques;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class Splash extends AwesomeSplash {
   // private FirebaseAnalytics mFirebaseAnalytics;
   // private InterstitialAd mInterstitialAd;

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!


    @Override
    public void initSplash(ConfigSplash configSplash) {

      // mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
      //  MobileAds.initialize(this, "ca-app-pub-4526692710511158~5477844156");
       // mInterstitialAd = new InterstitialAd(this);


        //mInterstitialAd.setAdUnitId("ca-app-pub-4526692710511158/7659733486");
       // mInterstitialAd.loadAd(new AdRequest.Builder()
              //  .addTestDevice("BDD0B79D56C9AA2F03AB5BBFB78AFCC8")
                //.addTestDevice("381A1B4E5B4A7F573A066D54374CDD5B")
                ///.build());


        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.backgroudcolor); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.mipmap.ic_launcher);//or any other drawable
        configSplash.setAnimLogoSplashDuration(1000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
       // configSplash.setPathSplash(100); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(1000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.green); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(1000);
        configSplash.setPathSplashFillColor(R.color.green); //path object filling color


        //Customize Title
        configSplash.setTitleSplash("I'm Working on it!");
        configSplash.setTitleTextColor(R.color.green);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(500);
        configSplash.setAnimTitleTechnique(Techniques.FadeInUp);
        //configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        //runOnUiThread(new Runnable() {
          //  @Override public void run() {
              //  if (mInterstitialAd.isLoaded()) {
               //     mInterstitialAd.show();
               // }
               // else Toast.makeText(Splash.this,
                //        "Ad failed to load", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
          //  }
       // }//);



        //transit to another activity here
        //or do whatever you want
    }
}