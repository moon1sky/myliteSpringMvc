package com.cn.webmvc;


import com.cn.webmvc.adapter.SimpleHandleMappingAdapter;
import com.cn.webmvc.controller.Controller;
import com.cn.webmvc.handler.SimpleHandlerMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {


    private ApplicationContext mvcApplicationContext;

    public DispatcherServlet(ApplicationContext mvcApplicationContext) {
        this.mvcApplicationContext = mvcApplicationContext;
    }


    public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doDispatch(request, response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {

        try {
            HandlerExecutionChain executionChain = getHandle(request);
            Object handler = executionChain.getHandler();

            HandleMappingAdapter handleAdapter = getHandleAdapter(handler);

            ModleAndView modleAndView = handleAdapter.handle(request,response,handler);

            //viewResolver

            response.getWriter().write("");

        } catch (Exception e) {

        }

    }

    private HandleMappingAdapter getHandleAdapter(Object handler) {
        HandleMappingAdapter adapter = (HandleMappingAdapter)mvcApplicationContext.getBean(SimpleHandleMappingAdapter.class);
        if(!adapter.supports(handler)){
            throw new RuntimeException("no adapter support it");
        }
        return adapter;
    }

    private HandlerExecutionChain getHandle(HttpServletRequest request) {
        HandlerMapping handlerMapping = (HandlerMapping)mvcApplicationContext.getBean(SimpleHandlerMapping.class);
        return handlerMapping.getHandler(request);
    }


}
