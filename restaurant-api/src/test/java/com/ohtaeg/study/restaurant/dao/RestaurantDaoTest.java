package com.ohtaeg.study.restaurant.dao;

import com.ohtaeg.study.restaurant.dao.fake.RestaurantDao;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantDaoTest {

    @DisplayName("가게를 저장할 수 있다.")
    @Test
    void save() {
//        RestaurantRepository restaurantRepository = new RestaurantDao();
//
//        int oldCount = restaurantRepository.findAll().size();
//        final Restaurant actual = restaurantRepository.save(new Restaurant("chulsu", "seoul"));
//        int newCount = restaurantRepository.findAll().size();
//
//        assertThat(actual.getId()).isEqualTo(1234L);
//        assertThat(newCount - oldCount).isOne();
    }
}