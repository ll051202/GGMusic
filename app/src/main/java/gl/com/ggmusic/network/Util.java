package gl.com.ggmusic.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by guilinlin on 16/4/17 10:45.
 * desc:
 */
public class Util {

    public static String inputSteamToString(InputStream is) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int len = 0;
            byte buffer[] = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            is.close();
            os.close();
            return new String(os.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "InputSteamToString err:IOException";
        }
    }
}
