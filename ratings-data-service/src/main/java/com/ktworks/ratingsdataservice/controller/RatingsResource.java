package com.ktworks.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktworks.ratingsdataservice.Entity.Rating;
import com.ktworks.ratingsdataservice.Entity.UserRating;

@RestController
@RequestMapping("ratingsdata")
public class RatingsResource{

	@GetMapping("/{userId}")
	public UserRating getRating(@PathVariable("userId") String userId) {
		List<Rating> ratingList =Arrays.asList(
			new Rating("1234",4),
			new Rating("5678",3)
			);
		
		return new UserRating(ratingList);
	}
}
