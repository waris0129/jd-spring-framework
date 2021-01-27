package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class ResponseWrapper {//describe how the json looks like in reposne body

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }


    public ResponseWrapper(String message) { // delete mapping
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success=true;
    }
}
