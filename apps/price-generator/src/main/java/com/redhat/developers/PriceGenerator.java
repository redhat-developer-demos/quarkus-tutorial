package com.redhat.developers;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.netty.util.internal.ThreadLocalRandom;

@ApplicationScoped
public class PriceGenerator {

    @Incoming("wine")
    @Outgoing("priced-wine")
    public String markup(String price) {
        Jsonb jsonb = JsonbBuilder.create();
        Wine wine = jsonb.fromJson(price, Wine.class);
        PricedWine pricedWine = wine.withPrice(new BigDecimal(ThreadLocalRandom.current().nextInt(100, 2000)).setScale(2)); 
        return jsonb.toJson(pricedWine);
    }

}