package com.example.demo.topic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping(path="/topics",method =RequestMethod.GET)
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
				
	}
	
	@RequestMapping(path="/topics/{myId}",method =RequestMethod.GET )
	public Topic getParticularTopic(@PathVariable("myId") int id) {
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(path="/topics",method=RequestMethod.POST)
	public String addTopic(@RequestBody Topic topic ) {
		System.out.println("Requested dto is :" + topic);
		int topicIdAddedWith =  topicService.addTopicToList(topic);
		return "Topic "+topic.getTopicName()+" - added with id " + topicIdAddedWith;
	
	}
	
	@RequestMapping(path="/topics/{myId}", method =RequestMethod.PUT)
	public void updateTopic( @RequestBody Topic topic, @PathVariable("myId") int idPassedInUrl) {
		System.out.println("Requested dto to put is :" + topic + " , with id :" + idPassedInUrl);
	
		topicService.updateTopicToList(topic,idPassedInUrl);
	}
	
	@RequestMapping(path="/topics/{myId}",method =RequestMethod.DELETE )
	public void deleteTopic(@PathVariable("myId") int id) {
		topicService.deleteParticularTopic(id);
	}
	
	
}

