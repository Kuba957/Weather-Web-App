package weather_package.Service;

public interface YahooService<T>{

    public T getForecast(String city) throws Exception;
}
