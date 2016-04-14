package gl.com.ggmusic.activity;


import android.graphics.PixelFormat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gl.com.ggmusic.R;
import gl.com.ggmusic.activity.main.MainDiscoverView;
import gl.com.ggmusic.activity.main.MainFriendsView;
import gl.com.ggmusic.activity.main.MainMusicView;
import gl.com.ggmusic.adapter.CommonUseViewPagerAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ImageView menuImageView;
    private ImageView discoverImageView;
    private ImageView musicImageView;
    private ImageView friendsImageView;
    private ImageView searchImageView;
    private android.support.v4.view.ViewPager contentViewPager;

    public MainActivity() {
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {

        this.contentViewPager = (ViewPager) findViewById(R.id.contentViewPager);
        this.searchImageView = (ImageView) findViewById(R.id.searchImageView);
        this.friendsImageView = (ImageView) findViewById(R.id.friendsImageView);
        this.musicImageView = (ImageView) findViewById(R.id.musicImageView);
        this.discoverImageView = (ImageView) findViewById(R.id.discoverImageView);
        this.menuImageView = (ImageView) findViewById(R.id.menuImageView);

    }


    @Override
    void initView() {

        toolbar.setVisibility(View.GONE);

        initBottomMusicView();

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
            case R.id.searchImageView:
                startActivity(SettingActivity.class);
                break;
            case R.id.discoverImageView:
                showViewPager(0);
                break;
            case R.id.musicImageView:
                showViewPager(1);
                break;
            case R.id.friendsImageView:
                showViewPager(2);
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

    /**
     * 初始化底部音乐悬浮穿
     */
    private void initBottomMusicView() {
        View musicView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_music, null);
        final TextView tv = (TextView) musicView.findViewById(R.id.musicNameTextView);
        //TYPE_TOAST 是关键,这样就不需要悬浮窗权限了
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
        //禁止获得焦点，不然下面的界面无法接收到触摸点击事件  无法接收onBack
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.gravity = Gravity.BOTTOM;

        musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        WindowManager windowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        windowManager.addView(musicView, params);
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


}
