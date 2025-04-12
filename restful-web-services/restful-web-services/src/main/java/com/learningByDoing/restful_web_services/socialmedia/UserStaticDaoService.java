package com.learningByDoing.restful_web_services.socialmedia;

import com.learningByDoing.restful_web_services.socialmedia.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserStaticDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;
    static {
        users.add((new User(++usersCount, "Adam1", LocalDate.now().minusYears(30))));
        users.add((new User(++usersCount, "Adam2", LocalDate.now().minusYears(25))));
        users.add((new User(++usersCount, "Adam33", LocalDate.now().minusYears(20))));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}

