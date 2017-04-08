package com.agilefaqs.spring.microservices.sessionservice.model;

public class Session {
    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    private UserProfile profile;

    public Session(UserProfile profile) {

        this.profile = profile;
    }

    public Session(){

    }
}
