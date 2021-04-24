package com.sooman_che.restaurant.domain;

import lombok.Getter;

@Getter
public class Restaurant {

    private Long id;
    private String name;
    private String address;

    public Restaurant(final Long id, final String name, final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

}
