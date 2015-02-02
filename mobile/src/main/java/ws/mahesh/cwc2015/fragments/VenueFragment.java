package ws.mahesh.cwc2015.fragments;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.databasehelpers.DatabaseHelper;
import ws.mahesh.cwc2015.venue.VenueAdapter;
import ws.mahesh.cwc2015.venue.VenueObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueFragment extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;
    private Cursor venue_cursor;
    private List<VenueObject> venueObject = new ArrayList<>();
    private VenueAdapter adapter;

    public VenueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_venue, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper = new DatabaseHelper(getActivity());
        venue_cursor = dbHelper.getVenues();
        fillData();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.venues_recyclerview);
        adapter = new VenueAdapter(getActivity(), venueObject);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
        dbHelper.close();
        venue_cursor.close();
    }

    private void fillData() {
        venueObject.clear();
        int i = 0;
        if (venue_cursor != null) {
            if (venue_cursor.moveToFirst()) {
                do {
                    VenueObject temp = new VenueObject(i, getIcon(venue_cursor.getString(venue_cursor.getColumnIndex("venue_id"))), venue_cursor.getString(venue_cursor.getColumnIndex("stadium")), venue_cursor.getString(venue_cursor.getColumnIndex("std_info")));
                    venueObject.add(temp);
                    i++;
                } while (venue_cursor.moveToNext());
            }
        }
    }

    private int getIcon(String team_id) {
        switch (team_id) {
            case "Adelaide":
                return R.drawable.adelaide;
            case "Gabba":
                return R.drawable.brisbane;
            case "Canberra":
                return R.drawable.canberra;
            case "Hobart":
                return R.drawable.hobart;
            case "MCG":
                return R.drawable.melbourne;
            case "Waca":
                return R.drawable.perth;
            case "Sydney":
                return R.drawable.sydney;
            case "Auckland":
                return R.drawable.auckland;
            case "Christchurch":
                return R.drawable.christchurch;
            case "Dunedin":
                return R.drawable.dunedin;
            case "Hamilton":
                return R.drawable.hamilton;
            case "Napier":
                return R.drawable.napier;
            case "Nelson":
                return R.drawable.nelson;
            case "Wellington":
                return R.drawable.wellington;
            default:
                return R.drawable.ic_public_black_24dp;
        }
    }

}
