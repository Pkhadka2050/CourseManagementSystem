package com.takeo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.takeo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	Course findByCname(String cname);
	
	@Query("select cname from Course")
	List<String> getCourseNames();

}
