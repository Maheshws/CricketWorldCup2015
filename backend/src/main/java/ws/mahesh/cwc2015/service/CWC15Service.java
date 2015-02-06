package ws.mahesh.cwc2015.service;

import java.util.List;
import java.util.logging.Logger;

import ws.mahesh.cwc2015.models.Match;
import ws.mahesh.cwc2015.models.NewsFeed;
import ws.mahesh.cwc2015.models.SimpleScore;


public class CWC15Service {

    private static final Logger logger = Logger.getLogger(CWC15Service.class
            .getName());

    private FetchDataService fetchDataService;
    private ObjectGeneratorService objectGeneratorService;
    private PersistenceService persistenceService;
    private MemCacheService memCacheService;
    private MemCacheServiceLong memCacheServiceLong;

    public CWC15Service() {
        this.fetchDataService = new FetchDataService();
        this.objectGeneratorService = new ObjectGeneratorService();
        this.persistenceService = new PersistenceService();
        this.memCacheService = new MemCacheService();
        this.memCacheServiceLong = new MemCacheServiceLong();
    }

    public List<Match> getMatches() {
        String livescore = getMatchesFromLocalOrRemote();
        List<Match> matches = objectGeneratorService.getMatches(livescore);
        logger.info("Total matches returned: " + matches.size());
        return matches;
    }

    public SimpleScore getScore(int id) {

        SimpleScore score = memCacheService.getSimpleScore(id);

        if (score == null) {
            score = persistenceService.findSimpleScore(id);
            if (score == null) {
                score = fetchSimpleScore(id);
                persistenceService.insertSimpleScore(score);
            } else {
                if (!score.getDetail().toLowerCase().contains("match over")) {
                    SimpleScore newScore = fetchSimpleScore(id);
                    if (isScoreUpdated(score, newScore)) {
                        persistenceService.updateSimpleScore(newScore);
                        score = newScore;
                    }
                }
            }
            memCacheService.putSimpleScore(score);

        }
        logger.info("SimpleScore returned for id " + id + " is " + score.toString());
        return score;
    }

    private boolean isScoreUpdated(SimpleScore oldScore, SimpleScore newScore) {
        boolean updated = false;
        if (newScore != null && newScore.getSimple() != null && newScore.getDetail() != null
                && (!newScore.getSimple().equals(oldScore.getSimple())
                || !newScore.getDetail().equals(oldScore.getDetail()))) {
            logger.info("SimpleScore score is updated");
            updated = true;
        }
        return updated;
    }

    private SimpleScore fetchSimpleScore(int id) {
        String detail = fetchDataService.getScore(id);
        String livescore = getMatchesFromLocalOrRemote();
        SimpleScore simpleScore = objectGeneratorService.getScore(detail, livescore, id);
        return simpleScore;
    }

    private String getMatchesFromLocalOrRemote() {
        String livescore = memCacheService.getLiveScore();
        if (livescore == null) {
            livescore = fetchDataService.getMatches();
            memCacheService.setLiveScore(livescore);
        }
        return livescore;
    }

    public List<NewsFeed> getNewsFeed() {
        String livescore = getNewsFeedFromLocalOrRemote();
        List<NewsFeed> newsFeeds = objectGeneratorService.getLiveFeed(livescore);
        logger.info("Total matches returned: " + newsFeeds.size());
        return newsFeeds;
    }

    private String getNewsFeedFromLocalOrRemote() {
        String livefeed = memCacheServiceLong.getNewsFeed();
        if (livefeed == null) {
            livefeed = fetchDataService.getLiveFeed();
            memCacheServiceLong.putNewsFeed(livefeed);
        }
        return livefeed;
    }
}
