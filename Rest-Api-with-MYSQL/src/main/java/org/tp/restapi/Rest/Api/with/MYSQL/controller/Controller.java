package org.tp.restapi.Rest.Api.with.MYSQL.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tp.restapi.Rest.Api.with.MYSQL.repository.Repository;
import org.tp.restapi.Rest.Api.with.MYSQL.student.Student;

@RestController
public class Controller {
	private Repository repo;
	public Controller(Repository repo) {
		this.repo=repo;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		
		List<Student> students = repo.findAll();
		return students;
	}
	@GetMapping("/students/{id}")
	public Student getOneUser(@PathVariable int id){
		Student student=repo.findById(id).get();
		return student;
	}
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	@PutMapping("/students/update/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable int id) {
	   
	   student= repo.save(student);
	   return student;
		
	}
	@DeleteMapping("/students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		repo.delete(student);
	}
	
}
