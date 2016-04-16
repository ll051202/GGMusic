package gl.com.ggmusic.music;

import android.content.Context;
import android.media.MediaPlayer;

import gl.com.ggmusic.R;

/**
 * Created by guilinlin on 16/4/16 19:07.
 * email 973635949@qq.com<br/>
 * desc：
 */
public class PlayMusicTool implements MediaPlayer.OnCompletionListener {

    public static final int START = 1;
    public static final int PAUSE = 2;
    public static final int STOP = 3;


    private MediaPlayer mediaPlayer;

    public PlayMusicTool(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.test);
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnCompletionListener(this);
    }

    public void start() {
        mediaPlayer.start();
    }

    public void puase(){
        mediaPlayer.pause();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }


}
