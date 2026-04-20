package com.javarush.pantera.lesson03.repository;

import com.javarush.pantera.lesson03.entity.User;

public interface Repo {
    void save(User user);

    User getById(Long id);
}
