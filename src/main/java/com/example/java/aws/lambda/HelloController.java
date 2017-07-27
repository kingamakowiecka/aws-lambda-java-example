package com.example.java.aws.lambda;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.example.java.aws.lambda.model.HelloResponse;

@RestController
@EnableWebMvc
public class HelloController {

    @RequestMapping(path = "/hello/spring", method = RequestMethod.GET)
    public HelloResponse getSpringHello() {
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello from spring");
        return response;
    }
}
