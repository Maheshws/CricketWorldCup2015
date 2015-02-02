package ws.mahesh.cwc15lite.service;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import java.util.List;
import java.util.logging.Logger;

import ws.mahesh.cwc15lite.models.Match;
import ws.mahesh.cwc15lite.models.NewsFeed;
import ws.mahesh.cwc15lite.models.SimpleScore;

public class JSONHelperService {

    private static final Logger logger = Logger.getLogger(JSONHelperService.class
            .getName());

    public String getMatchesJSON(List<Match> matches) {
        JSONArray array = new JSONArray();
        try {
            for (Match match : matches) {
                JSONObject object = new JSONObject();
                object.put("id", match.getMatchId());
                object.put("t1", match.getTeamOne());
                object.put("t2", match.getTeamTwo());
                array.put(object);
            }
        } catch (JSONException e) {
            logger.severe(e.getMessage());
        }

        return array.toString();
    }

    public String getSimpleScoresJSON(List<SimpleScore> simpleScores,
                                      long timestamp) {
        JSONArray array = new JSONArray();
        try {

            for (SimpleScore simpleScore : simpleScores) {
                JSONObject scoreObject = new JSONObject();
                scoreObject.put("id", simpleScore.getId());
                scoreObject.put("si", simpleScore.getSimple());
                scoreObject.put("de", simpleScore.getDetail());
                array.put(scoreObject);
            }
        } catch (JSONException e) {
            logger.severe(e.getMessage());
        }
        return array.toString();
    }

    public String getNewsFeedJSON(List<NewsFeed> newsFeeds) {
        JSONArray array = new JSONArray();
        try {

            for (NewsFeed newsFeed : newsFeeds) {
                JSONObject scoreObject = new JSONObject();
                scoreObject.put("id", newsFeed.getId());
                scoreObject.put("title", newsFeed.getTitle());
                scoreObject.put("desc", newsFeed.getDescription());
                scoreObject.put("timestamp", newsFeed.getTimestamp());
                array.put(scoreObject);
            }
        } catch (JSONException e) {
            logger.severe(e.getMessage());
        }
        return array.toString();
    }

}