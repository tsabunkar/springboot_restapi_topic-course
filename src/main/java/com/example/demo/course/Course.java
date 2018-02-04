package com.example.demo.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.example.demo.topic.Topic;

@Entity
public class Course {
	@Id
	private String courseName;
	private double courseFee;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
			
		}

	
	
	public Course(String courseName, double courseFee, Topic topic) {
		super();
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.topic = topic;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseFee=" + courseFee + ", topic=" + topic + "]";
	}

	

}
