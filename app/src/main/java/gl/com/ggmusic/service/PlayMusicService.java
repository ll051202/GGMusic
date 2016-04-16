package gl.com.ggmusic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import gl.com.ggmusic.R;

/**
 * Created by guilinlin on 16/4/16.
 */
public class PlayMusicService extends Service {

    public static final String ACTION_NAME = "gl.com.ggmusic.service.PlayMusicService";
    private MusicBinder musicBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        musicBinder = new MusicBinder();
        System.out.println("onCreate");
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.test);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("onBind");
        return musicBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    public class MusicBinder extends Binder {

        public PlayMusicService getService() {
            return PlayMusicService.this;
        }

    }

}
