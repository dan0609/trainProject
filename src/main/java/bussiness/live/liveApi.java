package bussiness.live;

import bussiness.live.bean.TodayOnhistory;
import com.google.gson.Gson;
import framework.callback.StringCallback;
import framework.log.Log;
import framework.request.MyGetRequest;

public class liveApi {
    //写方法
    public void gettodayOnhistory(String key,String date){
        //声明url，拼接参数
        String url = "http://v.juhe.cn/todayOnhistory/queryEvent.php?key="+key+"&date="+date;
        //调用框架层封装好的各种方法
        MyGetRequest.get(url, new StringCallback() {
            @Override
            public void success(String result) {
                //用Gson对接口返回的内容做解析，传参本身的参数和存储的实体类
                TodayOnhistory todayOnhistory = new Gson().fromJson(result,TodayOnhistory.class);
                if (todayOnhistory.getError_code() == 0){
                    Log.info("今日天气","reason"+todayOnhistory.getReason());
                }


            }

            @Override
            public void failure(int errorCode, String msg) {

            }
        });
    }
}
