package gl.com.ggmusic.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import gl.com.ggmusic.R;
import gl.com.ggmusic.util.MyUtil;

/**
 * Created by guilinlin on 16/4/15.
 */
public class BottomMusicView {

    public static final int GONE = 1;
    public static final int VISABLE = 2;

    private View bottomMusicView;
    private Application application;

    private Animation alphaInAnimation;
    private Animation alphaOutAnimation;


    /**
     * 初始化底部音乐悬浮穿
     */
    public void show(Application application, final Context context) {
        this.application = application;
        alphaInAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_0_1_300);
        alphaOutAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_1_0_300);
        EventBus.getDefault().register(this);//注册Eventbus

        bottomMusicView = LayoutInflater.from(context).inflate(R.layout.layout_bottom_music, null);
        final TextView tv = (TextView) bottomMusicView.findViewById(R.id.musicNameTextView);
        //TYPE_TOAST 是关键,这样就不需要悬浮窗权限了
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
        //禁止获得焦点，不然下面的界面无法接收到触摸点击事件  无法接收onBack
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.gravity = Gravity.BOTTOM;

        bottomMusicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUtil.T(context,"11");
            }
        });
        WindowManager windowManager = (WindowManager) application.getSystemService(Application.WINDOW_SERVICE);
        windowManager.addView(bottomMusicView, params);

    }

    @Subscribe
    public void onEventMainThrad(Object object) {
        int code = (int) object;
        switch (code) {
            case GONE:
                bottomMusicView.animate().alpha(0).setDuration(500).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        bottomMusicView.setVisibility(View.GONE);
                    }
                });
//                bottomMusicView.startAnimation(alphaOutAnimation);
                break;
            case VISABLE:
                bottomMusicView.animate().alpha(1).setDuration(500).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        bottomMusicView.setVisibility(View.VISIBLE);
                    }
                });
//                bottomMusicView.startAnimation(alphaInAnimation);
                break;
            default:
                break;
        }
    }

    /**
     * 移除
     */
    public void remove() {
        WindowManager windowManager = (WindowManager) application.getSystemService(Application.WINDOW_SERVICE);
        windowManager.removeView(bottomMusicView);
    }

}
