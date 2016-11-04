package edu.msc.spring.bootstrap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.msc.spring.bootstrap.About;
import edu.msc.rest.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by marcelo on 10/4/16.
 */

@RestController
@RequestMapping("/info/")
@ApiVersion({1, 2})
public class InfoServices {
    @Autowired
    private About about;

    @RequestMapping(value="/about", method = GET)
           // produces = {"application/cdc.info.about-v1+json"}) //This forces Safari to download the file instead of opening it on the browser.
    @ResponseBody
    public About about() throws JsonProcessingException {
        return about;
    }

    @RequestMapping("/ping")
    public String ping() {
        return "Hello There! I'm alive";
    }



}

