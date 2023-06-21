package com.codeup.springblogv2.repos;

import com.codeup.springblogv2.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, Long> {
}
