package com.ohtaeg.study.restaurant.api;

import com.ohtaeg.study.restaurant.application.RestaurantService;
import com.ohtaeg.study.restaurant.domain.MenuItem;
import com.ohtaeg.study.restaurant.domain.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    private final String URL = "/restaurant";

    @DisplayName("기본 url 호출을 성공한다.")
    @Test
    public void hello() throws Exception {
        mvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(content().contentType("text/plain;charset=UTF-8"))
           .andExpect(content().string("hello"))
           .andDo(print())
        ;
    }

    @DisplayName("가게 리스트를 조회하는 url 호출을 성공한다.")
    @Test
    public void list() throws Exception {
        // given
        final List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "ohtaeg", "incheon"));
        restaurants.add(new Restaurant(2004L, "ohtaeg2", "seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);

        // when then
        mvc.perform(get(URL))
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json"))
           .andExpect(jsonPath("$.[0].id").value(1004))
           .andExpect(jsonPath("$.[0].name").value("ohtaeg"))
           .andExpect(jsonPath("$.[0].address").value("incheon"))
           .andExpect(jsonPath("$.[1].id").value(2004))
           .andExpect(jsonPath("$.[1].name").value("ohtaeg2"))
           .andExpect(jsonPath("$.[1].address").value("seoul"))
           .andDo(print())
        ;
    }

    @DisplayName("가게 상세를 조회하는 url 호출을 성공 한다.")
    @Test
    public void detail() throws Exception {
        // given
        final long id = 1004;
        final String menu = "kimchi";
        final Restaurant restaurant = new Restaurant(id, "ohtaeg", "incheon");

        restaurant.addMenuItem(new MenuItem(menu));
        given(restaurantService.getRestaurant(id)).willReturn(restaurant);

        // when then
        mvc.perform(get(URL + "/" + id))
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json"))
           .andExpect(jsonPath("$.id").value(id))
           .andExpect(jsonPath("$.menuItems[0].name").value(menu))
           .andDo(print())
        ;
    }

    @DisplayName("가게를 생성하는 url 호출이 성공 한다.")
    @Test
    public void create() throws Exception {
        mvc.perform(post(URL).content("{\"name\":\"chulsu\",\"address\":\"seoul\"}")
                             .contentType(MediaType.APPLICATION_JSON_VALUE))
           .andExpect(status().isCreated())
           .andExpect(header().string("location", URL + "/" + 0))
           .andExpect(content().string("{}"))
           .andDo(print())
        ;
    }

}