package com.sooman_che.restaurant.application;

import com.sooman_che.restaurant.MenuItemRepositoryImpl;
import com.sooman_che.restaurant.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantServiceTest {

    RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        MenuItemRepository menuItemRepository = new MenuItemRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    @Test
    public void getRestaurants() throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant actual = restaurants.get(0);
        assertThat(actual.getId()).isEqualTo(1004L);
    }

    @Test
    public void getRestaurant() throws Exception {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(restaurant.getId()).isEqualTo(1004L);
        assertThat(menuItem.getName()).isEqualTo("kimchi");
    }
}