package com.imonichris.authenticationmicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imonichris.authenticationmicroservice.service.UserService;
import com.imonichris.authenticationmicroservice.dto.UserDTO;
import com.imonichris.authenticationmicroservice.response.UserResponseObject;

/**
 * @author Chris Imoni (https://github.com/chrisimoni)
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/users")
	public ResponseEntity<List<UserResponseObject>> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		List<UserResponseObject> users = new ArrayList<>();
		List<UserDTO> userDTOs = userService.getUsers(page, limit);
		
		userDTOs.stream().forEach(user -> {
			UserResponseObject resObj = modelMapper.map(user, UserResponseObject.class);
			users.add(resObj);
		});
		
		return ResponseEntity.ok().body(users);
	}
}
