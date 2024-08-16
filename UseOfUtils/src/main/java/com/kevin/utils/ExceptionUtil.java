package com.kevin.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class ExceptionUtil {

    /**
     * 捕获所有异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex){
        log.error("异常信息：{}", ex.getMessage());
        return ex.getMessage();
    }
    /**
     * 捕获sql异常
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error("异常信息：{}", ex.getMessage());
        String message = ex.getMessage();
        return ex.getMessage();
    }
}
