package framework.request;

import framework.callback.StringCallback;
import framework.log.Log;
import okhttp3.*;

import java.io.IOException;

public class MyGetRequest {
    private static final String TAG = MyGetRequest.class.getSimpleName();

    public static void get(String url, StringCallback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        long time = System.currentTimeMillis();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.debug(TAG, "onFailure: ");
                if (callback != null){
                    callback.failure(-1,"网络请求错误 url = "+url);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.debug("网络请求耗时","url = "+url+",time = "+(System.currentTimeMillis() - time));
                if (response == null ||response.body() == null){
                    if (callback != null){
                        callback.failure(-1, "网络请求错误 url = "+url);
                    }
                    return;
                }
                String msg = response.body().string();
                Log.debug(TAG,"onResponse url = "+url+",msg = "+msg);
                if (callback!= null){
                    callback.success(msg);
                }
            }
        });
    }
}
