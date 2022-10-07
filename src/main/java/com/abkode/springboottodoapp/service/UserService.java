package com.abkode.springboottodoapp.service;


import com.abkode.springboottodoapp.models.User;
import com.abkode.springboottodoapp.request.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationRequest userRegistrationRequest);
}
