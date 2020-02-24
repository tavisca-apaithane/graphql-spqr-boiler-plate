package com.example.demo;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@GraphQLApi
public class UserService {
    @Autowired
    UserRepository userRepository;
    @GraphQLQuery
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GraphQLMutation()
    public User addUser(String firstName, String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
//        List<User> list = new ArrayList();
//        list.add(user);
        return user;
    }

}
