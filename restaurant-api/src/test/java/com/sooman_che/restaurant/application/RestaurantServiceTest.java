package com.sooman_che.restaurant.application;

import com.sooman_che.restaurant.MenuItemRepositoryImpl;
import com.sooman_che.restaurant.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

    @InjectMocks
    RestaurantService restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Mock
    MenuItemRepository menuItemRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockRestaurantRepository();
        mockMenuItemRepository();
    }

    private void mockMenuItemRepository() {
        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(List.of(new MenuItem("kimchi")));
    }

    private void mockRestaurantRepository() {

        List<Restaurant> restaurants = List.of(
                new Restaurant(1004L, "Bob zip", "Seoul"),
                new Restaurant(2020L, "Cyber food", "Seoul")
        );

        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(restaurants.get(0));

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

    @Test
    public void addRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant("Beryong", "Seoul");
        Restaurant saved = new Restaurant(1234L,"Beryong", "Seoul");

        given(restaurantRepository.save(any())).willReturn(saved);

        Restaurant created = restaurantService.addRestaurant(restaurant);

        assertThat(created.getId()).isEqualTo(1234L);
    }

}