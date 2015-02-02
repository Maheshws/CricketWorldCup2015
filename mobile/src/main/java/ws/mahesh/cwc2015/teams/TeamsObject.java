package ws.mahesh.cwc2015.teams;

/**
 * Created by Mahesh on 1/26/2015.
 */
public class TeamsObject {
    int id;
    int logoId;
    String team;
    String captain;
    String coach;
    String players;

    public TeamsObject(int id, int logoId, String team, String captain, String coach, String players) {
        this.id = id;
        this.logoId = logoId;
        this.team = team;
        this.captain = captain;
        this.coach = coach;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getCaptain() {
        return captain;
    }

    public String getCoach() {
        return coach;
    }

    public String getPlayers() {
        return players;
    }

    public int getLogoId() {
        return logoId;
    }
}
