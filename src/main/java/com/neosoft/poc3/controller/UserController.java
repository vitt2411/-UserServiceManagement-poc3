package com.neosoft.poc3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc3.exception.ResourceNotFoundException;
import com.neosoft.poc3.model.User;
import com.neosoft.poc3.serviceImpl.UserSericeImpl;

@RestController
@RequestMapping("/api/v1/userServiceManagement")
public class UserController {

	@Autowired
	UserSericeImpl userService;

	@PostMapping("/user")

	public User createUser(@RequestBody User user) {

		return userService.createUser(user);

	}

	@GetMapping("/users")
	public List<User> getAllusers() {

		List<User> list = userService.getAll();
		return list;
	}

	@GetMapping("/sortByDob")
	public List<User> sortUsersByDateOfBirth() {

		List<User> sortByDob = userService.sortUserByDob();
		return sortByDob;
	}

	@GetMapping("/sortByDoj")
	public List<User> sortUsersByDateOfJoining() {

		List<User> sortByDoj = userService.sortUserByDoj();
		return sortByDoj;
	}

	@GetMapping("/getusers/{byFirstName}")
	public List<User> getUserByFirstName(@PathVariable(value = "byFirstName") String name) {

		List<User> users = userService.findByfirstName(name);
		return users;
	}

	@GetMapping("/getuser/{byLastName}")
	public List<User> getUserByLastName(@PathVariable(value = "byLastName") String name) {

		List<User> users = userService.findBylastName(name);
		return users;
	}

	@GetMapping("/getuserby/{byPincode}")
	public List<User> getUserByPinCode(@PathVariable(value = "byPincode") int pincode) {

		List<User> sortByDoj = userService.findByPincode(pincode);
		return sortByDoj;
	}

	@GetMapping("/userbyid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {

		User user = userService.getUserById(userId);
		return ResponseEntity.ok().body(user);

	}

	@PutMapping("/edituser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User userDetails) {

		System.out.println(userDetails);

		User updateUser = userService.updateUser(id, userDetails);

		return ResponseEntity.ok(updateUser);
	}

	@DeleteMapping("/deleteuser/{id}")

	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int id) {
		User user = userService.deleteUserById(id);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/user/soft/{id}")
	public ResponseEntity<String> softDelete(@PathVariable(value = "id") int id) {

		System.out.println(id);
		User user = userService.softDeleteById(id);

		return new ResponseEntity<>("User Deleted Softly", HttpStatus.OK);
	}

	@GetMapping("/users/{byname}/{bysurname}/{pincode}")
	public List<User> getAllbyNamebySurname(@PathVariable(value = "byname") String name,
			@PathVariable(value = "bysurname") String surname, @PathVariable(value = "pincode") int pincode) {

		List<User> list = userService.findByName(name, surname, pincode);
		return list;
	}

	/*
	 * @GetMapping("/user/{id2}") public ResponseEntity<User>
	 * getUserById1(@PathVariable(value = "id2") int userId) {
	 * 
	 * User user = userService.getUser(userId); return
	 * ResponseEntity.ok().body(user); }
	 */

}
