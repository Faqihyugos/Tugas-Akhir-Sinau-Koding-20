package com.sinaukoding.faqih.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;
    String message;
    HttpStatus http_status;

    public Response(String message, HttpStatus httpStatus) {
        this.message = message;
        this.http_status = httpStatus;
    }
    public Response( String message, HttpStatus httpStatus,Object object){
        this.message = message;
        this.http_status = httpStatus;
        this.data = object;
    }
}
