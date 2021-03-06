package com.inzamamul.security.service.security;

import com.inzamamul.security.entity.User;
import com.inzamamul.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        System.out.println(userName);
        Optional<User> user = userRepository.findByUsername(userName);
        return UserPrinciple.build(user);
    }

}
