package com.ohtaeg.study.restaurant.dao;

import com.ohtaeg.study.restaurant.domain.MenuItem;

import java.util.List;

public interface MenuItemRepository {

    List<MenuItem> findAllByRestaurantId(long id);
}
