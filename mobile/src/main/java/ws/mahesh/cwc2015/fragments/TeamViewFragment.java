package ws.mahesh.cwc2015.fragments;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.databasehelpers.DatabaseHelper;
import ws.mahesh.cwc2015.fixtures.FixtureObject;
import ws.mahesh.cwc2015.fixtures.FixturesAdapter;
import ws.mahesh.cwc2015.teams.TeamsObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamViewFragment extends Fragment {

    private static TeamsObject teamsObject;

    private RecyclerView recyclerView;
    private DatabaseHelper dbHelper;
    private Cursor fix_cursor;
    private List<FixtureObject> fixObject = new ArrayList<>();
    private FixturesAdapter adapter;

    public TeamViewFragment() {
        // Required empty public constructor
    }

    public static TeamViewFragment newInstance(TeamsObject teamsObject1) {
        TeamViewFragment fragment = new TeamViewFragment();
        Bundle args = new Bundle();
        teamsObject = teamsObject1;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView squad = (TextView) getActivity().findViewById(R.id.textViewSquad);
        squad.setText(teamsObject.getPlayers());

        dbHelper = new DatabaseHelper(getActivity());
        fix_cursor = dbHelper.getTeamFixtures(teamsObject.getTeam());
        fillData();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.fixs_recyclerview);
        adapter = new FixturesAdapter(getActivity(), fixObject, getResources().getColor(R.color.colorTeams));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
        dbHelper.close();
        fix_cursor.close();
    }

    private void fillData() {
        fixObject.clear();
        int i = 0;
        if (fix_cursor != null) {
            if (fix_cursor.moveToFirst()) {
                do {
                    FixtureObject temp = new FixtureObject(fix_cursor.getInt(0), fix_cursor.getInt(1), fix_cursor.getString(2), fix_cursor.getString(3), fix_cursor.getString(4), fix_cursor.getString(5), fix_cursor.getString(6), getIcon(fix_cursor.getString(5)), getIcon(fix_cursor.getString(6)), fix_cursor.getString(7), fix_cursor.getString(8), fix_cursor.getString(9), fix_cursor.getString(10), fix_cursor.getString(11), fix_cursor.getString(12), fix_cursor.getString(13), fix_cursor.getString(14), fix_cursor.getString(15));
                    fixObject.add(temp);
                    i++;
                } while (fix_cursor.moveToNext());
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
