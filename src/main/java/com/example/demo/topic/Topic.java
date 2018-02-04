package com.example.demo.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	private int topicId;
	private String topicName;
	private String description;
	
	public Topic() {
			
		}

	
	public Topic(int topicId, String topicName, String description) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.description = description;
	}
	
	
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
