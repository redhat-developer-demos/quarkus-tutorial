package com.redhat.developers;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
public interface SwapiService {
    @GET
    @Path("/films/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 2000L)
    @Fallback(SwapiFallback.class)
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = .5,
            delay = 5000L,
            successThreshold = 2
    )
    public Swapi getFilmById(@PathParam("id") String id);

    public static class SwapiFallback implements FallbackHandler<Swapi> {

        private static final Swapi EMPTY_SWAPI = new Swapi("",0,"","","");
        @Override
        public Swapi handle(ExecutionContext context) {
            return EMPTY_SWAPI;
        }

    }
}
