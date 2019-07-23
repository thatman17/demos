package com.revature.restdemo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("movies")
public class MovieController {
	public static List<Movie> movieCache;
	public MovieController() {
		movieCache = new ArrayList<>();
		movieCache.add(new Movie(1, "Jurassic Park"));
		movieCache.add(new Movie(2, "Avatar"));
		movieCache.add(new Movie(3, "The Matrix"));
	}

//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	public String index() {
//		return "<h1>Welcome to the Movies API</h1>";
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies() {
		return movieCache;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieById(@PathParam("id") int id) {
		return movieCache.get(id-1);
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieByTitle(@QueryParam("title") String title) {
		for (Movie m : movieCache) {
			if (m.getTitle().equalsIgnoreCase(title))
				return m;
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Movie postMovie(Movie movie) {
		return movie;
	}
}

class Movie {
	private int id;
	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Movie(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + "]";
	}

}