package com.jiangjian.learning.hibernate.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class Publisher {

    @Column(name = "publisher_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;


    public Publisher(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    private Publisher() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}