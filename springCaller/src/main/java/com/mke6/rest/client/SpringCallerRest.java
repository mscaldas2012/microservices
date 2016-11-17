package com.mke6.rest.client;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mke6.rest.client.model.HelloObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SpringCallerRest {
	@Autowired
	private HelloWorldController controller;

	@RequestMapping("/getMessage")
	@HystrixCommand(fallbackMethod="backupMessage")
	public HelloObject getMessage() {
		return controller.sayHello();
	}

	public HelloObject backupMessage() {
		HelloObject hello = new HelloObject();
		hello.setMessage("I'm not here");
		return hello;
	}

	@FeignClient("hello-world")
	interface HelloWorldController {
		@RequestMapping(value="/sayHello",method=GET)
		HelloObject sayHello();
	}
}
