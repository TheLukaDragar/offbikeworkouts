package com.dragar.luka.offbikeworkouts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dragar.luka.offbikeworkouts.view.OverviewActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

public class Main2Activity extends AppCompatActivity {

   // private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

       // ActionBar toolbar1 = getSupportActionBar();

       // toolbar1.setTitle("Support");
        //ProfileFragment fragment = new ProfileFragment();
        //FirebaseDynamicLinks.getInstance()
             //   .getDynamicLink(getIntent())
               // .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                 //   @Override
                   // public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                      //  Uri deepLink = null;
                       // if (pendingDynamicLinkData != null) {
                           /// deepLink = pendingDynamicLinkData.getLink();
                        //}
                        Toast.makeText(Main2Activity.this,
                                        "contact me here", Toast.LENGTH_LONG).show();

        //Intent intent = new Intent(Main2Activity.this, ProfileFragment.class);
        //   intent.putExtra(CoverActivity3.WORKOUT_KEY3,"2");
        //intent.putExtra(WorkoutActivity.TTS_KEY,0);
        //startActivity(intent);
       // finish();


                        // Handle the deep link. For example, open the linked
                        // content, or apply promotional credit to the user's
                        // account.
                        // ...

                        // ...
                  //  }
              //  })
               // .addOnFailureListener(this, new OnFailureListener() {
                 //   @Override
                 //   public void onFailure(@NonNull Exception e) {
                 //       Log.w(TAG, "getDynamicLink:onFailure", e);
                 //   }
            //    });

       // FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack(null);
        //transaction.commit();


        // ATTENTION: This was auto-generated to handle app links.
        //Intent appLinkIntent = getIntent();
       // String appLinkAction = appLinkIntent.getAction();
       // Uri appLinkData = appLinkIntent.getData();
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
}
