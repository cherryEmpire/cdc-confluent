package com.cherry.handler;

import com.cherry.entities.User;
import com.cherry.repositories.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchUser(String key) {
        return userRepository.searchUser(key);
    }
}
