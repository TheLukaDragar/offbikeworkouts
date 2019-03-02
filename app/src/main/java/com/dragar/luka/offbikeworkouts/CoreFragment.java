package com.dragar.luka.offbikeworkouts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.dragar.luka.offbikeworkouts.view.OverviewActivity;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity2;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity3;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity4;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity5;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoreFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FirebaseAnalytics mFirebaseAnalytics;
    ScrollView scrollView;

    private OnFragmentInteractionListener mListener;



    public CoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoreFragment newInstance(String param1, String param2) {
        CoreFragment fragment = new CoreFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_core, container, false);



        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean animate;

        animate = prefs.getBoolean("animationonoff",true);
      if (animate){
          // android:animation="@anim/item_animation_fall_down"
          String speed = prefs.getString("animationspeed","300");
          final Animation itemfalldown =AnimationUtils.loadAnimation(getActivity(),R.anim.item_animation_fall_down);

          assert speed != null;
          itemfalldown.setDuration(Long.parseLong(speed));

          LinearLayout layout = v.findViewById(R.id.corelayout);
          LayoutAnimationController anim = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation_fall_down);
          anim.setAnimation(itemfalldown);
          layout.setLayoutAnimation(anim);
      }
      if (!animate){ LinearLayout layout = v.findViewById(R.id.corelayout);
          final Animation fadein =AnimationUtils.loadAnimation(getActivity(),R.anim.fadeinfast);
          layout.startAnimation(fadein);
      }






       // final Animation animation5 =AnimationUtils.loadAnimation(getActivity(),R.anim.lefttoright);
       // final Animation fadein =AnimationUtils.loadAnimation(getActivity(),R.anim.fadeinfast);
       // ScrollView scrollView = (ScrollView) v.findViewById(R.id.animateplz);
       // scroll.scrollTo(0, scroll.getBottom());
        //sroll.scrollTo(10, 0);
        //sroll.startAnimation(animation5);

        final CardView card_view = v.findViewById(R.id.card_view);
        card_view.setRadius(20);
       // card_view.startAnimation(fadein);//RADIUS
       // creating a CardView and assigning a value.

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle params = new Bundle();
                String name= "test";
                params.putString("image_name", name);

                mFirebaseAnalytics.logEvent("main_opened", params);



                Intent intent = new Intent(getActivity(),OverviewActivity.class);

                startActivity(intent);



                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });
        CardView card_view2 = v.findViewById(R.id.card_view2);
        card_view2.setRadius(20);
        //card_view2.startAnimation(fadein);

        //RADIUS
        // creating a CardView and assigning a value.

        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        Intent intent = new Intent(getActivity(),OverviewActivity2.class);
                        startActivity(intent);


                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });
        CardView card_view3 = v.findViewById(R.id.card_view3);
        card_view3.setRadius(20);//RADIUS
        //card_view3.startAnimation(fadein);

        // creating a CardView and assigning a value.

        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(),OverviewActivity3.class);
                startActivity(intent);


                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });

        final CardView card_view4 = v.findViewById(R.id.card_view4);
        card_view4.setRadius(20);//RADIUS
        //card_view4.startAnimation(fadein);
        // creating a CardView and assigning a value.

        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getActivity(),OverviewActivity4.class);
                //  card_view.startAnimation(zoom);

                startActivity(intent);



                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });
        final CardView card_view5 = v.findViewById(R.id.card_view5);
        card_view5.setRadius(20);//RADIUS
       // card_view5.startAnimation(fadein);
        //sroll.scrollTo(0, 0);
        // creating a CardView and assigning a value.

        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getActivity(), OverviewActivity5.class);
                //  card_view.startAnimation(zoom);

                startActivity(intent);



                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });


        return v;
    }

    private void animatelayout() {


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
