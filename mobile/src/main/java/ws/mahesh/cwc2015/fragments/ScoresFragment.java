package ws.mahesh.cwc2015.fragments;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.databasehelpers.DatabaseHelper;
import ws.mahesh.cwc2015.fixtures.FixtureObject;
import ws.mahesh.cwc2015.fixtures.FixturesAdapter;
import ws.mahesh.cwc2015.webservices.models.LiveScores;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {
    SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;
    private Cursor upcom_cursor;
    private List<FixtureObject> upcomObject = new ArrayList<>();
    private FixturesAdapter adapter;
    private RecyclerView recyclerView2;
    private List<LiveScores> scoresObject = new ArrayList<>();
    private FixturesAdapter adapter1;

    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scores, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.scores_fragment_layout);
        dbHelper = new DatabaseHelper(getActivity());
        upcom_cursor = dbHelper.getFixturesLimited();
        fillData();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.upcomingMatches_recyclerview);
        adapter = new FixturesAdapter(getActivity(), upcomObject, getResources().getColor(R.color.colorFixtures));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        refreshContent();
                    }
                }).start();
            }
        });
    }

    private void refreshContent() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                //do n/w work here

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        dbHelper.close();
        upcom_cursor.close();
    }

    private void fillData() {
        upcomObject.clear();
        int i = 0;
        if (upcom_cursor != null) {
            if (upcom_cursor.moveToFirst()) {
                do {
                    FixtureObject temp = new FixtureObject(upcom_cursor.getInt(0), upcom_cursor.getInt(1), upcom_cursor.getString(2), upcom_cursor.getString(3), upcom_cursor.getString(4), upcom_cursor.getString(5), upcom_cursor.getString(6), getIcon(upcom_cursor.getString(5)), getIcon(upcom_cursor.getString(6)), upcom_cursor.getString(7), upcom_cursor.getString(8), upcom_cursor.getString(9), upcom_cursor.getString(10), upcom_cursor.getString(11), upcom_cursor.getString(12), upcom_cursor.getString(13), upcom_cursor.getString(14), upcom_cursor.getString(15));
                    upcomObject.add(temp);
                    i++;
                } while (upcom_cursor.moveToNext());
            }
        }
    }

    private int getIcon(String team_id) {
        switch (team_id) {
            case "AFG":
                return R.drawable.ic_afg_24;
            case "AUS":
                return R.drawable.ic_aus_24;
            case "BAN":
                return R.drawable.ic_ban_24;
            case "ENG":
                return R.drawable.ic_eng_24;
            case "IND":
                return R.drawable.ic_ind_24;
            case "IRE":
                return R.drawable.ic_ire_24;
            case "NZ":
                return R.drawable.ic_nz_24;
            case "PAK":
                return R.drawable.ic_pak_24;
            case "SCO":
                return R.drawable.ic_sct_24;
            case "SA":
                return R.drawable.ic_sa_24;
            case "SRI":
                return R.drawable.ic_sri_24;
            case "UAE":
                return R.drawable.ic_uae_24;
            case "WI":
                return R.drawable.ic_wi_24;
            case "ZIM":
                return R.drawable.ic_zim_24;
            default:
                return R.drawable.ic_tbd;
        }
    }
}
