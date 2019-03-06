package com.dragar.luka.offbikeworkouts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.dragar.luka.offbikeworkouts.view.CoverActivity;
import com.dragar.luka.offbikeworkouts.view.OverviewActivity;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   private String workout = "1";

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static ProfileFragment newInstance(String text) {

       ProfileFragment f = new ProfileFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //final Animation animation5 =AnimationUtils.loadAnimation(getActivity(),R.anim.righttoleft);
        //final Animation zoom=AnimationUtils.loadAnimation(getActivity(),R.anim.zoomin);
      //  RelativeLayout sroll = (RelativeLayout) v.findViewById(R.id.animateplz);
       // sroll.startAnimation(animation5);
        //  ImageButton imageButton = (ImageButton) v.findViewById(R.id.imageButton);
        // Button button = (Button) v.findViewById(R.id.button2);
        // Button button2 = (Button) v.findViewById(R.id.button3);
       // CardView prva = (CardView) v.findViewById(R.id.prva);
       // prva.setRadius(20);//RADIUS
        // creating a CardView and assigning a value.


        //prva.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(getActivity(),OverviewActivity.class);
              //  intent.putExtra(CoverActivity.WORKOUT_KEY,workout);
               // startActivity(intent);

                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
           // }
       // });
       // CardView druga = (CardView) v.findViewById(R.id.druga);
        // creating a CardView and assigning a value.

       // druga.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
              //  Intent intent = new Intent(getActivity(), OverviewActivity.class);
              //  startActivity(intent);

                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
          //  }
       // });
        //CardView tretja = (CardView) v.findViewById(R.id.tretja);
       // tretja.setRadius(20);//RADIUS
        // creating a CardView and assigning a value.

      // tretja.setOnClickListener(new View.OnClickListener() {
        //    @Override
       //     public void onClick(View v) {
       //         Intent intent = new Intent(getActivity(), OverviewActivity.class);
       //         startActivity(intent);

                // do whatever you want to do on click (to launch any fragment or activity you need to put intent here.)
        //    }
       // });

        return v;
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
