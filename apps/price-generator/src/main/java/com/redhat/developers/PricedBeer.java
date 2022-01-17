package com.redhat.developers;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PricedBeer {

    private String name;

    private BigDecimal price;

    private PricedBeer(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    static PricedBeer of(String name, BigDecimal price) {
        return new PricedBeer(name, price);
    }
    
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}