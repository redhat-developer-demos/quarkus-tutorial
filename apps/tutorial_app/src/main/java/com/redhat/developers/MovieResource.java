package com.redhat.developers;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/movie")
public class MovieResource {

    @RestClient
    @Inject
    SwapiService swapiService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MovieDTO> movies(@QueryParam("year") String year) {
        if (year != null) {
            return Movie.findByYear(Integer.parseInt(year))
            .stream()
            .map(movie -> MovieDTO.of(movie, swapiService.getMovieByTitle(movie.title)))
            .collect(Collectors.toList());
        }
        return Movie.<Movie>listAll()
            .stream()
            .map(movie -> MovieDTO.of(movie, swapiService.getMovieByTitle(movie.title)))
            .collect(Collectors.toList());
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newMovie(Movie movie) {
        movie.id = null;
        movie.persist();
        return Response.status(Status.CREATED).entity(movie).build();
    }

    @GET
    @Path("simple")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> simple(@QueryParam("year") String year) {
        if (year != null) {
            return Movie.findByYear(Integer.parseInt(year));            
        }
        return Movie.listAll();
    }

}