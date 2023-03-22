package com.blog.search.kkul.controller;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            RuntimeException.class , UnsupportedEncodingException.class
    })
    public ResponseEntity<Object> badRequestException(final RuntimeException ex) {
        return new ResponseEntity<>("실행 중 오류가 발생하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> invalidArgumentNotValidException(final MethodArgumentNotValidException ex) {
        String defaultMsg = StringUtils.replaceAll( ex.getMessage().split("default message")[2] , "\\[|\\]", "");
        return new ResponseEntity<>(StringUtils.trimToEmpty(defaultMsg), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex) {
        return new ResponseEntity<>("서버에서 알 수 없는 오류가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
