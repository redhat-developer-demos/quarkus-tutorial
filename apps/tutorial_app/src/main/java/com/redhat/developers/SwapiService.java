package com.redhat.developers;

import java.util.List;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import com.redhat.developers.Swapi.Results;

@Path("/api")
@RegisterRestClient
public interface SwapiService {
    @GET
    @Path("/films/")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 3, delay = 2000)
    @Fallback(SwapiFallback.class)
    @CircuitBreaker(
        requestVolumeThreshold=4,
        failureRatio=0.75,
        delay=5000
    )
    Swapi getMovieByTitle(@QueryParam("search") String title);

    public static class SwapiFallback implements FallbackHandler<Swapi> {

        private static final Swapi EMPTY_SWAPI = new Swapi(List.of(new Results(0,"","","")));
        @Override
        public Swapi handle(ExecutionContext context) {
            return EMPTY_SWAPI;
        }

    }
}
