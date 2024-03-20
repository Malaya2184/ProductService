package com.spider.productservice.sampleApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hii How are you ?";
    }
    @GetMapping("/{name}/{age}")
    public String sayToMe(@PathVariable("name") String name, @PathVariable("age") int age){
        return "Hi you name is " + name + " and your age is " + age ;
    }
    @GetMapping("/printmulti/{name}/{number}")
    public  String printMultiple(@PathVariable("name") String name, @PathVariable("number") int number){
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stb.append(" hello ").append(name);
        }
        return  stb.toString();
    }

}
