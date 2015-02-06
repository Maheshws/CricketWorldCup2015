package ws.mahesh.cwc2015.webservices.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ws.mahesh.cwc2015.webservices.models.Matches;
import ws.mahesh.cwc2015.webservices.models.NewsFeed;

/**
 * Created by Mahesh on 2/6/2015.
 */
public class JSONHelperService {


    public List<Matches> getMatchesJSON(String match1) {
        List<Matches> matches=new ArrayList<>();
        try {
        JSONArray array= new JSONArray(match1);
        for(int i=0;i<array.length();i++){
            JSONObject elem=(JSONObject)array.get(i);
            Matches match=new Matches(elem.getString("t1"),elem.getString("t2"),elem.getInt("id"));
            matches.add(match);
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return matches;
    }

    public List<NewsFeed> getFeedJSON(String feed1) {
        List<NewsFeed> feeds=new ArrayList<>();
        try {
            JSONArray array= new JSONArray(feed1);
            for(int i=0;i<array.length();i++){
                JSONObject elem=(JSONObject)array.get(i);
                NewsFeed feed=new NewsFeed(elem.getInt("id"),elem.getString("title"),elem.getString("desc"),elem.getString("timestamp"));
                feeds.add(feed);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return feeds;
    }
}
