package com.best0167.lol.lolcustomrecord.exception;

import com.best0167.lol.lolcustomrecord.web.dto.LCustomErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.best0167.lol.lolcustomrecord.exception.LCustomErrorCode.INTERNAL_SERVER_ERROR;
import static com.best0167.lol.lolcustomrecord.exception.LCustomErrorCode.INVALID_REQUEST;

@Slf4j
@RestControllerAdvice
public class LCustomExceptionHandler {

    @ExceptionHandler(LCustomException.class)
    public LCustomErrorResponse handleException(
            LCustomException e,
            HttpServletRequest request) {
        log.error("errorCode: {} url: {}, message: {}",
                e.getLCustomErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return LCustomErrorResponse.builder()
                .errorCode(e.getLCustomErrorCode())
                .errorMessage(e.getDetailMessage())
                .build();

    }

    @ExceptionHandler(value = {
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class
    })
    public LCustomErrorResponse handleBadRequest(
            Exception e, HttpServletRequest request
    ) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return LCustomErrorResponse.builder()
                .errorCode(INVALID_REQUEST)
                .errorMessage(INVALID_REQUEST.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public LCustomErrorResponse handleException (
            Exception e, HttpServletRequest request
    ) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return LCustomErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR)
                .errorMessage(INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
