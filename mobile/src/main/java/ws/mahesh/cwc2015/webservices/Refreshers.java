package ws.mahesh.cwc2015.webservices;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import ws.mahesh.cwc2015.webservices.helpers.HTTPHelperService;
import ws.mahesh.cwc2015.webservices.helpers.JSONHelperService;
import ws.mahesh.cwc2015.webservices.models.Matches;
import ws.mahesh.cwc2015.webservices.models.NewsFeed;

/**
 * Created by Mahesh on 2/6/2015.
 */
public final class Refreshers {
    private Context context;

    public Refreshers(Context context) {
        this.context = context;
    }

    public void getFeed() {
        String feed = HTTPHelperService.getResponse("csa?id=feed");
        if(feed==null)
            return;
        List<NewsFeed> feeds = JSONHelperService.getFeedJSON(feed);
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String feedsList = gson.toJson(feeds);
        prefsEditor.putString("FeedsList", feedsList);
        prefsEditor.apply();
        Log.i("I", "Got feed");
    }

    public void getMatches() {
        String feed = HTTPHelperService.getResponse("csa");
        List<Matches> matches = JSONHelperService.getMatchesJSON(feed);
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String matchesList = gson.toJson(matches);
        prefsEditor.putString("MatchesList", matchesList);
        prefsEditor.apply();
        Log.i("I", "Got Matches");
    }

}
