package com.superbeyone.eshop.inventory.vo;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className Response
 * @description 请求响应
 * @date 2019-03-06 09:56
 **/
public class Response {

    public static final String SUCCESS = "success";

    public static final String FAILURE = "failure";

    private String status;
    private String message;

    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
