package gl.com.ggmusic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import gl.com.ggmusic.R;

/**
 * Created by guilinlin on 16/4/16 22:40.
 * email 973635949@qq.com<br/>
 * desc：主页的侧滑菜单布局
 */
public class MainSideMeunView extends LinearLayout{

    public MainSideMeunView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_main_side_menu,this,true);
    }

}
