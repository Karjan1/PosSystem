package com.karoljanowski.pizzeria.service;

import com.karoljanowski.pizzeria.domain.security.Role;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
public interface RoleService {
    Role findByName(String name);
}
