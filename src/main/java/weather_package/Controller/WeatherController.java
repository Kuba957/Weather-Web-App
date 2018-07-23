package weather_package.Controller;

import weather_package.Model.Database;
import weather_package.Service.DatabaseService;
import weather_package.Service.YahooService;
import weather_package.web.Pages;
import com.github.fedy2.weather.data.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class WeatherController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private YahooService<Channel> yahooService;

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/forecast/krakow";
    }

    @RequestMapping(value = "/forecast/{city}", method = RequestMethod.GET)
    public String getForecast(Model model, @PathVariable("city") String city) throws Exception {

        Channel yahooResponse = yahooService.getForecast(city);
        model.addAttribute("cityKey", city);
        log.info("Redirecting to " + city + " weather page");
        model.addAttribute("currentWeather", yahooResponse.getItem().getCondition());
        log.info("Getting weather forecast for " + city + ".");
        model.addAttribute("forecasts", yahooResponse.getItem().getForecasts());

        Database weather = new Database();
        weather.setCity(city);
        weather.setTemp_low(yahooResponse.getItem().getForecasts().get(1).getLow());
        weather.setTemp_high(yahooResponse.getItem().getForecasts().get(1).getHigh());
        weather.setDate(yahooResponse.getItem().getForecasts().get(1).getDate().toString());
        databaseService.saveItem(weather);

        return Pages.FORECAST;

    }


    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        return Pages.ERROR;
    }


    @RequestMapping(value="/history",method = RequestMethod.GET)
    public ModelAndView history(){
        ModelAndView view = new ModelAndView();
        List<Database> history = databaseService.getAll();
        view.addObject("history",history);
        view.setViewName("/history");
        log.info("Redirecting to history page");
        return view;
    }
}