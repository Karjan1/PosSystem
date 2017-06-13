package com.karoljanowski.pizzeria.service.UserServiceImpl;

import com.karoljanowski.pizzeria.dao.RoleDao;
import com.karoljanowski.pizzeria.domain.security.Role;
import com.karoljanowski.pizzeria.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        return (roleDao.findByName(name));
    }
}
