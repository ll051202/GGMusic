package gl.com.ggmusic.activity;


import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import gl.com.ggmusic.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ImageView menuImageView;
    private ImageView discoverImageView;
    private ImageView musicImageView;
    private ImageView friendsImageView;
    private ImageView searchImageView;

    public MainActivity() {
        setContentView(R.layout.activity_main);
    }

    @Override
    void init() {

        this.searchImageView = (ImageView) findViewById(R.id.searchImageView);
        this.friendsImageView = (ImageView) findViewById(R.id.friendsImageView);
        this.musicImageView = (ImageView) findViewById(R.id.musicImageView);
        this.discoverImageView = (ImageView) findViewById(R.id.discoverImageView);
        this.menuImageView = (ImageView) findViewById(R.id.menuImageView);


        initBottomMusicView();
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


    @Override
    void initView() {

        toolbar.setVisibility(View.GONE);
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
            case R.id.menuImageView:
                startActivity(SettingActivity.class);
                break;

            default:
                break;
        }
    }
 

}
