package com.hzhiping.response;

import lombok.Data;

/**
 * @author hzhiping
 * @date 2023/01/31
 */
@Data
public class CommonResult<T> {
    private String success;
    private String code;
    private String msg;
    private T data;

    /**
     * 操作成功
     *
     * @param msg  消息
     * @param data 泛型对象
     * @return {@link CommonResult}<{@link T}>
     */
    public static <T> CommonResult<T> success(String msg, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = "200";
        result.success = "true";
        result.msg = msg;
        result.data = data;
        return result;
    }

    /**
     * 操作失败，异常传递
     *
     * @param code 异常代码
     * @param msg  异常消息
     * @return {@link CommonResult}<{@link T}>
     */
    public static <T> CommonResult<T> failed(String code, String msg) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.success = "false";
        result.msg = msg;
        result.data = null;
        return result;
    }


}