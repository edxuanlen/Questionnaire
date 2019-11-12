package com.run.config;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Author edxuanlen
 * @PROJECT questionnaire
 * @Date 2019/11/12 下午12:46
 * @Version 1.0
 **/

@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    private static final Logger logger = LoggerFactory.getLogger(ErrorPageConfig.class);

    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage error403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/404");
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage errorProxy = new ErrorPage(HttpStatus.PROXY_AUTHENTICATION_REQUIRED, "/error/404");
        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/404");
        errorPageRegistry.addErrorPages(error403, error404, error500, errorProxy);
    }

}
