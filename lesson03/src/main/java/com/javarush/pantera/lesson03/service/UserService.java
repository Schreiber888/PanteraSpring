package com.javarush.pantera.lesson03.service;

import com.javarush.pantera.lesson03.entity.User;
import com.javarush.pantera.lesson03.repository.Repo;
import com.javarush.pantera.lesson03.repository.UserRepository;
import com.javarush.pantera.lesson03.validator.Validator;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
@ToString
public class UserService {

    private final Repo userRepository;

    private final List<Validator<User>> validators=new ArrayList<>();

    public void saveAll(List<User> users) {
        validators.forEach(v -> {
            for (User user : users) {
                v.validate(user);
            }
        });

        users.forEach(userRepository::save);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
