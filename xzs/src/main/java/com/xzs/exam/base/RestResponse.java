package com.xzs.exam.base;

/**
 * 封装后端对前端的响应数据
 * @param <T>
 */
public class RestResponse<T> {
    private int code;   // 状态码
    private String message;     // 消息
    private T response;     // 数据

    /**
     * 以 code 和 message 构造新的参数
     * @param code 状态码
     * @param message 信息
     */
    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 以code, message 和 response 构造新的参数
     * @param code     状态码
     * @param message  信息
     * @param response 数据
     */
    public RestResponse(int code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    /**
     * 创建响应对象失败
     * @param code
     * @param msg
     * @return RestResponse
     */
    public static RestResponse fail(Integer code, String msg) {
        return new RestResponse<>(code, msg);
    }

    /**
     * 创建响应对象成功
     * @return RestResponse
     */
    public static RestResponse ok() {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage());
    }
    /**
     * 创建响应对象成功
     * @param <F>
     * @param response
     * @return RestResponse
     */
    public static <F> RestResponse<F> ok(F response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }

    /**
     * 获取响应码
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置响应码
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取消息
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置消息
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取数据
     * @return response
     */
    public T getResponse() {
        return response;
    }

    /**
     * 设置数据
     * @param response
     */
    public void setResponse(T response) {
        this.response = response;
    }
}
