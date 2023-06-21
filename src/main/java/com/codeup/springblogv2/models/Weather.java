package com.codeup.springblogv2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "weather_data")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false)
    private String feelsLike;

    @Column(nullable = false)
    private String windSpeed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Weather(String location, String feelsLike, String windSpeed) {
        this.location = location;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
    }
}
