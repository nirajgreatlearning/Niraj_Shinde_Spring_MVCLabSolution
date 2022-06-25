package com.greatlearning.college.fest.service;

import java.util.List;

import com.greatlearning.college.fest.models.Student;

public interface StudentService {
	public List<Student> getAllStudents();

	public Student getStudentById(long studentId);

	public void saveStudent(Student student);

	public void deleteStudent(long studentId);
}
