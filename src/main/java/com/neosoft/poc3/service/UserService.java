package com.neosoft.poc3.service;

import java.util.List;

import com.neosoft.poc3.exception.ResourceNotFoundException;
import com.neosoft.poc3.model.User;

public interface UserService {

	public User createUser(User u);

	public List<User> getAll();

	public User getUserById(int id);

	public User updateUser(int id, User user);

	public User getUser(int id);

	public List<User> findByName(String name, String lastname, int pincode);

	public User deleteUserById(int id);

	public User softDeleteById(int id);

	public List<User> sortUserByDob();

	public List<User> sortUserByDoj();

	public List<User> findByfirstName(String firstName);

	public List<User> findBylastName(String lastName);

	public List<User> findByPincode(int pincode);

}
