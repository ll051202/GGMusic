package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;
import gl.com.ggmusic.widget.HorizontalSideView;

/**
 * Created by guilinlin on 16/4/13.
 */
public class MainDiscoverView extends LinearLayout {

    private HorizontalSideView sideView;

    public MainDiscoverView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_main_discover, this, true);
        sideView = (HorizontalSideView) findViewById(R.id.sideView);

        sideView.addText("个性推荐", "歌单", "主播电台", "排行榜");

    }
}
