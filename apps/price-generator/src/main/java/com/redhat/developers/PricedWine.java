package com.redhat.developers;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class PricedWine {

    private String name;

    private BigDecimal price;

    private PricedWine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    static PricedWine of(String name, BigDecimal price) {
        return new PricedWine(name, price);
    }
    
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}