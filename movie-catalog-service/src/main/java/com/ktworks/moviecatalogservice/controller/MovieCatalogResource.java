package com.ktworks.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ktworks.moviecatalogservice.Entity.CatalogItem;
import com.ktworks.moviecatalogservice.Entity.Movie;
import com.ktworks.moviecatalogservice.Entity.Rating;
import com.ktworks.moviecatalogservice.Entity.UserRating;



@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private WebClient.Builder webClient;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
				
		UserRating ratings = webClient.build()
								.get()
								.uri("http://ratings-data-service/ratingsdata/"+userId)
								.retrieve()
								.bodyToMono(UserRating.class)
								.block();
		List<CatalogItem> catalogList = new ArrayList<>();
		
		for (Rating rating : ratings.getUserRating()) {
			
			Movie movie = webClient.build()
					.get()
					.uri("http://movie-info-service/movies/"+rating.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();
			catalogList.add(new CatalogItem(movie.getName(),"Test",rating.getRating()));
		}
		return catalogList;
	}
}
