package com.ohtaeg.study.restaurant.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

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

    @DisplayName("리스트를 조회 한다.")
    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurant"))
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json"))
           .andExpect(jsonPath("@[*].id").value(1004))
           .andExpect(jsonPath("@[*].name").value("ohtaeg"))
           .andExpect(jsonPath("@[*].address").value("incheon"))
           .andDo(print())
        ;
    }
}