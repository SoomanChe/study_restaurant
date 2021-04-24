package com.sooman_che.restaurant.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long restaurantId;

    public MenuItem(String name) {
        this.name = name;
    }
}
