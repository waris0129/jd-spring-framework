package com.school.entity.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Current {
    private String observation_time;
    private int temperature;
    private int weather_code;
    private List<String> weather_icons;
    private List<String> weather_descriptions;
    private int wind_speed;
    private int wind_degree;
    private String wind_dir;
    private int pressure;
    private int precip;
    private int humidity;
    private int cloudcover;
    private int feelslike;
    private int uv_index;
    private int visibility;
    private String is_day;
}
