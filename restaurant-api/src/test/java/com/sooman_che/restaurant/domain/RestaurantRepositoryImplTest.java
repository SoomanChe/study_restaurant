package com.sooman_che.restaurant.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestaurantRepositoryImplTest {

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong", "Seoul");
        Restaurant saved = repository.save(restaurant);
        assertThat(saved.getId()).isEqualTo(1234L);

        int newCount = repository.findAll().size();

        assertThat(newCount-oldCount).isEqualTo(1);
    }
}