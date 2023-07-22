package com.pavan.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.cruddemo.entity.Student;
import com.pavan.cruddemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> getStudents() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	public Student getStudentById(int id) {
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent())
			return student.get();
		else
			return new Student();
	}

	public Student addStudent(Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}
	
	public String deleteStudentById(int id) {
		Student s = getStudentById(id);
		if(s.getName() != null) {
			studentRepo.deleteById(id);
			return "Student deleted";
		} else {
			return "Student not found with id: " + id;
		}
	}
	
	public Student updateStudentById(Student student) {
		Student s = getStudentById(student.getId());
		if(s.getName() != null) {
			return studentRepo.save(student);
		} else {
			return new Student();
		}
	}
	
	
}
