package com.karoljanowski.pizzeria.service.UserServiceImpl;

import com.karoljanowski.pizzeria.dao.PizzaIngredientDao;
import com.karoljanowski.pizzeria.domain.PizzaIngredient;
import com.karoljanowski.pizzeria.service.PizzaIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
@Service
public class PizzaIngredientServiceImpl implements PizzaIngredientService {
    @Autowired
    private PizzaIngredientDao pizzaIngredientDao;

    @Override
    public PizzaIngredient findByName(String name) {
        return pizzaIngredientDao.findByName(name);
    }

    @Override
    public List<PizzaIngredient> findAll() {
        return pizzaIngredientDao.findAll();
    }

    @Override
    public void save(PizzaIngredient pizzaIngredient) {
        pizzaIngredientDao.save(pizzaIngredient);
    }
}

















