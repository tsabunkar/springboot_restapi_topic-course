package com.example.demo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepositry extends CrudRepository<Course, String>{

	
	public List<Course> findByTopicTopicId(int topicId);
	
	
}
 