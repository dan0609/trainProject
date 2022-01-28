package bussiness.live.bean;

import bussiness.weather.bean.WeatherWids;

import java.util.List;

public class TodayOnhistory {
    //接口的实体类
    private String reason;
    private int error_code;
    private List<Result> result;

    public String getReason() {
        return reason;
    }

    public int getError_code() {
        return error_code;
    }

    public List<Result> getResult() {
        return result;
    }

    //定义一个result类
    public static class Result{
        private String day;
        private String date;
        private int e_id;
        private String title;

        //command n 选Getter一键生成
        public String getDay() {
            return day;
        }

        public String getDate() {
            return date;
        }

        public int getE_id() {
            return e_id;
        }

        public String getTitle() {
            return title;
        }
    }
}
