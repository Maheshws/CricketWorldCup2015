package ws.mahesh.cwc2015.models;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Mahesh
 */
@Entity
public class SimpleScore implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Key key;
    @Transient
    private int id;
    private String simple;
    private String detail;
    private long timestamp;

    public SimpleScore(String simple, String detail, int id) {
        super();
        this.simple = simple;
        this.detail = detail;
        this.id = id;
        this.timestamp = System.currentTimeMillis();
        this.key = KeyFactory.createKey(SimpleScore.class.getSimpleName(), id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SimpleScore [id=" + id + ", simple=" + simple + ", detail="
                + detail + ", timestamp=" + timestamp + "]";
    }


}
