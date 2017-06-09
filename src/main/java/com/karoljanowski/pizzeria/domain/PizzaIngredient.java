package com.karoljanowski.pizzeria.domain;

import javax.persistence.*;

/**
 * Created by Karol Janowski on 2017-06-06.
 */
@Entity
public class PizzaIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INGREDIENT_ID")
    private Long id;
    private String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
