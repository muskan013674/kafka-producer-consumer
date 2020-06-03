package com.example.kfka.demo.Resource;

import com.example.kfka.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class UserResource {

    @Autowired
    private  KafkaTemplate<String, User> kafkaTemplate;

    private static final String Topic = "KafkaExample1";
    @GetMapping("/publish/{name}")
    public String post(@PathVariable ("name") final String name){

        kafkaTemplate.send(Topic,new User(name,"technologY",12000L));

        return "Published Successfully";
    }
}
