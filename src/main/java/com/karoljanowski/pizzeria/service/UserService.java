package com.karoljanowski.pizzeria.service;

import com.karoljanowski.pizzeria.domain.User;
import com.karoljanowski.pizzeria.domain.security.UserRole;

import java.util.Set;

/**
 * Created by Karol Janowski on 2017-06-06.
 */
public interface UserService {
    User findByPhone(String phone);
    User findByEmail(String email);
    User findByUsername(String username);
    boolean checkUserExists(String phone, String email, String username);
    boolean checkPhoneExists(String phone);
    boolean checkEmailExists(String email);
    boolean checkUsernameExists(String username);
    void save(User user);
    User createUser(User user, Set<UserRole> userRoles);


}
