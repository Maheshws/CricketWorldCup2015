package ws.mahesh.cwc2015.webservices;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.List;

import ws.mahesh.cwc2015.webservices.helpers.HTTPHelperService;
import ws.mahesh.cwc2015.webservices.helpers.JSONHelperService;
import ws.mahesh.cwc2015.webservices.models.NewsFeed;

public class FeedUpdaterService extends Service {
    public FeedUpdaterService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getFeed();
            }
        }).start();

    }

    private void getFeed() {
        String feed= HTTPHelperService.getResponse("csa?id=feed");
        List<NewsFeed> feeds= JSONHelperService.getFeedJSON(feed);
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String feedsList = gson.toJson(feeds);
        prefsEditor.putString("FeedsList", feedsList);
        prefsEditor.apply();
        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
