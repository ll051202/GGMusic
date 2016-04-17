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
    private static Toast toast;

    public static void t(Context context, Object msg) {
        if (toast == null) {
            toast = Toast.makeText
                    (context.getApplicationContext(), msg.toString(), Toast.LENGTH_LONG);
        } else {
            toast.setText(msg.toString());
        }

        toast.show();
    }
}
