package gl.com.ggmusic.activity;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import gl.com.ggmusic.R;
import gl.com.ggmusic.activity.main.MainDiscoverView;
import gl.com.ggmusic.activity.main.MainFriendsView;
import gl.com.ggmusic.activity.main.MainMusicView;
import gl.com.ggmusic.adapter.CommonUseViewPagerAdapter;
import gl.com.ggmusic.service.PlayMusicService;
import gl.com.ggmusic.widget.BottomMusicView;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 菜单图标
     */
    private ImageView menuImageView;
    /**
     * 发现页图标
     */
    private ImageView discoverImageView;
    /**
     * 我的音乐图标
     */
    private ImageView musicImageView;
    /**
     * 朋友图标
     */
    private ImageView friendsImageView;
    /**
     * 搜索图标
     */
    private ImageView searchImageView;
    /**
     * 首页的ViewPager
     */
    private android.support.v4.view.ViewPager contentViewPager;
    /**
     * 侧滑菜单
     */
    private View menuLayout;
    /**
     * 底部音乐图标
     */
    private BottomMusicView bottomMusicView;


    public MainActivity() {
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {
        this.menuLayout = findViewById(R.id.menuLayout);
        this.contentViewPager = (ViewPager) findViewById(R.id.contentViewPager);
        this.searchImageView = (ImageView) findViewById(R.id.searchImageView);
        this.friendsImageView = (ImageView) findViewById(R.id.friendsImageView);
        this.musicImageView = (ImageView) findViewById(R.id.musicImageView);
        this.discoverImageView = (ImageView) findViewById(R.id.discoverImageView);
        this.menuImageView = (ImageView) findViewById(R.id.menuImageView);

        bottomMusicView = new BottomMusicView();

        Intent service = new Intent(context.getApplicationContext(), PlayMusicService.class);
        context.getApplicationContext().startService(service);


    }


    @Override
    void initView() {

        toolbar.setVisibility(View.GONE);

        bottomMusicView.show(getApplication(),context);

        initViewPager();

    }


    @Override
    void setListener() {
        this.searchImageView.setOnClickListener(this);
        this.friendsImageView.setOnClickListener(this);
        this.musicImageView.setOnClickListener(this);
        this.discoverImageView.setOnClickListener(this);
        this.menuImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.discoverImageView:
                showViewPager(0);
                break;
            case R.id.musicImageView:
                showViewPager(1);
                break;
            case R.id.friendsImageView:
                showViewPager(2);

                EventBus.getDefault().post(BottomMusicView.GONE);
                break;
            case R.id.searchImageView:
                EventBus.getDefault().post(BottomMusicView.VISABLE);
                break;
            default:
                break;
        }
    }

    /**
     * 初始化首页3个ViewPager
     */
    private void initViewPager() {
        List<View> list = new ArrayList<>();
        list.add(new MainDiscoverView(context));
        list.add(new MainMusicView(context));
        list.add(new MainFriendsView(context));
        CommonUseViewPagerAdapter adapter = new CommonUseViewPagerAdapter(list);
        contentViewPager.setAdapter(adapter);
        contentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                showViewPager(position);
            }

            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void showViewPager(int position) {
        contentViewPager.setCurrentItem(position);
        if (position == 0) {
            discoverImageView.setImageResource(R.mipmap.actionbar_discover_selected);
            musicImageView.setImageResource(R.mipmap.actionbar_music_prs);
            friendsImageView.setImageResource(R.mipmap.actionbar_friends_prs);
        } else if (position == 1) {
            discoverImageView.setImageResource(R.mipmap.actionbar_discover_prs);
            musicImageView.setImageResource(R.mipmap.actionbar_music_selected);
            friendsImageView.setImageResource(R.mipmap.actionbar_friends_prs);
        } else if (position == 2) {
            discoverImageView.setImageResource(R.mipmap.actionbar_discover_prs);
            musicImageView.setImageResource(R.mipmap.actionbar_music_prs);
            friendsImageView.setImageResource(R.mipmap.actionbar_friends_selected);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bottomMusicView.remove();
    }

}
