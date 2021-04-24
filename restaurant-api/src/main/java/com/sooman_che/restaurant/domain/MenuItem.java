package com.sooman_che.restaurant.domain;

import lombok.Getter;

@Getter
public class MenuItem {

    private String name;
    public MenuItem(String name) {
        this.name = name;
    }
}
