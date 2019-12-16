package com.ohtaeg.study.restaurant.api;

import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "ohtaeg", "incheon");
        restaurants.add(restaurant);
        return restaurants;
    }
}
