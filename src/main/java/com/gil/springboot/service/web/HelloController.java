package com.gil.springboot.service.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * return json about request
 * Before the use this annotation, we did use @ResponseBody that have to write all method.
 */
@RestController
public class HelloController {

    // response about 'GET' request. (@RequestMapping(method=RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
