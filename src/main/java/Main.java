import bussiness.weather.WeatherApi;

public class Main {
    public static void main(String[] args) {
        WeatherApi weatherApi = new WeatherApi();
        weatherApi.getWeatherWids("1111");
        weatherApi.getWeatherWids("222");

    }
}
