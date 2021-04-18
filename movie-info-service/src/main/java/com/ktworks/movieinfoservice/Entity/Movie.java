package com.ktworks.movieinfoservice.Entity;

public class Movie {

	private String MovieId;
	private String name;
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String movieId, String name) {
		super();
		MovieId = movieId;
		this.name = name;
	}
	
	
}
