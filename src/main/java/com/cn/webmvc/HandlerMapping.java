package com.cn.webmvc;

import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.http.HttpServletRequest;

public interface HandlerMapping {

    HandlerExecutionChain getHandler(HttpServletRequest request);
}
