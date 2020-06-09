package com.cn.webmvc.handler;

import com.cn.webmvc.HandlerMapping;
import com.cn.webmvc.controller.Controller;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleHandlerMapping implements HandlerMapping {

    private final Map<String, Object> handlerMap = new LinkedHashMap<>();

    public SimpleHandlerMapping() {
        initMapping();
    }

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request){
        Object handle = handlerMap.get(request.getRequestURI());
        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain(handle);
        return handlerExecutionChain;
    }

    private void initMapping() {
        Controller controller = new Controller();
        RequestMapping mappingAnnotation = controller.getClass().getAnnotation(RequestMapping.class);
        if (mappingAnnotation == null) {
            throw new RuntimeException("No RequestMapping Annotation");
        }
        String controllerPath = mappingAnnotation.value()[0];
        if (!controllerPath.startsWith("/")) {
            controllerPath = "/" + controllerPath;
        }

        Method[] declaredMethods = Controller.class.getDeclaredMethods();
        if (declaredMethods == null) {
            return;
        }
        for (Method method : declaredMethods) {
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            String methodPath = methodAnnotation.value()[0];
            if (methodPath.startsWith("/")) {
                methodPath = methodPath.substring(0);
            }
            handlerMap.put(controllerPath + methodPath, controller);
        }

    }
}
