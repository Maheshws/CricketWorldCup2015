package ws.mahesh.cwc2015.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ws.mahesh.cwc2015.R;


public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv1 = (TextView) getActivity().findViewById(R.id.hello_world);
        tv1.setText("TODO:\n0.App graphics(logo,etc.)\n1.Countdown(needs ideas)\n2.Backend for scores\n3.Link App with server\n4.Android Wear Scores(20% done)\n5.Activity Transitions with final layouts for teams, schedule.\n6.Settings\n7.(NC) Voting system");
    }


}
