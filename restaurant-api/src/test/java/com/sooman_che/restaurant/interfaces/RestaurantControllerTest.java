package com.sooman_che.restaurant.interfaces;

import com.sooman_che.restaurant.MenuItemRepositoryImpl;
import com.sooman_che.restaurant.domain.MenuItemRepository;
import com.sooman_che.restaurant.domain.RestaurantRepository;
import com.sooman_che.restaurant.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @SpyBean(RestaurantRepositoryImpl.class)
    RestaurantRepository restaurantRepository;

    @SpyBean(MenuItemRepositoryImpl.class)
    MenuItemRepository menuItemRepository;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
           .andExpect(status().isOk())
           .andExpect(content().string(
                   containsString("\"id\":1004")
           ))
           .andExpect(content().string(
                   containsString("\"name\":\"Bob zip\"")
           ));
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
           .andExpect(status().isOk())
           .andExpect(content().string(
                   containsString("\"id\":1004")
           ))
           .andExpect(content().string(
                   containsString("\"name\":\"Bob zip\"")
           ))
           .andExpect(content().string(
                   containsString("kimchi")
           ))
        ;

        mvc.perform(get("/restaurants/2020"))
           .andExpect(status().isOk())
           .andExpect(content().string(
                   containsString("\"id\":2020")
           ))
           .andExpect(content().string(
                   containsString("\"name\":\"Cyber food\"")
           ));
    }

}