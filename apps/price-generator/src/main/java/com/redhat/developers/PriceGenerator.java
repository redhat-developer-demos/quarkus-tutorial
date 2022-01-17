package com.redhat.developers;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.reactive.messaging.annotations.Blocking;
import io.netty.util.internal.ThreadLocalRandom;
import java.util.Random;

@ApplicationScoped
public class PriceGenerator {
    private Random random = new Random();

    @Incoming("beer")
    @Outgoing("priced-beer")
    @Blocking
    public String markup(String price) {
        Jsonb jsonb = JsonbBuilder.create();
        Beer beer = jsonb.fromJson(price, Beer.class);
        PricedBeer pricedBeer = beer.withPrice(new BigDecimal(ThreadLocalRandom.current().nextInt(100, 2000)).setScale(2)); 
        return jsonb.toJson(pricedBeer);
    }

}