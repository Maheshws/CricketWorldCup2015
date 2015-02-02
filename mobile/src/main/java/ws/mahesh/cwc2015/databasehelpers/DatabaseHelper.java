package ws.mahesh.cwc2015.databasehelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by Mahesh on 1/24/2015.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "cwc15.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getPoints() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "team_name", "group1", "MP", "W", "D", "L", "RR", "PT"};
        String sqlTables = "points_table";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getTeams() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "team_id", "team", "captain", "coach", "players"};
        String sqlTables = "teams";
        String orderBy = "team ASC";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, orderBy);

        c.moveToFirst();
        return c;

    }

    public Cursor getVenues() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "venue_id", "stadium", "std_info"};
        String sqlTables = "venue";
        String orderBy = "venue_id ASC";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, orderBy);

        c.moveToFirst();
        return c;

    }

    public Cursor getFixtures() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "match_id", "matchtype", "team1", "team2", " team1_img", "team2_img", "date", "day", "time", "group_id", "stadium", "city", "country", "results", "result_full"};
        String sqlTables = "fixtures";
        String orderBy = "id ASC";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, orderBy);

        c.moveToFirst();
        return c;
    }

    public Cursor getTeamFixtures(String team) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "match_id", "matchtype", "team1", "team2", " team1_img", "team2_img", "date", "day", "time", "group_id", "stadium", "city", "country", "results", "result_full"};
        String sqlTables = "fixtures";
        String orderBy = "id ASC";
        String where = "team1=? OR team2=?";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, where, new String[]{team, team},
                null, null, orderBy);

        c.moveToFirst();
        return c;
    }
}
