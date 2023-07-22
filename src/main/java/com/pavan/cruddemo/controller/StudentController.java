package com.pavan.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.cruddemo.entity.Student;
import com.pavan.cruddemo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "Hello world!";
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = studentService.getStudents();
		return students;
	}

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		Student saved = studentService.addStudent(student);
		return saved;
	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return studentService.deleteStudentById(id);
	}

	@PutMapping("/student")
	public Student updateStudentById(@RequestBody Student student) {
		return studentService.updateStudentById(student);
	}
}
