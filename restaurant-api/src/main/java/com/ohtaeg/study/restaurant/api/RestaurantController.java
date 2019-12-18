package com.ohtaeg.study.restaurant.api;

import com.ohtaeg.study.restaurant.application.RestaurantService;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/restaurant")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        final String name = resource.getName();
        final String address = resource.getAddress();
        final Restaurant restaurant = new Restaurant(1234L, name, address);
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurant/" + restaurant.getId());
        return ResponseEntity.created(location)
                             .body("{}");
    }
}
