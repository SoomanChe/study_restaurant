package com.sooman_che.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private final List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository() {
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber food", "Seoul"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                        .filter(restaurant -> restaurant.getId().equals(id))
                        .findFirst()
                        .orElseGet(() -> null);
    }
}
