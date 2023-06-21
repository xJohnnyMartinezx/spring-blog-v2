package com.codeup.springblogv2.controllers;

import com.codeup.springblogv2.repos.WeatherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    @GetMapping("/")
//    @ResponseBody
//    public String home() {
//        return "This is the landing page!";
//    }

    WeatherRepo weatherDao;

    public HomeController(WeatherRepo weatherDao) {
        this.weatherDao = weatherDao;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("weatherList", weatherDao.findAll());

        return "home";
    }



//    Weather Map Controller
//    @GetMapping("/weather")
//    public String showWeather(){
//        return "/weather_map";
//    }
}
