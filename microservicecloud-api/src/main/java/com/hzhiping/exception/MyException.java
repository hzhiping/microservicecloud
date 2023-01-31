package com.hzhiping.exception;

import lombok.Data;

/**
 * @author hzhiping
 * @date 2023/01/13
 */
@Data
@SuppressWarnings("ALL")
public class MyException extends RuntimeException {
    private String errorMsg;
    private String errorCode = "500";

    public MyException() {
        super();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(MyExceptionInterface error, Throwable e) {
        super(error.getErrorCode(), e);
        this.errorCode = error.getErrorCode();
        this.errorMsg = error.getErrorMsg();
    }

    public MyException(String errorMsg, Throwable e) {
        super(errorMsg, e);
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(MyExceptionEnum ex) {
        super(ex.getErrorMsg());
        this.errorCode = ex.getErrorCode();
        this.errorMsg = ex.getErrorMsg();
    }

    public MyException(MyExceptionEnum ex, Object... params) {
        super(String.format(ex.getErrorMsg(), params));
        this.errorCode = ex.getErrorCode();
        this.errorMsg = String.format(ex.getErrorMsg(), params);
    }

    public MyException(MyExceptionEnum ex, Throwable e, Object... params) {
        super(String.format(ex.getErrorMsg(), params), e);
        this.errorCode = ex.getErrorCode();
        this.errorMsg = String.format(ex.getErrorMsg(), params);
    }

    public MyException(String errorCode, String errorMsg, Throwable ex) {
        super(errorMsg, ex);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}