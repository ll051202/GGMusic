package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;

/**
 * 主播电台
 * Created by guilinlin on 16/4/13.
 */
public class DiscoverRadioSetView extends LinearLayout {



    public DiscoverRadioSetView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_discover_radio_set, this, true);
    }
}
