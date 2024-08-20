package com.shivam.fistspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//This controller will be containing HTTPs request
@RestController

//localhost:8080/sample
//All the 8080/sample endpoint should come to this controller
@RequestMapping("/sample")
public class SampleController {

    //localhost:8080/sample/sayHello
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return " Hello "+name;
    }
    @GetMapping("/saybye")
    public String sayBye(){
        return "Bye Everyone";
    }
}
