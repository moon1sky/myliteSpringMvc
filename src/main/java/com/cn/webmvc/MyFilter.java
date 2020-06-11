package com.cn.webmvc;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "MyFilter",urlPatterns = "/invalid.do")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest; HttpServletResponse httpServletResponse;
        httpServletRequest = (HttpServletRequest)request;
        httpServletResponse = (HttpServletResponse)response;
        new DispatcherServlet(new MvcApplicationContext()).doService(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
