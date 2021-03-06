package ws.mahesh.cwc2015.models;

/**
 * Created by Mahesh on 2/2/2015.
 */
public class NewsFeed {
    private int id;
    private String title;
    private String description;
    private String timestamp;

    public NewsFeed(int id, String title, String description, String timestamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
