package com.examples.spring.cloud.security;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceServerController {

    @RequestMapping(value="/hello",method=RequestMethod.POST, produces={"application/JSON"})
    public String getHello(@RequestBody String name) {
        return "Hello "+name;
    }
}
