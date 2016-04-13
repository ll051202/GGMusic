package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;

/**
 * Created by guilinlin on 16/4/13.
 */
public class MainMusicView extends LinearLayout {

    public MainMusicView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_main_music,this,true);
    }
}
