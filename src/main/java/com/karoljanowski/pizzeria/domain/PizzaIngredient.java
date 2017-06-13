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
    private double priceSmall;
    private double priceMedium;
    private double priceLarge;
    private double priceXLarge;
    private double priceXXLarge;



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

    public double getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(double priceSmall) {
        this.priceSmall = priceSmall;
    }

    public double getPriceMedium() {
        return priceMedium;
    }

    public void setPriceMedium(double priceMedium) {
        this.priceMedium = priceMedium;
    }

    public double getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(double priceLarge) {
        this.priceLarge = priceLarge;
    }

    public double getPriceXLarge() {
        return priceXLarge;
    }

    public void setPriceXLarge(double priceXLarge) {
        this.priceXLarge = priceXLarge;
    }

    public double getPriceXXLarge() {
        return priceXXLarge;
    }

    public void setPriceXXLarge(double priceXXLarge) {
        this.priceXXLarge = priceXXLarge;
    }
}
