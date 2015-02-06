package ws.mahesh.cwc2015.webservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FeedUpdaterService extends Service {
    public FeedUpdaterService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Refreshers(FeedUpdaterService.this).getFeed();
                stopSelf();
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
