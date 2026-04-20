package com.javarus.pantera.lesson02.service;

import com.javarus.pantera.lesson02.entity.User;
import com.javarus.pantera.lesson02.repository.Repo;
import com.javarus.pantera.lesson02.repository.UserRepository;
import com.javarus.pantera.lesson02.validator.Validator;
import com.javarus.pantera.lesson02.validator.impl.MaxValidator;
import com.javarus.pantera.lesson02.validator.impl.MinValidator;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
@AllArgsConstructor
@ToString
public class UserService {

    private final UserRepository userRepository;

    private final List<Validator<User>> validators=new ArrayList<>();

    private final Repo[] repos;

    private final BeanFactory beanFactory;

    private final ApplicationContext applicationContext;

    private final Map<String,Object> beans;

    public void saveAll(List<User> users) {
        validators.forEach(v -> {
            for (User user : users) {
                v.validate(user);
            }
        });

        users.forEach(userRepository::save);
    }
}
