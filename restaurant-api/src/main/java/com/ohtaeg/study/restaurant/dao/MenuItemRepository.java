package com.ohtaeg.study.restaurant.dao;

import com.ohtaeg.study.restaurant.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemRepository extends CrudRepository<MenuItem ,Long> {
    List<MenuItem> findAllByRestaurantId(long id);
}
