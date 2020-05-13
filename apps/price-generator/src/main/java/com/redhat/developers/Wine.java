package com.redhat.developers;

import java.math.BigDecimal;

import javax.json.bind.annotation.JsonbCreator;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Wine {
   
    private String name;

    private Wine(String name) {
        this.name = name;
    }

    @JsonbCreator
    public static Wine of(String name) {
        return new Wine(name);
    }
    
    public PricedWine withPrice(BigDecimal price) {
        return PricedWine.of(this.name, price);
    }

    public String getName() {
        return name;
    }
    
}