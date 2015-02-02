package ws.mahesh.cwc2015.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.databasehelpers.DatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class PointsTableFragment extends Fragment {


    TableLayout tl, t2;
    private DatabaseHelper dbHelper;
    private Cursor pts_cursor;

    public PointsTableFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_points_table, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tl = (TableLayout) getActivity().findViewById(R.id.table1);
        t2 = (TableLayout) getActivity().findViewById(R.id.table2);
        dbHelper = new DatabaseHelper(getActivity());
        pts_cursor = dbHelper.getPoints();
        setUp();
    }

    public void setUp() {
        if (pts_cursor.moveToFirst()) {
            for (int i = 0; i < 7; i++) {
                TableRow tbrow = new TableRow(getActivity());
                TextView t1v = new TextView(getActivity());
                t1v.setText("" + (i + 1));
                t1v.setGravity(Gravity.CENTER);
                t1v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t1v);
                ImageView i1v = new ImageView(getActivity());
                i1v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(i1v);
                TextView t2v = new TextView(getActivity());
                t2v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("team_name")).toUpperCase());
                //t2v.setGravity(Gravity.CENTER);
                t2v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 3f));
                tbrow.addView(t2v);
                TextView t3v = new TextView(getActivity());
                t3v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("MP")));
                t3v.setGravity(Gravity.CENTER);
                t3v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t3v);
                TextView t4v = new TextView(getActivity());
                t4v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("W")));
                t4v.setGravity(Gravity.CENTER);
                t4v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t4v);
                TextView t5v = new TextView(getActivity());
                t5v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("D")));
                t5v.setGravity(Gravity.CENTER);
                t5v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t5v);
                TextView t6v = new TextView(getActivity());
                t6v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("L")));
                t6v.setGravity(Gravity.CENTER);
                t6v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t6v);
                TextView t7v = new TextView(getActivity());
                t7v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("RR")));
                t7v.setGravity(Gravity.CENTER);
                t7v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));
                tbrow.addView(t7v);
                TextView t8v = new TextView(getActivity());
                t8v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("PT")));
                t8v.setGravity(Gravity.CENTER);
                t8v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));
                tbrow.addView(t8v);
                tbrow.setPadding(4, 4, 4, 4);
                tl.addView(tbrow);
                pts_cursor.moveToNext();
            }
            for (int i = 0; i < 7; i++) {
                TableRow tbrow = new TableRow(getActivity());
                TextView t1v = new TextView(getActivity());
                t1v.setText("" + (i + 1));
                t1v.setGravity(Gravity.CENTER);
                t1v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t1v);
                ImageView i1v = new ImageView(getActivity());
                i1v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(i1v);
                TextView t2v = new TextView(getActivity());
                t2v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("team_name")).toUpperCase());
                //t2v.setGravity(Gravity.CENTER);
                t2v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 3f));
                tbrow.addView(t2v);
                TextView t3v = new TextView(getActivity());
                t3v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("MP")));
                t3v.setGravity(Gravity.CENTER);
                t3v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t3v);
                TextView t4v = new TextView(getActivity());
                t4v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("W")));
                t4v.setGravity(Gravity.CENTER);
                t4v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t4v);
                TextView t5v = new TextView(getActivity());
                t5v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("D")));
                t5v.setGravity(Gravity.CENTER);
                t5v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t5v);
                TextView t6v = new TextView(getActivity());
                t6v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("L")));
                t6v.setGravity(Gravity.CENTER);
                t6v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tbrow.addView(t6v);
                TextView t7v = new TextView(getActivity());
                t7v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("RR")));
                t7v.setGravity(Gravity.CENTER);
                t7v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));
                tbrow.addView(t7v);
                TextView t8v = new TextView(getActivity());
                t8v.setText(pts_cursor.getString(pts_cursor.getColumnIndex("PT")));
                t8v.setGravity(Gravity.CENTER);
                t8v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 2f));
                tbrow.addView(t8v);
                tbrow.setPadding(4, 4, 4, 4);
                t2.addView(tbrow);
                pts_cursor.moveToNext();

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        pts_cursor.close();
        dbHelper.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
