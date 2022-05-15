package com.cherry.handler;

import com.cherry.entities.User;
import com.cherry.repositories.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UpdateResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
