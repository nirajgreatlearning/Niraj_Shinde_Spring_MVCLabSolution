package com.greatlearning.college.fest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.greatlearning.college.fest.models.Student;
import com.greatlearning.college.fest.serviceimpl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping("/studentlist")
	public String studentList(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "studentlist";
	}

	@RequestMapping("/add")
	public String addStudent(Model m) {
		m.addAttribute("studentInfo", new Student());
		return "studentadd";
	}

	@RequestMapping(value = "/view/{studentId}")
	public String viewStudent(@PathVariable long studentId, Model model) {
		Student student = studentService.getStudentById(studentId);
		model.addAttribute("studentInfo", student);
		return "studentview";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@Valid @ModelAttribute("studentInfo") Student student, BindingResult result) {
		if (result.hasErrors()) {
			if (student.getId() > 0) {
				return "studentview";
			} else {
				return "studentadd";
			}
		} else {
			studentService.saveStudent(student);
			return "redirect:/studentlist";
		}
	}

	@RequestMapping(value = "/deletestudent/{studentId}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/studentlist";
	}
}
