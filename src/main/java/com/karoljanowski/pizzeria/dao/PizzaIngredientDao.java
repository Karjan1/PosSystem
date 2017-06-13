package com.karoljanowski.pizzeria.dao;

import com.karoljanowski.pizzeria.domain.PizzaIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
public interface PizzaIngredientDao extends CrudRepository<PizzaIngredient, Long> {
    PizzaIngredient findByName(String name);
    List<PizzaIngredient> findAll();
}
