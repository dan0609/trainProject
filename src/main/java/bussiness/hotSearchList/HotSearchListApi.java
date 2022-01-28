package bussiness.hotSearchList;

import bussiness.hotSearchList.bean.HotSearchList;
import com.google.gson.Gson;
import framework.callback.StringCallback;
import framework.log.Log;
import framework.request.MyGetRequest;

public class HotSearchListApi {
    public static void gethotSearchList(int ageGroupId){
        //声明url，拼接参数
        String url = "http://xxm.ximalaya.com/mobile/album/search/hotSearchList?ageGroupId="+ageGroupId;
        //调用框架层封装好的各种方法
        long time = System.currentTimeMillis();
        MyGetRequest.get(url, new StringCallback() {
            @Override
            public void success(String result) {
                //用Gson对接口返回的内容做解析，传参本身的参数和存储的实体类
                HotSearchList hotSearchList = new Gson().fromJson(result,HotSearchList.class);
                //打印日志
                Log.info("热搜榜", "请求成功"+" 耗时："+(System.currentTimeMillis()-time)+"\n"+result);

            }

            @Override
            public void failure(int errorCode, String msg) {
                Log.info("热搜榜","请求失败");

            }
        });
    }
}
