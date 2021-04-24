package com.sooman_che.restaurant.interfaces;

import com.sooman_che.restaurant.application.RestaurantService;
import com.sooman_che.restaurant.domain.MenuItem;
import com.sooman_che.restaurant.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = List.of(new Restaurant(1004L, "Bob zip", "Seoul"));

        given(restaurantService.getRestaurants()).willReturn(restaurants);

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
        Restaurant e1 = new Restaurant(1004L, "Bob zip", "Seoul");
        e1.setMenuItems(List.of(new MenuItem("kimchi")));

        Restaurant e2 = new Restaurant(2020L, "Cyber food", "Seoul");

        given(restaurantService.getRestaurant(1004L)).willReturn(e1);
        given(restaurantService.getRestaurant(2020L)).willReturn(e2);

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