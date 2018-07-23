package weather_package.Service.Impl;

import weather_package.Service.YahooService;
import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.HashMap;

@Service
public class YahooServiceImpl extends YahooWeatherService implements YahooService<Channel> {

    YahooService yahooService;
    private static final HashMap<String, String> woeIds;
    static {


        woeIds = new HashMap<>();
        woeIds.put("sanktpeterburgraion", "2123260");
        woeIds.put("krakow", "502075");
        woeIds.put("moscow", "2122265");
        woeIds.put("sochiraion","2086230");
    }

    public YahooServiceImpl() throws JAXBException {
        super();
    }

    @Override
    public Channel getForecast(String city) throws Exception {
        return getForecast(woeIds.get(city), DegreeUnit.CELSIUS);
    }

}
