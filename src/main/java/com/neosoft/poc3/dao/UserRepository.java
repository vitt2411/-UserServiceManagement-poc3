package com.neosoft.poc3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.poc3.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM User u WHERE u.id = ?1", nativeQuery = true)
	public User findAllActiveUsersNative(int id);

	public List<User> findByFirstNameOrLastNameOrPinCode(String name, String lastname, int pincode);

	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public List<User> findByPinCode(int pincode);

	@Modifying

	@Query("delete from User u where u.id=?1")
	public User deleteById(int id);

	/*
	 * @Modifying
	 * 
	 * @Query("update User u set u.flagDelete=1 where u.id=?1 ") public User
	 * softDelete(int id);
	 */

}
