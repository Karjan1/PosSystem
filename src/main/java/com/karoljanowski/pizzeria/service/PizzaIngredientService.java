package com.karoljanowski.pizzeria.service;

import com.karoljanowski.pizzeria.domain.PizzaIngredient;

import java.util.List;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
public interface PizzaIngredientService {
    PizzaIngredient findByName(String name);
    List<PizzaIngredient> findAll();
    void save(PizzaIngredient pizzaIngredient);
}
