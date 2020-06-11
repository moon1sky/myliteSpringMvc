package com.cn.webmvc.adapter;

import com.cn.webmvc.ApplicationContext;
import com.cn.webmvc.HandleMappingAdapter;
import com.cn.webmvc.ModleAndView;
import com.cn.webmvc.controller.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SimpleHandleMappingAdapter implements HandleMappingAdapter {

    private final Map<String, Object> methodMap = new LinkedHashMap<>();

    public SimpleHandleMappingAdapter() {
        initMapping();
    }

    @Override
    public boolean supports(Object handle) {
        final Annotation annotation = handle.getClass().getAnnotation(RestController.class);
        return annotation != null;
    }

    @Override
    public ModleAndView handle(HttpServletRequest request, HttpServletResponse response, Object handle) {
        String requestURI = request.getRequestURI();
        Method method = (Method) methodMap.get(requestURI);


        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap!=null){

        }
        //TODO

        Object modleAndView=null;
        try {
            if(parameterMap!=null && !parameterMap.isEmpty()){
                modleAndView = method.invoke(handle,parameterMap);
            }else{
                modleAndView = method.invoke(handle);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return modleAndView == null ? null : (ModleAndView) modleAndView;
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
                methodPath = methodPath.substring(1);
            }
            methodMap.put(controllerPath + methodPath, method);
        }
    }
}
