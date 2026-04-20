package com.javarush.pantera.lesson03;

import com.javarush.pantera.lesson03.config.Config;
import com.javarush.pantera.lesson03.entity.User;
import com.javarush.pantera.lesson03.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppAopDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = List.of(
                User.builder().id(1L).name("admin").email("ok@gmail.com").password("qwertysdfsdf").build(),
                User.builder().id(2L).name("ok").email("ok@gmail.com").password("1fsdfsdfsd").build(),
                User.builder().id(3L).name("superman").email("okokokokok@gmail.com").password("adasfsdfsdfsdf").build(),
                User.builder().id(4L).name("guest").email("okerwer@gmail.com").password("wqw88erty").build()
                );
        userService.saveAll(users);
        User user = userService.getById(3L);
        System.out.println(user);
        userService.getById(666L);
    }
}
