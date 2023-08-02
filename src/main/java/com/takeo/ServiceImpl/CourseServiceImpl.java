package com.takeo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.Course;
import com.takeo.repo.CourseRepository;
import com.takeo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		Course courseEnt= courseRepo.save(course);
		
		String msg="null";
		if(courseEnt != null)
			msg= "Course Added Successfully";
		else
			msg="Course is not Registered";
		
			return msg;
	}

	@Override
	public List<String> viewCourseNames() {
		// TODO Auto-generated method stub
		List<String> courseNames= courseRepo.getCourseNames();
	
			return courseNames;
	}

	@Override
	public List<Course> viewAllCourse() {
		// TODO Auto-generated method stub
		List<Course> viewAll=courseRepo.findAll();
		
		
		return viewAll;
	}

	@Override
	public String updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course co= courseRepo.save(course);
		String msg=null;
		
		if(co != null)
			msg="Updated Successfully";
		else
			msg="Not Updated";
		
		
		return msg;
		
	}

	@Override
	public boolean deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		List<Course> viewAll=courseRepo.findAll();
		
		
		Course c = viewAll.get(id);
		
		boolean flag=false;
		
		if(viewAll != null)
		{
			courseRepo.deleteById(id);
			flag=true;
		
		
			}
		return flag;
	}

}
