package com.ktworks.moviecatalogservice.Entity;

public class Movie {

	private String MovieId;
	private String name;
	public String getMovieId() {
		return MovieId;
	}
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
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
