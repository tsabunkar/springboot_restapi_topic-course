package com.example.demo.course;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.topic.Topic;


import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(path="/topics/{topicId}/courses",method =RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable("topicId") int topicId) {
		return courseService.getCourses(topicId);
				
	}
	
	@RequestMapping(path="/topics/{topicId}/courses/{courseName}",method =RequestMethod.GET )
	public Course getParticularCourse(@PathVariable("courseName") String courseName) {
		return courseService.getCourse(courseName);
	}
	
	
	@RequestMapping(path="/topics/{topicId}/courses",method=RequestMethod.POST)
	public String addCourse(@RequestBody Course course, @PathVariable("topicId") int topicId ) {
		System.out.println("Post method...");
		System.out.println("course is :" + course +", topicId is :"+ topicId);
		course.setTopic(new Topic(topicId, "" , ""));
		int id =  courseService.addCourseToList(course);
		return id +" record got insereted.." ;
	}
	
	@RequestMapping(path="/topics/{topicId}/courses/{courseName}", method =RequestMethod.PUT)
	public void updateCourse( @RequestBody Course course, @PathVariable("courseName") String courseName, @PathVariable("topicId") int topicId ) {
		course.setTopic(new Topic(topicId, "" , ""));
		courseService.updateCourseToList(course,courseName);
	}
	
	@RequestMapping(path="/topics/{topicId}/courses/{courseName}",method =RequestMethod.DELETE )
	public void deleteCourse(@PathVariable("courseName") String courseName) {
		courseService.deleteParticularCourse(courseName);
	}
	
	
}

