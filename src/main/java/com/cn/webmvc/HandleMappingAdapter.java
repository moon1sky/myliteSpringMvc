package com.cn.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandleMappingAdapter {

    boolean supports(Object handle);

    ModleAndView handle(HttpServletRequest request, HttpServletResponse response,Object handle);

}
