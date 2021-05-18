package com.neosoft.poc3.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "User_Management")
public class User {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "pincode", nullable = false, length = 6)
	private int pinCode;

	@Column(name = "email_address", nullable = false)
	private String emailID;

	@JsonFormat(pattern = "dd-mm-yyyy")
	private String dateOfBirth;

	@JsonFormat(pattern = "dd-mm-yyyy")
	private String dateOfJoining;
	@JsonFormat
	private int flagDelete;

}
