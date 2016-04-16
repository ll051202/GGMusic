package gl.com.ggmusic.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import gl.com.ggmusic.R;

public class PlayMusicService extends Service implements MediaPlayer.OnCompletionListener {

    private MusicBinder musicBinder;
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        musicBinder = new MusicBinder();
        System.out.println("onCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.test);
        mediaPlayer.setLooping(true);
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
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    public class MusicBinder extends Binder {

        public PlayMusicService getService() {
            return PlayMusicService.this;
        }

    }

}
