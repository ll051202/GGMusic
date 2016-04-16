package gl.com.ggmusic.bean;

/**
 * Created by guilinlin on 16/4/16 19:26.
 * email 973635949@qq.com<br/>
 *
 * desc：用于传递显示或隐藏首页底部音乐view的Event
 */
public class BottomMusicEvent {


    /**
     * 显示控件
     */
    public static final int GONE = 1;
    /**
     * 隐藏控件
     */
    public static final int VISABLE = 2;

    private int code ;

    public BottomMusicEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
