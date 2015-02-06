package ws.mahesh.cwc2015.webservices.models;

/**
 * Created by Mahesh on 2/6/2015.
 */
public class Matches {
    private String teamOne;
    private String teamTwo;
    private int matchId;

    public Matches(String teamOne, String teamTwo, int matchId) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.matchId = matchId;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public int getMatchId() {
        return matchId;
    }

    @Override
    public String toString() {
        return "Match [teamOne=" + teamOne + ", teamTwo=" + teamTwo
                + ", matchId=" + matchId + "]";
    }
}
