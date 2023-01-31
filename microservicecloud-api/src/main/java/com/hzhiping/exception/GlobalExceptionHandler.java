package com.hzhiping.exception;

import com.hzhiping.response.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hzhiping
 * @date 2023/01/13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MyException.class)
    public CommonResult exceptionHandler(MyException e) {
        return CommonResult.failed(e.getErrorCode(), e.getErrorMsg());
    }
}