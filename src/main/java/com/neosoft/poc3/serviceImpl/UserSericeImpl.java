package com.neosoft.poc3.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.poc3.dao.UserRepository;
import com.neosoft.poc3.exception.ResourceNotFoundException;
import com.neosoft.poc3.model.User;
import com.neosoft.poc3.service.UserService;

@Service
public class UserSericeImpl implements UserService {
	@Autowired
	UserRepository userRepositary;

	@Override
	public List<User> getAll() {

		return userRepositary.findAll();

	}

	@Override
	public User createUser(User user) {
		

		return userRepositary.save(user);
		
		
	}

	@Override

	public User getUserById(int id) {
		User user = userRepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		return user;
	}

	@Override
	public User updateUser(int id, User userDetails) {

		User updateUser = userRepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		updateUser.setFirstName(userDetails.getFirstName());
		updateUser.setLastName(userDetails.getLastName());
		updateUser.setDateOfBirth(userDetails.getDateOfBirth());

		updateUser.setDateOfJoining(userDetails.getDateOfJoining());

		updateUser.setEmailID(userDetails.getEmailID());
		updateUser.setFlagDelete(userDetails.getFlagDelete());
		updateUser.setPinCode(userDetails.getPinCode());

		return userRepositary.save(updateUser);

	}

	@Override
	public User getUser(int id) {
		return userRepositary.findAllActiveUsersNative(id);

	}

	@Override
	public List<User> findByName(String name, String lastname, int pincode) {
		return userRepositary.findByFirstNameOrLastNameOrPinCode(name, lastname, pincode);
	}

	@Override
	public User deleteUserById(int id) {

		User user = userRepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		userRepositary.delete(user);

		return user;
	}

	@Override
	public User softDeleteById(int id) {
		User user = userRepositary.findById(id).get();

		System.out.println(user);

		user.setFlagDelete(1);

		return userRepositary.save(user);
	}

	@Override
	public List<User> sortUserByDob() {

		List<User> users = userRepositary.findAll();

		List<User> sortedList = users.stream().sorted(Comparator.comparing(User::getDateOfBirth))
				.collect(Collectors.toList());

		return sortedList;

	}

	@Override
	public List<User> sortUserByDoj() {

		/*
		 * List<User> findAll = userRepositary.findAll(Sort.by(Sort.Direction.ASC,
		 * "dateOfBirth")); return findAll;
		 */

		List<User> users = userRepositary.findAll();

		List<User> sortedList = users.stream().sorted(Comparator.comparing(User::getDateOfJoining))
				.collect(Collectors.toList());

		return sortedList;

	}

	@Override
	public List<User> findByfirstName(String firstName) {
		return userRepositary.findByFirstName(firstName);
	}

	@Override
	public List<User> findBylastName(String lastName) {
		return userRepositary.findByLastName(lastName);
	}

	@Override
	public List<User> findByPincode(int pincode) {
		return userRepositary.findByPinCode(pincode);
	}

}
