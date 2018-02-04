package com.example.demo.course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepositry courseRepositry;
	
	public List<Course> getCourses(int topicId) {
		List<Course> listOfcourses = new ArrayList<Course>();
			
		courseRepositry.findByTopicTopicId(topicId)
						.forEach(listOfcourses::add);
		
		return listOfcourses;
	}

	
	public Course getCourse(String courseName) {
		return courseRepositry.findOne(courseName);
	}
	
	public int addCourseToList(Course course) { 
	Course t =	courseRepositry.save(course);
	return (t!=null)?1:0;
	}

	
	public void updateCourseToList(Course course, String courseName) {
		courseRepositry.save(course);
	}

	public void deleteParticularCourse(String courseName) {
		courseRepositry.delete(courseName);
	}
	
}
