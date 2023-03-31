package com.lcwd.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entites.Hotel;
import com.lcwd.user.service.entites.Rating;
import com.lcwd.user.service.entites.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server : " + userId));
		//fetch rating of the above user from RATING SERVICE
		//localhost:8083/ratings/users/96650216-828e-47d6-8775-62a97a3a28d9
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ",ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
			//api call to hotel service to get the hotel
			//localhost:8082/hotels/3df66673-eee0-4d3e-a453-55d2ac3a7ed6
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("response status code: {} ",forEntity.getStatusCode());
			//set the hotel to rating
			rating.setHotel(hotel);
			//return the rating
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

}
