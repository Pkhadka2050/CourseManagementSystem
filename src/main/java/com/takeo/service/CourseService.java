package com.takeo.service;

import java.util.List;
import java.util.Optional;

import com.takeo.entity.Course;

public interface CourseService {
	
	public String addCourse(Course course);
	public List<String> viewCourseNames();
	List<Course> viewAllCourse();
	public String updateCourse(Course course);
	public boolean deleteCourse(Integer id);

}
