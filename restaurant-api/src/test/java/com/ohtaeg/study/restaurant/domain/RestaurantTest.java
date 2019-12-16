package com.ohtaeg.study.restaurant.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

    @DisplayName("레스트랑 객체 생성을 성공한다.")
    @Test
    public void create() {
        // given
        final String name = "ohtaeg";
        final String address = "Incheon";

        // when
        Restaurant restaurant = new Restaurant(name, address);

        // then
        assertAll(
                () -> assertThat(restaurant.getName()).isEqualTo(name)
                ,() -> assertThat(restaurant.getAddress()).isEqualTo(address)
        );
    }

    @DisplayName("레스토랑 정보인 가게이름과 위치를 갖고올 수 있다.")
    @Test
    public void information() {
        // given
        final String name = "ohtaeg";
        final String address = "Incheon";

        // when
        Restaurant restaurant = new Restaurant(name, address);

        // then
        assertThat(restaurant.getInformation()).isEqualTo(name + " in " + address);
    }
}