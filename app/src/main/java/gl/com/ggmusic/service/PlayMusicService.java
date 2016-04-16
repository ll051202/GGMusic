package gl.com.ggmusic.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import gl.com.ggmusic.music.PlayMusicTool;
import gl.com.ggmusic.widget.BottomMusicView;

public class PlayMusicService extends Service {

    private MusicBinder musicBinder;
    private PlayMusicTool playMusicTool;

    @Override
    public void onCreate() {
        super.onCreate();
        musicBinder = new MusicBinder();
        playMusicTool = new PlayMusicTool(this);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int tag = intent.getIntExtra(BottomMusicView.TAG_START_MUSIC, -1);
        if (tag == PlayMusicTool.START) {
            playMusicTool.start();
        }else if(tag == PlayMusicTool.PAUSE){
            playMusicTool.puase();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 绑定service的操作
     *
     * @param intent
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBinder;
    }

    /**
     * 绑定Service成功后将当前Service返回，便于进行交互
     */
    public class MusicBinder extends Binder {


        public PlayMusicService getService() {
            return PlayMusicService.this;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
