package gl.com.ggmusic.network;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by guilinlin on 16/4/16 22:50.
 * email 973635949@qq.com<br/>
 * desc：网络请求库
 */
public class GGHttp {

    private String url = "";

    public GGHttp(String url) {
        this.url = url;
    }

    public void send(Action1<HttpResponse> action1) {
        send().subscribe(action1);
    }

    public Observable<HttpResponse> send() {
        return Observable
                .just(url)
                .observeOn(Schedulers.io())
                .map(new Func1<String, HttpResponse>() {
                    @Override
                    public HttpResponse call(String s) {
                        HttpResponse httpResponse = new HttpResponse();
                        getHttpResponse(s, httpResponse);
                        return httpResponse;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }


    private void getHttpResponse(String s, HttpResponse httpResponse) {
        try {

            URL url = new URL(s);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(4000);
            connection.setRequestMethod("POST");
            connection.connect();

            httpResponse.setResponseCode(connection.getResponseCode());
            httpResponse.setResponseMessage(connection.getResponseMessage());
            if (httpResponse.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                httpResponse.setResponseContent(Util.inputSteamToString(is));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
