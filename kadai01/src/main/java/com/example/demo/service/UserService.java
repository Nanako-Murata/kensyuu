package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void create(UserRequest userRequest) {

        Date now = new Date();

        User user = new User();
        user.setName(userRequest.getName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setCreateDate(now);
        user.setUpdateDate(now);

        userRepository.save(user);
    }

    public void update(UserUpdateRequest uur) {

        User user = findById(uur.getId());

        user.setName(uur.getName());
        user.setAddress(uur.getAddress());
        user.setPhone(uur.getPhone());
        user.setUpdateDate(new Date());

        userRepository.save(user);
    }
    

}