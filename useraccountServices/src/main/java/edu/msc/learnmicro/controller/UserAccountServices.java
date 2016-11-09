package edu.msc.learnmicro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.msc.learnmicro.model.UserAccount;
import edu.msc.learnmicro.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by caldama on 11/4/16.
 */
@RestController
@RequestMapping("/user")
public class UserAccountServices {

    @Autowired
    private UserAccountRepository repository;

    @RequestMapping(value="/", method = GET)
    // produces = {"application/cdc.info.about-v1+json"}) //This forces Safari to download the file instead of opening it on the browser.
    @ResponseBody
    public List<UserAccount> list() throws JsonProcessingException {
        return repository.findAll();
    }

    @RequestMapping(value="/{username}")
    public ResponseEntity<UserAccount> getUserByUsername(@PathVariable String username) {
        UserAccount user = repository.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value="/{username}/login", method = POST)
    public String login(@PathVariable String username, @RequestBody String body) throws Exception {
        if (body == null || body.trim().isEmpty()) {
            throw new Exception("Unable to login. Please provide password");
        }
        return this.getToken();
    }

    @RequestMapping(value="/validateToken", method= POST)
    public boolean validateToken(@RequestBody String token) throws Exception {
        if (token == null || token.trim().isEmpty()) {
            throw new Exception("Token is not Valid");
        }
        return token.equals(getToken());
    }

    private String getToken() {
        return "ABC123";
    }


}
