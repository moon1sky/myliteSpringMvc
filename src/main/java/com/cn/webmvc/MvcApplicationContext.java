package com.cn.webmvc;

import com.cn.webmvc.controller.Controller;
import com.cn.webmvc.handler.SimpleHandlerMapping;

import java.util.LinkedHashMap;
import java.util.Map;

public class MvcApplicationContext implements ApplicationContext{

    private final Map<Class, Object> beanMap = new LinkedHashMap<>();

    MvcApplicationContext() {
        initContext();
    }

    private void initContext() {
        beanMap.put(Controller.class, new Controller());
        beanMap.put(SimpleHandlerMapping.class, new SimpleHandlerMapping());
    }

    @Override
    public Object getBean(Class clazz) {
        if (clazz == null) {
            return null;
        }
        return beanMap.get(clazz);
    }
}
