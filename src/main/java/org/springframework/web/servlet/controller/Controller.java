package org.springframework.web.servlet.controller;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class Controller {


    @RequestMapping(value = "/demo/v1/{testId}" , method = RequestMethod.GET)
    public void testDemo(@PathVariable(name="id") String testId){
        System.out.println("testId="+testId);
    }


    @RequestMapping(value = "/invalid.do" , method = RequestMethod.GET)
    public void testInvalid(){
        System.out.println("testInvalid=========");
    }

}
