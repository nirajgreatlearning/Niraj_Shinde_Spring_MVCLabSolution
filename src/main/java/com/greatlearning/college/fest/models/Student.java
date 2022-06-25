package com.greatlearning.college.fest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long Id;

	@Column(name = "student_fname", length = 150)
	@NotBlank(message = "First Name is Required!")
	@Size(min = 2, max = 150, message = "First Name must be between 2 to 150 characters!")
	private String firstName;

	@Column(name = "student_lname", length = 150)
	@NotBlank(message = "Last Name is Required!")
	@Size(min = 2, max = 150, message = "Last Name must be between 2 to 150 characters!")
	private String lastName;

	@Column(name = "course_name", length = 150)
	@NotBlank(message = "Course Name is Required!")
	@Size(min = 2, max = 150, message = "Course Name must be between 2 to 150 characters!")
	private String courseName;

	@Column(name = "country_name", length = 150)
	@NotBlank(message = "Country Name is Required!")
	@Size(min = 2, max = 150, message = "country Name must be between 2 to 150 characters!")
	private String countryName;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String courseName, String countryName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.countryName = countryName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
