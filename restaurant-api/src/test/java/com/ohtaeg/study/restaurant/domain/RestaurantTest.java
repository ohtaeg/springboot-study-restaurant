package com.ohtaeg.study.restaurant.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    private final long id = 1004L;
    private final String name = "ohtaeg";
    private final String address = "Incheon";

    @DisplayName("레스트랑 객체 생성을 성공한다.")
    @Test
    public void create() {
        // when
        Restaurant restaurant = new Restaurant(id, name, address);

        // then
        assertAll(
                () -> assertThat(restaurant.getId()).isEqualTo(id)
                ,() -> assertThat(restaurant.getName()).isEqualTo(name)
                ,() -> assertThat(restaurant.getAddress()).isEqualTo(address)
        );
    }

    @DisplayName("레스토랑 정보인 가게이름과 위치를 갖고올 수 있다.")
    @Test
    public void information() {
        // when
        Restaurant restaurant = new Restaurant(id, name, address);

        // then
        assertThat(restaurant.getInformation()).isEqualTo(name + " / " + address);
    }
}