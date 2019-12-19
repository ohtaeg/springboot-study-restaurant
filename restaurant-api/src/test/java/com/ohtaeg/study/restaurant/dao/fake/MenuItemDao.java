package com.ohtaeg.study.restaurant.dao.fake;

import com.ohtaeg.study.restaurant.domain.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuItemDao  {//implements MenuItemRepository
    //@Override
    public List<MenuItem> findAllByRestaurantId(final long id) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("kimchi"));
        return menuItems;
    }
}
