package com.newlec.rlandapi.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RlandResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})// 특정 원하는 것만
    // @ExceptionHandler(value = {MyException.class, BBExcetopn.class})
    public ResponseEntity<Object> handlerAnyExcetion(Exception ex, WebRequest request){
        
        return new ResponseEntity<>("handler에서 오류메시지 보내용~", new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); // ex 위치의 데이터로 오류메시지를 보낸다. 

    }

}
