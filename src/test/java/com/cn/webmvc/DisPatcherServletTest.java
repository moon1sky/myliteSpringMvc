package com.cn.webmvc;

import com.cn.webmvc.mock.MockHttpServletRequest;
import com.cn.webmvc.mock.MockHttpServletResponse;
import org.junit.Before;
import org.junit.Test;

public class DisPatcherServletTest {


    private ApplicationContext applicationContext;
    private DispatcherServlet dispatcherServlet;

    @Before
    public void setUp(){
        this.applicationContext = new MvcApplicationContext();
        dispatcherServlet = new DispatcherServlet(applicationContext);
    }


    @Test
    public void doInvalid(){
        System.out.println("doInvalid start");
        MockHttpServletRequest request = new MockHttpServletRequest(null,"/invalid.do");
        MockHttpServletResponse response = new MockHttpServletResponse();
        dispatcherServlet.doService(request,response);
        System.out.println("doInvalid end");

    }


}
