package com.agilefaqs.spring.microservices.userservice.api;

import com.agilefaqs.spring.microservices.userservice.model.UserProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class Api {

    private List<UserProfile> profiles;

    protected Logger logger = Logger.getLogger(Api.class.getName());

    public Api() {
        profiles = new ArrayList<>();
        profiles.add(new UserProfile(1,"joseph", "harnet","email1@abc", "authtoken1"));
        profiles.add(new UserProfile(2,"joshua", "waugh","email2@abc", "authtoken2"));
        profiles.add(new UserProfile(3,"josh", "harper","email3@abc", "authtoken3"));
        profiles.add(new UserProfile(4,"raju", "srivastava","email4@abc", "authtoken4"));
        profiles.add(new UserProfile(5,"pappu", "yadav","email5@abc", "authtoken5"));
        profiles.add(new UserProfile(6,"swami", "nathan","email6@abc", "authtoken6"));
    }

    @RequestMapping("/users/{id}")
    public UserProfile findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Users.findByNumber(%s)", id));
        return profiles.stream().filter(it -> it.getId() == id).findFirst().get();
    }

    @RequestMapping("/users/profile/{email}")
    public UserProfile findByEmail(@PathVariable("email") String email) {
        logger.info(String.format("Users.findByEmail(%s)", email));
        return profiles.stream().filter(it -> it.getEmail().equals(email)).findFirst().get();
    }


    @RequestMapping("/users")
    public List<UserProfile> findAll() {
        logger.info("Users.findAll()");
        return profiles;
    }

}
