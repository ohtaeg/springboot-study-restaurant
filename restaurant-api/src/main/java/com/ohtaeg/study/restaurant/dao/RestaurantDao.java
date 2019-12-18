package com.ohtaeg.study.restaurant.dao;

import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantDao() {
        restaurants.add(new Restaurant(1004L, "ohtaeg", "incheon"));
        restaurants.add(new Restaurant(2004L, "ohtaeg2", "seoul"));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(final long id) {
        Restaurant restaurant = restaurants.stream()
                                           .filter(r -> r.getId() == id)
                                           .findFirst()
                                           .orElseGet(null);
        return restaurant;
    }

    @Override
    public Restaurant save(final Restaurant restaurant) {
        Restaurant create = new Restaurant(1234L, restaurant.getName(), restaurant.getAddress());
        restaurants.add(create);
        return create;
    }
}
