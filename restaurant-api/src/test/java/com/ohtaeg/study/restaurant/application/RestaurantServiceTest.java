package com.ohtaeg.study.restaurant.application;

import com.ohtaeg.study.restaurant.dao.MenuItemRepository;
import com.ohtaeg.study.restaurant.dao.RestaurantRepository;
import com.ohtaeg.study.restaurant.domain.MenuItem;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private MenuItemRepository menuItemRepository; //= new MenuItemDao();

    @Mock
    private RestaurantRepository restaurantRepository; // new RestaurantDao();

    @BeforeEach

    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockRestaurantRepository();
        mockMenuItemRepository();

        this.restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    private void mockRestaurantRepository() {
        final List<Restaurant> restaurants = new ArrayList<>();
        final Restaurant restaurant = new Restaurant(1004L, "ohtaeg", "incheon");
        restaurants.add(restaurant);
        restaurants.add(new Restaurant(2004L, "ohtaeg2", "seoul"));

        given(restaurantRepository.findAll()).willReturn(restaurants);
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));
    }

    private void mockMenuItemRepository() {
        final List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("kimchi"));
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
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
    @DisplayName("가게를 추가할 수 있다.")
    @Test
    public void addRestaurant() {
        // given
        final Restaurant restaurant = new Restaurant("chulsu", "seoul");
        final Restaurant expect = new Restaurant(1234L, "chulsu", "seoul");
        given(restaurantRepository.save(restaurant)).willReturn(expect);

        // when
        final Restaurant actual = restaurantRepository.save(restaurant);

        // then
        assertThat(actual.getId()).isEqualTo(1234L);
    }
}