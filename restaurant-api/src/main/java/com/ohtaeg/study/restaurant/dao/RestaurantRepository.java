package com.ohtaeg.study.restaurant.dao;

import com.ohtaeg.study.restaurant.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(long id);

    Restaurant save(Restaurant restaurant);
}
