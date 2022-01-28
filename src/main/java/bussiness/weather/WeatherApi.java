package bussiness.weather;

import framework.callback.StringCallback;
import com.google.gson.Gson;
import framework.log.Log;
import framework.request.MyGetRequest;
import bussiness.weather.bean.WeatherWids;

public class WeatherApi {
    //获取天气种类
    public void getWeatherWids(String key){
        String url = "http://apis.juhe.cn/simpleWeather/wids"+"?key="+key;
        MyGetRequest.get(url, new StringCallback() {
            @Override
            public void success(String result) {
                WeatherWids weatherWids = new Gson().fromJson(result, WeatherWids.class);
                if (weatherWids.getError_code() == 0){
                    Log.info("天气","reason: "+weatherWids.getReason());
                    for (int i = 0; i < weatherWids.getResult().size(); i++){
                        Log.info(" 天气" , "种类wid"+weatherWids.getResult().get(i).getWid()+","+weatherWids.getResult().get(i).getWeather());
                        if ("14".equals(weatherWids.getResult().get(i).getWid())){
                            if ("大雪".equals(weatherWids.getResult().get(i).getWeather())){

                            }else {
                                throw new RuntimeException("14的时候不是大雪！！！");
                            }
                        }
                    }

                }
            }

            @Override
            public void failure(int errorCode, String msg) {
                Log.info("天气","url :" +url +" errorCode " + errorCode + " msg:"+ msg);

            }
        });
    }

    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
    }
}
