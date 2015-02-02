package ws.mahesh.cwc2015.fixtures;

/**
 * Created by Mahesh on 1/28/2015.
 */
public class FixtureObject {
    int id;
    int match_id;
    String match_type;
    String team1;
    String team2;
    String team1_short;
    String team2_short;
    int team1_img;
    int team2_img;
    String date;
    String day;
    String time;
    String group;
    String stadium;
    String city;
    String country;
    String result;
    String result_full;

    public FixtureObject(int id, int match_id, String match_type, String team1, String team2, String team1_short, String team2_short, int team1_img, int team2_img, String date, String day, String time, String group, String stadium, String city, String country, String result, String result_full) {
        this.id = id;
        this.match_id = match_id;
        this.match_type = match_type;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_short = team1_short;
        this.team2_short = team2_short;
        this.team1_img = team1_img;
        this.team2_img = team2_img;
        this.date = date;
        this.day = day;
        this.time = time;
        this.group = group;
        this.stadium = stadium;
        this.city = city;
        this.country = country;
        this.result = result;
        this.result_full = result_full;
    }
}
