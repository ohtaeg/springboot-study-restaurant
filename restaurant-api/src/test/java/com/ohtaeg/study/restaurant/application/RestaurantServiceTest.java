package com.ohtaeg.study.restaurant.application;

import com.ohtaeg.study.restaurant.dao.MenuItemDao;
import com.ohtaeg.study.restaurant.dao.MenuItemRepository;
import com.ohtaeg.study.restaurant.dao.RestaurantDao;
import com.ohtaeg.study.restaurant.dao.RestaurantRepository;
import com.ohtaeg.study.restaurant.domain.MenuItem;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    private RestaurantService restaurantService;
    private MenuItemRepository menuItemRepository= new MenuItemDao();
    private RestaurantRepository restaurantRepository = new RestaurantDao();

    @BeforeEach
    void setUp() {
        this.restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    @DisplayName("해당 모든 레스토랑을 조회 한다.")
    @Test
    public void getRestaurants() {
        // when
        final List<Restaurant> restaurants = restaurantService.getRestaurants();

        // then
        assertAll(
                () -> assertThat(restaurants).isNotNull()
                ,() -> assertThat(restaurants).hasSize(2)
                ,() -> assertThat(restaurants.get(0)).isNotNull()
                ,() -> assertThat(restaurants.get(0).getId()).isEqualTo(1004L)
                ,() -> assertThat(restaurants.get(1)).isNotNull()
                ,() -> assertThat(restaurants.get(1).getId()).isEqualTo(2004L)
        );
    }

    @DisplayName("해당 id에 맞는 레스토랑을 찾을 수 있다.")
    @Test
    public void getRestaurant() {
        // given
        final long id = 1004L;

        // when
        final Restaurant restaurant = restaurantService.getRestaurant(id);
        final MenuItem menuItem = restaurant.getMenuItems().get(0);

        // then
        assertAll(
                () -> assertThat(restaurant.getId()).isEqualTo(id)
                ,() -> assertThat(restaurant.getMenuItems()).isNotNull()
                ,() -> assertThat(menuItem).isNotNull()
                ,() -> assertThat(menuItem.getName()).isEqualTo("kimchi")
        );

    }
}