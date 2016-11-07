package com.mke6.rest.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mke6.rest.model.HelloObject;

@RestController
@RequestMapping("/")
public class HelloWorldController {

  @RequestMapping("/sayHello")
  public HelloObject sayHello() {
    HelloObject hello = new HelloObject();
    hello.setMessage("Hello there!");
    return hello;
  }
}
