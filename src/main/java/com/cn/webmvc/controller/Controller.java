package com.cn.webmvc.controller;


import com.cn.webmvc.ModleAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {


    @RequestMapping(value = "/demo/v1/{testId}" , method = RequestMethod.GET)
    public ModleAndView testDemo(@PathVariable(name="id") String testId){
        System.out.println("testId="+testId);
        return new ModleAndView();
    }


    @RequestMapping(value = "/invalid.do" , method = RequestMethod.GET)
    public void testInvalid(){
        System.out.println("testInvalid=========");
    }

}
