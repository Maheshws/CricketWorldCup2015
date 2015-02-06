package ws.mahesh.cwc2015.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.mahesh.cwc2015.models.Match;
import ws.mahesh.cwc2015.models.NewsFeed;
import ws.mahesh.cwc2015.models.SimpleScore;
import ws.mahesh.cwc2015.service.CWC15Service;
import ws.mahesh.cwc2015.service.JSONHelperService;
import ws.mahesh.cwc2015.utils.StringUtils;


public class CWC15Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger
            .getLogger(CWC15Servlet.class.getName());
    private CWC15Service CWC15Service;
    private JSONHelperService jsonHelperService;

    public CWC15Servlet() {
        CWC15Service = new CWC15Service();
        jsonHelperService = new JSONHelperService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String responseString = null;
        String paramId = (String) request.getParameter("id");
        logger.info("ID = " + paramId);
        if (paramId == null) {
            List<Match> matches = CWC15Service.getMatches();
            responseString = jsonHelperService.getMatchesJSON(matches);
        } else if (paramId.equals("feed")) {
            List<NewsFeed> newsFeed = CWC15Service.getNewsFeed();
            responseString = jsonHelperService.getNewsFeedJSON(newsFeed);
        } else if (paramId.equals("all")) {
            long timestamp = 0;
            Date lastModified = StringUtils.getDate(request.getHeader("If-Modified-Since"));
            logger.info("lastModified = " + lastModified);
            if (lastModified != null) {
                timestamp = lastModified.getTime();
            }
            List<Match> matchesList = CWC15Service.getMatches();
            String[] matches=CWC15Service.getAllMatchIds(matchesList);
            logger.finer("Request matches : " + matches);
            List<SimpleScore> scores = new ArrayList<SimpleScore>();
            for (String matchId : matches) {
                if(matchId!=null) {
                    int id = Integer.parseInt(matchId);
                    SimpleScore simpleScore = CWC15Service.getScore(id);
                    if (timestamp == 0 || (simpleScore != null && simpleScore.getTimestamp() > timestamp)) {
                        scores.add(simpleScore);
                    }
                }
            }
            if (scores.size() == 0) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                return;
            }
            responseString = jsonHelperService.getSimpleScoresJSON(scores, System.currentTimeMillis());
        } else if (StringUtils.isNumericPlus(paramId)) {
            long timestamp = 0;
            Date lastModified = StringUtils.getDate(request.getHeader("If-Modified-Since"));
            logger.info("lastModified = " + lastModified);
            if (lastModified != null) {
                timestamp = lastModified.getTime();
            }
            String[] matchIds = paramId.split(" ");
            logger.finer("Request matches : " + matchIds);
            List<SimpleScore> scores = new ArrayList<SimpleScore>();
            for (String matchId : matchIds) {
                int id = Integer.parseInt(matchId);
                SimpleScore simpleScore = CWC15Service.getScore(id);
                if (timestamp == 0 || (simpleScore != null && simpleScore.getTimestamp() > timestamp)) {
                    scores.add(simpleScore);
                }
            }
            if (scores.size() == 0) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                return;
            }
            responseString = jsonHelperService.getSimpleScoresJSON(scores, System.currentTimeMillis());

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (responseString != null) {
            logger.finer("responseString: " + responseString);
            response.setContentType("application/json");
            response.addHeader("Last-Modified", StringUtils.getDate(new Date()));
            response.getWriter().println(responseString);
        }
    }
}