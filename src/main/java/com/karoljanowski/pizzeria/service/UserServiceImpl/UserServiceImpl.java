package com.karoljanowski.pizzeria.service.UserServiceImpl;

import com.karoljanowski.pizzeria.dao.RoleDao;
import com.karoljanowski.pizzeria.dao.UserDao;
import com.karoljanowski.pizzeria.domain.User;
import com.karoljanowski.pizzeria.domain.security.UserRole;
import com.karoljanowski.pizzeria.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Karol Janowski on 2017-06-06.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    @Override
    public boolean checkUserExists(String phone, String email, String username) {
        if (checkPhoneExists(phone) || checkEmailExists(email) || checkUsernameExists(username)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        if(findByPhone(phone)!=null){
            return true;
        }
        return false;
    }

    public User createUser(User user, Set<UserRole> userRoles){
        User localUser= userDao.findByUsername(user.getUsername());
        if (localUser!=null){
            LOG.info("Username {} already exists. Nothing will be done", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles){
                roleDao.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            localUser = userDao.save(user);
        }
        return localUser;
    }

    @Override
    public boolean checkEmailExists(String email) {
        if (findByEmail(email)!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        if (findByUsername(username)!=null){
            return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }
}
