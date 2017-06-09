package com.karoljanowski.pizzeria.dao;

import com.karoljanowski.pizzeria.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Karol Janowski on 2017-06-06.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findByPhone(String username);
    User findByEmail(String email);
    User findByUsername(String username);
}
