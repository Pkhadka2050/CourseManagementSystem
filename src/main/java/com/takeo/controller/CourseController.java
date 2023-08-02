package com.takeo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.ServiceImpl.CourseServiceImpl;
import com.takeo.entity.Course;

@RestController
@RequestMapping("/")
public class CourseController {
	
	
	@Autowired
	private CourseServiceImpl serviceImpl;
	
	List<Course> addCourse= new ArrayList();
	/*
	@PostMapping("/view")
	public ResponseEntity<List<Course>> viewCourses()
	{
		Course course= new Course();
		
		//setting values for course 
		course.setCourseId(101);
		course.setCname("Pravin Kc");
		course.setCduration("4 years");
		course.setCfee(25000);
		
		Course course1=new Course();
		course1.setCourseId(105);
		course1.setCname("Shiva Yannam");
		course1.setCduration("4 years");
		course1.setCfee(30000);
		
		//adding courses to the list
		addCourse.add(course1);
		addCourse.add(course);
		
		//adding course to database
		serviceImpl.addCourse(course);
		serviceImpl.addCourse(course1);
		
		
		
		
		return new ResponseEntity(HttpStatus.OK).ok(addCourse);
	}
	*/
	
	// OR We can do following for enter data into database
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Course course)
	{
		String msg = serviceImpl.addCourse(course);
		
		return ResponseEntity.ok(HttpStatus.OK).ok(msg);
		
	}
	
	@GetMapping("/viewAll")
	public List<Course> getCourses()
	{
		List<Course> viewAllCourses = serviceImpl.viewAllCourse();
		return viewAllCourses;
	}
	
	@GetMapping("/view")
	public List<String> courseNames()
	{
		List<String> viewCoursesNames = serviceImpl.viewCourseNames();
		return viewCoursesNames;
	}
	
	@PutMapping("/update")
	public String updateCourseinfo(@RequestBody Course course)
	{
		String updateCourse = serviceImpl.updateCourse(course);
		
		return updateCourse;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable Integer id)
	{
		boolean deleteCourse = serviceImpl.deleteCourse(id);
		
		if(deleteCourse)
			return ResponseEntity.noContent().build();
		else
		return ResponseEntity.notFound().build();
			
	}
	
	

}
