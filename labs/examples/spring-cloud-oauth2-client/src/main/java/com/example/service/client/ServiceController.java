package com.example.service.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;


@RestController
@Configuration
public class ServiceController {

@Autowired
public RestOperations template;
	
    @RequestMapping(value="/test",method=RequestMethod.POST, produces={"application/JSON"}, consumes={"text/plain"})
    public String getShipmentDetails(@RequestParam(value="name", defaultValue="0") String name) {
        ResponseEntity<String> result = template.postForEntity("http://localhost:9081/hello",name,String.class);
        return result.getBody();
    }  
    
    @RequestMapping(value="/greetings",method=RequestMethod.GET, produces={"application/JSON"})
    public String getGreetings() {
        ResponseEntity<String> result = template.postForEntity("http://localhost:9081/greetings",null, String.class);
        return result.getBody();
    }      

}
