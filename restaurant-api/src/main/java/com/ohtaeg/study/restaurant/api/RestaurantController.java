package com.ohtaeg.study.restaurant.api;

import com.ohtaeg.study.restaurant.application.RestaurantService;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }
}
