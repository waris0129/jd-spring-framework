package com.school.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper {


    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(Object data) {
        this.code = HttpStatus.OK.value();
        this.success = true;
        this.data = data;

    }

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
        this.data = data;

    }


    public ResponseWrapper(String message) { // delete mapping
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success=true;
    }
}
