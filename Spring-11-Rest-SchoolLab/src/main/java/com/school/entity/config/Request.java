package com.school.entity.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {

    private String _type;
    private String query;
    private String language;
    private String unit;
}
