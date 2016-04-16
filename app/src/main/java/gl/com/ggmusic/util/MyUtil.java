package gl.com.ggmusic.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by guilinlin on 16/4/14.
 */
public class MyUtil {

    public static void print(Object... objectses) {
        String str = "";
        for (Object o : objectses) {
            str += o + ",";
        }
        System.out.println(str);
    }

    /**
     * 快速显示一个日志
     *
     * @param context
     * @param msg
     */
    public static void T(Context context, Object msg) {
        Toast.makeText(context, msg.toString(), Toast.LENGTH_LONG).show();
    }
}
