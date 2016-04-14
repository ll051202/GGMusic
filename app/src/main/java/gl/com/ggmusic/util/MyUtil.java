package gl.com.ggmusic.util;

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
}
