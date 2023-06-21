package com.codeup.springblogv2.controllers;

import com.codeup.springblogv2.models.Post;
import com.codeup.springblogv2.models.User;
import com.codeup.springblogv2.models.Weather;
import com.codeup.springblogv2.repos.UserRepository;
import com.codeup.springblogv2.repos.WeatherRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    UserRepository userDao;
    WeatherRepo weatherDao;

    public WeatherController(UserRepository userDao, WeatherRepo weatherDao) {
        this.userDao = userDao;
        this.weatherDao = weatherDao;
    }


    @GetMapping("/weather-submit")
    public String weatherSubmitForm(Model model){
        model.addAttribute("weatherData", new Weather());
        return "weather_map";
    }


    @PostMapping("/weather-submit")
    public String submitWeatherInfo(@RequestParam String location, @RequestParam String feelsLike, @RequestParam String windSpeed){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Weather newWeatherData = new Weather(location, feelsLike, windSpeed);
        newWeatherData.setUser(user);
        weatherDao.save(newWeatherData);

        return "redirect:/";
    }

}
