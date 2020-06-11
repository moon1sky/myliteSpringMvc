package com.cn.webmvc;


import com.cn.webmvc.adapter.SimpleHandleMappingAdapter;
import com.cn.webmvc.controller.Controller;
import com.cn.webmvc.handler.SimpleHandlerMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DispatcherServlet extends HttpServlet {


    private ApplicationContext mvcApplicationContext;

    public DispatcherServlet(ApplicationContext mvcApplicationContext) {
        this.mvcApplicationContext = mvcApplicationContext;
    }


    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatch(request, response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {

        try {
            HandlerExecutionChain executionChain = getHandle(request);
            Object handler = executionChain.getHandler();

            HandleMappingAdapter handleAdapter = getHandleAdapter(handler);

            ModleAndView modleAndView = handleAdapter.handle(request, response, handler);


            //viewResolver
            String result = getViewResolver();
            response.getWriter().write(result);

        } catch (Exception e) {
            System.out.println("exception::::" + e);
        }

    }

    private String getViewResolver() throws IOException {
        //TODO
        String file = "page/overview.page";
        StringBuffer sb = new StringBuffer();
        try(InputStream in = ClassLoader.getSystemResourceAsStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(in)) ){
            String s;
            while ( (s=br.readLine())!=null && s.length() != 0) {
                sb.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private HandleMappingAdapter getHandleAdapter(Object handler) {
        HandleMappingAdapter adapter = (HandleMappingAdapter) mvcApplicationContext.getBean(SimpleHandleMappingAdapter.class);
        if (!adapter.supports(handler)) {
            throw new RuntimeException("no adapter support it");
        }
        return adapter;
    }

    private HandlerExecutionChain getHandle(HttpServletRequest request) {
        HandlerMapping handlerMapping = (HandlerMapping) mvcApplicationContext.getBean(SimpleHandlerMapping.class);
        return handlerMapping.getHandler(request);
    }


}
