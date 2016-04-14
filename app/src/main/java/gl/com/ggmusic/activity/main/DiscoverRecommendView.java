package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;

/**
 * 个性推荐
 * Created by guilinlin on 16/4/13.
 */
public class DiscoverRecommendView extends LinearLayout {



    public DiscoverRecommendView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_discover_recommend, this, true);
    }
}
