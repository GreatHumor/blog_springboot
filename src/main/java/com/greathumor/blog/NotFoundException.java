package com.greathumor.blog;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 使用ResponseStatus注解使得异常跳转到404.html页面
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // 标识状态码，交给springboot本身去处理，根据状态码跳转到对应页面
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
