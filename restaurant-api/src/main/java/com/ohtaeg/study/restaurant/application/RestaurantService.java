package com.ohtaeg.study.restaurant.application;

import com.ohtaeg.study.restaurant.dao.MenuItemRepository;
import com.ohtaeg.study.restaurant.dao.RestaurantRepository;
import com.ohtaeg.study.restaurant.domain.MenuItem;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private MenuItemRepository menuItemRepository;

    public RestaurantService(final RestaurantRepository restaurantRepository, final MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(long id) {
        //TODO null delete
        Restaurant restaurant = restaurantRepository.findById(id)
                                                    .orElseGet(null);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItem(menuItems);
        return restaurant;
    }

    public Restaurant addRestaurant(final Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
