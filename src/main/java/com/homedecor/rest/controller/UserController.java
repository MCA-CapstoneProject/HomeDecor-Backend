package com.homedecor.rest.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedecor.rest.dto.UserDto;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> list = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/get/by-id")
	public ResponseEntity<UserDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
		UserDto list = userService.findByUserId(id);
		return new ResponseEntity<UserDto>(list, HttpStatus.OK);
	}

	@PostMapping(value = { "/add", "/update" })
	public ResponseEntity<BaseResponse> createOrUpdateUser(@RequestBody UserDto userDto) {
		BaseResponse response = userService.createOrUpdateUser(userDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
		BaseResponse response = userService.deleteUserById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
