package com.agilefaqs.spring.microservices.sessionservice.api;

import com.agilefaqs.spring.microservices.sessionservice.client.UserServiceClient;
import com.agilefaqs.spring.microservices.sessionservice.model.Session;
import com.agilefaqs.spring.microservices.sessionservice.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class Api {


    @Autowired
    private UserServiceClient userServiceClient;

    protected Logger logger = Logger.getLogger(Api.class.getName());
    private UserProfile nullProfile = new UserProfile(-1, "unknown", "unnown", "unknown", "null");

    @RequestMapping("/sessions/authenticate")
    public Session authenticate(@RequestParam("email") String email, @RequestParam("token") String token) {
        logger.info(String.format("Sessions.authenticate(%s)", email));
        UserProfile profile = userServiceClient.getProfile(email);
        return profile.getAuthtoken().equals(token) ? new Session(profile) : new Session(nullProfile);
    }
}
