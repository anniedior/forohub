package com.forohub.foro.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository repository;

    public List<Topic> findAll() {
        return repository.findAll();
    }

    public Topic findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Topic save(Topic topic) {
        return repository.save(topic);
    }

    public Topic update(Long id, Topic topicDetails) {
        Topic topic = repository.findById(id).orElse(null);
        if (topic != null) {
            topic.setTitle(topicDetails.getTitle());
            topic.setDescription(topicDetails.getDescription());
            return repository.save(topic);
        }
        return null;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
