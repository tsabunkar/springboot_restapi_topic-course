package com.example.demo.topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepositry topicRepositry;
	
	public List<Topic> getTopics() {
		List<Topic> listOfTopics = new ArrayList<Topic>();
			
		topicRepositry.findAll()
						.forEach(listOfTopics::add);
		return listOfTopics;
	}

	
	public Topic getTopic(int id) {
		return topicRepositry.findOne(id);
	}
	
	public int addTopicToList(Topic topic) {
	Topic t =	topicRepositry.save(topic);
	return (t!=null)?1:0;
	}

	
	public void updateTopicToList(Topic topic, int idPassedInUrl) {
		topicRepositry.save(topic);
	}

	public void deleteParticularTopic(int id) {
		topicRepositry.delete(id);
	}
	
}
