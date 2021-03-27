package com.haikou.reagent.pojo;


import java.io.Serializable;

/**
 * 响应消息状态码枚举对象
 * @author 章卜
 * @since 2021-03-21
 */

public enum ResultCode implements Serializable {
    /**
     * 调用成功
     */
    SUCCESS(200, "success"),
    /**
     * 响应失败
     */
    FAILED(1001, "响应失败"),
    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(1002, "参数校验失败"),
    /**
     * 未知错误
     */
    ERROR(5000, "未知错误");
    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
