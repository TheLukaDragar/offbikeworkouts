package com.dragar.luka.offbikeworkouts;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.vr.VrListenerService;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dragar.luka.offbikeworkouts.model.Exercise;
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta;
import com.dragar.luka.offbikeworkouts.model.Workout;
import com.dragar.luka.offbikeworkouts.model.WorkoutRepository;
import com.dragar.luka.offbikeworkouts.view.CoverActivity;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity2;

import com.dragar.luka.offbikeworkouts.view.OverviewActivity3;
import com.dragar.luka.offbikeworkouts.view.WorkoutActivity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GiftsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GiftsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GiftsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean audio =true;


    private OnFragmentInteractionListener mListener;

    public GiftsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GiftsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GiftsFragment newInstance(String param1, String param2) {
        GiftsFragment fragment = new GiftsFragment();
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
        View v = inflater.inflate(R.layout.fragment_gifts, container, false);



        final CardView card_view = (CardView) v.findViewById(R.id.card_view);
        card_view.setRadius(20);//RADIUS
        // creating a CardView and assigning a value.

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GiftsFragment.this.getActivity(),Start.class);
                intent.putExtra("ker","1");



               // intent.putExtra(CoverActivity.WORKOUT_KEY,workout);
                //intent.putExtra(WorkoutActivity.TTS_KEY,0);
                startActivity(intent);

                //val intent = Intent(this,OverviewActivity::class.java) startActivity(intent)
                //val startIntent = Intent(start, CoverActivity::class.java)
                // startIntent.putExtra(CoverActivity.WORKOUT_KEY, workout)
                // .startActivity(startIntent)






              //  Intent intent = new Intent(getActivity(),CoverActivity.class);
             //   intent.putExtra(CoverActivity.WORKOUT_KEY, workout);
                //  card_view.startAnimation(zoom);

               // startActivity(intent);



                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
            }
        });

        final CardView card_view2 = (CardView) v.findViewById(R.id.card_view2);
        card_view2.setRadius(20);//RADIUS
        // creating a CardView and assigning a value.

        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GiftsFragment.this.getActivity(),Start.class);
                // intent.putExtra(CoverActivity.WORKOUT_KEY,workout);
                intent.putExtra("ker","2");
                startActivity(intent);


            }
        });

        final CardView card_view3 = (CardView) v.findViewById(R.id.card_view3);
        card_view3.setRadius(20);//RADIUS
        // creating a CardView and assigning a value.




       final Workout workout = new Workout(
                R.string.Firstplank,
                R.string.starteasy,
                R.drawable.color_back,
                0xff0B65DB,
                new ExerciseMeta[]{new ExerciseMeta(new Exercise(
                        R.string.exercise_title_plank,
                       R.string.exercise_desc_plank,
                       R.drawable.exercise_plank
                ), 30,false)}
                ,30);


       // R.string.exercise_title_laterallungetotricepsextension,
                //R.string.tbd,WorkoutRepository.NULL_RESOURCE)


        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GiftsFragment.this.getActivity(),CoverActivity.class);
                 intent.putExtra(CoverActivity.WORKOUT_KEY,workout);
                //intent.putExtra("ker","2");
                startActivity(intent);


            }
        });
       // Button button = (Button) v.findViewById(R.id.button);
       // button.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {

             // Intent intent = new Intent(getActivity(),Start.class);
               //  intent.putExtra(OverviewActivity.WORKOUT_KEY,workout);
                 //intent.putExtra(WorkoutActivity.TTS_KEY,0);
              //  startActivity(intent);

            //    MediaPlayer mediaplayer = MediaPlayer.create(getActivity(), R.raw.movie_1);//You Can Put Your File Name Instead Of abc
               // mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
               //     @Override
               //     public void onCompletion(MediaPlayer mediaPlayer) {
                //        mediaPlayer.reset();
                //        mediaPlayer.release();
                //    }
              //  });
              //  mediaplayer.start();

           // }
       // }//);






        return v;
    }

    private void showToast(String text){
        Toast.makeText(getActivity(),text, Toast.LENGTH_SHORT).show();// this = Context
        MediaPlayer mediaplayer = MediaPlayer.create(getActivity(), R.raw.movie_1);//You Can Put Your File Name Instead Of abc
        mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                mediaPlayer.release();
            }
        });
        mediaplayer.start();
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
