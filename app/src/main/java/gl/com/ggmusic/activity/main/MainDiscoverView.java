package gl.com.ggmusic.activity.main;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import gl.com.ggmusic.R;
import gl.com.ggmusic.adapter.CommonUseViewPagerAdapter;
import gl.com.ggmusic.widget.HorizontalSideView;

/**
 * 首页的发现页，可以理解一个Activity
 * Created by guilinlin on 16/4/13.
 */
public class MainDiscoverView extends LinearLayout {

    private HorizontalSideView sideView;
    private Context context;
    private ViewPager contentViewPager;

    public MainDiscoverView(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_main_discover, this, true);
        sideView = (HorizontalSideView) findViewById(R.id.sideView);
        contentViewPager = (ViewPager) findViewById(R.id.contentViewPager);

        init();

        setListener();
    }

    private void init() {
        initViewPager();
    }

    /**
     * 初始化viewPager，加入文字的顺序必须和加入view的顺序意义对应
     */
    private void initViewPager() {
        sideView.addText("个性推荐", "歌单", "主播电台", "排行榜");
        List<View> viewList = new ArrayList<>();
        viewList.add(new DiscoverRecommendView(context));
        viewList.add(new DiscoverSongView(context));
        viewList.add(new DiscoverRadioSetView(context));
        viewList.add(new DiscoverRankingView(context));
        contentViewPager.setAdapter(new CommonUseViewPagerAdapter(viewList));
    }

    private void setListener() {
        //viewPager滑动时修改sideView的进度条
        contentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                sideView.setDividerMargin(position+positionOffset);
            }
            public void onPageSelected(int position) {
                sideView.setSelectedTextColor(position);
            }
            public void onPageScrollStateChanged(int state) {
            }
        });

        sideView.setOnItemClickListener(new HorizontalSideView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                contentViewPager.setCurrentItem(position);
            }
        });

    }
}
