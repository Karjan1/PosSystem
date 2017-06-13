package com.karoljanowski.pizzeria.controler;

import com.karoljanowski.pizzeria.domain.PizzaIngredient;
import com.karoljanowski.pizzeria.service.PizzaIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by Karol Janowski on 2017-06-12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PizzaIngredientService pizzaIngredientService;

    @RequestMapping(value = "/pizzaIngredients", method = RequestMethod.GET)
    public String pizzaIngredients(Model model){
        List<PizzaIngredient> pizzaIngredientList = pizzaIngredientService.findAll();
        PizzaIngredient pizzaIngredient = new PizzaIngredient();
        model.addAttribute("pizzaIngredientList", pizzaIngredientList);
        model.addAttribute("pizzaIngredient", pizzaIngredient);
        return "pages/pizzaIngredients";
    }

    @RequestMapping(value = "/pizzaIngredients", method = RequestMethod.POST)
    public String pizzaIngredientsPOST(@ModelAttribute("pizzaIngredient") PizzaIngredient pizzaIngredient, Principal principal){
        System.out.println(pizzaIngredient.getName());
        System.out.println(pizzaIngredient.getPriceXLarge());
        pizzaIngredientService.save(pizzaIngredient);
        return "redirect:/";
    }

}





















