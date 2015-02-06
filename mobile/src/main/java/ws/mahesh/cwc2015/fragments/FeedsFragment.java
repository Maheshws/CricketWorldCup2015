package ws.mahesh.cwc2015.fragments;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.databasehelpers.DatabaseHelper;
import ws.mahesh.cwc2015.feeds.FeedsAdapter;
import ws.mahesh.cwc2015.webservices.Refreshers;
import ws.mahesh.cwc2015.webservices.models.NewsFeed;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<NewsFeed> newsFeeds = new ArrayList<>();
    private FeedsAdapter adapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

    public FeedsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feeds, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.feeds_fragment_layout);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.feeds_recyclerview);
        newsFeeds.clear();
        getFeed();
        adapter = new FeedsAdapter(getActivity(), newsFeeds);
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
        final String oldT=newsFeeds.get(0).getTimestamp();
        new Refreshers(getActivity()).getFeed();
        getFeed();
        final String newT=newsFeeds.get(0).getTimestamp();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(newT.equalsIgnoreCase(oldT)) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                adapter = new FeedsAdapter(getActivity(), newsFeeds);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void makeDumFeed() {
        NewsFeed foo=new NewsFeed(0,"Welcome to World Cup 2015 App","Please make sure you have internet connection to get latest updates from World Cup\nSwipe to refresh", ""+Calendar.getInstance().getTime());
        newsFeeds.add(foo);
    }

    private void getFeed() {
        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String feedsList = appSharedPrefs.getString("FeedsList", "");
        prefsEditor.apply();
        if(feedsList.equals("")) {
            makeDumFeed();
        }
        else {
            Type type = new TypeToken<List<NewsFeed>>(){}.getType();
            newsFeeds = gson.fromJson(feedsList, type);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }


}
