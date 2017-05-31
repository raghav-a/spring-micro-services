package com.agilefaqs.spring.microservices.sessionservice.client;

import com.agilefaqs.spring.microservices.sessionservice.model.UserProfile;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;




@FeignClient("user-service-micro")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/profile/{email}")
    UserProfile getProfile(@PathVariable("email") String email);

}
