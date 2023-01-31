package com.hzhiping.exception;

/**
 * 自定义异常枚举类
 *
 * @author hzhiping
 * @date 2023/01/13
 */
@SuppressWarnings("ALL")
public enum MyExceptionEnum implements MyExceptionInterface {
    NULL_EXCEPTION("500001", "空指针异常");

    private String code;
    private String msg;

    MyExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}