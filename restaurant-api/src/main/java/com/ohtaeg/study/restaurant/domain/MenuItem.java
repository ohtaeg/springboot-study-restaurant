package com.ohtaeg.study.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private long id;

    private long restaurantId;

    private final String name;

    public MenuItem(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
