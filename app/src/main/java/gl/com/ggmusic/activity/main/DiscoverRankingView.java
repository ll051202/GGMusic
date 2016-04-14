package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;

/**
 * 排行榜
 * Created by guilinlin on 16/4/13.
 */
public class DiscoverRankingView extends LinearLayout {



    public DiscoverRankingView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_discover_ranking, this, true);
    }
}
