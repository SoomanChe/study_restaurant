package com.sooman_che.restaurant.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
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
